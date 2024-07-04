public class Situazione extends Operation {

    public Situazione(ContoBancario conto) {
        super(conto);
    }

    @Override
    public void esegui() {
        conto.stampaSaldo();
    }
}
