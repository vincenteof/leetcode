package SearchInsert;

// no.35
public class Solution {
    // no much iteration or recursion, you should first focus on small case and consider how bigger case become small
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            if (i == j - 1) {
                if (nums[i] < target) {
                    return i + 1;
                } else {
                    return i;
                }
            }

            int mid = (i + j) / 2;
            int midItem = nums[mid];
            if (midItem > target) {
                j = mid;
            } else if (midItem < target) {
                i = mid + 1;
            } else {
                return mid;
            }
        }

        return j;
    }
}
