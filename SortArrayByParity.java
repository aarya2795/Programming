/***************************************************************************************************************************************
Name: Sort Array By Parity

Description: Given an array A of non-negative integers, return an array consisting of all the even elements of A, 
	     followed by all the odd elements of A. You may return any answer array that satisfies this condition.

Example 1:   Input: [3,1,2,4]
	     Output: [2,4,3,1]
	     
	     The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Approach 1:  Two Pass
	     Write all the even elements first, then write all the odd elements.
Steps:
	1. Initialize a new empty result array of length = length of A array
	2. Looping through the A, copy all even elements in the result array using an index variable. All even elements are copied first
	3. Loop through the array, copy all odd elements in the result array by incrementing the same index variable used previously.
	   All odd elements are now copied following the even ones.

Time Complexity: O(N), where N is the length of A.

Space Complexity: O(N), the space used by the answer.


Approach 2:  Two Pointer
Steps:
	1. Initialize two pointers namely even and odd to track the elements from front beginning and end of the array, A respectively
	2. In a while loop check if the element at index pointed by 'even' is even, if yes then simply increment the even pointer but
	   if not, then check if the element at index pointed by 'odd' is even, if yes then simply swap both the elements and if not 
           then simply decrement the pointer odd as the odd element is in its desired position already and shouldn't be moved
	3. The stopping criteria would be reached when even pointer is greater than the odd pointer 

Time Complexity: O(N), where N is the length of A.

Space Complexity: O(1), the space used for swapping

***************************************************************************************************************************************/

public class SortArrayByParity{
    public static int[] sortArrayByParity_linear(int[] A)
    {
        int[] resultArray = new int[A.length];
        int index = 0;
        
        for(int i = 0; i < A.length; i++)
        {
            if(A[i]%2 == 0)
                resultArray[index++] = A[i];
        }
        
        for(int i = 0; i < A.length; i++)
        {
            if(A[i]%2 != 0)
                resultArray[index++] = A[i];
        }
        
        return resultArray;
    }  
    public static int[] sortArrayByParity(int[] A)
    {
        int even = 0;               //i
        int odd = A.length - 1;     //j
        
        while(even < odd)
        {
            if(A[even]%2 != 0)
            {
                if(A[odd]%2 == 0)
                {
                    int temp = A[even];
                    A[even] = A[odd];
                    A[odd] = temp;
                    even ++;
                    odd --;
                }
                else
                    odd--;
            }
            else
                even++;
        }
        
        return A;
    }
    public static void printArray(int[] result)
    {
        System.out.print("[");
        for(int i = 0; i < result.length; i++)
            System.out.print(result[i]+",");
        System.out.println("]");
    }

    public static void main(String []args){
        int[] A = new int[]{3,1,2,4};
         
        int[] resultWithoutPointers = sortArrayByParity_linear(A);
        printArray(resultWithoutPointers);
         
        int[] resultWithPointers = sortArrayByParity(A);
        printArray(resultWithPointers);
    }
}