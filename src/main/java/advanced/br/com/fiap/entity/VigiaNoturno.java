package advanced.br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class VigiaNoturno extends Funcionario {

    @Column(name = "adicional_noturno", precision = 10, scale = 2)
    private Double adicionalNoturno;

    public VigiaNoturno(){}

    public VigiaNoturno(String nome, int horasTrabalhadas, double valorHoraTrabalhada, double adicionalNoturno) {
        super(nome, horasTrabalhadas, valorHoraTrabalhada);
        this.adicionalNoturno = adicionalNoturno;
    }

    @Override
    public void imprimirInformacao (){
        String mensagem = String.format("\n\nInformações do Vigia Noturno\nNIVEL: Vigia Noturno\nID:%d\nNOME:%s\nSALÁRIO: R$%.2f\nVALOR HORA: R$%.2f" +
                "\nHORAS TRABALHADAS: %d", getId(), getNome(), calcularSalario(),getValorHoraTrabalhada(), getHorasTrabalhadas());
        System.out.println(mensagem);
    }

    @Override
    public Double calcularSalario() {
        int diasTrabalhados = getHorasTrabalhadas() / 8;
        // Adicional noturno é uma porcentegem somada o que vai ganhar de acordo com bonus dias Trabalhado
        // Adicional Noturno: 12.5%
        // Dias Trabalhasdos: 10
        // Total: 22.5 % de bônus.
        double adicional = (adicionalNoturno + diasTrabalhados) / 100.0;
        return getValorHoraTrabalhada() * (getHorasTrabalhadas() * adicional);
    }
}
