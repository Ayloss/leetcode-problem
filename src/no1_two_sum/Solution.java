package no1_two_sum;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 先排序之后，再从两边往中间遍历。
 * 首先用Arrays.sort对数字从小到大排序。时间复杂度为O(nlogn).
 * 接着使用两个指针，一个指向头，一个指向尾。把头尾指向的数字相加，得到sum。
 * 如果sum > target，说明数字太大，就把右边的指针往中间移，缩小数字。
 * 如果sum < target, 就把左边的指针往中间移。
 *
 * Created by status200 on 2018/3/17.
 */
class Solution {

    class Num {
        public int pos;
        public int val;

        public Num(int pos, int val) {
            this.pos = pos;
            this.val = val;
        }
    }

    public int[] twoSum(int[] nums, int target) {

        ArrayList<Num> arr = new ArrayList<>(10000);

        for (int i = 0; i < nums.length; i++) {
            arr.add(new Num(i,nums[i]));
        }
        arr.sort(Comparator.comparingInt(e -> e.val));


        int begin = 0, end = nums.length - 1;
        while(begin < end) {

            Num num1 = arr.get(begin),num2 = arr.get(end);

            int sum = num1.val + num2.val;

            if(sum > target) {
                end--;
            } else if (sum < target) {
                begin++;
            } else {
                return new int[]{num1.pos,num2.pos};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] s = new int[]{3,2,4};

        Solution solution = new Solution();
        solution.twoSum(s,6);
    }
}
