package SearchInsert;

// no.35
public class Solution {
    // no much iteration or recursion, you should first focus on small case and consider how bigger case become small
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int mid = i + (j - i) / 2;
        while (i <= j) {
            mid = i + (j - i) / 2;
            if (target > nums[mid]) {
                i = mid + 1;
            } else if (target < nums[mid]) {
                j = mid - 1;
            } else {
                return mid;
            }
        }
        if (nums[mid] < target) {
            return j + 1;
        } else {
            return i;
        }
    }
}
