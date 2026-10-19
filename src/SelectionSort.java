import java.util.Comparator;

public class SelectionSort<T extends Comparable<T>> implements IOrdenator<T> {

    private T[] dadosOrdenados;
    private Comparator<T> comparador;

    public SelectionSort() {
        setComparador(T::compareTo);
    }

    public SelectionSort(Comparator<T> comparador) {
        setComparador(comparador);
    }

    @Override
    public void setComparador(Comparator<T> comparador) {
        this.comparador = comparador;
    }

    @Override
    public T[] ordenar(T[] dados) {
        dadosOrdenados = dados;
        for (int i = 0; i < dadosOrdenados.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < dadosOrdenados.length; j++) {
                if (comparador.compare(dadosOrdenados[j], dadosOrdenados[menor]) < 0) {
                    menor = j;
                }
            }
            if (menor != i) {
                swap(i, menor);
            }
        }
        return dadosOrdenados;
    }

    private void swap(int i, int j) {
        T temp = dadosOrdenados[i];
        dadosOrdenados[i] = dadosOrdenados[j];
        dadosOrdenados[j] = temp;
    }
}
