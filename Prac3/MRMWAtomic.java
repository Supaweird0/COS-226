public class MRMWAtomic<T> {
    
    private StampedValue<T>[] a_table; // array of atomic MRSW registers

    public MRMWAtomic(int capacity, T init) {
        a_table = (StampedValue<T>[]) new StampedValue[capacity];
        StampedValue<T> value = new StampedValue<T>(init);
        for (int j = 0; j < a_table.length; j++) {
            a_table[j] = value;
        }
    }

    public int getThreadNo() {
        String str = Thread.currentThread().getName();
        char threadChar = str.charAt(str.length() - 1);
        int threadNo = Character.getNumericValue(threadChar);
        return threadNo;
    }

    public void write(T value) {
        int me = getThreadNo();
        StampedValue<T> max = StampedValue.MIN_VALUE;
        for (int i = 0; i < a_table.length; i++) {
            max = StampedValue.max(max, a_table[i]);
        }
        a_table[me] = new StampedValue(max.stamp + 1, value);
    }

    public T read() {
        StampedValue<T> max = StampedValue.MIN_VALUE;
        for (int i = 0; i < a_table.length; i++) {
            max = StampedValue.max(max, a_table[i]);
        }
        return max.value;
    }
    
}