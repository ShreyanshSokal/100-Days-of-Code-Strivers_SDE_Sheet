// Here's an explanation for both the `maxLenBetter` and `maxLenOptimised` methods for the problem "Largest subarray with 0 sum" based on your provided code:

// ### Problem Explanation: Largest Subarray with 0 Sum

// The task is to find the length of the largest subarray with a sum of 0. This can be solved using different approaches.

// ### Code Explanation:


class GfG
{
    int maxLenBetter(int arr[], int n)
    {
        int k = 0;
        //Better solution using prefix sum and hashmap
        
        // logic -> 
        
        // [|_____(x-k)______ | __(k)__|........(rest array)...........]
        
        // if we want subarray with sum k, we can traverse in a prefix sum
        // and we can check if previously any sum = x-k is stored?
        
        // if yes, then remaining part from prefSum till cur/i 
        // will be equal to k.
        
        Map<Integer, Integer> prefsum = new HashMap();
        //here prefsum stores [prefsum, index till prefsum]
        
        int maxlen = 0, sum = 0;
        
        for(int i=0 ; i<n; i++)
        {
            sum += arr[i];
            
            if(sum == k) maxlen = i+1;
            
            if(prefsum.containsKey(sum-k) == true)
            {
                int len = i - prefsum.get(sum);
                maxlen = len > maxlen ? len : maxlen;
            }
            else
            {
                //if arr contains 0 then no need to update the index
                // because updating index will decrease the length 
                //and result in wrong answer
                if(arr[i] == 0) continue;
                
                //If the sum is already present, then also, it will result
                //in decreasing the len if we update index so we'll
                //not update the index for existing prefsum.
                if( prefsum.containsKey(sum) == true)continue;
                
                else prefsum.put(sum, i);
            }

        }
        return maxlen;
    }
}


// #### Explanation:

// 1. **Prefix Sum and HashMap Approach**:
//     - This approach leverages the concept of prefix sums and uses a HashMap to store these sums along with their corresponding indices.
//     - As you traverse the array, you maintain a running sum (`sum`). For every index `i`, you check if `sum - k` (where `k` is 0 in this problem) has already been seen before. 
//     - If it has, it means there is a subarray with sum `k` (0 in this case) between the previous index of this sum and the current index `i`.
//     - The length of this subarray is `i - prefsum.get(sum - k)`.
//     - If `sum == k`, it means the subarray starting from index 0 up to `i` has the desired sum.
//     - To avoid incorrect results, the code checks and handles the cases where the current element is 0 or if the current prefix sum has been seen before.

// 2. **Efficiency**:
//     - This solution runs in `O(n)` time complexity as it only involves a single pass through the array and some lookups in the HashMap, making it efficient for large inputs.

int maxLenOptimised(int arr[], int n)
{
    int k = 0;
    //Optimal solution using 2 pointers - only for Positives and 0s
    
    int len = 0 ,maxlen = 0, left = 0, right =0, sum=arr[0] ;
    
    while(right < n)
    {
    
        // check if sum is already > k and then cut it down
        while(left <= right && sum > k)
        {
                sum-=arr[left];
                left++;
        }
    
        //check if after cutting, sum == k? store len
        if(sum == k)
        {
            len = right - left+1;
            maxlen = len > maxlen ? len : maxlen;
        }
        
        //here sum is <= k, so now we can move right
        right++;    
        
        if(right < n)
           sum+= arr[right];
    }
    return maxlen;
}


// #### Explanation:

// 1. **Two Pointers Approach**:
//     - This approach uses two pointers (`left` and `right`) to maintain a sliding window of the subarray and adjusts the window size to find the largest subarray with a sum equal to `k` (0 in this case).
//     - As you expand the window by moving the `right` pointer, you keep track of the current sum.
//     - If the sum exceeds `k`, the `left` pointer is incremented to reduce the window size until the sum is less than or equal to `k`.
//     - If the sum equals `k`, the length of the current window is compared with the maximum length found so far.
//     - This method is efficient but is mainly suitable when the array contains only non-negative numbers.

// 2. **Efficiency**:
//     - This approach also has a time complexity of `O(n)` but is typically used in scenarios where the array contains only non-negative numbers.

// Both methods effectively solve the problem but use different techniques, with the first being more general and the second being more specialized.
