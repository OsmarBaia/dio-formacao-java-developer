import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {
    private JTextField cpfField;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton registerButton;

    private JButton goBackButton;


    public RegisterFrame() {
        setTitle("Digital Innovation Bank - Cadastro");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel nameLabel = new JLabel("Nome:");
        nameLabel.setBounds(50, 30, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 30, 100, 25);
        add(nameField);

        JLabel cpfLabel = new JLabel("CPF:");
        cpfLabel.setBounds(50, 70, 100, 25);
        add(cpfLabel);

        cpfField = new JTextField();
        cpfField.setBounds(150, 70, 100, 25);
        add(cpfField);

        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(50, 110, 100, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 110, 100, 25);
        add(passwordField);

        registerButton = new JButton("Cadastrar");
        registerButton.setBounds(150, 200, 100, 25);
        add(registerButton);

        goBackButton = new JButton("Voltar");
        goBackButton.setBounds(25, 200, 100, 25);
        add(goBackButton);

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WelcomeFrame().setVisible(true);
                dispose();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String cpf = cpfField.getText();
                String password = new String(passwordField.getPassword());

                Client newClient = new Client(cpf, name, password);
                Bank.clients.add(newClient);
                Bank.accounts.add(new CheckingAccount(newClient));

                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");

                new LoginFrame().setVisible(true);
                dispose();
            }
        });
    }
}
