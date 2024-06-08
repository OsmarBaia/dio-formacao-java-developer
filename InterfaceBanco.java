import javax.swing.*;
import java.awt.event.*;

public class InterfaceBanco extends JFrame implements ActionListener {
    private JTextField campoNumeroConta, campoAgencia, campoNomeCliente, campoSaldo;
    private JTextArea campoSaida;
    private JButton botaoEnviar, botaoCancelar;

    public InterfaceBanco() {
        setTitle("Banco");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


        JLabel labelNumeroConta = new JLabel("Número da Conta:");
        labelNumeroConta.setBounds(20, 20, 120, 20);
        add(labelNumeroConta);

        campoNumeroConta = new JTextField();
        campoNumeroConta.setBounds(150, 20, 200, 20);
        add(campoNumeroConta);

        JLabel labelAgencia = new JLabel("Agência:");
        labelAgencia.setBounds(20, 50, 120, 20);
        add(labelAgencia);

        campoAgencia = new JTextField();
        campoAgencia.setBounds(150, 50, 200, 20);
        add(campoAgencia);

        JLabel labelNomeCliente = new JLabel("Nome do Cliente:");
        labelNomeCliente.setBounds(20, 80, 120, 20);
        add(labelNomeCliente);

        campoNomeCliente = new JTextField();
        campoNomeCliente.setBounds(150, 80, 200, 20);
        add(campoNomeCliente);

        JLabel labelSaldo = new JLabel("Saldo:");
        labelSaldo.setBounds(20, 110, 120, 20);
        add(labelSaldo);

        campoSaldo = new JTextField();
        campoSaldo.setBounds(150, 110, 200, 20);
        add(campoSaldo);

        campoSaida = new JTextArea();
        campoSaida.setBounds(20, 140, 330, 80);
        campoSaida.setEditable(false);
        campoSaida.setLineWrap(true);
        campoSaida.setWrapStyleWord(true);
        add(campoSaida);

        botaoEnviar = new JButton("Enviar");
        botaoEnviar.setBounds(100, 240, 100, 30);
        botaoEnviar.addActionListener(this);
        add(botaoEnviar);

        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBounds(220, 240, 100, 30);
        botaoCancelar.addActionListener(this);
        add(botaoCancelar);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoEnviar) {
            int numeroConta = Integer.parseInt(campoNumeroConta.getText());
            String agencia = campoAgencia.getText();
            String nomeCliente = campoNomeCliente.getText();
            double saldo = Double.parseDouble(campoSaldo.getText());

            String mensagem = "Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é "
                    + agencia + ", conta " + numeroConta + " e seu saldo " + saldo + " já está disponível para saque.";

            campoSaida.setText(mensagem);
        } else if (e.getSource() == botaoCancelar) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        InterfaceBanco interfaceBanco = new InterfaceBanco();
        interfaceBanco.setVisible(true);
    }
}