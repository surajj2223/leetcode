package leetcode

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 *
 * MEDIUM
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 */

 fun maxProfitBuySellStock2 (prices: IntArray): Int {
    var p1 = 0; var p2 = 1; var toSell = -1; var buy = -1; var profit = 0;
    for (i in 0 ..< prices.size -1) {
        if (prices[p1] < prices[p2]) {
            if (buy == -1) {
                buy = prices[p1];
            }
        } else {
            if (buy != -1) {
                profit+= prices[p1] - buy;
                buy = -1;
            }
        }
        p1++; p2++;
    }

    if (buy != -1) {
        profit += prices[prices.size - 1] - buy;
    }

    return profit;
}

fun main() {
    print(maxProfitBuySellStock2(intArrayOf(7,1,5,3,6,4)))
}

/**
 * Solution:
 *
 * Here we have to actually find what is the total maximum profit we can make from the input set i.e.
 * we need to make maximum profit by making sure to buy and sell the stocks at all opportunities.
 * So we start by looking at subsequent indexes with 2 pointers and check if current is less than next that means we are looking at a RISE
 * hence BUY (if it's not bought already) else there is DIP hence we sell only if its already bought.
 * This goes on until n-2th index and finally we check if there is something that was bought and wasn't sold
 * so we sell it using n-1th price because if having something as bought left means there was a RISE
 * encountered which is only possible if n-1th element was bigger than n-2nd.
 */