/***************************************************************************************************************************************
Name: How Many Numbers Are Smaller Than the Current Number

Description: Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. 
	     That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Example 1:
	   Input: nums = [8,1,2,2,3]
	   Output: [4,0,1,1,3]

Example 2:
	   Input: nums = [6,5,4,8]
	   Output: [2,1,0,3]

Constraints:
	  1. 2 <= nums.length <= 500
	  2. 0 <= nums[i] <= 100

Approach I: Brute Force Method
Steps:	 1. We first create a new array of length equal to the length of nums array, to store the result
	 2. Then we simply traverse the array using nested for with the help of two pointers such that when we find an element larger 
	    than the current element in the array, we increment the current count at that particular index in the result array
	 3. Return the result array

Time Complexity: O(n * n)


Approach II: Hash Map
Steps:	  1. Clone the nums array into a new result array needed to obtain the result
 	  2. Sort the nums array
	  3. Declare a HashMap
	  4. Map the array element to its index
	  5. Traverse the array again and re-write the nums array with the mapped values for the elements
	  6. Return the modified nums array

Time Complexity: O(nlogn)


Approach III: Count Logic
Steps:	   1. We make use of the given constraint no. 2 and initlize an empty array 'numsCount' of length 101
	   2. Loop through nums array using n as pointer, and increment element at the nth position in the numsCount array
	   3. Loop through numsCount array beginning with index 1 and add element at nth index with the one at n - 1 index
	   4. Overwrite existing nums array element with the element in the numsCount array at index = nums[i] - 1. 
	      Here if nums array element equals to 0, we continue the loop as the lowest possible element value can be 0 
	   5. Return the modified nums array as result

Time Complexity: O(n)

***************************************************************************************************************************************/
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class SmallerNumbersThanCurrent{
    
    public static int[] bruteForceSolution(int[] nums)
    {
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            for(int j = 0;j<nums.length;j++)
            {
                if(nums[j]<nums[i])
                    result[i]++;
            }
        }
        
        return result;
    }
    
    public static int[] hashMapSolution(int[] nums)
    {
        int[] result = nums.clone();
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            //add each element's value & it's index to the table
            if(map.containsKey(nums[i]))
                continue;
            map.put(nums[i], i);
        }

        //check if the elemment's complement exists in the table (also insure that the complement is not elemment itself!)
        for(int i = 0; i < result.length; i++){
            nums[i] = map.get(result[i]);
        }
        
        return nums;
    }
    
    public static int[] withoutSortingSolution(int[] nums)
    {
        int[] numsCount = new int[101];

        for(int n : nums) numsCount[n]++;

        for(int i = 1; i < numsCount.length; i++)
            numsCount[i] = numsCount[i] + numsCount[i-1];
            
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)continue;
            nums[i] = numsCount[nums[i] - 1];
        }
        
        return nums;
    }

     public static void main(String []args){
         
         int[] nums = new int[]{8, 1, 2, 2, 3};
        
         int[] result = hashMapSolution(nums);
         System.out.print("[");
         for(int i = 0; i < result.length; i++){
            System.out.print(result[i]+",");
         }
         System.out.println("]");
     }
}