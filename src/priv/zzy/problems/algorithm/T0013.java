package priv.zzy.problems.algorithm;

import priv.zzy.Solution;

import java.util.HashMap;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。
 * 12 写做 XII ，即为 X + II 。
 * 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。
 * 但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。
 *
 * 这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T0013 extends Solution {

    public int romanToInt(String s) {
        HashMap<Character, Integer> valueDict = new HashMap<>();
        valueDict.put('I', 1);
        valueDict.put('V', 5);
        valueDict.put('X', 10);
        valueDict.put('L', 50);
        valueDict.put('C', 100);
        valueDict.put('D', 500);
        valueDict.put('M', 1000);

        int ans = 0;
        char c, nextc;
        for (int i = 0; i < s.length(); ++i) {
            c = s.charAt(i);
            if (i < s.length() - 1) {
                nextc = s.charAt(i + 1);
                if (c == 'I') {
                    if (nextc == 'V' || nextc == 'X') {
                        ans += valueDict.get(nextc) - valueDict.get(c);
                        ++i;
                        continue;
                    }
                } else if (c == 'X') {
                    if (nextc == 'L' || nextc == 'C') {
                        ans += valueDict.get(nextc) - valueDict.get(c);
                        ++i;
                        continue;
                    }
                } else if (c == 'C') {
                    if (nextc == 'D' || nextc == 'M') {
                        ans += valueDict.get(nextc) - valueDict.get(c);
                        ++i;
                        continue;
                    }
                }
            }
            ans += valueDict.get(c);
        }

        return ans;
    }

    @Override
    public void run() {
        String[] inputs = {"IV", "IX", "LVIII", "MCMXCIV"};
        Integer[] outputs = {4, 9, 58, 1994};
        test(inputs, outputs, this, "romanToInt", String.class);
    }
}
