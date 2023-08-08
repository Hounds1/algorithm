package linearsearch.basic;

/**
 * 선형 탐색은 정렬되어 있지 않은 배열을 탐색할 때 유용합니다.
 * 배열의 크기가 커질 경우 많은 시간이 소요될 수 있습니다.
 * 그러나 크기가 작은 배열을 대상으로 한다면 구현이 간단하고
 * 효과적인 성능을 얻을 수 있습니다.
 * 이 예제는 랜덤하게 생성된 배열에서 랜덤하게 생성된 목표 값을
 * 탐색하며 첫 번째부터 가장 먼저 발견된 일치하는 인덱스를
 * 반환합니다.
 */
public class LinearSearch {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
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

        long startTime = System.currentTimeMillis();

        int result = linearSearch(unsortedArray, randomTarget);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        if (result != 1)
            System.out.println("Target index is : " + result);
        else
            System.out.println("Target index not found");

        System.out.println("ElapsedTime is : " + elapsedTime + " (ms)");
    }
}
