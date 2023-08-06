package prefixsum;

/**
 * 누적합은 각 원소까지의 누적된 합을 계산하는 알고리즘 입니다.
 */
public class PrefixSum {

    public static int[] prefix(int[] arr) {

        /**
         * arr.length를 int 변수로 선언하는 이유는 여러 곳에서 사용할 경우 중복된 연산이 발생함으로
         * 성능상 이점을 가질 수 없다는 점에 있습니다.
         */
        int range = arr.length;
        int[] newArr = new int[range];
        int sum = 0;

        for(int i = 0; i < range; i++) {
            newArr[i] = arr[i] + sum;
            sum += arr[i];
        }

        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        System.out.print("Origin arr is : [ ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.print("]");
        System.out.println(" ");


        int[] prefix = prefix(arr);
        System.out.print("New arr is : [ ");
        for (int num : prefix) {
            System.out.print(num + " ");
        }
        System.out.print("]");
    }
}
