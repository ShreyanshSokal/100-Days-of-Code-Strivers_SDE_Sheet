class Solution {
    public void sortColors(int[] nums) 
    { 
        int n = nums.length, left = 0, cur = 0, right = n-1; 
        while( cur <= right) 
        {	 
            int temp = nums[cur]; 
            if(temp == 0) 
            { 
                nums[cur] = nums[left]; 
                nums[left] = temp; 
                cur++; 
                left++; 
            } 

            if(temp == 2) 
                { 
                    nums[cur] = nums[right]; 
                    nums[right] = temp; 
                    right--; 
                } 

            if(temp == 1)cur++; 
        } 
        // return nums; 
    } 
}


// 0000 | 001002122 | 22222
//          c  r   
//          l 
