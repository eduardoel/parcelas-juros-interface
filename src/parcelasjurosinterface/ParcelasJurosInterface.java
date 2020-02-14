package parcelasjurosinterface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Contract;
import model.services.ContractService;
import model.services.PaypalService;

public class ParcelasJurosInterface {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter contract data"); //Inserir dados do contrato
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        Date date = sdf.parse(sc.next());
        System.out.print("Contract value: "); //Valor do contrato
        double totalValue = sc.nextDouble();

        Contract contract = new Contract(number, date, totalValue);

        System.out.print("Enter number of installments: "); //Digite o número de parcelas
        int n = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContrat(contract, n);

        System.out.println("Installments:"); //Parcelas
        contract.getInstallments().forEach((x) -> {
            System.out.println(x);
        });

        sc.close();
    }

}
