package no3_longest_substring_without_repeating_character;

import java.util.HashSet;

/**
 * 滑动窗口法。
 * 如果从索引 i 到 j - 1 之间的子字符串 s[ij]已经被检查为没有重复字符。
 * 我们只需要检查 s[j] 对应的字符是否已经存在于子字符串。
 *
 * Created by status200 on 2018/9/9.
 */
public class Solution2 {

    public int lengthOfLongestSubstring(String s) {

        // 代表窗口里的字符
        HashSet<Character> set = new HashSet<>();

        char[] arr = s.toCharArray();
        int len = 0;
        // 定义一个窗口
        int windowLeft = 0, windowRight = 0;
        while(windowLeft < arr.length && windowRight < arr.length) {

            // 如果不包含重复字符,窗口右侧右移，窗口增大
            if(!set.contains(arr[windowRight])) {
                set.add(arr[windowRight++]);
                len = Math.max(len, windowRight - windowLeft);
            }
            // 如果包含重复字符，窗口左侧右移，窗口缩小
            // 重复的字符可能不在该子字符串的两端,因此窗口缩小后还需要再次判断有无重复字符
            // 比如: ebacda
            else {
                set.remove(arr[windowLeft++]);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        String s = "asfdvcsdwwascvae";
        System.out.println(new Solution2().lengthOfLongestSubstring(s));
    }
}
