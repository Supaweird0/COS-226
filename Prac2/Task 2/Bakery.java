import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

// Name: Asakundwi Siphuma
// Student Number: 21556416

public class Bakery implements Lock
{
	boolean[] flag;
	int[] label;
	// Label[] label;
	public int size;

	public Bakery(int n) {
		size = n;
		flag = new boolean[size];
		label = new int[size];
		for (int i = 0; i < size; i++) {
			flag[i] = false;
			label[i] = 0;
		}
	}

	public int getThreadNo() {
        String str = Thread.currentThread().getName();
        char threadChar = str.charAt(str.length() - 1);
        int threadNo = Character.getNumericValue(threadChar);
        return threadNo;
    }

	// find the largest value in the array of Labels
	private int findMaxElement() {
        // int maxValue = arr[0];
        // for (int element : arr) {
        //     if (element > maxValue) {
        //         maxValue = element;
        //     }
        // }
        // return maxValue;
		int maxVal = label[0];
		for (int i = 0; i < label.length; i++) {
			if (label[i] > maxVal)
				maxVal = label[i];
		}
		// System.out.println(maxVal);
		return maxVal;
    }

	@Override
	public void lock() {
		int i = getThreadNo();
		flag[i] = true;
		label[i] = findMaxElement() + 1;
		// spin while conflicts arise
		for (int j = 0; j < size; j++) {
			while ((j != i) && flag[j] && (label[j] < label[i]) || ((label[j] == label[i]) && j < i)) {}
		}
	}

	@Override
	public void unlock() {
		int i = getThreadNo();
		flag[i] = false;
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
