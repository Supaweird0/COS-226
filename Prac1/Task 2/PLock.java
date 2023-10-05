import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class PLock implements Lock {
    boolean[] flag = new boolean[2];
    int victim;

    PLock() {
        flag[0] = false;
        flag[1] = false;
    }

    public int getThreadNo() {
        String str = Thread.currentThread().getName();
        char threadChar = str.charAt(str.length() - 1);
        int threadNo = Character.getNumericValue(threadChar);
        return threadNo;
    }

    @Override
    public void lock() {
        int currThread = getThreadNo();
        int otherThread = 1 - currThread;
        flag[currThread] = true;                   // I'm interested
        victim = currThread;                       // you go first
        while (flag[otherThread] && victim == currThread) {} // wait
    }

    @Override
    public void unlock() {
        // System.out.println("unlocked" + Thread.currentThread().getName());
        int currThread = getThreadNo();
        flag[currThread] = false;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lockInterruptibly'");
    }

    @Override
    public boolean tryLock() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tryLock'");
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tryLock'");
    }

    @Override
    public Condition newCondition() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'newCondition'");
    }
}

// void mut_excl(int me /* 0 or 1 */) {
//     static int loser;
//     static int interested[2] = {0, 0};
//     int other; /* local variable */
   
//     other = 1 - me;
//     interested[me] = 1;
//     loser = me;
//     while (loser == me && interested[other])
//         ;

//     /* critical section */
//     interested[me] = 0;
// }
// 
