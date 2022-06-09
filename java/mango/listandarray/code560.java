package mango.listandarray;

/**
 * code 560
 * 给一个整数数组 nums 和一个整数 k，统计并返回数组中和为 k 的连续子数组的个数
 * <p>
 * nums = [1,1,1], k = 2    result = 2
 * nums = [1,2,3], k = 2    result = 2
 * <p>
 * 思路:先算出来所有的前缀和，然后列举所有的子数组的可能，找出等于k的前缀和的个数
 * <p>
 * 优化思路:内层的for循环更换为查hash表
 * preSum[j] - preSum[i] = k   ->   preSum[i] = preSum[j] - k
 */
public class code560 {
    public int subarraySum(int[] nums, int k) {
        //记录前缀和
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        //遍历前缀和，计算结果
        int count = 0;
        for (int i = 0; i <= nums.length; i++) {
            for (int j = nums.length; j > i; j--) {
                if (preSum[j] - preSum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        HashMap<Integer, Integer>


    }
}
