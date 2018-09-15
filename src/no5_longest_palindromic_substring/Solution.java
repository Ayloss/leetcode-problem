package no5_longest_palindromic_substring;

/**
 * 从某一个中心开始，同时往两边遍历查找，找到最长回文数。
 *
 * Created by status200 on 2018/3/23.
 */
public class Solution {


    public String longestPalindrome(String s) {

        int maxLeft1 = 0;
        int maxRight1 = 0;

        int maxLeft2 = 0;
        int maxRight2 = 0;

        // 从中心往两边扩展
        for (int center = 0; center < s.length(); center++) {

            // 中心为1个字符
            for (int expand = 0; expand <= s.length() / 2; expand++) {

                int left = center - expand;
                int right = center + expand;
                if (left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) {
                    break;
                } else {

                    if (maxRight1 - maxLeft1  < right - left) {
                        maxRight1 = right;
                        maxLeft1 = left;
                    }
                }
            }

            // 中心为两个字符
            for (int expand = 0; expand <= s.length() / 2; expand++) {

                int centerL = center;
                int centerR = centerL + 1;

                if (centerR >= s.length()) {
                    break;
                }

                if (s.charAt(centerL) == s.charAt(centerR)) {
                    int left = centerL - expand;
                    int right = centerR + expand;
                    if (left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) {
                        break;
                    } else {
                        if (maxRight2 - maxLeft2  < right - left) {
                            maxRight2 = right;
                            maxLeft2 = left;
                        }
                    }
                } else{
                    break;
                }
            }
        }

        int len1 = maxRight1 - maxLeft1;
        int len2 = maxRight2 - maxLeft2;

        return len1 > len2 ? s.substring(maxLeft1,maxRight1 + 1) : s.substring(maxLeft2,maxRight2 + 1);
    }

    public static void main(String[] args) {

//        StringBuilder s = new StringBuilder();
//
//        for (int i = 0; i < 1000; i++) {
//            s.append("c");
//        }
//
//        System.out.println(new Solution().longestPalindrome(s.toString()));

        System.out.println(new Solution().longestPalindrome("abbc"));

    }
}
