/***************************************************************************************************************************************
Name: Isomorphic Strings

Description: Given two strings s and t, determine if they are isomorphic.

	     Two strings are isomorphic if the characters in s can be replaced to get t.

	     All occurrences of a character must be replaced with another character while preserving the order of characters. 
	     No two characters may map to the same character but a character may map to itself.

Example 1:
	     Input: s = "egg", t = "add"
	     Output: true
Example 2:
	     Input: s = "foo", t = "bar"
	     Output: false
Example 3: 
	     Input: s = "paper", t = "title"
	     Output: true

Steps:
	1. Initially, if any of the strings is equal to null or if their lengths are not equal then return false
	2. Further, we declare a HASHMAP of <Character, Character> mapping
	3. Then we check 2 conditions for iterations equal to the length of one of the strings:
	   a. if the HashMap already contains the character of string s at the ith location then check if it is equal to the character 
	      of the string t at the same ith location, if not then return false
	   b. else we first check if the HashMap contains a character value equal to character at the ith location in t string
	      and if it does exist return false else, map the character in s string to the one in t string at ith location 
	   c. lastly, if all conditions are satisfied it means that all the mapping for each character of the two strings to 
	      each other comes out to e consistent and hence return true.

Time Complexity: O(n). Because of the containsValue() method where every search of containsValue() is O(n).
		 Note: so in HashMap objects are actually store inside an array. The position (index) will be calculated based 
		       on the hashcode of the object, so it the index will be index = hashcode % (length of the array). 
		       When two object are matched into the same index, hashmap will use a linkedlist to store them. 
		       That is where the O(N) comes in, because you might need to go through this whole linkedlist to check 
		       if the object is inside or not

Space complexity: O(n). The space required by has table is equal to the number of characters in any of the strings s or t

***************************************************************************************************************************************/

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class IsomorphicStrings{
    
    public static boolean isIsomorphic(String s, String t)
    {
        if(s == null || t == null || s.length() != t.length())
            return false;
            
        HashMap<Character, Character> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                char c = map.get(s.charAt(i));
                if(c != t.charAt(i))
                    return false;
            }
            else
            {
                if(map.containsValue(t.charAt(i)))
                    return false;
                map.put(s.charAt(i), t.charAt(i));
            }
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
         
         boolean result = isIsomorphic(s, t);
         System.out.println(result);
     }
}