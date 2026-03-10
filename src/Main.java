import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Conta conta = new Conta();

        int contadorDeErro = 0;
        boolean usuarioLogado = false;
        String escolhaUsuario = "";

        System.out.println("Seja bem-vindo ao Banco Proveitoso! Crie sua conta a seguir.");
        System.out.print("Insira seu nome: ");
        String nome = scan.next();
        System.out.print("Insira seu CPF: ");
        String cpf = scan.next();
        System.out.print("Insira uma nova senha: ");
        String senha = scan.next();
        System.out.print("Deposite um valor inicial: ");
        double saldo = scan.nextDouble();


        conta.setNomeDoUsuario(nome);
        conta.setCpfDoUsuario(cpf);
        conta.setSenhaDoUsuario(senha);
        conta.setDepositoInicialDoUsuario(saldo);
        conta.calculoChequeEspecial();


        for (escolhaUsuario.equalsIgnoreCase(""); !escolhaUsuario.equalsIgnoreCase("não"); ){

            if (escolhaUsuario.equalsIgnoreCase("")) {
                System.out.print("""
                        ---##===============================##---
                           Você criou a sua conta com sucesso!
                                    Deseja continuar?
                        -------------[Sim]-----[Não]-------------
                        ---##===============================##---
                        """);
                escolhaUsuario = scan.next();

                if(escolhaUsuario.equalsIgnoreCase("sim")){
                    System.out.print("""
                            ---##===============================##---
                            --------------[Faça Log-in]--------------
                            ---##===============================##---
                            """);

                    System.out.print("Insira seu CPF: ");
                    // Atenção
                    cpf = scan.next();

                    while (!cpf.equalsIgnoreCase(conta.getCpfDoUsuario())){
                        System.out.println("Inválido! Tente novamente.");
                        contadorDeErro++;

                        System.out.print("Insira seu CPF corretamente: ");
                        cpf = scan.next();

                        if (contadorDeErro == 3){
                            System.out.println("Tente novamente mais tarde.");
                            break;
                        } else if (cpf.equalsIgnoreCase(conta.getCpfDoUsuario())) {
                            contadorDeErro = 0;
                        }
                    }

                    System.out.print("Insira sua senha: ");
                    // Atenção
                    senha = scan.next();

                    while (!senha.equalsIgnoreCase(conta.getSenhaDoUsuario())){
                        System.out.println("Inválido! Tente novamente.");
                        contadorDeErro++;

                        System.out.print("Insira sua senha corretamente: ");
                        senha = scan.next();

                        if (contadorDeErro == 3){
                            System.out.println("Tente novamente mais tarde.");
                            break;
                        } else if (senha.equalsIgnoreCase(conta.getSenhaDoUsuario())) {
                            contadorDeErro = 0;
                        }
                    }

                    if (cpf.equalsIgnoreCase(conta.getCpfDoUsuario()) && senha.equalsIgnoreCase(conta.getSenhaDoUsuario())){
                        System.out.println("""
                                ---##===============================##---
                                       Você fez Login com sucesso!
                                ---##===============================##--- 
                                """);

                        usuarioLogado = true;
                    } else if (contadorDeErro == 3){
                        break;
                    }
                }

                if (usuarioLogado) {
                    for (escolhaUsuario.equalsIgnoreCase("sim"); !escolhaUsuario.equalsIgnoreCase("não"); ) {
                        System.out.println("""
                                ---##===============================##---
                                + + + O que gostaria de fazer hoje? + + +
                                + + + ============================= + + +
                                +                                       +
                                + [1] Consultar saldo                   +
                                + [2] Consultar cheque especial         +
                                + [3] Fazer um depósito                 +
                                + [4] Fazer um saque                    +
                                + [5] Pagar um boleto                   +
                                + [6] Verificar uso do cheque especial  +
                                + [7] Sair                              +
                                +                                       +
                                + + + ============================= + + +
                                """);
                        int servicoEscolhido = scan.nextInt();

                        switch (servicoEscolhido) {
                            case 1:
                                System.out.println(conta.getSaldoDoUsuario());;
                                break;
                            case 2:
                                System.out.println(conta.getChequeEspecial());;
                                break;
                            case 3: conta.depositoUsuario();
                                break;
                            case 4: conta.saqueUsuario();
                                break;
                            case 5:
                                break;
                            case 6:
                                System.out.println(conta.isSituacaoChequeEspecial());;
                                break;
                            case 7:
                                System.out.println("""
                                        Você deseja continuar ?
                                        """);
                                escolhaUsuario = scan.next();
                                break;

                        }
                    }
                }

                if (escolhaUsuario.equalsIgnoreCase("não")){
                    System.out.print("""
                            Muito obrigado por usar nossos serviços.
                            Até a próxima!
                            """);
                    break;
                }
            }
        }

    }
}