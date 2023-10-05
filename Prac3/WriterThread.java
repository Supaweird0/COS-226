import java.util.Random;

public class WriterThread extends Thread {
    private MRMWAtomic register;
    private Random random = new Random();

    public WriterThread(MRMWAtomic register) {
        this.register = register;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int newValue = random.nextInt(100);
            register.write(newValue);
            System.out.println("Writer " + getName() + ": Wrote value " + newValue);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
