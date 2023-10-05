public class Main {
    public static void main(String[] args) {
        Thread[] threads = new MyThread[5];

        for(int i = 0; i < 5; i++){
            threads[i] = new MyThread();
        }

        System.out.println("Threads created by extending the Thread class:");

        for(Thread t : threads){        // Start running threads
            t.start();
        }

    }
}
