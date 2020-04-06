/***************************************************************************************************************************************
Name: Squares of a Sorted Array

Description: Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, 
	     also in sorted non-decreasing order.

Example 1:
	     Input: [-4,-1,0,3,10]
	     Output: [0,1,9,16,100]
Example 2:

	     Input: [-7,-3,2,3,11]
	     Output: [4,9,9,49,121]

	     
Approach 1:  Two Pointers
	     
Steps:
	1. Initialize an index to the end of the given A array in order to keep track of the final element in the result array
	2. Initialize two pointers first and last to the start and end of the given A array respectively 
	3. Initialize an empty result array of length equal to that of A array to store squares of the numbers 
	4. Loop through the array, where the stopping condition is reached once we reach index = 0, and fil the result array such that-
	   -> if Math.abs(A[first]) > Math.abs(A[last]) then put the square of the element pointed by 'first' and increment the pointer
	   -> if Math.abs(A[last]) >= Math.abs(A[first]) then put the square of the element pointed by 'last' and decrement the pointer	 
	   Make sure to decrement the index for the result array upon insertion of the square of the correct array element
	5. Return the result array

Time Complexity: O(N), where N is the length of A.

Space Complexity: O(N), the space used by the answer.


Approach 2:  Using in-built sort function
Steps:
	1. Looping through the array, overwrite the array elements with its 'square' values
	2. Sort the array using Arrays.sort function and return the sorted array.
  
Time Complexity: O(NlogN), where N is the length of A.

Space Complexity: O(N)

***************************************************************************************************************************************/

import java.util.Arrays;

public class SquaresOfSortedArray{
    public static int[] sortedSquares_twoPointers(int[] A){
        int index = A.length - 1;
        int first = 0;
        int last = A.length - 1;
        int[] result = new int[A.length];
        
        while(index >= 0)
            result[index--] = Math.abs(A[first]) > Math.abs(A[last]) ? A[first] * A[first++] : A[last] * A[last--];
            
        return result;
    }
    
    public static int[] sortedSquares_sortFunction(int[] A){
        for(int i = 0; i < A.length; i++)
            A[i] *= A[i];
        Arrays.sort(A);
        
        return A;
    }

    public static void printArray(int[] resultArray){
        System.out.print("[");
        for(int i = 0; i < resultArray.length; i++)
            System.out.print(resultArray[i] + ",");
        System.out.println("]");
    }
    
    public static void main(String []args){
        int[] A = new int[]{-4,-1,0,3,10};
        
        int[] resultByTwoPoiners = sortedSquares_twoPointers(A);
        int[] resultBySortFunction = sortedSquares_sortFunction(A);
        
        System.out.print("Result by Two Pointers Method: ");
        printArray(resultByTwoPoiners);
        System.out.print("Result by In-built Sort Function Method: ");
        printArray(resultBySortFunction);
         
    }
}