import java.util.Scanner;

public class Conta {
    private String nomeDoUsuario;
    private String cpfDoUsuario;
    private String senhaDoUsuario;

    private double depositoInicialDoUsuario;
    private double saldoDoUsuario;
    private double chequeEspecial;
    private double limiteChequeEspecial;

    private boolean situacaoChequeEspecial = false;


    public String getNomeDoUsuario() {
        return nomeDoUsuario;
    }

    public void setNomeDoUsuario(String nomeDoUsuario) {
        this.nomeDoUsuario = nomeDoUsuario;
    }

    public String getCpfDoUsuario() {
        return cpfDoUsuario;
    }

    public void setCpfDoUsuario(String cpfDoUsuario) {
        this.cpfDoUsuario = cpfDoUsuario;
    }

    public String getSenhaDoUsuario() {
        return senhaDoUsuario;
    }

    public void setSenhaDoUsuario(String senhaDoUsuario) {
        this.senhaDoUsuario = senhaDoUsuario;
    }

    public double getDepositoInicialDoUsuario() {
        return depositoInicialDoUsuario;
    }

    public void setDepositoInicialDoUsuario(double depositoInicialDoUsuario) {
        this.depositoInicialDoUsuario = depositoInicialDoUsuario;
    }

    public void calculoChequeEspecial(){
        if (getDepositoInicialDoUsuario() <= 500){
            this.chequeEspecial = 50;
            this.limiteChequeEspecial = this.chequeEspecial;
        } else {
            this.chequeEspecial = getDepositoInicialDoUsuario() / 2;
            this.limiteChequeEspecial = this.chequeEspecial;
        }
        this.saldoDoUsuario += getDepositoInicialDoUsuario();
    }


    public double getSaldoDoUsuario() {
        return saldoDoUsuario;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public boolean isSituacaoChequeEspecial() {
        return situacaoChequeEspecial;
    }

    void depositoUsuario(){
        Scanner scan = new Scanner(System.in);
        double valorDeDeposito = scan.nextDouble();

        if ((valorDeDeposito < this.limiteChequeEspecial && this.chequeEspecial < this.limiteChequeEspecial) && situacaoChequeEspecial){
            System.out.println("""
                    ===+++!Atenção!+++===
                    O seu cheque especial ainda está em uso!
                    Por favor, consulte a situação do cheque especial.
                    """);
            this.chequeEspecial += valorDeDeposito;

        } else if ((valorDeDeposito >= this.chequeEspecial) && situacaoChequeEspecial){

            

            this.saldoDoUsuario += (valorDeDeposito - this.chequeEspecial);
            this.chequeEspecial = this.limiteChequeEspecial;


            System.out.println("""
                    ===+++!Atenção!+++===
                      Você cobriu o cheque especial!
                    Por favor, consulte a situação do cheque especial.
                    Caso o depósito tenha sido de um valor que tenha
                    ultrapassado o cheque especial o restante
                    do saldo estará em sua conta!
                    """);

            this.situacaoChequeEspecial = false;
        }
    }

    void saqueUsuario(){
        Scanner scan = new Scanner(System.in);
        double valorDeSaque = scan.nextDouble();



        if(!(valorDeSaque > this.saldoDoUsuario && situacaoChequeEspecial) && !(valorDeSaque > (this.saldoDoUsuario + this.chequeEspecial))){
            this.saldoDoUsuario -= valorDeSaque;
            System.out.println("Você fez um saque no valor de: R$ " + valorDeSaque);
        }

        if (this.saldoDoUsuario <= 0 && !situacaoChequeEspecial) {
            this.saldoDoUsuario += this.chequeEspecial;
            this.chequeEspecial = 0;
            System.out.print("""
                    ===+++!Atenção!+++===
                    Seu saldo foi ZERADO.
                    Por favor, consulte a situação do cheque especial.
                    """);
            this.situacaoChequeEspecial = true;

        } else if (this.saldoDoUsuario == 0 && this.chequeEspecial == 0 && situacaoChequeEspecial) {
            System.out.print("""
                    ===+++!Atenção!+++===
                    Você não possui saldo e o seu limite do cheque
                    especial foi usado completamente.
                    Por favor, consulte a situação do cheque especial
                    """);

        } else if ((valorDeSaque >= this.saldoDoUsuario && situacaoChequeEspecial) || (valorDeSaque > (this.saldoDoUsuario + this.chequeEspecial))) {
            System.out.print("""
                    Você não pode fazer este saque.
                    """);
        }
    }
}