/***************************************************************************************************************************************
Name: Two Sum

Description: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
	     You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
	     Given nums = [2, 7, 11, 15], target = 9,

             Because nums[0] + nums[1] = 2 + 7 = 9,
	     return [0, 1]

Steps (Two-pass Hash Table):

	1. We calculate the complement by using the target value (target - nums[i]) and check if it exists in the table,
	  making sure that the complement is not same as the nums[i] element itself. 
	2. Once the complement is found, we look up its index.

The data structure we use is a HASH TABLE as it serves as the best way to maintain mapping of each element in the array 
to it's index.

Time Complexity: O(n). We traverse the list containing n elements exactly twice. 
		 Since the hash table reduces the look up time to O(1), the time complexity is O(n).

Space Complexity: O(n). The extra space required depends on the number of items stored in the hash table, 
		  which stores exactly n elements.
***************************************************************************************************************************************/

import java.util.Scanner;
import java.util.HashMap;

public class TwoSum{
    
    public static int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            //add each element's value & it's index to the table
            map.put(nums[i], i);
        }
        
        //check if the elemment's complement exists in the table (also insure that the complement is not elemment itself!)
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i)
                return new int[] {i, map.get(complement)};
        }

        throw new IllegalArgumentException("No two sum solution");
    }

     public static void main(String []args){
         
         int[] nums = new int[5];
         Scanner input = new Scanner(System.in);
        
         System.out.print("Enter no. of elements you want in array: ");
         int num_of_array_ele = input.nextInt();
         
         for(int i=0; i<num_of_array_ele; i++){
            System.out.println("Ele "+(i + 1)+": ");
            nums[i] = input.nextInt();
         }

         System.out.print("Enter TARGET: ");
         int target = input.nextInt();
         
         int[] result = twoSum(nums, target);

         System.out.println("["+result[0]+", "+result[1]+"]");

         input.close();
     }
}