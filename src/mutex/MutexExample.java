package mutex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexExample {

    private final Lock mutex = new ReentrantLock();

    /**
     * 어떤 스레드가 뮤텍스를 먼저 획득할 지는 알 수 없습니다.
     * 이는, 스레드 스케줄링에 따라 달라지며 스레스 스케줄링은 운영체제와 JVM이 결정합니다.
     * 따라서, 운영체제의 현재 상태와 시스템 리소스 등에 따라 스레드의 동작 순서가 달라질 수 있습니다.
     * 해당 예제도 여러 번 실행했을 때 thread1과 thread2의 순서가 변하는 것을 볼 수 있습니다.
     */
    public void criticalSection(final String threadName) {
        mutex.lock();
        try {
            System.out.println(threadName + " entering critical section");

            System.out.println(threadName + " exiting critical section");
        } finally {
            mutex.unlock();
        }
    }

    public static void main(String[] args) {
        MutexExample example = new MutexExample();

        Thread thread1 = new Thread(() -> {
            example.criticalSection("thread1");
        });

        Thread thread2 = new Thread(() -> {
            example.criticalSection("thread2");
        });

        thread1.start();
        thread2.start();
    }
}
