
public class MRSWAtomic<T> {
    ThreadLocal<Long> lastStamp;
    private StampedValue<T>[][] a_table; // each entry is SRSW atomic
    public MRSWAtomic(T init, int readers) {

        lastStamp = new ThreadLocal<Long>() {
            protected Long initialValue() {long num = 0; return num; };
        };

        a_table = (StampedValue<T>[][]) new StampedValue[readers][readers];
        StampedValue<T> value = new StampedValue<T>(init);
        for (int i = 0; i < readers; i++) {
            for (int j = 0; j < readers; j++) {
                a_table[i][j] = value;
            }
        }
    }

    public int getThreadNo() {
        String str = Thread.currentThread().getName();
        char threadChar = str.charAt(str.length() - 1);
        int threadNo = Character.getNumericValue(threadChar);
        return threadNo;
    }

    public T read() {
        int me = getThreadNo();
        StampedValue<T> value = a_table[me][me];
        for (int i = 0; i < a_table.length; i++) {
            value = StampedValue.max(value, a_table[i][me]);
        }
        for (int i = 0; i < a_table.length; i++) {
            if (i == me) continue;
            a_table[me][i]  = value;
        }
        return value.value;
    }
    
    public void write(T newValue) {
        long stamp = lastStamp.get() + 1;
        lastStamp.set(stamp);
        StampedValue<T> value = new StampedValue<T>(stamp, newValue);
        for (int i = 0; i < a_table.length; i++) {
            a_table[i][i] = value;
        }
    }
}