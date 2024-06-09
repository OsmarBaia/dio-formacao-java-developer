import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeFrame extends JFrame {
    private JButton loginButton;
    private JButton registerButton;
    private JButton closeButton;

    public WelcomeFrame() {
        setTitle("Digital Innovation Bank");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        loginButton = new JButton("Fazer Login");
        loginButton.setBounds(80, 50, 140, 25);
        add(loginButton);

        registerButton = new JButton("Cadastrar");
        registerButton.setBounds(80, 100, 140, 25);
        add(registerButton);

        closeButton = new JButton("Fechar");
        closeButton.setBounds(80, 150, 140, 25);
        add(closeButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame().setVisible(true);
                dispose();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterFrame().setVisible(true);
                dispose();
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new WelcomeFrame().setVisible(true);
    }
}
