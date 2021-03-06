/***************************************************************************************************************************************
Name: First Unique Character in a String

Description: Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Example 1: s = "leetcode"
	   return 0

Example 2: s = "loveleetcode"
	   return 2

Approach: The best possible solution here could be of a linear time because to ensure that the character is unique you have to check the 
	  whole string anyway.

Steps:
	1. We go through the string and save in a hash map the number of times each character appears in the string
	2. Further we go through the string the second time, this time we use the hash map as a reference to check if a character is 
	   unique or not
	3. If the character is unique, just return its index

Time Complexity: O(N) since we go through the string of length N two times.

Space Complexity: O(N) since we have to keep a hash map with N elements.

***************************************************************************************************************************************/

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class FirstUniqueCharInString{
    public static int firstUniqChar(String s)
    {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(int i = 0; i < s.charAt(i); i++)
        {
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        
        return -1;
    }

	public static void main(String[] args){

	Scanner input = new Scanner(System.in);
        System.out.println("Enter String s: ");
        String s = input.nextLine();
		
	int result = firstUniqChar(s);
	System.out.println(result);

	}
}
