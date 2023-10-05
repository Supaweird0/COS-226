import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

// Name: Asakundwi Siphuma
// Student Number: 21556416

public class Filter implements Lock
{
	int[] level;
	int[] victim;
	public int size;

	public Filter(int n) {
		size = n;
		level = new int[size];
		victim = new int[size];
		for (int i = 0; i < size; i++) {
			level[i] = 0;
		}
	}

	public int getThreadNo() {
        String str = Thread.currentThread().getName();
        char threadChar = str.charAt(str.length() - 1);
        int threadNo = Character.getNumericValue(threadChar);
        return threadNo;
    }

	@Override
	public void lock() {
		int me = getThreadNo();
		for (int i = 1; i < size; i++) {
			level[me] = i;
			victim[i] = me;
			// spin while conflicts arise
			for (int j = 0; j < size; j++) {
				while (j != me && (level[j] >= i && victim[i] == me)) {
					// spin wait - 
				}
			}
		}
	}

	@Override
	public void unlock() {
		int me = getThreadNo();
		level[me] = 0;
	}

	public void lockInterruptibly() throws InterruptedException
	{
		throw new UnsupportedOperationException();
	}

	public boolean tryLock()
	{
		throw new UnsupportedOperationException();
	}

	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException
	{
		throw new UnsupportedOperationException();
	}

	public Condition newCondition()
	{
		throw new UnsupportedOperationException();
	}

}
