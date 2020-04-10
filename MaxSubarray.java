/***************************************************************************************************************************************
Name: Remove Element

Description: Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum 
	     and return its sum.

Example 1:   Input: [-2,1,-3,4,-1,2,1,-5,4],
	     Output: 6
		
	     Explanation: [4,-1,2,1] has the largest sum = 6.

Approach 1: Using temporary variables

Steps: 
	1. Declare and initialize 2 variables - temp and ans to 0 and nums[0] respectively
	2. Loop through the array and copy the value of the largest element in nums, in the ans variable
	3. Check if either the length of nums is 1 or if the ans value is 0, then return ans
	4. Looping through nums, use the temp variable to store the intermediate sum. Add the current element to temp
	5. if temp value is less than or equal to 0 then make temp = 0
	6. else check if temp is greater than ans, if yes then replace ans variable value with that of temp
	7. Return the ans variable as it holds the maximum sum of the subarray of nums

Time complexity: O(n).

Space complexity: O(1).


Approach 2: Saving previous Value

Steps: 
	1. If nums array is null or has no elements in it, throw IllegalArgumentException
	2. Declare and initialize 2 variables intermediateSum and maxSum both to nums[0]
	3. Looping through nums, set maximum of (intermediateSum + current_element, current_element) as new value of intermediateSum 
	4. Similarly, set maximum of (maxSum, intermediateSum) as the new value of maxSum
	5. Return maxSum

Time complexity: O(n).

Space complexity: O(1).

***************************************************************************************************************************************/

public class MaxSubarray {
    public static int solution1(int[] nums) {
        
        if(nums == null || nums.length == 1)
            return 0;
            
        int temp = 0;
        int ans = nums[0];
        
        for(int n : nums)
            if(n > ans) ans = n;
            
        if(ans == 0)
            return 0;
            
        for(int i = 0; i < nums.length; i++)
        {
            temp += nums[i];
            if(temp <= 0)
                temp = 0;
            else
            {
                if(temp > ans)
                    ans = temp;
            }
        }
        
        return ans;
    }

    public static int solution2(int[] nums) {
        if(nums == null || nums.length == 0)
            throw  new IllegalArgumentException("Array is either null or empty");
            
        int intermediateSum = nums[0];
        int maxSum = nums[0];

        for(int i = 0; i < nums.length; i++)
        {
           intermediateSum = Math.max(intermediateSum + nums[i], nums[i]);
           maxSum = Math.max(maxSum, intermediateSum);
        }
        
        return maxSum;
    }
    public static void main(String []args){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
         
        int largestSum = solution1(nums);
        
        System.out.print(largestSum);
    }
}