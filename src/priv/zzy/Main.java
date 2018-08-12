package priv.zzy;

import priv.zzy.problems.SolutionT0001;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    static byte[] evaluate(byte[] str) {
       byte leftWeight = 0;
       byte currentWeight = 0;

       for (int i = 0; i < str.length; ++i) {
           if (str[i] == '(') {
               ++currentWeight;
           } else {
               if (currentWeight == 0) {
                   ++leftWeight;
               } else {
                   --currentWeight;
               }
           }
       }
       byte[] result = new byte[2];
       result[0] = leftWeight;
       result[1] = currentWeight;
       return result;
    }

    static boolean isLegal(byte[] weight) {
        return weight[0] == 0 && weight[1] == 0;
    }

    static boolean isLegal(byte[] weight1, byte[] weight2) {
        return weight1[0] == 0 && weight1[1] == weight2[0] && weight2[1] == 0;
    }

    public static void main(String[] args) {
//        Solution s = new SolutionT0001();
//        s.run();
        Scanner cin = new Scanner(System.in);
        int answer = 0;
        int n = cin.nextInt();

        byte[][] weight = new byte[n][];

        for (int i = 0; i < n; ++i) {
            weight[i] = evaluate(cin.next().getBytes());
        }

        for (int i = 0; i < n - 1; ++i) {
            if (isLegal(weight[i])) {
                ++answer;
            }
            for (int j = i + 1; j < n; ++j) {
                if (isLegal(weight[i], weight[j])) {
                    ++answer;
                }
                if (isLegal(weight[j], weight[i])) {
                    ++answer;
                }
            }
        }
        if (isLegal(weight[n - 1])) {
            ++answer;
        }

        System.out.println(answer);

    }
}
