import java.util.ArrayList;
import java.util.List;

public class Client {
    String cpf;
    String name;
    String password;
    List<BankAccount> accounts;
    public String getCpf() {
        return this.cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void addAccount(BankAccount account) {
        this.accounts.add(account);
    }

    public void removeAccount(BankAccount account) {
        this.accounts.remove(account);
    }

    public Client(String cpf, String name, String password) {
        this.cpf = cpf;
        this.name = name;
        this.password = password;
        accounts = new ArrayList<>();
    }
}
