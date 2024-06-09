# Formação Java Developer

<img align="left" height="320rem" alt="Badge Formação Java Developer" src="https://hermes.dio.me/tracks/da6041a9-80ef-409e-bd50-5e7be4dfadf6.png"/>

## 4️⃣ Criando um Banco Digital com Java e Orientação a Objetos

<br><br><br>

## O Que deve ser utilizado

+ POO

## Objetivo

Desafio: Considerando nosso conhecimento no domínio bancário, iremos abstrair uma solução Orientada a Objetos em Java. Para isso, vamos interpretar o seguinte cenário: “Um banco oferece aos seus clientes dois tipos de contas (corrente e poupança), as quais possuem as funcionalidades de depósito, saque e transferência (entre contas da própria instituição).”

Abstração
Habilidade de concentrar-se nos aspectos essenciais de um domínio, ignorando características menos importantes ou acidentais. Nesse contexto, objetos são abstrações de entidades existentes no domínio em questão.

Encapsulamento
Encapsular significa esconder a implementação dos objetos, criando assim interfaces de uso mais concisas e fáceis de usar/entender. O encapsulamento favorece principalmente dois aspectos de um sistema: a manutenção e a evolução.

Herança
Permite que você defina uma classe filha que reutiliza (herda), estende ou modifica o comportamento de uma classe pai. A classe cujos membros são herdados é chamada de classe base. A classe que herda os membros da classe base é chamada de classe derivada.

Polimorfismo
Capacidade de um objeto poder ser referenciado de várias formas, ou seja, é capacidade de tratar objetos criados a partir das classes específicas como objetos de uma classe genérica. Cuidado, polimorfismo não quer dizer que o objeto fica se transformando, muito pelo contrário, um objeto nasce de um tipo e morre daquele tipo, o que pode mudar é a maneira como nos referimos a ele.

## Projeto

### Diagramação UML

#### Core

```mermaid
classDiagram
    Client --> BankAccount : owns
    BankAccount <|-- CheckingAccount
    BankAccount <|-- SavingsAccount
    BankAccount --> IAccount : implements
    Bank o-- Client
    Bank o-- BankAccount

    class Client {
        - String cpf
        - String name
        - String password
        - List BankAccount accounts
        + String getCpf()
        + String getName()
        + void setName(String name)
        + String getPassword()
        + void setPassword(String password)
        + List~BankAccount~ getAccounts()
        + void addAccount(BankAccount account)
        + void removeAccount(BankAccount account)
    }

    class BankAccount {
        <<Abstract>>
        - static int sequentialID
        - static final int defaultAgency
        - int bankID
        - int accountID
        - Client client
        - float balance
        + void deposit(float value)
        + void withdraw(float value)
        + void transfer(IAccount destAccount, float value)
        + void statement()
        + void AccountData()
    }

    class CheckingAccount {
        + void statement()
    }

    class SavingsAccount {
        - float returnValue
        + void statement()
        + float getReturnValue()
        + void setReturnValue(int monthsAmount, float adjustment)
    }

    class IAccount {
        <<Interface>>
        + void deposit(float value)
        + void withdraw(float value)
        + void transfer(IAccount destAccount, float value)
        + void statement()
    }

    class Bank {
        - static List Client  clients
        - static List BankAccount accounts
        - static Scanner sc
        + void main(String[] args)
        + void CreateFakeData()
        + void StartMenu()
        + void LoginMenu()
        + void ClientMenu(Client client)
        + void AccountMenu(IAccount account)
        + void AccountOperations(IAccount account, String selectedOption)
        + BankAccount SearchForAccount(int bankAgency, int accountNumber)
        + void CreateClient()
    }
```

#### UI
```mermaid
classDiagram
class WelcomeFrame {
        - loginButton: JButton
        - registerButton: JButton
        - closeButton: JButton
        --
        + WelcomeFrame()
    }

    class RegisterFrame {
        - cpfField: JTextField
        - nameField: JTextField
        - passwordField: JPasswordField
        - registerButton: JButton
        - goBackButton: JButton
        --
        + RegisterFrame()
        - registerClient(name: String, cpf: String, password: String): void
    }

    class LoginFrame {
        - cpfField: JTextField
        - passwordField: JPasswordField
        - loginButton: JButton
        - goBackButton: JButton
        --
        + LoginFrame()
        - verifyLogin(cpf: String, password: String): void
    }


    class AccountSelectionFrame {
        - accountList: JList<String>
        - selectButton: JButton
        - goBackButton: JButton
        --
        + AccountSelectionFrame(client: Client)
    }

    class MainMenuFrame {
        - viewAccountsButton: JButton
        - logoutButton: JButton
        --
        + MainMenuFrame(client: Client)
    }

    class AccountOperationsFrame {
        - account: BankAccount
        - balanceLabel: JLabel
        - depositButton: JButton
        - withdrawButton: JButton
        - transferButton: JButton
        - backButton: JButton
        --
        + AccountOperationsFrame(account: BankAccount)
    }
```


### Implementação

BankAccount.java
```
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

```

SavingAccount.java
```
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
```

CheckingAccount.java
```
public class CheckingAccount extends BankAccount {
    public CheckingAccount(Client client) {
        super(client);
    }

    @Override
    public void statement() {
        System.out.println("=== Extrato Conta Corrente ===");
        this.AccountData();
    }
}

```

IAccount.java
```
public interface IAccount {
    void deposit(float value);
    void withdraw(float value);
    void transfer(IAccount destAccount, float value);
    void statement();
}
```

### Extra - Interface

#### Wellcome Screen

<img width="251" alt="image" src="https://github.com/OsmarBaia/dio-formacao-java-developer/assets/88497805/181fb457-b773-4b17-a634-a1b7b468c830">

#### Cadastro de Cliente

<img width="219" alt="image" src="https://github.com/OsmarBaia/dio-formacao-java-developer/assets/88497805/02053193-d528-4e26-b484-872d3ac35d16">

#### Login

<img width="241" alt="image" src="https://github.com/OsmarBaia/dio-formacao-java-developer/assets/88497805/53cd8e4f-0e61-45b5-9003-183956720ed7">

#### Menu de Usuário

<img width="235" alt="image" src="https://github.com/OsmarBaia/dio-formacao-java-developer/assets/88497805/07ea45f5-bc82-40b1-9385-f64bc3d98182">

#### Seleção de Conta

<img width="224" alt="image" src="https://github.com/OsmarBaia/dio-formacao-java-developer/assets/88497805/c66ec050-f6d1-4670-bbfd-360c9765149a">

#### Menu de operações financeiras

<img width="230" alt="image" src="https://github.com/OsmarBaia/dio-formacao-java-developer/assets/88497805/8c19ae18-289e-43a3-ba4c-fcb8a4c35622">



