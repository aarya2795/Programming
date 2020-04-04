/***************************************************************************************************************************************
Name: Intersection of Two Arrays

Description: Given two arrays, write a function to compute their intersection. 
	     Considering, each element in the result must be unique. The result can be in any order.

Example 1: Input: nums1 = [1,2,2,1], nums2 = [2,2]
	   Output: [2]

Example 2: Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	   Output: [9,4]

Approach 1 - Use two HashSets; one for storing all elements of an array and other to store the intersection result
Steps:
	1. Make a HashSet with numbers from nums1. Declare a resultSet to store the result of intersection
	2. While traversing nums2, check if nums2 contains the current element and resultSet does not contain the same
	3. If the two conditions are satisfied, then add the element to the resultSet
	4. Since our return value must be an array, convert our solution set into an array.

Time Complexity: O(n + m)

Space Complexity: O(n + m)

Approach 2 - Union of Sets method
Steps:
	1. Make a Set with numbers from nums2
	2. Make a Set with numbers from nums2
	3. The "set union" of these 2 sets is our solution. In Java we use the retainAll() for set union.
	4. Since our return value must be an array, convert our solution set into an array.

Time Complexity: O(n + m)

Space Complexity: O(n + m)

***************************************************************************************************************************************/

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class IntersectionOfTwoArrays{
    
    public static int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> resultSet = new HashSet<Integer>();

        for(int n : nums1)
            set.add(n);

        for(int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i]) && !resultSet.contains(nums2[i]))
                resultSet.add(nums2[i]);
        }

        int[] arr = new int[resultSet.size()]; 
        int i = 0;
        for (int num : resultSet)
            arr[i++] = num;
        
        return arr;
    }
    public static int[] UnionOfSets(int[] nums1, int[] nums2){

        Set<Integer> resultSet = new HashSet();
        
        for (Integer n : nums1)
            resultSet.add(n);

        Set<Integer> set2 = new HashSet();
        for (Integer n : nums2)
            set2.add(n);

        resultSet.retainAll(set2);
        
        int[] arr = new int[resultSet.size()]; 
        int i = 0;
        for (int num : resultSet)
            arr[i++] = num;
            
        return arr;
    }
    public static void main(String []args){

        Scanner input = new Scanner(System.in);
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9,4,9,8,4};
        input.close();
         
        int[] result = intersection(nums1, nums2);

        System.out.print("[ ");
        for(int n : result)
            System.out.print(n+" ");
        System.out.print("]");
     }
}