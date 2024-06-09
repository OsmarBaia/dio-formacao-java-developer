import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountSelectionFrame extends JFrame {
    private JList<String> accountList;
    private JButton selectButton;
    private JButton goBackButton;


    public AccountSelectionFrame(Client client) {
        setTitle("Digital Innovation Bank - Seleção de Conta");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (BankAccount account : Bank.accounts) {
            if(account.getClient() == client){
                listModel.addElement(account.toString());
            }
        }

        accountList = new JList<>(listModel);
        accountList.setBounds(50, 30, 200, 100);
        add(accountList);

        selectButton = new JButton("Selecionar");
        selectButton.setBounds(150, 200, 100, 25);
        add(selectButton);

        goBackButton = new JButton("Sair");
        goBackButton.setBounds(25, 200, 100, 25);
        add(goBackButton);

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WelcomeFrame().setVisible(true);
                dispose();
            }
        });

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = accountList.getSelectedIndex();
                if (selectedIndex != -1) {
                    BankAccount selectedAccount = Bank.accounts.get(selectedIndex);
                    new AccountOperationsFrame(selectedAccount).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma conta!");
                }
            }
        });
    }
}
