/***************************************************************************************************************************************
Name: Add Strings

Description: Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
	     Note: The length of both num1 and num2 is < 5100.
		   Both num1 and num2 contains only digits 0-9.
		   Both num1 and num2 does not contain any leading zero.
		   You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:   Input: num1 = "123", num2 = "45"
	     Output: "168"

Example 2:   Input: num1: "999", num2 = "1"
	     Output: "1000"

Example 3:   Input: num1: "0", num2 = "0"
	     Output: "0"

Approach 1: Array-to-String Method

Steps:	1. Declare & initialize a max variable with the value = Math.max(num1.length(), num2.length()) + 1
	2. Declare a result array of length = max + 1 & also a carry variable with initial value as 0
	3. Looping through the two strings at the same time using i & j pointers pointed to the last element of num1 & num2 resp. 
	   & k variable initialized with the value of max; in order to store the sum of current two digits in each of the arrays,
	   we have variable left = i >= 0 ? num1.charAt(i) - '0' : 0 & right = (j >= 0) ? num2.charAt(j) - '0' : 0;
	   The reason to use this kind of assignment of value is that we won't care about indices i or j going negative in such case
	4. Once we have the two digits, we add them along with the value of carry & copy the value in variable 'sum'
	5. Next, fill the k index of result array with the condition as: result[k] = (char)((sum < 10) ? sum + '0' : sum - 10 + '0')
	   Note: (sum < 10) ? 0 : 1 is much faster than sum / 10; likewise (sum < 10) ? sum : sum - 10 instead of sum % 10
		 Also we fill the result from right to left as k is decrementing and this avoids reversal of the result
	6. Update the carry value as 0 if sum is less than 10 else update value as 1
	7. Once we are done accessing all elements of both the arrays & storing their sums in the result array, we reach the next part
	   of the code where by now i & j have reached negative index values & sum is 0 too as variables left, right & carry are zero,
	   so we convert the integer result array to String using valueOf method of String class which returns the string representation 
	   of a specific subarray of the char array argument - String valueOf(char[] array, int offset, int count) 
							         ... offset = initial offset of subarray & count = length of the subarray
	8. Return this String

Time Complexity: O(N), where N is the length of the longer of the 2 input strings.

Space Complexity: O(N).


Approach 2: String Builder Method
Intuition:  We need to return a new string & hence dynamic creation of the string is needed, & as String is immutable, in order to avoid
	    many discarded string object in heap memory we make use of StringBuilder that creates a mutable sequence of characters. 

Steps:	1. Declare & initialize 2 variables num1_length & num2_length to num1_length - 1 & num2_length - 1 resp. & variable carry = 0
	2. Create an empty string builder 'resultString' with no characters in it and an initial capacity of 16 characters.
	3. Looping through the 2 strings at the same time using a while loop where stopping condition = num1_length>=0 || num2_length>=0,
	   in order to store the sum of current two digits in each of the arrays, we have - 
	   variables num1_int = num1_length >= 0 ? num1.charAt(num1_length--) - '0' : 0 
	           & num2_int = (num2_length >= 0) ? num2.charAt(num2_length--) - '0' : 0;
	4. Once we have the two digits, we add them along with the value of carry & copy the value in variable result_int
	5. Using if-else branching condition, check if result_int is less than 9 in which case simply insert the value in resultString 
	   at offset = 0 & make carry = 0; if not, then insert (result_int - 10) value in resultString at offset = 0 & make carry = 1
	6. One ending while loop, check if carry is greater than 0, if yes then insert carry value in resultString at offset = 0;
	   this will happen in the Example 2 case mentioned above
	7. Last, convert the string builder 'resultString' to String and return it.

Time Complexity: O(N), where N is the length of the longer of the 2 input strings.

Space Complexity: O(N).

***************************************************************************************************************************************/

public class AddStrings{
    public static String arrayToString_solution(String num1, String num2) {
        int max = Math.max(num1.length(), num2.length()) + 1;
        char[] result = new char[max + 1];
        int carry = 0;
        
        for(int i = num1.length() - 1, j = num2.length() - 1, k = max; ; i--, j--, k--)
        {
            int left = i >= 0 ? num1.charAt(i) - '0' : 0;
            int right = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = left + right + carry;
            
            result[k] = (char)((sum < 10) ? sum + '0' : sum - 10 + '0');
            carry = sum < 10 ? 0 : 1;

            if(i < 0 && j < 0 && sum == 0)
                return String.valueOf(result, k + 1, max - k);                      // String valueOf(int[] data, int offset, int count) 
        }
    }
    
     public static String stringBuilder_solution(String num1, String num2) {
        int num1_length = num1.length() - 1;
        int num2_length = num2.length() - 1;
        int carry = 0;
        StringBuilder resultString = new StringBuilder();
        
        while(num1_length >= 0 || num2_length >= 0)
        {
            int num1_int = num1_length >= 0 ? num1.charAt(num1_length--) - '0' : 0;
            int num2_int = num2_length >= 0 ? num2.charAt(num2_length--) - '0' : 0;
            int result_int =  num1_int + num2_int + carry;
            if(result_int > 9)
            {
                resultString.insert(0, result_int - 10);
                carry = 1;               
            }
            else
            {
                resultString.insert(0, result_int);
                carry = 0;               
            }
        }
        if(carry > 0)
            resultString.insert(0, carry);
        
        return resultString.toString();
        }

    public static void printString(String result, int num)
    {
        if(num == 1)
            System.out.print("Result by Array-to-String Solution: ");
        else
            System.out.print("\nResult by String-Builder Solution: ");
        
        System.out.print("\"");
        for(int i = 0; i < result.length(); i++)
            System.out.print(result.charAt(i));
        System.out.print("\"");
    }

    public static void main(String []args){
        String s1 = "985";
        String s2 = "84";
        String result_by_arrayToStringSolution = arrayToString_solution(s1, s2);
        String result_by_stringBuilderSolution = stringBuilder_solution(s1, s2);
        
        printString(result_by_arrayToStringSolution, 1);
        printString(result_by_stringBuilderSolution, 2);
    }
}