import java.sql.Timestamp;
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

    public Professor(String nome, String estado, String cidade, String estado_civil, Date data_nascimento, double salario, boolean ativo, String especialidade){
        this.nome = nome;
        this.cidade = estado;
        this.estado = estado;
        this.estado_civil = estado_civil;
        this.data_nascimento = data_nascimento;
        this.salario = salario;
        this.ativo = ativo;
        this.especialidade = especialidade;

    }

    public Professor( int id, String nome, String estado, String cidade, String estado_civil, Date data_nascimento, double salario, boolean ativo, String especialidade ) {

        this.id = id;
        this.nome = nome;
        this.cidade = estado;
        this.estado = estado;
        this.estado_civil = estado_civil;
        this.data_nascimento = data_nascimento;
        this.salario = salario;
        this.ativo = ativo;
        this.especialidade = especialidade;
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getEstado(){
        return estado;
    }

    public String getCidade(){
        return cidade;
    }

    public String getEstado_civil(){
        return estado_civil;
    }

    public String getEspecialidade(){
        return especialidade;
    }

    public boolean getAtivo(){
        return ativo;
    }

    public double getSalario() {
        return salario;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public Timestamp getData_cadastro() {
        return data_cadastro;
    }

    public Timestamp getData_remocao() {
        return data_remocao;
    }

    public Timestamp getData_atualizacao() {
        return data_atualizacao;
    }

    public void setId( int id){
        this.id = id;
    }

    public void setNome( String nome){
        this.nome = nome;
    }

    public void setEstado( String estado){
        this.estado = estado;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public void setSalario( double salario){
        this.salario = salario;
    }

    public void setEstado_civil( String estado_civil){
        this.estado_civil = estado_civil;
    }

    public void setEspecialidade ( String especialidade){
        this.especialidade = especialidade;
    }

    public void setData_nascimento( Date data_nascimento){
        this.data_nascimento = data_nascimento;
    }

    public void setAtivo( Boolean ativo){
        this.ativo = ativo;
    }

    public void setData_remocao(Timestamp data_remocao) {
        this.data_remocao = data_remocao;
    }

    public void setData_cadastro(Timestamp data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public void setData_atualizacao(Timestamp data_atualizacao) {
        this.data_atualizacao = data_atualizacao;
    }
}
