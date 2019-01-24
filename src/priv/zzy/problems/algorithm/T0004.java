package priv.zzy.problems.algorithm;

import priv.zzy.Solution;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
public class T0004 extends Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return solution1(nums1, nums2);
    }

    /**
     * 方法一
     *
     * 总体思路：将两个数组看成一个整体（优先队列），忽略中位数之前的元素，
     * 根据两个数组所含元素个数的奇偶性输出元素本身或者两个数的平均值。
     *
     * 其中，忽略元素个数：总数 / 2（奇数个元素）；总数 / 2 - 1（偶数个元素）
     *
     * 时间复杂度：
     * 最好情况：O(1)，当其中一个数组为空时
     * 最差情况：O(m + n)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数的值
     */
    public double solution1(int[] nums1, int[] nums2) {

        if (isEmpty(nums1)) {
            return solve(nums2);
        }
        if (isEmpty(nums2)) {
            return solve(nums1);
        }

        int i1 = 0, i2 = 0;
        int totalCount = nums1.length + nums2.length; // totalCount >= 2

        int ignoreCount = totalCount >> 1;
        boolean countIsOdd = (totalCount & 1) == 1;

        if (!countIsOdd) --ignoreCount;

        while (ignoreCount > 0) {
            if (nums1[i1] < nums2[i2]) {
                ++i1;
                if (i1 >= nums1.length) {
                    if (countIsOdd) {
                        return nums2[i2 + ignoreCount - 1];
                    } else {
                        return (nums2[i2 + ignoreCount - 1] + nums2[i2 + ignoreCount]) / 2.0;
                    }
                }
            } else {
                ++i2;
                if (i2 >= nums2.length) {
                    if (countIsOdd) {
                        return nums1[i1 + ignoreCount - 1];
                    } else {
                        return (nums1[i1 + ignoreCount - 1] + nums1[i1 + ignoreCount]) / 2.0;
                    }
                }
            }
            --ignoreCount;
        }

        if (countIsOdd) {
            return Integer.min(nums1[i1], nums2[i2]);
        } else {
            if (i1 + 1 < nums1.length && nums1[i1 + 1] < nums2[i2]) {
                return (nums1[i1] + nums1[i1 + 1]) / 2.0;
            }
            if (i2 + 1 < nums2.length && nums2[i2 + 1] < nums1[i1]) {
                return (nums2[i2] + nums2[i2 + 1]) / 2.0;
            }

            return (nums1[i1] + nums2[i2]) / 2.0;
        }
    }

    private double solve(int[] array) {
        int midIndex = array.length >> 1;
        if ((array.length & 1) == 1) {
            return array[midIndex];
        } else {
            return (array[midIndex] + array[midIndex - 1]) / 2.0;
        }
    }

    private boolean isEmpty(int[] array) {
        return (array == null) || (array.length == 0);
    }

    @Override
    public void run() {
        int[] nums1 = {1, 2};
        int[] nums2 = {-1, 3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
