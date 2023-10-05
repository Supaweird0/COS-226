public class Register<T> {
    private T value;
    public T read() {
        return value;
    }

    public void write(T v) {
        value = v;
    }
}
