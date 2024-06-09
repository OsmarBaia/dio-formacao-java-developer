import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args){
        CreateFakeData();
        // UI
        LaunchUI();
        //LaunchTerminalInterface();
    }
    private static void LaunchUI(){
        SwingUtilities.invokeLater(() -> new WelcomeFrame().setVisible(true));
    }
    private static void CreateFakeData(){
        // Client 1
        Client c1 = new Client("12332145665", "Jõao Silva", "12345");
        clients.add(c1);

        CheckingAccount ac1 = new CheckingAccount(c1);
        ac1.deposit(1000);
        accounts.add(ac1);

        SavingsAccount ac2 = new SavingsAccount(c1);
        ac1.transfer(ac2,200);
        accounts.add(ac2);

        // Client 2
        Client c2 = new Client("98778965432", "Maria Alves", "54321");
        clients.add(c2);
        CheckingAccount ac3 = new CheckingAccount(c2);
        ac3.deposit(100);
        ac1.transfer(ac3,100);

        accounts.add(ac3);
    }

    private static void LaunchTerminalInterface(){
        String option = "-1";

        while (!option.equals("0")){
            System.out.println("=== Digital Innovation Bank ===");
            System.out.println("\n\n        Seja Bem-Vindo!\n\n");
            System.out.println("O Que deseja fazer?");
            System.out.println("1 - Logar");
            System.out.println("2 - Cadastrar");
            System.out.println("0 - Sair");
            System.out.println("Digite o numero: ");
            option = sc.nextLine();
            switch (option){
                case "1":
                    TerminalLoginMenu();
                    break;
                case "2":
                    TerminalCreateClient();
                    break;
                case "0":
                    System.out.println("Até Logo");
                    break;
                default:
                    System.out.println("Digite um numero valido");
                    break;
            }
        }
    }

    private static void TerminalLoginMenu(){
        String cpf = "";
        String psswd = "";

        System.out.println("=== Digital Innovation Bank ===");
        System.out.println("\n\n        Log-in!\n\n");
        System.out.println("Por favor digite seu CPF: ");
        cpf = sc.nextLine();
        System.out.println("\nPor favor digite sua senha: ");
        psswd = sc.nextLine();

        Client client = null;
        for (Client c:clients){
            if(c.getCpf().equals(cpf) && c.getPassword().equals(psswd)){
                client = c;
                break;
            }
        }

        if(client != null){
            TerminalClientMenu(client);
        }
        else
        {
            System.out.print("\n   Usuário ou Senha incorretos\n\n");
        }
    }

    private static void TerminalClientMenu(Client client){
        if(client == null){return;}

        String selectedMenuOption = "-1";
        IAccount selectedAccount = null;

        //Account Selection
        while (!selectedMenuOption.equals("0")){
            System.out.println("=== Digital Innovation Bank ===");
            System.out.printf("\n   Seja Bem-Vindo %s!\n\n", client.getName());

            if(client.accounts.size() > 1){
                String selectedAccountNumber = "";
                System.out.println("Selecione uma conta: ");
                for (int i = 0; i < client.accounts.size(); i++){
                    System.out.printf("\n %d - %s", i + 1,  client.accounts.get(i).toString());
                    System.out.print("\n");
                }
                System.out.println("0 - Sair");
                System.out.println("Digite o numero: ");
                selectedMenuOption = sc.nextLine();
            }
            else
            {
                selectedMenuOption = "1";
            }

            switch (selectedMenuOption){
                case "0":
                    System.out.println("Sessão Finalizada!");
                    TerminalLoginMenu();
                    break;
                case "1":
                    System.out.println("Conta Corrente Selecionada");
                    selectedAccount = client.accounts.getFirst();
                    break;
                case "2":
                    System.out.println("Conta Poupança Selecionada");
                    selectedAccount = client.accounts.getLast();
                    break;
                default:
                    System.out.println("Selecione o numero referente a uma das contas mostradas na tela");
                    break;
            }

            if (selectedAccount == null)
            {
                //Throw Error
                System.out.println("Alguma coisa deu errado ao selecionar conta! Por favor tente de novo mais tarde!");
            }
            else
            {
                TerminalAccountMenu(selectedAccount);
            }
        }
    }

    private static void TerminalAccountMenu(IAccount account){
        if(account == null){return;}
        //Account Info
        account.statement();
        System.out.print("\n");

        //Account Options
        String selectedMenuOption = "-1";
        while (!selectedMenuOption.equals("0")) {
            System.out.println("O Que deseja fazer?");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Transferir");
            System.out.println("0 - Sair");
            System.out.println("Digite o numero: ");
            selectedMenuOption = sc.nextLine();

            switch (selectedMenuOption){
                case "1":
                    TerminalAccountOperations(account, "withdraw");
                    break;
                case "2":
                    TerminalAccountOperations(account, "deposit");
                    break;
                case "3":
                    TerminalAccountOperations(account, "transfer");
                    break;
                case "0":
                    System.out.println("Até Logo");
                    LaunchTerminalInterface();
                    break;
                default:
                    System.out.println("Digite um numero valido");
                    break;
            }
        }
    }
    private static void TerminalAccountOperations(IAccount account, String selectedOption){
        if(account == null){return;}
        System.out.println("Digite o valor: ");
        float value = sc.nextFloat();

        switch (selectedOption){
            case "withdraw":
                account.deposit(value);
                break;
            case "deposit":
                account.withdraw(value);
                break;
            case "transfer":
                int destBankAgencyID;
                int destBankAccountID;
                System.out.println("Numero da Agencia: ");
                destBankAgencyID = sc.nextInt();
                System.out.println("Numero da Conta:");
                destBankAccountID = sc.nextInt();
                BankAccount destAccount = SearchForAccount(destBankAgencyID, destBankAccountID);
                account.transfer(destAccount, value);
                break;
            default:
                System.out.println("Operação invalida!");
                break;
        }
    }


    private static BankAccount SearchForAccount(int bankAgency, int accountNumber){
       BankAccount targetAccount = null;
        for(BankAccount acc: accounts){
            if(acc.getBankID() ==  bankAgency && acc.getAccountID()==accountNumber){
                targetAccount =  acc;
            }
        }
        return targetAccount;
    }

    private static void TerminalCreateClient(){
        String cpf = "";
        String psswd = "";
        String name = "";

        System.out.println("=== Digital Innovation Bank ===");
        System.out.println("\n\n   Cadastro De Cliente!\n\n");
        System.out.println("Por favor digite seu Nome e Sobrenome: ");
        name = sc.nextLine();
        System.out.println("Por favor digite seu CPF: ");
        cpf = sc.nextLine();
        System.out.println("\nPor favor digite uma senha: ");
        psswd = sc.nextLine();


        Client client = new Client(cpf, name, psswd);
        CheckingAccount account = new CheckingAccount(client);

        clients.add(client);
        accounts.add(account);

        System.out.println("Parabens! Seja bem-vindo ao Innovation Bank!");
        System.out.println("Redirecionando par ao menu inicial...");
        LaunchTerminalInterface();
    }

    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<BankAccount> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
}



