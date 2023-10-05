import java.util.concurrent.locks.Lock;

public class SharedResources {
    Lock l;

	public void access() {
		// rand no., in range (min, max) => ((Math.random() * (max - min)) + min);
		long time = (long) Math.floor(Math.random() * (1000 - 200) + 200);
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
