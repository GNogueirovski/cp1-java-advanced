package advanced.br.com.fiap.entity;


import advanced.br.com.fiap.annotations.Descricao;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_FUNCIONARIO")
@Descricao(descricao = "Tabela com informações básicas de um funcionário")
@SequenceGenerator(name = "funcionario", sequenceName = "SQ_TB_FUNCIONARIO", allocationSize = 1)
public class Funcionario {
    @Id
    @Column(name="id_funcionario")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario")
    private Integer id;
    @Column(name="nm_funcionario", nullable = false, length = 100)
    private String nome;
    @Column(name="hr_trabalhada", length = 60)
    private Integer horasTrabalhadas;
    @Column(name="vl_hora_trabalhada", precision = 10, scale = 2)
    private Double valorHoraTrabalhada;


    public Funcionario (){}

    public Funcionario(String nome, int horasTrabalhadas, double valorHoraTrabalhada) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHoraTrabalhada = valorHoraTrabalhada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorHoraTrabalhada() {
        return valorHoraTrabalhada;
    }

    public void setValorHoraTrabalhada(double valorHoraTrabalhada) {
        this.valorHoraTrabalhada = valorHoraTrabalhada;
    }


    public void exibirSQL(Funcionario funcionario, String operacao) {
        Table table = funcionario.getClass().getSuperclass().getAnnotation(Table.class);
        Field[] fields = funcionario.getClass().getSuperclass().getDeclaredFields();

        List<String> nomeColunas = new ArrayList<>();
        for (Field field : fields) {
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
                System.out.printf("INSERT INTO %s (%s)  VALUES ('%s','%s', '%s', '%.2f')",
                        table.name(), colunas,
                        funcionario.getId(),
                        funcionario.getNome(),
                        funcionario.getHorasTrabalhadas(),
                        funcionario.getValorHoraTrabalhada());
                break;
            case "UPDATE":
                System.out.printf("UPDATE %s SET (%s) = ('%s','%s','%s','%s') WHERE id_funcionario = %d",
                        table.name(), colunas,
                        funcionario.getId(),
                        funcionario.getNome(),
                        funcionario.getHorasTrabalhadas(),
                        funcionario.getValorHoraTrabalhada(),
                        funcionario.getId());
                break;
            case "DELETE":
                System.out.printf("DELETE FROM %s WHERE id_funcionario = %d", table.name(), funcionario.getId());
                break;
        }
    }

    public void imprimirInformacao (){
        String mensagem = String.format("\n\nInformações do Funcionário\nNivel: Base\nID:%d\nNOME:%s\nSALÁRIO: R$%.2f\nVALOR HORA: R$%.2f" +
                "\nHORAS TRABALHADAS: %d", getId(), getNome(), calcularSalario(),getValorHoraTrabalhada(), getHorasTrabalhadas());
        System.out.println(mensagem);
    }

    public Double calcularSalario(){
        return this.getValorHoraTrabalhada() * this.getHorasTrabalhadas();
    }
}
