# Formação Java Developer

<img align="left" height="320rem" alt="Badge Formação Java Developer" src="https://hermes.dio.me/tracks/da6041a9-80ef-409e-bd50-5e7be4dfadf6.png"/>

## 1️⃣ Simulando Uma Conta Bancária Através Do Terminal/Console
O projeto ContaBanco, implementado na classe ContaTerminal.java, visa receber dados via terminal, como número da conta, agência, nome do cliente e saldo. Os dados serão inseridos pelo usuário conforme solicitado pelo programa, utilizando a classe Scanner para captura. As variáveis devem ser declaradas conforme suas respectivas regras: número da conta (inteiro), agência (texto), nome do cliente (texto) e saldo (decimal). Após a inserção dos dados, o programa exibirá uma mensagem de agradecimento ao cliente, concatenando as informações inseridas. Por exemplo: "Olá [Nome Cliente], obrigado por criar uma conta em nosso banco, sua agência é [Agencia], conta [Numero] e seu saldo [Saldo] já está disponível para saque".

<br><br>

## O Que deve ser utilizado

+ Lógica de programação e POO;
+ Conhecimentos básicos em Java;
+ Computador com SO de sua preferência(Windows, Linux, Mac OS);
+ IDE (Visual Studio Code, Eclipse, etc);

## Objetivo

Vamos exercitar todo o conteúdo apresentado no módulo de Sintaxe codificando o seguinte cenário.

1. Crie o projeto ContaBanco que receberá dados via terminal contendo as características de conta em banco conforme atributos abaixo:
2. Dentro do projeto, crie a classe ContaTerminal.java para realizar toda a codificação do nosso programa.
>[!TIP]
> Revise sobre regras de declaração de variáveis

| Atributo       | Tipo    | Exemplo       |
| -------------  | ------- | ------------- |
| Numero         | Inteiro | 1021          |
| Agencia        | Texto   | 067-8         |
| Nome Cliente   | Texto   | MARIO ANDRADE |
| Saldo          | Decimal | 237.48        |

>[!TIP]
> Revise sobre terminal, main args e a classe Scanner

2. Permita que os dados sejam inseridos via terminal sendo que o usuário receberá a mensagem de qual informação será solicitada, exemplo:
   
  + Programa: "Por favor, digite o número da Agência !"
  + Usuário: 1021 (depois ENTER para o próximo campo)
    
> [!TIP]
> Revise sobre concatenação e classe String com método concat

3. Depois de todas as informações terem sido inseridas, o sistema deverá exibir a seguinte mensagem:
*"Olá [Nome Cliente], obrigado por criar uma conta em nosso banco, sua agência é [Agencia], conta [Numero] e seu saldo [Saldo] já está disponível para saque".*

Os campos em [ ] devem ser alterados pelas informações que forem inseridas pelos usuários.

## Projeto
```
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, digite o número da Conta:");
        int numero = scanner.nextInt();

        scanner.nextLine(); // Consumir a quebra de linha

        System.out.println("Por favor, digite o número da Agência:");
        String agencia = scanner.nextLine();

        System.out.println("Por favor, digite o nome do Cliente:");
        String nomeCliente = scanner.nextLine();

        System.out.println("Por favor, digite o saldo:");
        double saldo = scanner.nextDouble();

        String mensagem = "Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " 
                + agencia + ", conta " + numero + " e seu saldo " + saldo + " já está disponível para saque.";

        System.out.println(mensagem);

        scanner.close();
    }
}
```

### Extra - Interface
<img width="955" alt="image" src="https://github.com/OsmarBaia/dio-formacao-java-developer/assets/88497805/e8da753a-9186-4797-8b8b-604bcd682d62">
