package no3_longest_substring_without_repeating_character;

import java.util.HashMap;

/**
 * 暴力解法，使用HashMap来判断重复.
 * 内存超限.
 *
 * Created by status200 on 2018/9/9.
 */
public class Solution1 {

    private char[] arr;
    public int lengthOfLongestSubstring(String s) {
        arr = s.toCharArray();
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            int len = searchAt(i);
            if(len > maxLength) {
                maxLength = len;
            }
        }

        return maxLength;
    }

    public int searchAt(int pos) {
        HashMap<String, Integer> helperMap = new HashMap<>();

        int length = 0;
        for (int i = pos; i < arr.length; i++) {
            String key = arr[i] + "";
            if(helperMap.get(arr[i]+"") == null) {
                helperMap.put(key, 1);
                length++;
            } else {
                return length;
            }
        }

        return length;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new Solution1().lengthOfLongestSubstring(s));
    }
}
