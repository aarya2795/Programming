/***************************************************************************************************************************************
Name: Roman to Integer

Description: Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

	     Symbol       Value
	     I             1
	     V             5
	     X             10
	     L             50
	     C             100
	     D             500
	     M             1000

	     Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:   Input: "III"		Example 4: Input: "LVIII"
	     Output: 3				   Output: 58
	     abc acb

Example 2:   Input: "IV"		Example 5: Input: "MCMXCIV"
	     Output: 4				   Output: 1994

Example 3:   Input: "IX"
	     Output: 9

Approach 1: Switch Case Method

Intuition: The idea is: if the value of current Roman character is bigger than the previous one, the result should plus the value of the 
	   current character and minus the value of the previous one.. e.g. "CM" means 900, initialize variable result=0; the result 
	   should plus (1000 - 100)


Approach 2: HashMap Method

Intuition: Using a hashmap we map the conversions of roman digits to integer. Now, if a numeral with smaller value precedes one with a 
	   larger value, we subtract the value from the total, otherwise we add the value to the total. 
	   At the end, we still have to add the last character value.

***************************************************************************************************************************************/

import java.util.Map;
import java.util.HashMap;

public class RomanToInt{
    public static int switchCaseSolution(String s) {
        int result = 0, current = 0, previous = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            switch(s.charAt(i))
            {
                case 'I': current = 1;
                    break;
                case 'V': current = 5;
                    break;
                case 'X': current = 10;
                    break;
                case 'L': current = 50;
                    break;
                case 'C': current = 100;
                    break;
                case 'D': current = 500;
                    break;
                case 'M': current = 1000;
                    break;
            }
            
            if(current > previous)
                result = result - (2 * previous) + current;
            else
                result += current;
            previous = current;
        }
        return result;
    }
    
    public static int hashMapSolutin(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap();
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);        
        
        for(int i = 0; i < s.length() - 1; i++)
        {
            if(map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))
                result -= map.get(s.charAt(i));
            else
                result += map.get(s.charAt(i));
        }
        return (result + map.get(s.charAt(s.length() - 1)));
    }
    
    public static void main(String args[]) {
        String s = "MCMXCIV";
        
        System.out.println("Result by Switch Case Method: " + switchCaseSolution(s));
        System.out.println("Result by Hash Map Method: " + hashMapSolutin(s));
    }
}