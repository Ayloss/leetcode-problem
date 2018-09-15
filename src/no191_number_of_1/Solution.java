package no191_number_of_1;

/**
 * Created by status200 on 2018/9/1.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(6));
    }
    public int hammingWeight(int n) {

        int s = n;
        int count = 0;
        while(s != 0) {
            count += s & 1;
            s = s >>> 1;
        }

        return count;
    }
}
