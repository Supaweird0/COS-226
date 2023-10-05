public class MyThread extends Thread {
    Integer[] arr;
    int n, m;

    MyThread(Integer[] array, int n, int m) {
        this.m = m;
        this.n = n;
        this.arr = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = i;
        }
    }

    @Override
    public void run() {
        boolean isPrime = true;;
        int primeNo = 0;

        for (int i = n; i < m; i++) {
            isPrime = true;
            if (arr[i] >= 2) {
                for (int j = 2; j <= m; j++) {
                    if (arr[i] % j == 0 && arr[i] != j) {
                        isPrime = false;
                        break;
                    }
                    
                    primeNo = arr[i];   
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if (isPrime && primeNo != 0)
                System.out.println(Thread.currentThread().getName() + " [" + n + "-" + m + "]: " + primeNo);
        }
    }
}
