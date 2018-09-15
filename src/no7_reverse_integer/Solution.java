package no7_reverse_integer;

/**
 * 取巧的解法, 用long绕过int的最大限制.
 *
 * Created by status200 on 2018/4/3.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-2147483648));
    }

    int reverse(int x) {
        long s = x;
        long y = 0;
        while (s != 0) {
            y = y * 10 + s % 10;
            s /= 10;
        }
        if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)y;
    }

}
