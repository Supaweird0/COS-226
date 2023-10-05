// allows a timestamp and a value to be read or written together
public class StampedValue<T> {
    public long stamp;
    public T value;

    public StampedValue(T value) {
        this.stamp = 0;
        this.value = value;
    }

    public StampedValue(long stamp, T value) {
        this.stamp = stamp;
        this.value = value;
    }

    public static StampedValue max(StampedValue x, StampedValue y) {
        if (x.stamp > y.stamp)
            return x;
        return y;
    }

    public static StampedValue MIN_VALUE = new StampedValue(null);

}
