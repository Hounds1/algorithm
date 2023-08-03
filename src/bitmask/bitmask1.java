package bitmask;

/**
 * 비트마스킹은 비트 연산을 사용하여 n번째 비트를 조작하고 데이터로 사용하는 기법입니다.
 */

public class bitmask1 {
    public static void main(String[] args) {
        /**
         * 비트를 사용하기 위해 정수형 변수를 선언합니다.
         */
        int flags = 0;


        /**
         * flags의 2번째 비트를 활성화합니다.
         */
        flags |= (1 << 1);

         if ((flags & (1 << 1)) != 0) {
             System.out.println("2번째 비트가 설정되어 있습니다.");
         }

        /**
         * flags의 2 번째 비트를 비활성화합니다.
         */
        flags &= ~(1 << 1);

         if ((flags & (1 << 1)) == 0) {
             System.out.println("2번째 비트가 해제되었습니다.");
         }
    }

}
