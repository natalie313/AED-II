//Questão 02
import java.util.Comparator;

public class BubbleSort<T extends Comparable<T>> implements IOrdenator<T> {

    private T[] dadosOrdenados;
    private Comparator<T> comparador;

    public BubbleSort() {
        setComparador(T::compareTo);
    }

    public BubbleSort(Comparator<T> comparador) {
        setComparador(comparador);
    }

    @Override
    public void setComparador(Comparator<T> comparador) {
        this.comparador = comparador;
    }

    @Override
    public T[] ordenar(T[] dados) {
        dadosOrdenados = dados;
        comparacoes = 0;
        for (int i = dadosOrdenados.length - 1; i > 0; i--) {
            int menor = i;
            for (int j = i + 1; j < dadosOrdenados.length; j++) {
                for (int j = 0; j < i; j++) {
				    comparacoes++;
				    if (comparador.compare(dadosOrdenados[j], dadosOrdenados[j + 1]) > 0)
					    swap (j, j + 1);
			        }
                }
                if (menor != i) {
                    wap(i, menor);
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
