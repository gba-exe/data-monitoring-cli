package exe.gba.objeto;

import java.time.LocalDate;

public class Funcionario {
    private Integer idFuncionario;
    private String nome;
    private String email;
    private String senha;

    public Funcionario () {}

    public Funcionario (String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Funcionario (String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Funcionario (Integer id, String nome, String email, String senha) {
        this.idFuncionario = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "idFuncionario=" + idFuncionario +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
