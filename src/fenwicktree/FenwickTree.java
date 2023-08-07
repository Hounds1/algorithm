package fenwicktree;

public class FenwickTree {

    private final int[] fenwickTree;

    public FenwickTree(final int size) {
        fenwickTree = new int[size + 1];
    }

    /**
     * 팬윅 트리를 초기화합니다. 선언된 fenwickTree에
     * 원본 배열을 동기화시켜 객체가 가진 연산을 적용할
     * 준비를 합니다.
     */
    public void build(final int[] array) {
        for (int i = 0; i < array.length; i++) {
            update(i, array[i]);
        }
    }

    /**
     * 특정 인덱스까지 구간 합을 계산합니다.
     * 펜윅 트리를 사용하여 인덱스를 조사하면서
     * 누적 합을 계산합니다.
     */
    public int query(int index) {
        int sum = 0;
        index++; // 1-based index로 반환합니다.
        while (index > 0) {
            /**
             * 특정 인덱스 구간의 합은 fenwickTree[index]에
             * 저장되어 있습니다.
             */
            sum += fenwickTree[index];
            /**
             * 다음에 조사할 구간을 결정합니다.
             * 마지막 비트를 지워가며 구간을 이동합니다.
             */
            index -= index & -index;
        }

        return sum;
    }

    /**
     * 특정 인덱스의 값을 업데이트하고 펜윅 트리를 갱신합니다.
     * 펜윅 트리는 인덱스에 따라 여러 개의 노드로 이루어져 있으며,
     * 각 노드는 일부 구간의 합을 저장합니다. value값을 해당
     * 인덱스와 연관된 노드에 추가하여 구간 합을 갱신합니다.
     */
    public void update(int index, int value) {
        index++;
        while (index < fenwickTree.length) {
            fenwickTree[index] += value;
            /**
             * 비트 연산을 통해 영향을 받는 노드를 갱신합니다.
             */
            index += index & -index;
        }
    }
}
