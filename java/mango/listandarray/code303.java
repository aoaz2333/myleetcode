package mango.listandarray;

/**
 * 给定一个整数组nums
 * 求出数组从索引 i 到 j (i<=j) 范围内元素的总和，包含i j两点
 *
 * 前缀和问题，初始化时先计算出前n项和
 */
public class code303 {
    private final int[] rangeSumFromZero;

    public code303(int[] nums) {
        rangeSumFromZero = new int[nums.length];
        for (int i = 0; i <= nums.length - 1; i++) {
            int rangeSum = 0;
            for (int j = 0; j <= i; j++) {
                rangeSum += nums[j];
            }
            rangeSumFromZero[i] = rangeSum;
        }
    }

    //设计一个sumRange时间复杂度最低的方法
    public int sumRange(int left, int right) {
        if (left == 0) {
            return rangeSumFromZero[right];
        }
        return rangeSumFromZero[right] - rangeSumFromZero[left - 1];
    }

}
