import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField cpfField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private JButton goBackButton;

    public LoginFrame() {
        setTitle("Digital Innovation Bank - Login");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel cpfLabel = new JLabel("CPF:");
        cpfLabel.setBounds(50, 30, 100, 25);
        add(cpfLabel);

        cpfField = new JTextField();
        cpfField.setBounds(150, 30, 100, 25);
        add(cpfField);

        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(50, 70, 100, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 100, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 200, 100, 25);
        add(loginButton);

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

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                String password = new String(passwordField.getPassword());
                // Verificar login
                verifyLogin(cpf, password);
            }
        });
    }

    private void verifyLogin(String cpf, String password) {
        Client client = null;
        for (Client c : Bank.clients) {
            if (c.getCpf().equals(cpf) && c.getPassword().equals(password)) {
                client = c;
                break;
            }
        }

        if(client == null){
            JOptionPane.showMessageDialog(null, "CPF ou Senha incorretos!");
        }
        else{
            new MainMenuFrame(client).setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        new LoginFrame().setVisible(true);
    }
}
