package leetcode

import kotlin.math.max

/**
 * EASY
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */

fun maxProfitBuySellStock1(prices: IntArray): Int {
    var buy = prices[0];
    var profit = 0;
    for(i in 1..<prices.size) {
        if (prices[i] < buy) buy = prices[i];
        else {
            profit=max(profit, prices[i] - buy)
        }
    }
    return profit;
}

/**
 * Solution:
 * Assumption: Person should sell the stock with max profit that means we need to find the max of profitable
 * events for a single buy, i.e. Once bought, we have the array to track sell events i.e. prices of stocks bigger
 * than bought, we keep checking the profit that can be made by selling on all of those and just updating the profit
 * only when the new profit is bigger than last.
 *
 * Regarding buying, we assume we buy at day 0 and  starts to traverse for next subsequent days, if we hit a DIP we say okay now
 * I am buying here and start to track profits within next days.
 *
 * Good to understand if we are not actually buying / selling until we finalize the MAX PROFIT.
 *
 */