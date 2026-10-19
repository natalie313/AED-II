import java.util.Comparator;

public interface IOrdenator<T extends Comparable<T>> {
    T[] ordenar(T[] dados);
    void setComparador(Comparator<T> comparador);
}
