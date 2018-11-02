package priv.zzy.utils;

public class ArrayUtil {

    /**
     * 二分查找给定值 <br />
     * 注意: 数组<b>必须升序</b>，否则结果未定义
     * 数组中多个元素与给定值相等时，可能返回其中任意一个下标
     * 
     * @param array 给定数组
     * @param value 给定值
     * @param fromIndex 范围左界
     * @param toIndex 范围右界
     * @param restrict 
     *      true: 严格查找，给定值不存在则返回 <b>-1</b> <br />
     *      false: 非严格查找，给定值不存在则返回[fromIndex, toIndex]范围内最接近
     *              （位置最接近的，并非数值最接近）给定值的
     *              元素下标（该元素可能大于或小于给定值，不确定），
     *              保证该下标在[fromIndex, toIndex]之间
     * @return 下标
     */
    public static int binarySearch(int[] array, int fromIndex, int toIndex, int value, boolean restrict) {
        if (array == null || array.length == 0) return -1;
        
        int l = fromIndex, r = toIndex;
        int mid;
        
        while (l <= r) {
            if (l == r) {
                if (restrict && array[l] != value){ 
                    return -1;
                } else {
                    return l;
                }
            }
            mid = (l + r) / 2;
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        // 当且仅当 r = l + 1（此时mid == l） 并且 array[mid] > value 时，
        // r = mid - 1 -> r = l - 1
        // l > r
        // 以下代码才会执行

        if (!restrict) {
            return l;
        }
        
        return -1;
    }

    /**
     * 二分查找给定值 <br />
     * 注意: 数组<b>必须升序</b>，否则结果未定义
     * 给定值不存在则返回 <b>-1</b>
     * 数组中多个元素与给定值相等时，可能返回其中任意一个下标
     * 
     * @param array 给定数组
     * @param value 给定值
     * @return 下标
     */
    public static int binarySearch(int[] array, int value) {
        return binarySearch(array, value, true);
    }

    public static int binarySearch(int[] array, int value, boolean restrict) {
        return binarySearch(array, 0, array.length - 1, value, restrict);
    }

    /**
     * 获取给定值的下界<br />
     * 即大于等于给定值的元素的最小下标<br />
     * 若不存在大于等于给定值的元素，返回<b>toIndex + 1</b>
     * @param array 给定数组
     * @param value 给定值
     * @param fromIndex 范围左界
     * @param toIndex 范围右界
     * @return 下界下标
     */
    public static int lowerBound(int[] array, int fromIndex, int toIndex, int value) {
        if (array == null || array.length == 0) throw new IllegalArgumentException("Array cannot be null or empty");

        int index = binarySearch(array, fromIndex, toIndex, value, false);

        // Impossible. Check for safety
        if (index == -1) return 0;

        if (array[index] == value) {
            while (index >= 0 && array[index] == value) --index;
            return index + 1;
        } else {
            if (array[index] < value) {
                return index + 1;
            } else {
                return index;
            }
        }
    }
}
