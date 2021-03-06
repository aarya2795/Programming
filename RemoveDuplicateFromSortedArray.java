/***************************************************************************************************************************************
Name: Remove Duplicates from Sorted Array

Description: Given a sorted array nums, remove the duplicates in-place such that each element appear only once & return the new length.

	     Do not allocate extra space for another array, do this by modifying the input array in-place with O(1) extra memory.

Example 1:   Given nums = [1,1,2],

	     Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
	     It doesn't matter what you leave beyond the returned length.

Example 2:   Given nums = [0,0,1,1,1,2,2,3,3,4],

	     Your function should return length = 5, with the first five elements of nums modified to 0, 1, 2, 3, and 4 respectively.
	     It doesn't matter what values are set beyond the returned length.

Steps:
	1. Initially, return 0 straightaway if you find that the nums array is null or if its length is 0
	2. Intialize a j pointer which keeps track of the index of the resulting elements in in the modified array
	2. Looping through nums, check if the current element is does not equal the element pointed by pointer j, 
	   if this condition is satisfied then return increment the j pointer and copy the current element in nums[i]
	3. Return the pointer the value 'j + 1' as this will be the length of the modified result array

Time Complexity: O(N), where N is the length of nums.

Space Complexity: O(1).

***************************************************************************************************************************************/

public class RemoveDuplicateFromSortedArray{
    public static int removeDuplicates(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return 0;
            
        int j = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=nums[j])
            {
                j++;
                nums[j] = nums[i];
            }
        }
        
        return j+1;
    }
    
    public static void main(String []args){
    int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
    
    int length = removeDuplicates(nums);
         
    System.out.println(length);
    
    }
}