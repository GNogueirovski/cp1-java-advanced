package advanced.br.com.fiap.entity;
import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FuncionarioSenior extends Funcionario {

    public FuncionarioSenior(){}

    public FuncionarioSenior(String nome, Integer horasTrabalhadas, Double valorHoraTrabalhada) {
        super(nome, horasTrabalhadas, valorHoraTrabalhada);
    }


    @Override
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

    @Override
    public void imprimirInformacao (){
        String mensagem = String.format("\n\nInformações do Funcionário Sênior\nID:%d\nNivel:Senior\nNOME:%s\nSALÁRIO: R$%.2f\nVALOR HORA: R$%.2f" +
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
