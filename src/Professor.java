import java.util.Date;

public class Professor {

    private int id;
    private String nome;
    private String estado;
    private String cidade;
    private String estado_civil;
    private Date data_nascimento;
    private double salario;
    private boolean ativo;
    private String especialidade;

    private java.sql.Timestamp data_cadastro;
    private java.sql.Timestamp data_atualizacao;
    private java.sql.Timestamp data_remocao;

    public Professor(String nome, String estado, String cidade, String estado_civil, Date data_nascimento, double salario){
        this.nome = nome;
        this.cidade = estado;
        this.estado = estado;
        this.estado_civil = estado_civil;
        this.data_nascimento = data_nascimento;
        this.salario = salario;
        this.ativo = ativo;


    }
}
