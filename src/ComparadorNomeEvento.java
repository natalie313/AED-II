import java.util.Comparator;

public class ComparadorNomeEvento implements Comparator<Ingresso> {
    @Override
    public int compare(Ingresso a, Ingresso b) {
        int cmp = a.evento.compareTo(b.evento);
        if (cmp != 0) return cmp;

        return Double.compare(a.evento(), b.evento());
    }
}
