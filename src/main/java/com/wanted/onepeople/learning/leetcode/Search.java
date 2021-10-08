package com.wanted.onepeople.learning.leetcode;

/**
 * @Description: 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，
 * 如果目标值存在返回下标，否则返回 -1。
 * @Author fdc
 * @Date 2021-09-22
 */
public class Search {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = -1;
        int res = search(nums, target);
        System.out.println(res);
    }

    /**
     * @Description: 左闭右闭
     * @Author fdc
     * @Date 2021/10/8 14:29
     * @param: nums
     * @param: target
     * @return int
     * @UpdateDate 2021/10/8 14:29
     **/
    public static int search(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }

    /**
     * @Description: 左闭右开
     * @Author fdc
     * @Date 2021/10/8 14:30
     * @param: nums
     * @param: target
     * @return int
     * @UpdateDate 2021/10/8 14:30
     **/
    public int search1(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid;
        }
        return -1;
    }
}
