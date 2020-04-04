/***************************************************************************************************************************************
Name: Contains Duplicate

Description: Given an array of integers, find if the array contains any duplicates.
	     Your function should return true if any value appears at least twice in the array, 
	     and it should return false if every element is distinct.

Example 1: Input: [1,2,3,1]
	   Output: true

Example 2: Input: [1,2,3,4]
	   Output: false

Example 3: Input: [1,1,1,3,3,4,3,2,4,2]
	   Output: true

Approach: Utilize a dynamic data structure that supports fast search and insert operations which is a Hash Table.
	  The operations we need to support here are search() and insert(). For a self-balancing Binary Search Tree, 
	  the search() and insert() are both O(logn) time. For a Hash Table, search() and insert() are both O(1) on average.
	  Hence, by using hash table, we can achieve linear time complexity for finding the duplicate in an unsorted array.

Steps: 
	1. Initialize an Empty HashSet of length equal to array 'nums' length
	2. While traversing through all the elements of the array check if the array element is already present in the set; if it is 
	   then return true as that is the duplicate
	3. Once you reach the end of the array and did not find any duplicate element in the array, return false

Time complexity : O(n). We do search() and insert() for n times and each operation takes constant time.

Space complexity: O(n). The space used by a hash table is linear with the number of elements in it.

***************************************************************************************************************************************/

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicate{
    
    public static boolean containsDuplicate(int[] nums)
    {
        Set<Integer> set = new HashSet<>(nums.length);
        
        for(int i = 0;i < nums.length;i++)
        {
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        
        return false;
    }

     public static void main(String []args){
    
         Scanner input = new Scanner(System.in);
         int[] nums = new int[]{1,1,1,3,3,4,3,2,4,2};
         input.close();
         
         boolean result = containsDuplicate(nums);
         System.out.println(result);
     }
}