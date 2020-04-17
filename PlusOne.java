/***************************************************************************************************************************************
Name: Plus One

Description: Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
	     The digits are stored such that the most significant digit is at the head of the list, and each element in the array 
	     contain a single digit. You may assume the integer does not contain any leading zero, except the number 0 itself.
	     You may assume no duplicates in the array.

Example 1:   Input: [1,2,3]
	     Output: [1,2,4]
	
	     Explanation: The array represents the integer 123.

Example 2:   Input: [4,3,2,1]
	     Output: [4,3,2,2]
	     
	     Explanation: The array represents the integer 4321.

Steps:
	1. If digits array is found to be null, return null
	2. Looping through the array, beginning from the end the of the array, check if the current array element is less than 9
	   If yes, increment the value of the array element by 1 and return the array
	   If not, the element is 9 and hence adding 1 to it would lead to 0 in the unit place so make element at current index, 0
	3. In the case where all elements of the array are 9, we will create a new result array of length = digits.length + 1
	   An integer containing all digits = 9, is incremented by 1, its most significant digit will become 1 so we make result[0] = 1
	   we then return the result array.

Time Complexity: O(N), where N is the length of nums.

Space Complexity: O(N).

***************************************************************************************************************************************/

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        if(digits == null)
            return null;
            
        for(int i = digits.length - 1; i >= 0; i-- )
        {
            if(digits[i] < 9)
            {
                digits[i]++;
                return digits;
            }
            else
                digits[i] = 0;
        }
        
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        
        return result;
    }

    public static void main(String []args){
        
        int[] digits = new int[]{9,9,9};
        int[] plusOne = plusOne(digits);
        
        System.out.print("[");
        for(int i = 0; i < plusOne.length; i++)
            System.out.print(plusOne[i] + ",");
        System.out.println("]");        
    }
}
