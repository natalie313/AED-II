import java.util.Comparator;

public class ComparadorPorData implements Comparator<Ingresso> {
    @Override
    public int compare(Ingresso a, Ingresso b) {
        int cmp = a.dataEvento.compareTo(b.dataEvento);
        if (cmp != 0) return cmp;

        return Double.compare(a.valorFinal(), b.valorFinal());
    }
}
