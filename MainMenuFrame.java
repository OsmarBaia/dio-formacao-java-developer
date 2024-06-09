import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuFrame extends JFrame {
    private JButton viewAccountsButton;
    private JButton logoutButton;

    public MainMenuFrame(Client client) {
        setTitle("Digital Innovation Bank - Menu Principal");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        viewAccountsButton = new JButton("Ver Contas");
        viewAccountsButton.setBounds(80, 50, 140, 25);
        add(viewAccountsButton);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(80, 100, 140, 25);
        add(logoutButton);

        viewAccountsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AccountSelectionFrame(client).setVisible(true);
                dispose();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WelcomeFrame().setVisible(true);
                dispose();
            }
        });
    }
}
