public class SRSWAtomic<T>{

    StampedValue<T> r_value;
    ThreadLocal<Long> lastStamp;
    ThreadLocal<StampedValue<T>> lastRead;
 
    public T read() { 
        StampedValue<T> value = r_value;
        StampedValue<T> last = lastRead.get();
        StampedValue<T> result = StampedValue.max(value, last);
        lastRead.set(result);
        return result.value;
    }

    public void write(T newValue) {
        long stamp = lastStamp.get() + 1;
        r_value = new StampedValue<T>(stamp, newValue);
        lastStamp.set(stamp);
    }
}