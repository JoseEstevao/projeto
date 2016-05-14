package br.com.projetowebnutri.dell.teste250416;

/**
 * Created by Dell on 22/04/2016.
 */
public class Usuario {

    private String nome;
    private String senha;
    private Integer id;



    public Usuario() {
    }



    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
