/*
Intuition:
The problem of finding a duplicate number in an array where each number is within a specific range suggests the use of cycle detection algorithms. Specifically, this problem can be approached using Floyd's Tortoise and Hare algorithm, commonly used for cycle detection in linked lists. The idea is to treat the array as a linked list where each index points to the value at that index, creating a cycle due to the duplicate number.

Approach:
Phase 1: Finding the Intersection Point:

Initialize two pointers, slow and fast, both set to the start of the array (index 0).
Move slow one step at a time (i.e., slow = nums[slow]).
Move fast two steps at a time (i.e., fast = nums[nums[fast]]).
Continue this process until slow and fast meet. This point is guaranteed to be within the cycle created by the duplicate number.
Phase 2: Finding the Entrance to the Cycle:

Reset one pointer (slow) to the start of the array (index 0).
Move both slow and fast one step at a time until they meet again. The meeting point is the duplicate number.

Time Complexity:
The time complexity of this algorithm is linear, which means it is O(n), where n is the number of elements in the array. This is because both pointers traverse the array, and the combined number of steps taken by slow and fast is proportional to the size of the array.
Space Complexity:
The space complexity is constant, which means it is O(1). This is because we are using only a fixed amount of extra space for the two pointers, regardless of the size of the input array.

*/

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}
