public class MyThreadLocal<T> extends ThreadLocal<T>{
    StampedValue<T> lastRead;
    Long lastStamp;

}
