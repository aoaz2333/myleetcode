package mango.listandarray.list;

/**
 * 370 区间加法
 * 假设有一个长度为 n 的数组，初始化后所有数字为0，你将会被给出一个k个更新操作
 * 其中，每个操作会被表示为一个三元组，[start_index, end_index, value]
 *
 * 请返回操作k次后的结果
 */
public class code370 {
    //差分数组可解
}


/**
 * 查分数组工具类
 */
class Difference {
    private int[] diffArray;

    public Difference(int[] nums) {
        assert nums.length > 0;
        diffArray = new int[nums.length];
        diffArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diffArray[i] = nums[i] - nums[i - 1];
        }
    }

    /**
     * 给闭区间 [i, j] 内的元素同时加上 value
     */
    public void increment(int i, int j, int value) {
        if (i >= 0) {
            diffArray[i] += value;
        }
        if (j + 1 < diffArray.length) {
            diffArray[j + 1] -= value;
        }
    }

    public int[] getDiffArray() {
        int[] result = new int[diffArray.length];

        result[0] = diffArray[0];
        for (int i = 1; i <= diffArray.length - 1; i++) {
            result[i] = result[i - 1] + diffArray[i];
        }
        return result;
    }
}