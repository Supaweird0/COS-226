public class MyThread extends Thread {
    MRMWAtomic<Long> register = new MRMWAtomic<Long>(5,(long) 0);

    @Override
    public void run() {
        System.out.println("This thread is running");
        for (int i = 0; i < 5; i++) {
            Long val = register.read();
            System.out.println("Reader " + Thread.currentThread().getId() + ": Read value " + val);
        }
    }
}
