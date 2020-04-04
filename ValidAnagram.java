/***************************************************************************************************************************************
Name: Valid Anagram

Description: Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1: Input: s = "anagram", t = "nagaram"
	   Output: true

Examle 2:  Input: s = "rat", t = "car"
	   Output: false

Approach: To examine if t is a rearrangement of s, we count occurrences of each letter in the two strings and compare them since both 
	  s and t contain only letters from a−z, a simple counter table of size 26 is suffice. 
          We increment the counter for each letter in s and decrement the counter for each letter in t, then check if the counter 
	  reaches back to zero.

	  Note: You may assume the string contains only lowercase alphabets.

Time complexity: O(n). Time complexity is O(n) because accessing the counter table is a constant time operation.

Space complexity: O(1). Although we do use extra space, the space complexity is O(1) as the table's size stays constant ragardless of n.

***************************************************************************************************************************************/

import java.util.Scanner;

public class ValidAnagram{
    
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] anagramCheck = new int[26];
        
        for(int i = 0; i < s.length(); i++)
        {
            anagramCheck[s.charAt(i) - 'a'] ++;
            anagramCheck[t.charAt(i) - 'a'] --;            
        }

        for(int i : anagramCheck)
        {
            if(i != 0)
                return false;
        }
        
        return true;
    }
    public static void main(String []args){

         Scanner input = new Scanner(System.in);
         System.out.println("Enter value for s: ");
         String s = input.nextLine();
         System.out.println("Enter value for t: ");
         String t = input.nextLine();
         input.close();
         
         boolean result = isAnagram(s, t);
         System.out.println(result);
     }
}