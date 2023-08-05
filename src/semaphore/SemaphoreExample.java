package semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    /**
     * 최대 수용할 스레드의 수를 미리 지정합니다.
     */
    private final Semaphore semaphore = new Semaphore(1);

    public void criticalSection(final String threadName) throws InterruptedException {
        semaphore.acquire();
        try {
            System.out.println(threadName + " entering critical section");

            /**
             * 스레드 스케줄링과 동시성을 확인하기 위해 먼저 진입하고 세마포어를 획득한 스레드에 1000 밀리초의
             * 휴식을 부여합니다.
             * 이 sleep()에서 다음으로 실행될 스레드를 결정하는데 영향을 줄 수 있는 스레드 스케줄링에 대한
             * 힌트를 제공하는 시간을 부여합니다.
             */
            Thread.sleep(1000);

            System.out.println(threadName + " exiting critical section");
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        SemaphoreExample example = new SemaphoreExample();

        Thread thread1 = new Thread(() -> {
            try {
                example.criticalSection("thread1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                example.criticalSection("thread2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }
}
