package no190_reverse_bits;

/**
 * 和no7类似<br>
 * 二进制对应10进制的运算: <br>
 * + : | <br>
 * %10 : & 1 <br>
 * *10 : << 1 <br>
 * /10 : >> 1 <br>
 *
 * Created by status200 on 2018/9/1.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(43261596));
    }
    public int reverseBits(int n) {
        int s = n;
        int y = 0;

        // 必须固定移动32位
        for (int bits = 0; bits < 32; bits++) {
            y = (y << 1)  | (s & 1);
            s = s >>> 1;
        }

        return y;
    }
}
