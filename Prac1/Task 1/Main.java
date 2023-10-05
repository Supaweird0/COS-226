public class Main {

    public static void main(String[] args) {
        
        int size = 45;
        Integer[] array = new Integer[size];
        Thread t1 = new MyThread(array, 0, 15);
        Thread t2 = new MyThread(array, 16, 30);
        Thread t3 = new MyThread(array, 30, 45);

        t1.start();
        t2.start();
        t3.start();
        
        // System.out.println(Thread.activeCount());
        // MyThread thread1 = new MyThread();

        // MyRunnable runnable1 = new MyRunnable();
        // Thread thread2 = new Thread(runnable1);

        // thread1.start();
        // try {
        //     thread1.join(3000); // this will make it so that thread2 waits fro thread1 to die before executing
        //     // calling thread (ex. main) waits until specified thread dies or for x milliseconds
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        // thread2.start();
        // // System.out.println(1/0);
    }
}
