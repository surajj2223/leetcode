package leetcode

/**
 * Given an integer array nums, find the
 * subarray
 *  with the largest sum, and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */

/**
 * Brute force approach
 * O(N^2)
 */
fun maxSubArrayBruteForce(nums: Array<Int>): Int {
    var gSum = -999;
    for (i in 0 ..< nums.size - 1) {
        var mLSum = 0;
        for (j in i ..< nums.size) {
            mLSum+= nums[j];
            gSum = Math.max(gSum,mLSum)
        }
    }
    return gSum;
}

/**
 * Kadane's Algorithm
 * O(N)
 */
fun maxSubArrayKadanesAlgo(nums: Array<Int>): Int {
    var mSum = -999;
    var sum = 0;
    for (element in nums) {
        sum+= element;
        mSum = Math.max(sum, mSum);
        if (sum < 0) sum = 0;
    }
    return mSum;
}

fun main() {
    print(maxSubArrayKadanesAlgo(arrayOf(5,4,-1,7,8)))
}