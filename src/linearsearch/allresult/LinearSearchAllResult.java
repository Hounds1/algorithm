package linearsearch.allresult;

import java.util.LinkedList;
import java.util.List;

/**
 * 랜덤한 길이와 원소로 생성된 배열 속에서
 * 랜덤으로 생성된 목표 값이 총 몇개나 있는지
 * 선형 탐색을 통해 찾아냅니다.
 * 찾아낸 인덱스 값은 indexList에 저장되어
 * 마지막까지 탐색을 마친 후 반환됩니다.
 * 순서를 보장하기 위해 LinkedList를 사용합니다.
 */
public class LinearSearchAllResult {

    public static List<Integer> linearSearch(int[] arr, int target) {
        List<Integer> indexList = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                indexList.add(i);
            }
        }

        return indexList;
    }

    public static int[] generateRandomElementArray(final int range) {
        int[] randomArray = new int[range];

        for (int i = 0; i < range; i++) {
            int random = (int) (Math.random() * range);
            randomArray[i] = random;
        }

        return randomArray;
    }

    public static void main(String[] args) {
        int randomRange = (int) (Math.random() * 100);
        int[] unsortedArray = generateRandomElementArray(randomRange);

        System.out.print("UnsortedArray is : [ ");
        for (int i : unsortedArray) {
            System.out.print(i + " ");
        }
        System.out.print("]");
        System.out.println(" ");

        int randomTarget = (int) (Math.random() * randomRange);
        System.out.println("Target is : " + randomTarget);

        long startTime = System.currentTimeMillis();

        List<Integer> resultList = linearSearch(unsortedArray, randomTarget);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        if (!resultList.isEmpty()) {
            System.out.print("All target index is : [ ");
            for (int i : resultList) {
                System.out.print(i + " ");
            }
            System.out.print("]");
            System.out.println(" ");
        } else
            System.out.println("Target index not found");

        System.out.println("ElapsedTime is : " + elapsedTime + " (ms)");
    }
}
