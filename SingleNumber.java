/***************************************************************************************************************************************
Name: Single Number 

Description: Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Example 1: Given nums = [2,2,1]
           Output: 1

Example 2: Given nums = [2,2,1]
         Output: 1

Approach 1: Two-pass Hash Table
Steps:	  
	1. The data structure we make use of is a HASH TABLE
	2. We create a hash table with the elements of the given array as key and the count for the occurrence of each 
	   element as the value for the key.
	3. We then traverse the HashMap to check which key value is a '1' and return it's key.

Time Complexity: O(n). Time complexity of for loop is O(n). Time complexity of hash table operation pop is O(1).

Space complexity: O(n). The space required by hash table is equal to the number of elements in nums array


Approach 2: XOR Method
Steps: 
	1. We use the fact: x ^ x = 0, so if you do XOR between all elements one element will remain as it is, while all 
	   others will turn to 0
	2. The remaining element is the answer and we therefore return it.
	
Basically, we can XOR all bits together to find the unique number.

Time Complexity: O(n⋅1) = O(n). Time complexity of for loop is O(n). Time complexity of hash table operation pop is O(1)

Space complexity: O(n). The space required by Hash table is equal to the number of elements in nums.

****************************************************************************************************************************************/
 
import java.util.Scanner;
import java.util.HashMap;

public class SingleNumber{
    public static int SingleNumber_HashSolution(int[] nums)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i <  nums.length; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else
                map.put(nums[i], 2);
        }
        
        for(Integer key : map.keySet()){
            if(map.get(key) == 1)
                return key;
       }
       
       return 0;
    }
    
    public static int SingleNumber_XorSolution(int[] nums)
    {
        int temp = 0;
        
        for(int element : nums)          
            temp ^= element;

        return temp;
    }    
    
    public static void main (String[] args) {
        
        int[] nums = new int[]{2,2,3,4,5,4,5,6,6};
 
        int xor_result = SingleNumber_XorSolution(nums);        
        System.out.println("Result by XOR Method: " + xor_result);

        int hashmap_result = SingleNumber_HashSolution(nums);       
        System.out.println("Result by Hashmap Method: " + hashmap_result);
        
    }
}