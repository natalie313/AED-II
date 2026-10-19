//Questão 02
import java.util.Comparator;

public class MergeSort<T extends Comparable<T>> implements IOrdenator<T> {

    private T[] dadosOrdenados;
    private Comparator<T> comparador;

    public MergeSort() {
        setComparador(T::compareTo);
    }

    public MergeSort(Comparator<T> comparador) {
        setComparador(comparador);
    }

    @Override
    public void setComparador(Comparator<T> comparador) {
        this.comparador = comparador;
    }

    @Override
    public T[] ordenar(T[] dados) {
        dadosOrdenados = dados;
        mergesort(0, dadosOrdenados.length - 1);
        return dadosOrdenados;
    }

	private void mergesort(int esq, int dir) {
		
		if (esq < dir) {
			int meio = (esq + dir) / 2;
	        mergesort(esq, meio);
	        mergesort(meio + 1, dir);
	        intercalar(esq, meio, dir);
	    }
	}

    private void intercalar(int esq, int meio, int dir) {

		int n1, n2, i, j, k;

	    n1 = meio - esq + 1;
	    n2 = dir - meio;

	    @SuppressWarnings("unchecked")
		T[] a1 = (T[]) new Comparable[n1];
	      	
		@SuppressWarnings("unchecked")
		T[] a2 = (T[]) new Comparable[n2];

	    for (i = 0; i < n1; i++) {
	    	a1[i] = dadosOrdenados[esq + i];
	    }

	    for (j = 0; j < n2; j++) {
	    	a2[j] = dadosOrdenados[meio + 1 + j];
	    }

	    for (i = j = 0, k = esq; (i < n1 && j < n2); k++) {
	    	comparacoes++;
	      	movimentacoes++;
	        if (comparador.compare(a1[i], a2[j]) < 0)
	        	dadosOrdenados[k] = a1[i++];
	        else
	        	dadosOrdenados[k] = a2[j++];
	    }
		
		if (i == n1)
			for (; k <= dir; k++) {
				movimentacoes++;
        		dadosOrdenados[k] = a2[j++];
		    }
		else
		    for (; k <= dir; k++) {
		    	movimentacoes++;
	        	dadosOrdenados[k] = a1[i++];
		    }
	}   

    private void swap(int i, int j) {
        T temp = dadosOrdenados[i];
        dadosOrdenados[i] = dadosOrdenados[j];
        dadosOrdenados[j] = temp;
    }
}
