/***************************************************************************************************************************************
Name : ContainsDuplicate II

Description: Given an array of integers and an integer k, find out whether there are two distinct indices i and j in array 
	     such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1: Input: nums = [1,2,3,1], k = 3
	   Output: true

Example 2: Input: nums = [1,0,1,1], k = 1
	   Output: true

Example 3: Input: nums = [1,2,3,1,2,3], k = 2
	   Output: false

Approach: While traversing through the elements of the array check if the array element is already present in the HashMap
	  If it is present then we calculate the absolute difference of the current index and the index value stored for 
	  the duplicate element (key), and if this difference is less than or equal to the given k value, then return true.

Time complexity : O(n). We do search() and insert() for n times and each operation takes constant time.
		  The Math.abs takes O(1) time complexity, as the operation itself is constant time and the input is fixed. 
		  Regardless of the input, the operation will always take the save time.

Space complexity: O(n). The space used by a hash table is linear with the number of elements in it.

***************************************************************************************************************************************/

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import static java.lang.Math.abs;

public class ContainsDuplicateII{
    
    public static boolean containsNearbyDuplicate(int[] nums, int k)
    {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(nums[i]))
            {
                if(Math.abs((map.get(nums[i]) - i)) <= k)
                    return true;
            }
            map.put(nums[i], i);
        }
        
        return false;
    }

     public static void main(String []args){
    
         Scanner input = new Scanner(System.in);
         int[] nums = new int[]{1,2,3,1,2,3};
         System.out.println("Enter k: ");
         int k = input.nextInt();
         input.close();
         
         boolean result = containsNearbyDuplicate(nums, k);
         System.out.println(result);
     }
}