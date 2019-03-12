package Reverse;

// no.7
// core of it is how to discover calculation is overflowed
public class Solution {
    public int reverse(int x) {
        return reverseRecur(x).value;
    }

    private Result reverseRecur(int x) {
        int sub = x / 10;
        int digit = x % 10;

        if (sub == 0) {
            return new Result(x, 1, false);
        }

        Result subReverseResult = reverseRecur(sub);
        if (subReverseResult.over) {
            return subReverseResult;
        }

        Integer newPart = calNewPart(digit, subReverseResult.len);
        if (newPart == null) {
            subReverseResult.value = 0;
            subReverseResult.over = true;
            return subReverseResult;
        }
        int newValue = newPart + subReverseResult.value;
        if (subReverseResult.value >= 0) {
            if (newValue < 0) {
                subReverseResult.over =  true;
                subReverseResult.value = 0;
                return subReverseResult;
            }
        } else {
            if (newValue >= 0) {
                subReverseResult.over =  true;
                subReverseResult.value = 0;
                return subReverseResult;
            }
            subReverseResult.value = newValue;
        }
        subReverseResult.value = newValue;
        subReverseResult.len += 1;

        return subReverseResult;
    }

    private Integer calNewPart(int digit, int len) {
        if (len > 9) {
            return null;
        }
        if (len == 9 && digit > 2) {
            return null;
        }
        return ((int) Math.pow(10, len)) * digit;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.reverseRecur(1534236469);
    }
}

class Result {
    Result(int value, int len, boolean over) {
        this.value = value;
        this.len = len;
        this.over = over;
    }
    int value;
    int len;
    boolean over;
}
