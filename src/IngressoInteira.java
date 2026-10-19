import java.time.LocalDate;

public class IngressoInteira extends Ingresso {

    public IngressoInteira(String evento, double precoBase, LocalDate dataEvento) {
        super(evento, precoBase, dataEvento);
    }

    @Override
    public double valorFinal() {
        return precoBase;
    }
}
