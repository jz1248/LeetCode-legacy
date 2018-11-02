package priv.zzy.explore.medium.c06;

import priv.zzy.Solution;
import priv.zzy.utils.ArrayUtil;

import java.util.Arrays;

/**
 * <h2>最长上升子序列</h2>
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <hr />
 * 示例: <br />
 * 输入: [10,9,2,5,3,7,101,18]<br />
 * 输出: 4<br />
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。<br />
 * <hr />
 * 说明:<br />
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。<br />
 * 你算法的时间复杂度应该为 O(n^2) 。<br />
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?<br />
 */
public class C06T04 extends Solution {

    /**
     * 解法一
     * 动态规划 <br />
     * 设d[i]为序列中前i个元素并且以nums[i]结尾的最长上升子序列的长度 <br />
     * 则 d[i] = max(d[j] + 1),
     *          其中 0 <= j < i && nums[j] < nums[i]
     * <hr />
     *
     * 时间复杂度: O(n^2)    <br />
     * 空间复杂度: O(n)      <br />
     *
     * @param nums 无序整数序列
     * @return 最长上升子序列长度
     */
    public int solution1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] d = new int[nums.length];
        Arrays.fill(d, 1);

        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    d[i] = Integer.max(d[i], d[j] + 1);
                }
            }
        }

        int answer = d[0];
        for (int i = 0; i < d.length; i++) {
            answer = Integer.max(answer, d[i]);
        }
        return answer;
    }

    /**
     * 解法二
     * 动态规划（改进版解法一）<br />
     * 解法一中，内层循环较为耗时，并且题目只需要求长度，
     * 所以可以使用模拟栈，通过二分查找来降低复杂度
     *
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] stack = new int[nums.length];
        int top = -1;
        int answer = 1;

        stack[++top] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (stack[top] < nums[i]) {
                stack[++top] = nums[i];
            } else {
                answer = Integer.max(answer, top + 1);

                int index = ArrayUtil.lowerBound(stack, 0, top, nums[i]);

                stack[index] = nums[i];
            }
        }

        answer = Integer.max(answer, top + 1);

        return answer;
    }

    /**
     * 解法三
     * 同解法二，简化实现
     * @param nums
     * @return
     */
    public int solution3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] stack = new int[nums.length];
        int top = 0;
        stack[top] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (stack[top] < nums[i]) stack[++top] = nums[i];
            else {
                int l = 0, r = top, mid;
                while (l <= r) {
                    mid = (l + r) / 2;
                    if (stack[mid] < nums[i])
                        l = mid + 1;
                    else
                        r = mid - 1;
                }
                // 这里 l 一定是不小于nums[i]的最小下标
                //
                // 在跳出循环前，l == r是一定有机会成立的
                // 此时，若 r 没被修改过，说明对于任意x < r，有stack[x]<nums[i]
                // 若 r 被修改过，则有stack[r + 1] >= nums[i]
                // 同理，若 l 没被修改过，说明对于任意x > l，有stack[x]>=nums[i]，此时结果正确
                // 若 l 被修改过，则有stack[l - 1] < nums[i]
                //
                // 当 l == r 时，
                //      若 stack[mid] < nums[i]，
                //          即 stack[l] < nums[i] <= stack[r + 1]
                //          则 l = mid + 1 = r + 1，此时结果正确。
                //      否则， stack[mid] >= nums[i]
                //          即 stack[l] >= nums[i]
                //          则 r = mid - 1 = l - 1，此时结果正确。
                //
                // 综上，l 一定是不小于nums[i]的最小下标
                stack[l] = nums[i];
            }
        }

        return top + 1;
    }

    public int lengthOfLIS(int[] nums) {
        return solution3(nums);
    }

    @Override
    public void run() {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
