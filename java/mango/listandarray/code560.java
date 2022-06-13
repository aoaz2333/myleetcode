package mango.listandarray;

import java.util.HashMap;
import java.util.Map;

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
        Map<Integer, Integer> preSum2Count = new HashMap<>();

        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            int count = preSum2Count.getOrDefault(preSum[i], 0);
            count++;
            preSum2Count.put(preSum[i], count);
        }

        int count = 0;
        for (int i = 1; i <= nums.length; i++) {
            int target = preSum[i] + k;
            count += preSum2Count.getOrDefault(target, 0);

            target = preSum[i] - k;
            count += preSum2Count.getOrDefault(target, 0);
        }
        return count;
    }

    /**
     * 一边遍历，一边在hash表中查询有没有目标结果，简化了内层的时间复杂度
     */
    public int subarraySum3(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> preSum2Count = new HashMap<>();

        //初始化0，为了自身之和刚好等于k时，不会被过滤
        preSum2Count.put(0, 1);

        int count = 0;
        int sum0Toi = 0;
        for (int i = 0; i <= n - 1; i++) {
            sum0Toi += nums[i];

            //注意要先查找有没有合适的结果，再将自身的结果记录到
            int target = sum0Toi - k;
            //在前面已有的子数组中
            count += preSum2Count.getOrDefault(target, 0);

            int preSumCount = preSum2Count.getOrDefault(sum0Toi, 0);
            preSumCount++;
            preSum2Count.put(sum0Toi, preSumCount);
        }
        return count;
    }

    public static void main(String[] args) {
        code560 c = new code560();
        int[] array = {1};
        int k = 0;
        System.out.println(c.subarraySum3(array, k));
    }

}
