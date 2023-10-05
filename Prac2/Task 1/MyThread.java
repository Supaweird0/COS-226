public class MyThread extends Thread {
    SharedResources criticalSection;
	Filter fLock = new Filter(6);

	public MyThread(SharedResources CrSection ){
		criticalSection = CrSection;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 4; i++) {
			fLock.lock();
			try {
				criticalSection.access();

				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + ": level[" + fLock.getThreadNo() + "] = " + i + ", victim[" + i + "] = " + fLock.getThreadNo()); 
				criticalSection.access();

			} finally {
				System.out.println(Thread.currentThread().getName() + "---------------- DONE");
				fLock.unlock();
			}
		}
		// for(int i = 0; i < flock.size; i++) {
		// 	String threadName = Thread.currentThread().getName();
		// 	System.out.println(threadName + ": level[" + flock.getThreadNo() + "} = " + i + ", victim[" + i + "] = " + flock.getThreadNo()); 
		// }
	}
}
