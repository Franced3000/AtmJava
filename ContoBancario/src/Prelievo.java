public class Prelievo extends Operation {
    private double amount;

    public Prelievo(ContoBancario conto, double amount) {
        super(conto);
        this.amount = amount;
    }

    @Override
    public void esegui() {
        conto.preleva(amount);
    }
}