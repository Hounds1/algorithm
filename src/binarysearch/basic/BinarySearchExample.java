package binarysearch.basic;

import java.util.Arrays;

/**
 * 이분 탐색 알고리즘은 중간을 기점으로 중간 수와 목표값을 비교하고 인덱스 범위를 줄여나갑니다.
 * 시간 복잡도는 O(n log n)이며
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

        int result = binarySearch(arr, target);

        if (result != -1)
            System.out.println("Result is : " + result);
        else
            System.out.println("No result found");
    }
}
