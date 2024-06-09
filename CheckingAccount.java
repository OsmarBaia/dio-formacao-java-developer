public class CheckingAccount extends BankAccount implements IAccount{
    public CheckingAccount(Client client) {
        super(client);
    }

    @Override
    public void statement() {
        System.out.println("=== Extrato Conta Corrente ===");
        this.AccountData();
    }
}
