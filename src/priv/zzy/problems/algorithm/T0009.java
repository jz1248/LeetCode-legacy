package priv.zzy.problems.algorithm;

import priv.zzy.Solution;

/**
 * 判断一个整数是否是回文数。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class T0009 extends Solution {


    public boolean isPalindrome(int x) {
        return solution1(x);
    }

    /**
     * 解法1:
     * 朴素解法。
     * 将数字转换为字符串，倒序后与原串比较
     *
     * @param x
     * @return
     */
    private boolean solution1(int x) {
        if (x < 0) return false;
        if (x < 10) return true;    // 0 <= x <= 9
        String valueStr = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        sb.append(valueStr);
        sb.reverse();

        return sb.toString().equals(valueStr);
    }

    /**
     * 解法2:
     * 不将整数转为字符串
     *
     * @param x
     * @return
     */
    private boolean solution2(int x) {
        if (x < 0) return false;
        if (x < 10) return true;    // 0 <= x <= 9
        if (x % 10 == 0) return false;   // ends with 0 but starts with non-zero digit.

        int[] digits = new int[10];

        // extract digits. Note that x > 10 here.
        int a = x, len = 0;
        while (a != 0) {
            digits[len++] = a % 10;
            a /= 10;
        }

        for (int i = 0; i < len >> 1; ++i) {
            if (digits[i] != digits[len - i - 1])
                return false;
        }

        return true;
    }

    @Override
    public void run() {
        Integer[] inputs = {121, -121, 10};
        Boolean[] outputs = {true, false, false};
        for (int i = 0; i < inputs.length; ++i) {
            printCase(inputs[i], solution2(inputs[i]), outputs[i]);
        }
    }
}
