import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Ingresso implements Comparable<Ingresso> {

    private static int ultimoId = 1;

    protected int idIngresso;
    protected String evento;
    protected double precoBase;
    protected LocalDate dataEvento;

    private static final DateTimeFormatter FORMATO_DATA =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Ingresso(String evento, double precoBase, LocalDate dataEvento) {
        this.idIngresso = ultimoId++;
        this.evento = evento;
        this.precoBase = precoBase;
        this.dataEvento = dataEvento;
    }

    public abstract double valorFinal();
    
    @Override
    public String toString() {
        return String.format("[%03d] %s | %s | Base: R$ %.2f | Final: R$ %.2f | Data: %s",
                idIngresso,
                getClass().getSimpleName(),
                evento,
                precoBase,
                valorFinal(),
                dataEvento.format(FORMATO_DATA));
    }

    @Override
    public int hashCode() {
        return idIngresso;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ingresso outro = (Ingresso) obj;
        return this.idIngresso == outro.idIngresso;
    }

    @Override
    public int compareTo(Ingresso outro) {
        return Integer.compare(this.idIngresso, outro.idIngresso);
    }
}
