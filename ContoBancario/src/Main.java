import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ContoBancario conto1 = new ContoBancario("IT60X0542811101000000123456", 1000);
        ContoBancario conto2 = new ContoBancario("IT60X0542811101000000654321", 500);

        System.out.println("Benvenuti nella banca!");

        boolean exit = false;
        while (!exit) {
            System.out.println("Seleziona un'operazione:");
            System.out.println("1. Prelievo");
            System.out.println("2. Versamento");
            System.out.println("3. Bonifico");
            System.out.println("4. Svuota Conto");
            System.out.println("5. Situazione");
            System.out.println("6. Esci");

            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma la nuova riga

            switch (scelta) {
                case 1:
                    System.out.println("Inserisci IBAN:");
                    String ibanPrelievo = scanner.nextLine();
                    ContoBancario contoPrelievo = getContoByIban(ibanPrelievo, conto1, conto2);
                    if (contoPrelievo != null) {
                        System.out.println("Inserisci l'importo da prelevare:");
                        double importoPrelievo = scanner.nextDouble();
                        scanner.nextLine(); // Consuma la nuova riga
                        Operation prelievo = new Prelievo(contoPrelievo, importoPrelievo);
                        prelievo.esegui();
                    }
                    break;
                case 2:
                    System.out.println("Inserisci IBAN:");
                    String ibanVersamento = scanner.nextLine();
                    ContoBancario contoVersamento = getContoByIban(ibanVersamento, conto1, conto2);
                    if (contoVersamento != null) {
                        System.out.println("Inserisci l'importo da versare:");
                        double importoVersamento = scanner.nextDouble();
                        scanner.nextLine(); // Consuma la nuova riga
                        Operation versamento = new Versamento(contoVersamento, importoVersamento);
                        versamento.esegui();
                    }
                    break;
                case 3:
                    System.out.println("Inserisci IBAN del conto da cui prelevare:");
                    String ibanBonificoDa = scanner.nextLine();
                    ContoBancario contoBonificoDa = getContoByIban(ibanBonificoDa, conto1, conto2);
                    if (contoBonificoDa != null) {
                        System.out.println("Inserisci IBAN del conto su cui versare:");
                        String ibanBonificoA = scanner.nextLine();
                        ContoBancario contoBonificoA = getContoByIban(ibanBonificoA, conto1, conto2);
                        if (contoBonificoA != null) {
                            System.out.println("Inserisci l'importo del bonifico:");
                            double importoBonifico = scanner.nextDouble();
                            scanner.nextLine(); // Consuma la nuova riga
                            Operation bonifico = new Bonifico(contoBonificoDa, contoBonificoA, importoBonifico);
                            bonifico.esegui();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Inserisci IBAN:");
                    String ibanSvuotaConto = scanner.nextLine();
                    ContoBancario contoSvuotaConto = getContoByIban(ibanSvuotaConto, conto1, conto2);
                    if (contoSvuotaConto != null) {
                        Operation svuotaConto = new SvuotaConto(contoSvuotaConto);
                        svuotaConto.esegui();
                    }
                    break;
                case 5:
                    System.out.println("Inserisci IBAN:");
                    String ibanSituazione = scanner.nextLine();
                    ContoBancario contoSituazione = getContoByIban(ibanSituazione, conto1, conto2);
                    if (contoSituazione != null) {
                        Operation situazione = new Situazione(contoSituazione);
                        situazione.esegui();
                    }
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }

            // Stampa delle operazioni svolte
            conto1.stampaListaOperazioni();
            conto2.stampaListaOperazioni();
        }

        scanner.close();
    }

    private static ContoBancario getContoByIban(String iban, ContoBancario... conti) {
        for (ContoBancario conto : conti) {
            if (conto.getIban().equals(iban)) {
                return conto;
            }
        }
        System.out.println("Conto non trovato per l'IBAN: " + iban);
        return null;
    }
}