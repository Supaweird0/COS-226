public class MyThread extends Thread {
    SharedResources criticalSection;
	Bakery bLock = new Bakery(6);

	public MyThread(SharedResources CrSection ){
		criticalSection = CrSection;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 4; i++) {
			bLock.lock();
			try {
				criticalSection.access();

				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + ": flag[" + bLock.getThreadNo() + "] = " + bLock.flag[i] + ", label[" + bLock.getThreadNo() + "] = " + (bLock.label[i]+1)); 
				// System.out.println(threadName + ": flag[" + i + "] = " + bLock.flag[i] + ", label[" + i + "] = " + (bLock.label[i]+1)); 
				criticalSection.access();
			} finally {
				System.out.println(Thread.currentThread().getName() + ": ---------------- DONE");
				bLock.unlock();
			}
		}
		// for(int i = 0; i < flock.size; i++) {
		// 	String threadName = Thread.currentThread().getName();
		// 	System.out.println(threadName + ": level[" + flock.getThreadNo() + "} = " + i + ", victim[" + i + "] = " + flock.getThreadNo()); 
		// }
	}
}
