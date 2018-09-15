package no5_longest_palindromic_substring;

/**
 * 优化的算法。首先查找最长的重复串，再往两边同时遍历查找。
 *
 * Created by status200 on 2018/3/24.
 */
public class Solution2 {

    private int maxBegin = 0;
    private int maxEnd = 0;

    public String longestPalindrome(String s) {

        // String.charAt自带检查下标是否溢出机制，速度会稍微慢
        char[] chars = s.toCharArray();
        int len = chars.length;

        int beginIndex,endIndex;

        if(s.length() <= 1) return s;

        for (int i = 0; i < s.length(); i++) {
            beginIndex = i;
            endIndex = i;

            // 先找到中间最长的回文串
            // 比如 aaaaaaaaaaaa
//            while (endIndex < s.length() - 1 && s.charAt(endIndex) == s.charAt(endIndex + 1)) endIndex++;

            while(endIndex < len - 1 && chars[endIndex] == chars[endIndex+1]) endIndex++;

            // 此算法优化的地方在此
            // 已经找过的中间一大串只有包含一个字符的串可以直接跳过，避免重复搜索
            // 例如baaaaaaaabsdfg中的第一个a和最后一个a，对于上面一个循环的搜索，结果都是一样的
            i = endIndex;

            // 找到中间最长重复串后，往两边搜索，直到出现非回文的情况
//            while (beginIndex >= 0 && endIndex < s.length() && s.charAt(beginIndex) == s.charAt(endIndex)) {
            while(beginIndex >= 0 && endIndex < len && chars[beginIndex] == chars[endIndex]) {
                beginIndex--;
                endIndex++;
            }

            // 退出时是是不满足回文串条件的，求得的回文串左右要往中间缩进一个字符
            endIndex--;
            beginIndex++;

            // 和已经记录的最长的结果比较
            if (maxEnd - maxBegin < endIndex - beginIndex) {
                maxEnd = endIndex;
                maxBegin = beginIndex;
            }
        }

        return s.substring(maxBegin,maxEnd +1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().longestPalindrome("cbbd"));
    }

}
