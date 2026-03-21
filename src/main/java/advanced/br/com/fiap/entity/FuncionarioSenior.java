package advanced.br.com.fiap.entity;
import javax.persistence.*;

@Entity
public class FuncionarioSenior extends Funcionario {

    public FuncionarioSenior(){}

    public FuncionarioSenior(String nome, int horasTrabalhadas, double valorHoraTrabalhada) {
        super(nome, horasTrabalhadas, valorHoraTrabalhada);
    }

    @Override
    public void imprimirInformacao (){
        String mensagem = String.format("\n\nInformações do Funcionário Sênior\nNivel: Senior\nID:%d\nNOME:%s\nSALÁRIO: R$%.2f\nVALOR HORA: R$%.2f" +
                "\nHORAS TRABALHADAS: %d", getId(), getNome(), calcularSalario(),getValorHoraTrabalhada(), getHorasTrabalhadas());
        System.out.println(mensagem);
    }

    @Override
    public Double calcularSalario() {
        // A cada 15h o Func. Senior recebe um Bônus
        int bonusHoras = getHorasTrabalhadas() / 15;
        // A cada 15h o Sênior recebe um Bonus de 5%
        double bonus = (5 * bonusHoras) / 100.0;
        return getValorHoraTrabalhada() * (getHorasTrabalhadas() * bonus);
    }
}
