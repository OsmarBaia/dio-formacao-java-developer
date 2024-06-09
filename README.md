# Formação Java Developer

<img align="left" height="320rem" alt="Badge Formação Java Developer" src="https://hermes.dio.me/tracks/da6041a9-80ef-409e-bd50-5e7be4dfadf6.png"/>

## :two: Criando Um Pequeno Sistema Para Validação de Processo Seletivo
O projeto DesafioControleFluxo deve receber dois números inteiros via terminal e imprimir uma série de números incrementados a partir do menor número até o maior. Se o primeiro número for maior que o segundo, o sistema deve lançar uma exceção customizada chamada ParametrosInvalidosException com a mensagem "O segundo parâmetro deve ser maior que o primeiro". A classe principal Contador.java gerencia a entrada de dados e chama o método contar, que realiza a lógica de contagem e impressão. A classe ParametrosInvalidosException representa a exceção de negócio.

<br><br>

## O Que deve ser utilizado

+ Lógica de programação e POO;
+ Conhecimentos básicos em Java;
+ Computador com SO de sua preferência(Windows, Linux, Mac OS);
+ IDE (Visual Studio Code, Eclipse, etc);

## Objetivo

Vamos exercitar todo o conteúdo apresentado no módulo de Controle de Fluxo codificando o seguinte cenário.

O sistema deverá receber dois parâmetros via terminal que representarão dois números inteiros, com estes dois números você deverá obter a quantidade de interações (for) e realizar a impressão no console (System.out.print) dos números incrementados, exemplo:

* Se você passar os números 12 e 30, logo teremos uma interação (for) com 18 ocorrências para imprimir os números, exemplo: `"Imprimindo o número 1"`, `"Imprimindo o número 2"` e assim por diante.
* Se o primeiro parâmetro for MAIOR que o segundo parâmetro, você deverá lançar a exceção customizada chamada de `ParametrosInvalidosException` com a segunda mensagem: `"O segundo parâmetro deve ser maior que o primeiro"`

1. Crie o projeto DesafioControleFluxo
2. Dentro do projeto, crie a classe Contador.java para realizar toda a codificação do nosso programa.
3. Dentro do projeto, crie a classe ParametrosInvalidosException que representará a exceção de negócio no sistema.

Abaixo temos um trecho de código no qual você poderá seguir alterando as partes que contenham `??`

```
public class Contador {
	public static void main(String[] args) {
		Scanner terminal = new Scanner(System.in);
		System.out.println("Digite o primeiro parâmetro");
		int parametroUm = terminal.??;
		System.out.println("Digite o segundo parâmetro");
		int parametroDois = terminal.??;
		
		try {
			//chamando o método contendo a lógica de contagem
			contar(parametroUm, parametroDois);
		
		}catch (? exception) {
			//imprimir a mensagem: O segundo parâmetro deve ser maior que o primeiro
		}
		
	}
	static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
		//validar se parametroUm é MAIOR que parametroDois e lançar a exceção
		
		int contagem = parametroDois - parametroUm;
		//realizar o for para imprimir os números com base na variável contagem
	}
}
```

## Projeto
```
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.println("Digite o primeiro parâmetro");
        int parametroUm = terminal.nextInt();
        System.out.println("Digite o segundo parâmetro");
        int parametroDois = terminal.nextInt();

        try {
            // Chamando o método contendo a lógica de contagem
            contar(parametroUm, parametroDois);
        } catch (ParametrosInvalidosException exception) {
            // Imprimir a mensagem: O segundo parâmetro deve ser maior que o primeiro
            System.out.println(exception.getMessage());
        }
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        // Validar se parametroUm é MAIOR que parametroDois e lançar a exceção
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        int contagem = parametroDois - parametroUm;
        // Realizar o for para imprimir os números com base na variável contagem
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}

class ParametrosInvalidosException extends Exception {
    public ParametrosInvalidosException(String message) {
        super(message);
    }
}
```

### Extra - Interface
<img width="950" alt="image" src="https://github.com/OsmarBaia/dio-formacao-java-developer/assets/88497805/597ace56-1ab5-465d-af0f-1e234fe85bf2">
<img width="953" alt="image" src="https://github.com/OsmarBaia/dio-formacao-java-developer/assets/88497805/80346ce4-8976-4ad3-89b3-b0295bc9a98a">




