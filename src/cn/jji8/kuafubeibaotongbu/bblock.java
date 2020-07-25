package cn.jji8.kuafubeibaotongbu;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class bblock implements Lock {
    // 锁的状态
    private boolean isLocked = false;
    // 正在运行的进程，开始为null
    private Thread runningThread = null;
    // 计数器
    private int count = 0;

    // 进程的执行体
    @Override
    public synchronized void lock() {
        while (isLocked) {
            try {
                System.out.println("正在等待线程...");
                // 通知线程，等！
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 一旦发现线程空闲，立刻进行占用。
        isLocked = true;
        // 正在运行的进程进行更换。
        runningThread = Thread.currentThread();
        // 计数自增。
        count++;
        System.out.println("当前进入次数:"+count+" 线程ID:"+runningThread.getId()+" 线程名:"+runningThread.getName());
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public synchronized void unlock() {
        if (runningThread == Thread.currentThread()) {
            count--;
            if (count == 0) {
                // 修改锁的状态
                isLocked = false;
                // 全部释放后线程恢复null
                runningThread = null;
                // 通知等待线程，具体是那个抢到就不知道了
                notifyAll();
            }
        }

    }

    @Override
    public Condition newCondition() {
        return null;
    }
    public boolean isLocked(){
        return isLocked;
    }
}
