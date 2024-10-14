import java.util.*;

class Solution {

    // Approach:
    // 1. Given a set of page requests and a fixed cache size C, the task is to find the number of page faults using the Least Recently Used (LRU) policy.
    // 2. A HashSet 'memory' is used to store the current pages in the cache. If the size of 'memory' exceeds C, we remove the least recently used page.
    // 3. A HashMap 'map' keeps track of the last access time (index) of each page.
    // 4. For each page, if it is not present in the cache, it counts as a page fault. If the cache is full, the least recently used page is removed and replaced with the new page.

    // Time Complexity (TC): O(n * C)
    // Each page access results in at most C lookups and updates in the worst case, where n is the number of pages, and C is the cache size.

    // Space Complexity (SC): O(C)
    // We are using a HashSet and a HashMap to store up to C pages and their corresponding indices.

    static int pageFaults(int n, int C, int pages[]) {
        Set<Integer> memory = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        int pageFault = 0;
        
        for (int i = 0; i < n; i++) {
            // Check if memory has space
            if (memory.size() < C) {
                if (!memory.contains(pages[i])) {
                    pageFault++;
                    memory.add(pages[i]);
                }
                // Update the most recently used by setting the current index i
                map.put(pages[i], i);

            } else {
                // If page is not in memory and memory is full
                if (!memory.contains(pages[i])) {
                    pageFault++;
                    int min = Integer.MAX_VALUE, val = 0;
                    
                    // Find the least recently used page to remove
                    for (Integer j : memory) {
                        if (map.get(j) < min) {
                            min = map.get(j);
                            val = j;
                        }
                    }
                    
                    memory.remove(val);  // Remove LRU page
                    memory.add(pages[i]);  // Add new page
                }
                // Update the most recently used by setting the current index i
                map.put(pages[i], i);
            }
        }
        return pageFault;
    }
}
