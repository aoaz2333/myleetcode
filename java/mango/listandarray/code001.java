package mango.listandarray;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target
 * 请你在数组中找出和为目标值 target 的那两个整数
 * 并返回他们的数组下标
 * 每个输入只有一种答案，元素不会重复出现
 * <p>
 * 输入:
 * nums = [2,7,11,15], target = 9
 * [0,1]
 * <p>
 * 输入:
 * nums = [3,2,4], target = 6
 * [1,2]
 * <p>
 * 因为答案唯一，所以可以遍历一次将结果存下来，第二遍直接找到目标索引
 */
public class code001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> value2Index = new HashMap<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            value2Index.put(target - nums[i], i);
        }

        for (int i = 0; i <= nums.length - 1; i++) {
            int value = nums[i];
            if (value2Index.containsKey(value)) {
                return new int[]{i, value2Index.get(value)};
            }
        }
        return new int[0];
    }
}
