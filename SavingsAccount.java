import java.util.Random;

public class SavingsAccount extends BankAccount{
    float returnValue;

    public SavingsAccount(Client client) {
        super(client);
        this.returnValue = 0;
    }

    @Override
    public void statement() {
        System.out.println("=== Extrato Conta Poupança ===");
        this.AccountData();
        System.out.printf("Rendimentos: %.2f%n", this.getReturnValue());
    }

    public float getReturnValue() {
        Random rand = new Random();
        float n = rand.nextFloat(3)+3;
        int m = rand.nextInt(12)+ 12;
        this.setReturnValue(m, n);
        return this.returnValue;
    }

    public void setReturnValue(int monthsAmount, float adjustment){
        this.returnValue = (float) (this.getBalance() * Math.pow(1 + adjustment/100, monthsAmount));
    }
}