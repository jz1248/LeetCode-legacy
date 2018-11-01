package priv.zzy.explore.medium.c06;

import priv.zzy.Solution;

import java.util.Arrays;

/**
 * <h2>零钱兑换</h2>
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。<br/>
 * 编写一个函数来计算可以凑成总金额所需的 <b>最少</b> 的硬币个数。<br/>
 * 如果 <b>没有任何一种</b> 硬币组合能组成总金额，返回 <b>-1</b>。<br/>
 * <hr/>
 * 示例 1:<br/>
 * 输入: coins = [1, 2, 5], amount = 11<br/>
 * 输出: 3 <br/>
 * 解释: 11 = 5 + 5 + 1<br/>
 * <br/>
 * 示例 2:<br/>
 * 输入: coins = [2], amount = 3<br/>
 * 输出: -1<br/>
 * <hr/>
 * 说明:<br/>
 * 你可以认为每种硬币的数量是无限的。<br/>
 */
public class C06T03 extends Solution {

    /**
     * 解法一：动态规划
     *
     * 设 d[i]: 凑成总金额 i 元所需的最少硬币数。
     * 则有状态转移方程：
     * d[i] = min(d[i - coins[j]] + 1), j: 0 ... coins.length - 1
     *
     * 时间复杂度：O(amount * coins.length)
     * 空间复杂度: O(amount)
     * 提交状态: Accepted
     *
     */
    public int solution1(int[] coins, int amount) {
        int[] d = new int[amount + 1];
        Arrays.fill(d, -1);
        d[0] = 0;

        int index;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (rangeCheck(index = i - coins[j], 0, amount) && d[index] != -1) {
                    d[i] = d[i] == -1 ? d[index] + 1 : Integer.min(d[i], d[index] + 1);
                }
            }
        }

        return d[amount];
    }

    private boolean rangeCheck(int val, int min, int max) {
        return min <= val && val <= max;
    }

    /**
     * 计算所需最少的硬币个数
     * @param coins 硬币面额
     * @param amount 总金额
     * @return 最少硬币数；-1：不存在组合
     */
    public int coinChange(int[] coins, int amount) {
        return solution1(coins, amount);
    }

    @Override
    public void run() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
}
