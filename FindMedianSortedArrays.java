/***************************************************************************************************************************************
Name: Median of Two Sorted Arrays

Description: There are two sorted arrays nums1 and nums2 of size m and n respectively.
	     Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
	     You may assume nums1 and nums2 cannot be both empty.

Example 1:   nums1 = [1, 3]
	     nums2 = [2]
	     The median is 2.0

Example 2:   nums1 = [1, 2]
	     nums2 = [3, 4]
	     The median is (2 + 3)/2 = 2.5
	     
Edge condition example:
Example 3:   nums1 = [23,26,31,35]
	     nums2 = [3,5,7,9,11,16]
	     The median is (11 + 16)/2 = 13.5

Notes: 	     Given a sorted array, Median is the middle element if length of the array is odd and 
             it is the average of the middle 2 elements if length of the array is even. 
	     So basically, median is an element that partitions the array into two halves.

	     In case of 2 sorted arrays, the median of the merged sorted array is considered to be the median of the two arrays
	     But the time complexity in this approach will be O(m + n) so we need an alternative approach to this Brute Force solution
	     in order to get time complexity = O(log(m+n))	     

Idea:  
	     Consider two sorted arrays x and y
	     X --> x1, x2, x3, x4, x5, x6
	     Y --> y1, y2, y3, y4, y5, y6, y7, y8

	     So our task if to partition the array into 2 halves such that the number of elements in each half is exactly same and every 
	     element on the left half is less than equal to every element in the right half. 

	     So considering the arrays above, if we partition X array like this - x1, x2  |  x3, x4, x5, x6	
	     then in order to get the median it is necesaary to partion Y array like this - y1, y2, y3, y4, y5  |  y6, y7, y8 so that,
	     as the LHS of the combined array will have 2 + 5 = 7 elements and RHS will have 4 + 3 = 7 elements i.e. both the arrays 
	     are now partitioned into equal halves

	     Our next task is to check for the combined array if the every element on the LHS <= every element on the RHS.
	     We know that x2 <= x3 and y5 <= y6 so to get the median of combined array, we need to make sure the following 2 conditons:
	     1. x2 <= y6
	     2. y5 <= x3	

	     Once we find such a partition, the elements that are going to help us find the median are x2, y5, x3 and y6 such that,
	     for the combined array which will be having 14 elements in total, the median will be average( max(x2, y5), min(x3, y6))
	Note: If there was an alternating case where the combined array would have odd number of elements then median = max(x2, y5)

	     Hence, to obtain the correct partition, we do a binary search on the smaller of the two arrays making sure that every 
	     element on the LHS <= every element on the RHS which will give us time complexity = O(log(min(x, y))) 
												 where x and y are lengths of the X & Y

Time Complexity: O(min(log(m+n)))

Space Complexity: O(1).

***************************************************************************************************************************************/

public class FindMedianSortedArrays {
    public static double findMedianSolution(int[] nums1, int[] nums2) {
        // if length of nums1 array is greater than that of nums2 then switch the arrays
        if(nums1.length > nums2.length)
            return findMedianSolution(nums2, nums1);
        
        int m = nums1.length;
        int n = nums2.length;
        
        int start = 0;
        int end = m;
        
        while(start <= end)
        {
            int xPartition = (start + end) / 2;
            int yPartition = (m + n + 1) / 2 - xPartition;       
            // reason for adding 1 is that it plays well in case of even and odd number of elements in the combined array
            
            int maxLeftX = (xPartition == 0) ? Integer.MIN_VALUE : nums1[xPartition - 1];
            int minRightX = (xPartition == m) ? Integer.MAX_VALUE : nums1[xPartition];
            
            // if xPartition is 0 it means nothing is there on the left side so we use -INF for minLeftX
            // if xPartition is equal to the length of the nums1 array, it means nothing is there on the right side 
            // so we use +INF for maxRightX
            int maxLeftY = (yPartition == 0) ? Integer.MIN_VALUE : nums2[yPartition - 1];
            int minRightY = (yPartition == n) ? Integer.MAX_VALUE : nums2[yPartition];
            
            if(maxLeftX <= minRightY && maxLeftY <= minRightX)
            {
                // By now we have partitioned the array at correct position
                // Now we get max of left elements and min of right elements to get median in case of even length combined array size
                // or get max of left for odd length combined array size
                if((m + n) % 2 == 0)
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                else
                    return (Math.max(maxLeftX, maxLeftY));
            }
            else if(maxLeftX > minRightY)
                end = xPartition - 1;
            else
                start = xPartition + 1;
        }
        // This part of the code will be reached only when the input arrays are not sorted
        throw new IllegalArgumentException("arrays are not sorted");
    }
    
    public static void main(String []args){
    int[] nums1 = new int[]{23,26,31,35};
    int[] nums2 = new int[]{3,5,7,9,11,16};
    
    double median = findMedianSolution(nums1, nums2);
         
    System.out.println(median);
    
    }
}