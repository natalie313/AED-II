import java.time.LocalDate;

public class IngressoMeia extends Ingresso {

    private static final double DESCONTO = 0.5;

    public IngressoMeia(String evento, double precoBase, LocalDate dataEvento) {
        super(evento, precoBase, dataEvento);
    }

    @Override
    public double valorFinal() {
        return precoBase * DESCONTO;
    }
}
