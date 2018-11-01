package priv.zzy.explore.medium.c06;

import priv.zzy.Solution;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 */
public class C06T01 extends Solution {

    public boolean canJump(int[] nums) {
        boolean[] can = new boolean[nums.length];

        can[nums.length - 1] = true;
        for (int i = can.length - 1; i >= 0; --i) {
            if (nums[i] == 0) continue;
            for (int j = i + 1; j <= i + nums[i]; ++j) {
                if (j < can.length && can[j]) {
                    can[i] = true;
                    break;
                }
            }
        }

        return can[0];
    }

    @Override
    public void run() {
        int[] nums = {3,1,1,4,2};
        System.out.println(canJump(nums));
    }
}
