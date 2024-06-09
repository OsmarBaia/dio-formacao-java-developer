import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContadorGUI {
    public static void main(String[] args) {
        // Criação do frame principal
        JFrame frame = new JFrame("Contador");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criação dos componentes
        JPanel panel = new JPanel();
        JLabel label1 = new JLabel("Digite o primeiro parâmetro:");
        JTextField textField1 = new JTextField(10);
        JLabel label2 = new JLabel("Digite o segundo parâmetro:");
        JTextField textField2 = new JTextField(10);
        JButton button = new JButton("Contar");
        JTextArea textArea = new JTextArea(5, 20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Adição dos componentes ao painel
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(button);
        panel.add(scrollPane);

        // Adição do painel ao frame
        frame.add(panel);
        frame.setVisible(true);

        // Ação do botão
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int parametroUm = Integer.parseInt(textField1.getText());
                    int parametroDois = Integer.parseInt(textField2.getText());
                    textArea.setText(""); // Limpa a área de texto antes de exibir a contagem
                    contar(parametroUm, parametroDois, textArea);
                } catch (ParametrosInvalidosException exception) {
                    JOptionPane.showMessageDialog(frame, exception.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    static void contar(int parametroUm, int parametroDois, JTextArea textArea) throws ParametrosInvalidosException {
        // Validar se parametroUm é MAIOR que parametroDois e lançar a exceção
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        int contagem = parametroDois - parametroUm;
        // Realizar o for para imprimir os números com base na variável contagem
        for (int i = 1; i <= contagem; i++) {
            textArea.append("Imprimindo o número " + i + "\n");
        }
    }
}

class ParametrosInvalidosException extends Exception {
    public ParametrosInvalidosException(String message) {
        super(message);
    }
}
