import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountOperationsFrame extends JFrame {
    private BankAccount account;
    private JLabel balanceLabel;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton transferButton;
    private JButton backButton;

    public AccountOperationsFrame(BankAccount account) {
        this.account = account;
        setTitle("Digital Innovation Bank - Operações");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        balanceLabel = new JLabel("Saldo: " + account.getBalance());
        balanceLabel.setBounds(100, 30, 200, 25);
        add(balanceLabel);

        depositButton = new JButton("Depositar");
        depositButton.setBounds(80, 70, 140, 25);
        add(depositButton);

        withdrawButton = new JButton("Sacar");
        withdrawButton.setBounds(80, 110, 140, 25);
        add(withdrawButton);

        transferButton = new JButton("Transferir");
        transferButton.setBounds(80, 150, 140, 25);
        add(transferButton);

        backButton = new JButton("Sair");
        backButton.setBounds(80, 190, 140, 25);
        add(backButton);

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valueStr = JOptionPane.showInputDialog("Digite o valor para depositar:");
                float value = Float.parseFloat(valueStr);
                account.deposit(value);
                balanceLabel.setText("Saldo: " + account.getBalance());
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valueStr = JOptionPane.showInputDialog("Digite o valor para sacar:");
                float value = Float.parseFloat(valueStr);
                account.withdraw(value);
                balanceLabel.setText("Saldo: " + account.getBalance());
            }
        });

        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valueStr = JOptionPane.showInputDialog("Digite o valor há transferir:");
                float value = Float.parseFloat(valueStr);

                String destBankIDStr = JOptionPane.showInputDialog("Digite o código da agencia:");
                int destBankID = Integer.parseInt(destBankIDStr);

                String destAccountIDStr = JOptionPane.showInputDialog("Digite o numero da conta:");
                int destAccountID = Integer.parseInt(destAccountIDStr);

                BankAccount destAccount = null;
                for(BankAccount acc: Bank.accounts){
                    if(acc.getBankID() == destBankID && acc.getAccountID() == destAccountID){
                        destAccount = acc;
                        break;
                    }
                }

                if (destAccount != null) {
                    account.transfer(destAccount, value);
                    balanceLabel.setText("Saldo: " + account.getBalance());
                } else {
                    JOptionPane.showMessageDialog(null, "Conta destino não encontrada!");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WelcomeFrame().setVisible(true);
                dispose();
            }
        });
    }
}
