package mango.listandarray;

/**
 * code303
 * 给定一个整数组nums
 * 求出数组从索引 i 到 j (i<=j) 范围内元素的总和，包含i j两点
 *
 * 前缀和问题，初始化时先计算出前n项和
 * 注意输入的是数组的下标
 */
public class NumArray {
    private final int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        int rangeSum = 0;
        for (int i = 1; i <= nums.length; i++) {
            rangeSum += nums[i - 1];

            preSum[i] = rangeSum;
        }
    }

    //设计一个sumRange时间复杂度最低的方法
    public int sumRange(int left, int right) {
        return preSum[right +1] - preSum[left];
    }

}
