package advanced.br.com.fiap.entity;
import javax.persistence.*;

@Entity
public class FuncionarioSenior extends Funcionario {

    public FuncionarioSenior(){}

    public FuncionarioSenior(String nome, int horasTrabalhadas, double valorHoraTrabalhada) {
        super(nome, horasTrabalhadas, valorHoraTrabalhada);
    }

    public void imprimirInformacao (){
        String mensagem = String.format("\n\nInformações do Funcionário\n%sNivel: Senior\nID:%d\nNOME:%s\nSALÁRIO: R$%.2f\nVALOR HORA: R$%.2f" +
                "\nHORAS Trabalhadas: %d", this.getId(), this.getNome(), this.calcularSalario(),this.getValorHoraTrabalhada(), this.getHorasTrabalhadas());
        System.out.println(mensagem);
    }

    public Double calcularSalario() {
        int bonusHoras = getHorasTrabalhadas() / 15;
        double bonus = 3.0 + bonusHoras / 100.0;
        return getValorHoraTrabalhada() * (getHorasTrabalhadas() * bonus);
    }
}
