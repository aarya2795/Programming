/***************************************************************************************************************************************
Name: Search Insert Position

Description: Given an array of size n, find the majority element. 
	     The majority element is the element that appears more than ⌊ n/2 ⌋ times.
	     You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:   Input: [3,2,3]
	     Output: 3

Example 2:   Input: [2,2,1,1,1,2,2]
	     Output: 2

Approach 1:  Sorting Array

Steps:	1. Sort the array using the Arrays.sort() method
	2. Return the element present at index = n/2, as this will be the majority element since it occurs n/2 or more no. of times

Time Complexity: O(N log(N)), where N is the length of nums.

Space Complexity: O(1)
----------------------------------------------------------------------------------------------------------------------------------------

Approach 2:  Brute Force 
	     (We can exhaust the search space in quadratic time by checking whether each element is the majority element.)

Steps: 	1. The brute force algorithm iterates over the array, and then iterates again for each number to count its occurrences. 
	2. As soon as a number is found to have appeared more than any other can possibly have appeared, return it.

Time Complexity: O(N^2), where N is the length of nums.

Space Complexity: O(1)
----------------------------------------------------------------------------------------------------------------------------------------

Approach 3: HashMap Method 

Main Idea: We know that majority element occurs more than ⌊ n/2 ⌋ times, and a HashMap best allows us to count element occurrences)

Steps:	1. Use a HashMap that maps elements to counts in order to count occurrences in linear time by looping over nums.
	2. Then, we simply return the key with maximum value.

Time Complexity: O(N), where N is the length of nums.
		 We iterate over nums once and make a constant time HashMap insertion on each iteration. 
		 Therefore, the algorithm runs in O(n)O(n) time.

Space Complexity: O(N)
----------------------------------------------------------------------------------------------------------------------------------------

Approach 4: Sufix- Prefix Logic

Main idea: If we don't have the majority element in the prefix, then the suffix must have a majority element,
	   and this majority element will also be the majority element for the entire array.

Steps: 	
	1. Declare & initialize a variable 'count' to 0 and an Integer object 'majorityElement' to null
	2. Loop through the array. At each index i, we treat the array as 2 pieces- prefix as [0, i) & suffix as [i, end]
	3. If count == 0 which means no majority element is present in prefix, then set majority element as current element
	4. Increment the count by 1 if current element == count, and decrement the count by 1 if current element != count
	5. Return the majorityElement

Time Complexity: Time Complexity: O(n)

Space Complexity: O(1)

***************************************************************************************************************************************/

import java.util.Arrays; 
import java.util.Map;
import java.util.HashMap;

public class MajorityElement {
    
    public static int sortArrayMethod(int[] nums) {
        Arrays.sort(nums);
        return(nums[nums.length / 2]);
    }
    
    public static int bruteForce(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int flag = 0;
            for(int j = i + 1; j < nums.length; j++)
                if(nums[i] == nums[j])
                    flag++;
            
            if(flag >= (nums.length / 2))
                return nums[i];
        }
        
        return -1;
    }
    
    public static int HashMapMethod(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        
        Map.Entry<Integer, Integer> majorityElement = null;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            if(majorityElement == null || entry.getValue() > majorityElement.getValue())
                majorityElement = entry;
        
        return majorityElement.getKey();
    }
    
    public static int prefix_sufix_logic(int[] nums) {
        Integer majorityElement = null;
        int count = 0;
        
        for(int current_element : nums)
        {
            if (count == 0)                       // no majority element in prefix
                majorityElement = current_element;  //selects new majority element
            
            count += (current_element == majorityElement) ? 1 : -1;
        }
        
        return majorityElement;
    }
    
	public static void main(String[] args) {
	    
		int[] nums = new int[]{2,2,1,1,1,2,2};
		int result_sortArray = sortArrayMethod(nums);
		int result_bruteForce = bruteForce(nums);
		int result_hashMap = HashMapMethod(nums);
		int result_prefixSufix= prefix_sufix_logic(nums);
		
    	System.out.println("Result by Sorting Array Method: " + result_sortArray);
    	System.out.println("Result by Brute Force Method: " + result_bruteForce);
    	System.out.println("Result by HashMap Method: " + result_hashMap);
    	System.out.println("Result by Prefix-Sufix Logic: " + result_prefixSufix);
	}
}