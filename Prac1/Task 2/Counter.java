public class Counter {
    static int counter = 0;
    private PLock lock = new PLock();
    
    public int getAndIncrement() {
        lock.lock();
        // System.out.println("lock acquired by " + Thread.currentThread().getName());
        try {
            int temp = counter;
            counter = temp + 1;
            return temp;
        } finally {
            lock.unlock();
        }
    }
}
