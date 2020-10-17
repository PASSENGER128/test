package simple;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例：
 *      给定 nums = [2, 7, 11, 15], target = 9
 *
 *      因为 nums[0] + nums[1] = 2 + 7 = 9
 *      所以返回 [0, 1]
 *
 */

public class SummationOverTwoNumbers {

    public static void main(String[] args) {

       int[] nums = {2, 7, 11, 15};
       int target = 9;

       int[] result = twoSumByHash2(nums,target);
        for (int i : result) {
            System.out.println(i);
        }


    }


    /**
     * 暴力破解法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums,int target) {

        int[] result = new int[2];

        for (int i = 0;i < nums.length;i++) {

            int temp = target - nums[i];

            for (int j = i + 1;j < nums.length;j++) {

                if (temp == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                }

            }

        }
        return result;

    }


    /**
     * 两边哈希表
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumByHash(int[] nums,int target) {

        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0;i < nums.length;i++) {
            map.put(nums[i],i);
        }

        for (int j = 0;j < nums.length;j++) {
            int temp = target - nums[j];
            // 判断是否在哈希表中，并且不能和自身相等
            if(map.containsKey(temp) && map.get(temp) != j) {
                result[0] = j;
                result[1] = map.get(temp);
                // 找见一组是，及时跳出循环
                break;
            }
        }

        return result;
    }

    /**
     * 单遍哈希表
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumByHash2(int[] nums,int target) {

        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];

        for (int i = 0;i < nums.length;i++) {

            /**
             * 每次放入之前都判断一下符合条件的值在不在里面，如果在，直接返回，不在，该数据放入哈希表中，
             * 因为放入哈希表的数据都是按数组索引的大小依次放的，
             * 所以返回的时候，应该先返回符合条件值的索引，再返回这次添加的那个元素的索引。
             */
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                result[0] = map.get(temp);
                result[1] = i;
            }
            map.put(nums[i],i);

        }

        return result;

    }

}
