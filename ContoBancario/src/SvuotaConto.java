public class SvuotaConto extends Operation {

    public SvuotaConto(ContoBancario conto) {
        super(conto);
    }

    @Override
    public void esegui() {
        conto.svuotaConto();
    }
}