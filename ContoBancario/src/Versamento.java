public class Versamento extends Operation {
    private double amount;

    public Versamento(ContoBancario conto, double amount) {
        super(conto);
        this.amount = amount;
    }

    @Override
    public void esegui() {
        conto.versa(amount);
    }
}