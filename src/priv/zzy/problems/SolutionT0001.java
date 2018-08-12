package priv.zzy.problems;

import priv.zzy.Solution;

import java.util.ArrayList;
import java.util.HashMap;

public class SolutionT0001 extends Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> bucket = new HashMap<>();
        for (int i=0;i<nums.length;++i) {
            bucket.putIfAbsent(nums[i], new ArrayList<>());
            bucket.get(nums[i]).add(i);
        }

        for (Integer number: bucket.keySet()) {
            ArrayList<Integer> indexes = bucket.get(target - number);
            if (indexes != null) {
                for (Integer index: indexes) {
                    if (!index.equals(bucket.get(number).get(0))) {
                        int[] result = new int[2];
                        result[0] = bucket.get(number).get(0);
                        result[1] = index;
                        return result;
                    }
                }

            }
        }
        return null;
    }

    @Override
    public void run() {
        int[] nums = {3, 3};
        twoSum(nums, 6);
    }
}
