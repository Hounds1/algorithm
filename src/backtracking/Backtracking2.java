package backtracking;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * n * n 체스판에서 n개의 퀸(십자 및 대각 공격 가능)이 서로 다른 퀸을 공격할 수 없도록 배치하는 방법이 있는지
 * 찾아내는 백트래킹 알고리즘입니다.
 */
public class Backtracking2 {

    /**
     * 해당하는 솔루션이 몇 개나 존재하는지 확인할 list 입니다.
     * 해당 list를 통해 솔루션의 존재 여부 또한 판단합니다.
     */
    private static final List<Boolean> list = new ArrayList<>();

    private static boolean isSafe(int board[], int row, int col, int n) {

        /**
         * 동일한 열에 퀸이 있는지 확인합니다.
         */
        for(int i = 0; i < row; i++) {
            if (board[i] == col) return false;
        }


        /**
         * 양 방향 대각으로 퀸이 있는지 확인합니다.
         */
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i] == j) return false;
        }

        for(int i = row -1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i] == j) return false;
        }

        return true;
    }

    private static boolean solveQueenUtil(int board[], int row, int n) {
        /**
         * 모든 퀸이 배치되어도 false를 통해 계속해서 다른 솔루션이 존재하는지 탐색합니다.
         */
        if (row >= n) {
            printBoard(board, n);
            list.add(Boolean.TRUE);
            return false;
        }

        for(int i = 0; i < n; i++) {
            if (isSafe(board, row, i, n)) {

                /**
                 * 퀸을 배치합니다.
                 */
                board[row] = i;

                /**
                 * 다음 퀸을 배치합니다.
                 */
                if (solveQueenUtil(board, row + 1, n)) return true;

                /**
                 * 배치에 실패하면 백트래킹 합니다.
                 */
                board[row] = -1;
            }
        }
        return false;
    }

    /**
     * 어떤 배치로 체스판에 퀸이 놓여있는지 보여줍니다.
     */
    private static void printBoard(int board[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i] == j)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
        System.out.println();
    }


    /**
     * 초기화를 담당하는 함수로 -1로 초기화된 배열을 생성하고
     * solveQueenUtil()을 호출합니다.
     */
    public static boolean solveQueen(int n) {
        int[] board = new int[n];
        for(int i = 0; i < n; i++) {
            board[i] = -1;
        }

        return solveQueenUtil(board, 0, n);
    }


    /**
     * n이 4로 4 * 4 체스판에 4개의 퀸이 서로 공격하지 못하게 배치될 방법이 있는지를 요청합니다.
     * list에 들어있는 원소의 개수로 솔루션의 존재 여부와 갯수를 출력합니다.
     */
    public static void main(String[] args) {
        int n = 4;
        solveQueen(n);
        if (list.size() != 0)
            System.out.println("O and " + list.size());
        else System.out.println("X");
    }
}
