package com.wanted.onepeople.learning.leetcode;

/**
 * @Description: 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @Author fdc
 * @Date 2021-10-08
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3, 4};
        int val = 3;
        System.out.println(removeElement1(nums, val));
    }

    private static int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if(nums[i] == val){
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                i--; // 因为下表i以后的数值都向前移动了一位，所以i也向前移动一位
                size--; // 此时数组的大小-1
            }
        }
        return size;
    }

    /**
     * @Description: 双指针
     * @Author fdc
     * @Date 2021/10/8 16:28
     * @param: nums
     * @param: val
     * @return int
     * @UpdateDate 2021/10/8 16:28
     **/
    private static int removeElement1(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if(nums[fastIndex] != val){
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }
}
