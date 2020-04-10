/***************************************************************************************************************************************
Name: Search Insert Position

Description: Given a sorted array and a target value, return the index if the target is found. 
	     If not, return the index where it would be if it were inserted in order.
	
	     You may assume no duplicates in the array.

Example 1:   Input: [1,3,5,6], 5
	     Output: 2

Example 2:   Input: [1,3,5,6], 2
	     Output: 1

Example 3:   Input: [1,3,5,6], 7
	     Output: 4

Example 4:   Input: [1,3,5,6], 0
	     Output: 0

Steps:
	1. While traversing the array, check for 2 conditions using an 'OR' operator: 
	   --> if nums[i] == target means the given target value is present at ith index so return i
	   --> or if nums[i] > target that means as the array is sorted, the given target value is not present further in the 
		remaining array and hence return i which would be the desired index where it would be if it were inserted in order
	2. If none of the above conditions are satisfied, then we come to a conclusion that the target element is neither in the array 
	   nor is it smaller than any of the elements in the array hence its desired index where it would be, if it were inserted in 
	   order, is the end of the array hence return the length of array which indicates end of the array itself

Time Complexity: O(N), where N is the length of nums.

Space Complexity: O(1)

***************************************************************************************************************************************/

public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        
        for(int i = 0; i < nums.length; i++)
            if(nums[i] == target || nums[i] > target)
                return i;
        
        return nums.length;
    }

    public static void main(String []args){
        int[] nums = new int[]{1,3,5,6};
        int target = 7;
         
        int index = searchInsert(nums, target);
        
        System.out.print(index);
    }
}