package advanced.br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class VigiaNoturno extends Funcionario {

    @Column(name = "adicional_noturno", precision = 10, scale = 2)
    private double adicionalNoturno;

    public VigiaNoturno(){}

    public VigiaNoturno(String nome, int horasTrabalhadas, double valorHoraTrabalhada, double adicionalNoturno) {
        super(nome, horasTrabalhadas, valorHoraTrabalhada);
        this.adicionalNoturno = adicionalNoturno;
    }

    public void imprimirInformacao (){
        String mensagem = String.format("\n\nInformações do Vigia Noturno\n%sNivel: Senior\nID:%d\nNOME:%s\nSALÁRIO: R$%.2f\nVALOR HORA: R$%.2f" +
                "\nHORAS Trabalhadas: %d", getId(), getNome(), calcularSalario(),getValorHoraTrabalhada(), getHorasTrabalhadas());
        System.out.println(mensagem);
    }

    public Double calcularSalario() {
        int diasTrabalhados = getHorasTrabalhadas() / 8;
        adicionalNoturno = 1.5 + diasTrabalhados / 100.0;
        return getValorHoraTrabalhada() * (getHorasTrabalhadas() * adicionalNoturno);
    }
}
