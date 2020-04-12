/***************************************************************************************************************************************
Name:  Merge Sorted Arrays

Description: Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
	     Note:
		1. The number of elements initialized in nums1 and nums2 are m and n respectively.
		2. You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

Example 1:   Input: nums1 = [1,2,3,0,0,0], m = 3
		    nums2 = [2,5,6],       n = 3

	     Output: [1,2,2,3,5,6]

Example 2:   Input: nums1 = [0], m = 0
	            nums2 = [1], n = 1

Steps:
	1. Declare & initialize 3 variables: 
	   --> num1_index to the last index of the array nums1, considering the last element belonging to nums1 array alone
	   --> num2_index to the last index of the array nums2, 
	   --> final_nums1_index = num1_index + num2_index - 1 so that it represents the last index of the final nums1 array
	2. Using a while loop where the stopping condition would be (num1_index >= 0 && num2_index >= 0) so that all elements of the 
	   nums1 array are checked and compared with that of nums2 array, we check for 2 conditions:
	   --> if element in the nums1 array at index = nums1_index is greater than element in the nums2 array at index = nums2_index, 
		  copy element in the nums1 array at index nums1_index, to the index = final_nums1_index and decrement both indices
	   --> else if element in the nums2 array at index = nums2_index is less than or equal to element in the nums1 array at 
	       	  index = nums1_index, copy element in the nums2 array at index nums2_index, to the index = final_nums1_index location
	          and decrement both indices	
	3. In case if any elements in the nums2 array are left to be copied to the nums1 array (this happens when all elements are 
	   greater than the remaining elements in the nums2 array), using a while loop, copy all the remaining elements to nums1 array.
	   Note: There is no need to copy elements of nums1 array, since they're already in correct spot

Time Complexity: O(N)

Space Complexity: O(1)

***************************************************************************************************************************************/

public class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int num1_index = m-1;
        int num2_index = n-1;        
        int final_nums1_index = num1_index + num2_index + 1;
        
        while(num1_index >= 0 && num2_index >= 0)
        {
            if(nums1[num1_index] > nums2[num2_index])
                nums1[final_nums1_index--] = nums1[num1_index--];
            else
                nums1[final_nums1_index--] = nums2[num2_index--];
        }
        
        while(num2_index >= 0)
            nums1[final_nums1_index--] = nums2[num2_index--];
    }

    public static void main(String []args){
        
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        
        merge(nums1, (nums1.length - nums2.length), nums2, nums2.length);
        
        System.out.print("[");
        for(int i = 0; i < nums1.length; i++)
            System.out.print(nums1[i] + ",");
        System.out.println("]");
        
    }
}