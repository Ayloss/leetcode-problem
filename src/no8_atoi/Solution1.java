package no8_atoi;

/**
 * Created by status200 on 2018/9/9.
 */
public class Solution1 {


    public static void main(String[] args) {
        String input = "2147483648";
        System.out.println(new Solution1().myAtoi(input));
    }

    public int myAtoi(String str) {
        char[] arr = str.toCharArray();

        int i = 0;
        int sign = 1;
        int base = 0;

        try {
            // 跳过空格
            while (Character.isSpaceChar(arr[i])) {
                i++;
            }
        }
        // 越界的时候要么字符串为空，要么全为空格
        catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }

        if(arr[i] == '-') {
            sign = -1;
            i++;
        } else if(arr[i] == '+') {
            sign = 1;
            i++;
        } else if(Character.isDigit(arr[i])) {
        } else {
            return 0;
        }

        // 数字开始的位置
        int numStartPosition = i;
        // 对数字进行转换
        while(i < arr.length && Character.isDigit(arr[i])) {
            if(base > Integer.MAX_VALUE / 10 ||
                    (base == Integer.MAX_VALUE / 10 && arr[i] - '0' > 7)) {
                return sign > 0? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            base = 10*base + (arr[i] - '0');
            i++;
        }

        // 没有任何数字
        if(numStartPosition == i) {
            return 0;
        }

        return base * sign;
    }
}
