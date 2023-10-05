public class MyThread extends Thread {
    Integer[] arr;
    Counter c = new Counter();

    MyThread(Integer[] array) {
        this.arr = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = i;
        }
    }

    @Override
    public void run() {
        boolean isPrime = true;
        int primeNo = 0;

        for (int i = 0; i < arr.length; i = c.getAndIncrement()) {
            isPrime = true;
            if (arr[i] >= 2) {
                for (int j = 2; j <= arr.length; j++) {
                    if (arr[i] % j == 0 && arr[i] != j) {
                        isPrime = false;
                        break;
                    }
                    primeNo = arr[i];   
                }
            }

            // i = c.getAndIncrement();

            // try {
            //     Thread.sleep(500);
            // } catch (InterruptedException e) {
            //     // TODO Auto-generated catch block
            //     e.printStackTrace();
            // }

            if (isPrime && primeNo != 0)
                System.out.println(Thread.currentThread().getName() + ": " + primeNo);
        }
    }
}

/*
 * Should we be able to pass a number into the counter object? If so, do we pass  value into the MyThread constructor
 * How should the output look? Zero to the size of the array? Or zero to the passed in number?
 * Prob: thread doesn't unlock before other thread acquires the lock
 */