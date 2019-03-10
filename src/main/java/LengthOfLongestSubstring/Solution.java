package LengthOfLongestSubstring;

import java.util.*;

// no.3
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int startPos = 0;
        Map<Character, Integer> posForChar = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            if (posForChar.containsKey(currentChar)) {
                int prevCharPos = posForChar.get(currentChar);
                int firstLength = prevCharPos - startPos + 1;
                int secondLength = i - prevCharPos;
                deleteChars(posForChar, s, startPos, prevCharPos);
                posForChar.put(currentChar, i);     // you should change previous existed index!!!
                longest = max(longest, firstLength, secondLength);
                startPos = prevCharPos + 1;
            } else {
                posForChar.put(currentChar, i);
                int currentLen = i - startPos + 1;
                if (currentLen > longest) {
                    longest = currentLen;
                }
            }
        }

        return longest;
    }

    private int max(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        }
        return b > c ? b : c;
    }

    private void deleteChars(Map<Character, Integer> posForChar, String str, int start, int end) {
        for (int i = start; i < end; i++) {
            posForChar.remove(str.charAt(i));
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.lengthOfLongestSubstring("abcabcbb");
    }
}
