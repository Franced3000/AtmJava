public class Bonifico extends Operation {
    private ContoBancario destinatario;
    private double amount;

    public Bonifico(ContoBancario conto, ContoBancario destinatario, double amount) {
        super(conto);
        this.destinatario = destinatario;
        this.amount = amount;
    }

    @Override
    public void esegui() {
        conto.bonifico(destinatario, amount);
    }
}