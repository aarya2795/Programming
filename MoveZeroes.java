/***************************************************************************************************************************************
Name: Move Zeros

Description: Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the 
	     non-zero elements.

Example 1:   Input: [0,1,0,3,12]
	     Output: [1,3,12,0,0]

Steps:	1. Declare a pointer i to keep track of the non-zero elements
	2. Looping through the nums array, using a j pointer, check if the element is not equal to 0, if the condition is satisfied, 
	   then copy the non-zero element to the location pointed by ith index and increment i
	2. Once the loop ends, we get all the non-zero elements in their correct place, so we have to fill the end of the array with 0s;
	   For this we have another loop beginning from the current value of i until the length of nums and we put 0 in those locations

Time complexity: O(N). Where N is the length of the array

Space complexity: O(1).

***************************************************************************************************************************************/

public class MoveZeroes{
    public static void moveZeroes(int[] nums) {
        int i = 0;
        
        for(int j = 0; j < nums.length; j++)
            if(nums[j] != 0)
                nums[i++] = nums[j];

        while(i < nums.length)
            nums[i++] = 0;
    }

    public static void printArray(int[] result)
    {
        System.out.print("[");
        for(int i = 0; i < result.length; i++)
            System.out.print(result[i] + ",");
        System.out.println("]");
    }

    public static void main(String []args){
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        printArray(nums);
    }
}