package advanced.br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Entity
public class VigiaNoturno extends Funcionario {

    @Column(name = "adicional_noturno", precision = 10, scale = 2)
    private Double adicionalNoturno;

    public VigiaNoturno(){}

    public VigiaNoturno(String nome, Integer horasTrabalhadas, Double valorHoraTrabalhada, Double adicionalNoturno) {
        super(nome, horasTrabalhadas, valorHoraTrabalhada);
        this.adicionalNoturno = adicionalNoturno;
    }

    public Double getAdicionalNoturno() {
        return adicionalNoturno;
    }

    public void setAdicionalNoturno(Double adicionalNoturno) {
        this.adicionalNoturno = adicionalNoturno;
    }

    @Override
    public void exibirSQL(Funcionario funcionario, String operacao) {
        VigiaNoturno vigia = (VigiaNoturno) funcionario;

        Table table = vigia.getClass().getSuperclass().getAnnotation(Table.class);
        Field[] fieldsFuncionario = vigia.getClass().getSuperclass().getDeclaredFields();
        Field[] fieldsVigia = vigia.getClass().getDeclaredFields();

        List<String> nomeColunas = new ArrayList<>();

        for (Field field : fieldsFuncionario) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                nomeColunas.add(column.name());
            }
        }

        for (Field field : fieldsVigia) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                nomeColunas.add(column.name());
            }
        }

        String colunas = String.join(", ", nomeColunas);

        switch (operacao.toUpperCase()) {
            case "SELECT":
                System.out.printf("SELECT * FROM %s",table.name());
                break;
            case "INSERT":
                System.out.printf("INSERT INTO %s (%s)  VALUES ('%s','%s', '%s', '%.2f', '%.2f')",
                        table.name(), colunas,
                        vigia.getId(),
                        vigia.getNome(),
                        vigia.getHorasTrabalhadas(),
                        vigia.getValorHoraTrabalhada(),
                        vigia.getAdicionalNoturno());
                break;
            case "UPDATE":
                System.out.printf("UPDATE %s SET (%s) = ('%s','%s','%s','%.2f','%.2f') WHERE id_funcionario = %d",
                        table.name(), colunas,
                        vigia.getId(),
                        vigia.getNome(),
                        vigia.getHorasTrabalhadas(),
                        vigia.getValorHoraTrabalhada(),
                        vigia.getAdicionalNoturno(),
                        vigia.getId());
                break;
            case "DELETE":
                System.out.printf("DELETE FROM %s WHERE id_funcionario = %d", table.name(), vigia.getId());
                break;
        }
    }

    @Override
    public void imprimirInformacao (){
        String mensagem = String.format("\n\nInformações do Vigia Noturno\nID:%d\nNivel:Vigia Noturno\nNOME:%s\nSALÁRIO: R$%.2f\nVALOR HORA: R$%.2f" +
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
