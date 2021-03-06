/***************************************************************************************************************************************
Name: Intersection of Two Arrays ||

Description: Given two arrays, write a function to compute their intersection.

Example 1: Input: nums1 = [1,2,2,1], nums2 = [2,2]
	   Output: [2,2]

Example 2: Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	   Output: [4,9]

Approach 1 - HashMap Method
Steps:
	1. Make a HashMap with numbers from nums1 using map.merge functino which enters default value as 1 if Key not 
	   present already or computers the sum otherwise
	2. Declare a ArrayList to store the result of intersection
	2. While traversing nums2, check if the HashMap contains Key equal to the current element and if the value mapped 
	   to the key is greater than 0
	3. If the two conditions are satisfied, then add the element to the ArrayList ad update the mapped value by 
	   decrementing the count by 1
	4. Since our return value must be an array, convert our solution set into an array.

Time Complexity: O(n + m)

Space Complexity: O(n + m)


Approach 1 - Sorting Array Method
Steps:
	1. Sort both the arrays
	2. Initialize a pointer k 
	3. Loop through both the arrays at the same time using two pointers i and j to keep track of the current indices
	4. Check for 3 cases:-
	   -> if element in both arrays at ith and jth position is equal then insert the element at the kth index of nums1
	   -> else if element at nums1[i] is smaller than element at nums2[j] then increment i
	   -> else if element at nums1[i] is greater than element at nums2[j] then increment j
	5. Since our return value must be an array, convert our solution into an array by copying 0 to k elements of nums1 

Time Complexity: O(nlogn) + O(mlogm) + O(n) + O(m)

Space Complexity: O(n + m)

***************************************************************************************************************************************/

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArrays||{
  public static int[] solution (int[] nums1, int[] nums2)
  {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums1)
            map.merge(n, 1, Integer :: sum);
            
        List<Integer> intersection = new ArrayList();
        
        for(int n : nums2)
        {
            if(map.containsKey(n) && map.get(n)>0)
            {
                intersection.add(n);
                map.merge(n, -1, Integer :: sum);
            }
        }
        
        int[] result = new int[intersection.size()];
        for(int i = 0; i < result.length; i++)
            result[i] = intersection.get(i);

        return result;
     }
    
  public static int[] sortedArraySolution(int[] nums1, int[] nums2)
  {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int k =0;
        
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

    public static void main (String[]args)
    {
        int[] nums1 = new int[]{ 1, 2, 2, 1 };
        int[] nums2 = new int[]{ 2, 2 };

        int[] result = solution (nums1, nums2);
        System.out.print ("[");
        for (int i = 0; i < result.length; i++)
	        System.out.print (result[i] + ",");
        System.out.println ("]");
    }
}