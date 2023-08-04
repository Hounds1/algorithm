package twopointer.subarraysum;

/**
 * 배열 내에서 수들을 더했을 때 목표값을 충족할 수 있는지 검사합니다.
 * 예를 들어, 목표하는 값이 3이라고 가정했을 때 1 + 1 + 1, 1 + 2, 3은 덧셈이나 그 자체로 목표값을 충족합니다.
 */
public class SubarraySumEqK {

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > k) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 3};
        int k = 3;

        int result = subarraySum(nums, k);
        System.out.println(result);
    }
}
