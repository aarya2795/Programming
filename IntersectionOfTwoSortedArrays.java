/***************************************************************************************************************************************
Name: Intersection of Two Sorted Arrays

Description: Given two arrays, write a function to compute their intersection. Considering, each element in the result must be unique. 
	     The result can be in any order.

Example 1: Input: nums1 = [1,2,2,1], nums2 = [2,2]
	   Output: [2]

Example 2: Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	   Output: [9,4]

Example 3: Input: nums1 = [4, 9, 5, 7, 6], nums = [9,4,9,8,4,5,6,6]
	   Output: [4, 5, 6, 9]

Approach: Two pointers Method

Steps:
	1. Declare a HashSet to store the copy the numbers that are intersecting 
	2. Declare 2 pointers i and j
	3. Declare an ArrayList to store the result of intersection
	3. In a While loop, check three conditions and perform accordingly
	   - if element at ith location in nums1 equals element at jth location in nums2 then add the element to the HashSet and 
	     ArrayList and increment both the pointers
	   - else if element at ith location in nums1 is less than element at jth location in nums2 , increment i
	   - else if element at ith location in nums1 is greater than element at jth location in nums2 , increment j
	4. Since our return value must be an array, convert our solution set into an array.

Time Complexity: O(n + m)

		First if we need to sort the arrays (if unsorted) and this takes O(nlogn) time; n is the length of an array
		Sorting both the arrays we lead to O (nlogn) + O(mlogm); considering n = nums1 length and m = nums2 length
		There are 2 pointers which in worse case time scenario will go over the both the array lengths O(m) + O(n)
		Then the time complexity of adding/checking Set is constant so we don't have to really worry about that. 
		Then all required numbers are added to the list which depends on the number of elements in common. 

		So time complexity in worst case will be O(nlogn) + O(mlogm) + O(n) + O(m) + O(c).
		Asymptotically, code complexity is either O(nlogn) or O(mlogm) whichever array is longer!

	  	Note: In case the arrays are already sorted, the worst case will be O(n) + O(m) + O(c) i.e. O(n + m)

Space Complexity: O(n + m)

***************************************************************************************************************************************/

import java.util.*; 

public class IntersectionOfTwoSortedArrays{
    
    public static int[] intersectionBySorting(int[] nums1, int[] nums2)
    {
        //If arrays not sorted, uncomment the following statement
	//Arrays.sort(nums1); Arrays.sort(nums2);
        int k = 0;
	    
        for(int i = 0, j = 0; i < nums1.length && j < nums2.length;)
        {
            if(nums1[i] == nums2[j])
            {
                nums1[k++] = nums1[i];
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
        
        return Arrays.copyOfRange(nums1, 0, k);
    }
        
    public static void main(String []args){

        Scanner input = new Scanner(System.in);
        int[] nums1 = new int[]{4, 9, 5, 7, 6};
        int[] nums2 = new int[]{9, 4, 9, 8, 4, 5, 6, 6};
        input.close();
         
        int[] result = intersectionBySorting(nums1, nums2);
        System.out.print("[ ");
        for(int n : result)
            System.out.print(n + " ");
        System.out.print("]");
     }
}
