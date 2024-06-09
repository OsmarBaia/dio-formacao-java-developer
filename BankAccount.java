public abstract class BankAccount implements IAccount {
    protected static int sequentialID = 1;
    protected static final int defaultAgency = 1;

    private int bankID;
    private final int accountID;
    private final Client client;
    private float balance;

    public BankAccount(Client client){
        this.accountID = sequentialID++;
        this.bankID = defaultAgency;
        this.client = client;
        this.balance = 0;
        this.client.addAccount(this);
    }

    public int getAccountID() {
        return accountID;
    }

    public int getBankID() {
        return bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }


    public float getBalance() {
        return balance;
    }

    public void deposit(float value) {
        try{
            if(value < 0){
                throw new NegativeValueException("O valor de deposito não pode ser negativo");
            }

            this.balance += value;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void withdraw(float value){
        try {
            if(value < 0){
                throw new NegativeValueException("O valor de saque não pode ser negativo");
            } else if (value > balance) {
                throw new NoBalanceException("O valor de saque não pode ser maior que o saldo");
            }
            else
            {
                this.balance -= value;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void transfer(IAccount destAccount, float value){
        try{
            this.withdraw(value);
            destAccount.deposit(value);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    protected void AccountData() {
        System.out.printf("Agencia: %d%n", this.getBankID());
        System.out.printf("Conta: %d%n", this.getAccountID());
        System.out.printf("Saldo: %.2f%n", this.getBalance());
    }
    public void statement(){}

    public Client getClient() {
        return client;
    }

    static class NegativeValueException extends Exception {
        public NegativeValueException(String message) {
            super(message);
        }
    }

    static class NoBalanceException extends Exception {
        public NoBalanceException(String message) {
            super(message);
        }
    }
}
