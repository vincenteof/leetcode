package TwoSum;

import java.util.HashMap;
import java.util.Map;

// no.1
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer prevIdx = map.get(target - nums[i]);
            if (prevIdx != null) {
                return new int[] { prevIdx, i };
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {};
    }
    public static void main(String[] args) {
    }
}
