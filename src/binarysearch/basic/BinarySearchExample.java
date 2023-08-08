package binarysearch.basic;

import java.util.Arrays;

/**
 * 이분 탐색 알고리즘은 중간을 기점으로 중간 수와 목표값을 비교하고 인덱스 범위를 줄여나갑니다.
 * 시간 복잡도는 O(n log n)이며 배열의 크기 n에 대해 매 단계마다 검색 범위가 대략 절반으로 줄어들게 됩니다.
 * 그러나 배열이 정렬 되어있지 않다면 배열을 정렬하기 위한 추가적인 비용이 소모될 수 있습니다.
 */
public class BinarySearchExample {

    public static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // 찾은 경우 인덱스를 반환합니다.
            } else if (arr[mid] < target) {
                left = mid + 1; // 중간 값보다 큰 경우 오른쪽 반을 탐색합니다.
            } else {
                right = mid - 1; // 중간 값보다 작은 경우 왼쪽 반을 탐색합니다.
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,9,10,15,22,35};
        int target = 5;

        long startTime = System.nanoTime();

        int result = binarySearch(arr, target);

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        if (result != -1)
            System.out.println("Target index is : " + result);
        else
            System.out.println("Target index not found");

        System.out.println("ElapsedTime is : " + elapsedTime + "(ns)");
    }
}
