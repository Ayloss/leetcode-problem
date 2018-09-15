package no53_maximum_subarray;

/**
 *
 *
 * Created by status200 on 2018/4/4.
 */
public class Solution {


    public int maxSubArray(int[] nums) {
        int maxEndHere = nums[0];//从某个位置开始到当前所在位置的和
        int maxSoFar = nums[0];//子数组中的最大和
        for (int i = 1; i < nums.length; i++) {

            //对于某个子数组，如果加上它右边的元素，大于它右边的元素，那就可以往右扩展该数组
            //否则，就直接结束该子数组的扩展

            //分情况讨论: sum->子数组的和,A[i]子数组右边元素
            //1. sum>0,A[i]>0 => sum+A[i] > A[i] 扩展该子数组
            //2. sum<0,A[i]>0 => sum+A[i] < A[i] 不扩展该子数组
            //3. sum<0,A[i]<0 => sum+A[i] < A[i] 不扩展该子数组
            //4. sum>0,A[i]>0 => sum+A[i] > A[i] 扩展该子数组
            maxEndHere = Math.max(maxEndHere + nums[i],nums[i]);

            //确认当前已扩展的子数组的和是否最大
            maxSoFar = Math.max(maxEndHere,maxSoFar);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1};

        System.out.println(new Solution().maxSubArray(nums));
    }
}
