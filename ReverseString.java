/***************************************************************************************************************************************
Name: Reverse String

Description: Write a function that reverses a string. The input string is given as an array of characters char[].
	     Do not allocate extra space for another array, do this by modifying the input array in-place with O(1) extra memory.
	     You may assume all the characters consist of printable ascii characters.

Example 1:   Input: ["h","e","l","l","o"]
	     Output: ["o","l","l","e","h"]

Example 2:   Input: ["H","a","n","n","a","h"]
	     Output: ["h","a","n","n","a","H"]

Approach: Two Pointers Approach

Intuition: In this approach, two pointers are used to process two array elements at the same time. Usual implementation is to set one 
	   pointer in the beginning and one at the end and then to move them until they both meet.

Steps:  1. Set pointer left at index 0, and pointer right at index n - 1, where n is a number of elements in the array.
	2. While left < right:
	   --> Swap s[left] and s[right].
	   --> Move left pointer one step right, and right pointer one step left.

Time Complexity: O(N) to swap N/2 element.

Space Complexity: O(1).

***************************************************************************************************************************************/

public class ReverseString{
    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;

        while(left < right)
        {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
    
    public static void main(String args[]) {
        char[] s = {'H','a','n','n','a','h'};
        reverseString(s);
        
        System.out.println(s);
    }
}