import java.util.Arrays;
import java.util.HashMap;

public class EasySum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 11, 13};
        int target = 15;

        int[] result = finalOptimized(nums, target);

        System.out.println(Arrays.toString(result));
    }

    public static int[] bruteForce(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static int[] optimizedFirst(int[] nums, int target) {
        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                return new int[]{start, end};
            } else {
                if (target > sum) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static int[] finalOptimized(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (hashMap.containsKey(compliment)) {
                return new int[] {i, hashMap.get(compliment)};
            }
            hashMap.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
