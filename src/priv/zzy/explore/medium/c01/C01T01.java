package priv.zzy.explore.medium.c01;

import priv.zzy.Solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 探索 - 中级练习
 *
 * 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */
public class C01T01 extends Solution {

    /**
     * 朴素解法，循环检查
     * 时间复杂度：O(n^3)
     * 提交结果：TLE
     * @param nums
     * @return
     */
    public List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                for (int k = j + 1; k < nums.length; ++k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> t = new ArrayList<>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[k]);
                        answer.add(t);
                    }
                }
            }
        }

        for (int i = 0; i < answer.size() - 1; ++i) {
            for (int j = i + 1; j < answer.size(); ++j) {
                if (isEqual(answer.get(i), answer.get(j))) {
                    answer.remove(j);
                    --j;
                }
            }
        }

        return answer;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        return solution1(nums);
    }

    boolean isEqual(List<Integer> l1, List<Integer> l2) {
        Integer sum1 = 0, sum2 = 0;
        for (Integer i: l1) {
            sum1 += i;
        }
        for (Integer i: l2) {
            sum2 += i;
        }

        boolean maxIsEqual = Integer.max(l1.get(0),Integer.max(l1.get(1), l1.get(2))) == Integer.max(l2.get(0),Integer.max(l2.get(1), l2.get(2)));
        boolean minIsEqual = Integer.min(l1.get(0),Integer.min(l1.get(1), l1.get(2))) == Integer.min(l2.get(0),Integer.min(l2.get(1), l2.get(2)));
        boolean sumIsEqual = sum1.equals(sum2);
        return maxIsEqual && minIsEqual && sumIsEqual;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                int[] nums = stringToIntegerArray(line);

                List<List<Integer>> ret = threeSum(nums);

                String out = int2dListToString(ret);

                System.out.print(out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
