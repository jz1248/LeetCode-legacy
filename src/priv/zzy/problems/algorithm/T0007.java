package priv.zzy.problems.algorithm;

import priv.zzy.Solution;

/**
 * 给出一个 32 位的有符号整数，
 * 你需要将这个整数中每位上的数字进行反转。
 */
public class T0007 extends Solution {

    public int reverse(int x) {
        boolean isNegative = x < 0;
        long a = x;

        // convert abs(x) to String
        String strInt = String.valueOf(isNegative ? -a : a);

        StringBuilder sb = new StringBuilder();
        sb.append(strInt);
        sb.reverse();

        a = Long.parseLong(sb.toString());
        if (isNegative) a = -a;

        if (a > Integer.MAX_VALUE || a < Integer.MIN_VALUE)
            return 0;

        return (int)a;
    }

    @Override
    public void run() {
        Integer[] inputs = {123, -123, 120, Integer.MAX_VALUE, Integer.MIN_VALUE};
        Integer[] correctOutputs = {321, -321, 21, 0, 0};
        for (int i = 0; i < inputs.length; ++i) {
            printCase(inputs[i], reverse(inputs[i]), correctOutputs[i]);
        }
    }
}
