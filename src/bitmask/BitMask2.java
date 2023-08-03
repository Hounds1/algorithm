package bitmask;

/**
 * 해당 예제는 비트마스킹을 통해 권한을 관리하는 예제입니다.
 * CRUD 권한을 비트마스킹을 통해 관리한다고 가정해봅시다.
 */
public class BitMask2 {

    private static final int READ = 1;
    private static final int CREATE = 2;
    private static final int UPDATE = 4;
    private static final int DELETE = 8;

    private int permissions;

    public BitMask2() {
        permissions = 0;
    }

    /**
     * 비트 값을 바꿔 권한을 활성화 합니다.
     */
    public void grant(int permission) {
        permissions |= permission;
    }

    /**
     * 권한을 비활성화 합니다.
     */
    public void revoke(int permission) {
        permissions &= ~permission;
    }

    /**
     * 현재 권한이 활성화 되어있는지 확인합니다.
     */
    public boolean isGranted(int permission) {
        return (permissions & permission) == permission;
    }

    public static void main(String[] args) {
        BitMask2 manager = new BitMask2();
        manager.grant(READ);
        manager.grant(CREATE);

        System.out.println(manager.isGranted(READ));
        System.out.println(manager.isGranted(CREATE));
        System.out.println(manager.isGranted(UPDATE));

        manager.grant(UPDATE);

        System.out.println(manager.isGranted(UPDATE));

        manager.revoke(CREATE);

        System.out.println(manager.isGranted(CREATE));
    }
}
