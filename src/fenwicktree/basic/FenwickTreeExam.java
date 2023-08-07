package fenwicktree.basic;

import fenwicktree.FenwickTree;

/**
 * 펜윅 트리 또는 이진 인덱스 트리는 수열의 동적 구간 합을
 * 효율적으로 계산하는 자료 구조입니다.
 * 주로 배열의 특정 인덱스까지의 원소들의 합을 빠르게
 * 계산하기 위해 사용됩니다.
 * 펜윅 트리는 효율성을 제공하면서도 상대적으로 간단한
 * 구현을 가지고 있습니다.
 */
public class FenwickTreeExam {

    public static void main(String[] args) {
        int[] array = {3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3};
        int size = array.length;

        FenwickTree fenwick = new FenwickTree(size);
        fenwick.build(array);

        int rangeSum = fenwick.query(7);
        System.out.println("Sum 0 ~ 7 : " + rangeSum);

        fenwick.update(3,2);

        rangeSum = fenwick.query(7);
        System.out.println("Sum 0 ~ 7 : " + rangeSum);
    }
}
