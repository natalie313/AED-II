import java.util.Comparator;

public class ComparadorPorValorFinal implements Comparator<Ingresso> {
    @Override
    public int compare(Ingresso a, Ingresso b) {
        int cmp = a.valorFinal.compareTo(b.valorFinal);
        if (cmp != 0) return cmp;

        return Double.compare(a.valorFinal(), b.valorFinal());
    }
}
