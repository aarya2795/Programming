/***************************************************************************************************************************************
Name: Count Primes

Description: Count the number of prime numbers less than a non-negative number, n.

Example: Input: 10
	 Output: 4
	 Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

Approach: This solution is simply based on Sieve of Eratosthenes (https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes).

Steps:
	1. Init an array (isPrime[]) of size = n and type = boolean. Initialize all numbers 2 and the ones that are not multiples of 2 
	   as true for now i.e. just start at 3 and iterate by 2 through the loops, we will later cross off the non-prime numbers.
	2. Loop through array and set multiples of prime p to false;notice here, we only need to loop until square root of n 
	   (instead of n) to cross off all non-primes
	   Note: To cross off multiples of prime p, we want to cross off 2p, 3p, 4p, 5p, but all kp where k < p have already been 
	   crossed off in a previous step. For this reason, for each prime, we can start crossing off at p + p
	3. Loop through array and count the primes
	4. Return the count.

Tip: Since you know any multiple of 2 can't be a prime, you can eliminate a huge chunk of work from all three steps.

Time Complexity: O(sqrt(n) * n) as we have nested loops.

		 However, this analysis did not take into account that the inner loop is skipped whenever isPrime[i] is true. 
		 The actual time complexity is O(n * log(log(n))) according to this link -
		 (https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes#Algorithmic_complexity)

Space Complexity: O(n) due to boolean[]isPrime.

***************************************************************************************************************************************/

import java.util.Scanner;

public class CountPrimes{
    
    public static int countPrimes(int n)
    {
        if(n <= 2)
            return 0;

        boolean isPrime[] = new boolean[n];
        isPrime[2] = true;

        for(int i = 3; i < n; i += 2)
            isPrime[i] = true;

        for(int i = 3; i * i < n; i += 2)
        {
            if(isPrime[i])
            {
                for(int next = i + i; next < n; next += i)
                    isPrime[next] = false;
            }  
        }
        
        int count = 1;
        
        for(int i = 3; i < n; i += 2)
        {
            if(isPrime[i])
                count++;
        }    
        
        return count;
    }

     public static void main(String []args){

         Scanner input = new Scanner(System.in);
         System.out.println("Enter value for n: ");
         int n = input.nextInt();
         input.close();
         
         int count = countPrimes(n);
         System.out.println("Number of Prime numbers less n are: " + count);
     }
}