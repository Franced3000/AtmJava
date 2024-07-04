import java.util.ArrayList;
import java.util.List;

public class ContoBancario {
    private double currentBalance;
    private String iban;
    private List<String> listaOperazioni;

    public ContoBancario(String iban, double initialBalance) {
        this.iban = iban;
        this.currentBalance = initialBalance;
        this.listaOperazioni = new ArrayList<>();
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public String getIban() {
        return iban;
    }

    public void registraOperazione(String operazione) {
        listaOperazioni.add(operazione);
    }

    public void stampaListaOperazioni() {
        System.out.println("Operazioni sul conto " + iban + ":");
        for (String operazione : listaOperazioni) {
            System.out.println(operazione);
        }
    }

    public void eseguiOperazioni(List<Operation> operazioni) {
        for (Operation operazione : operazioni) {
            operazione.esegui();
        }
    }

    public void preleva(double amount) {
        if (amount <= currentBalance) {
            currentBalance -= amount;
            registraOperazione("Prelievo di " + amount + " euro.");
        } else {
            System.out.println("Saldo non sufficiente.");
        }
    }

    public void versa(double amount) {
        currentBalance += amount;
        registraOperazione("Versamento di " + amount + " euro.");
    }

    public void svuotaConto() {
        registraOperazione("Svuotato conto di " + currentBalance + " euro.");
        currentBalance = 0;
    }

    public void stampaSaldo() {
        System.out.println("Saldo attuale del conto " + iban + ": " + currentBalance + " euro.");
    }

    public void bonifico(ContoBancario destinatario, double amount) {
        if (amount <= currentBalance) {
            this.preleva(amount);
            destinatario.versa(amount);
            registraOperazione("Bonifico di " + amount + " euro verso " + destinatario.getIban() + ".");
        } else {
            System.out.println("Saldo non sufficiente per effettuare il bonifico.");
        }
    }
}
