package priv.zzy.common;

/**
 * Interface that indicates
 * a deserializer of type T
 * @param <T>
 */
public interface Deserializer<T> {
    T deserialize(String data);
}
