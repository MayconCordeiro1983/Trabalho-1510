package model;

public class Usuario {
    private String nome;
    private int idade;
    private String cidade;

    public Usuario() {}

    public Usuario(String nome, int idade, String cidade) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getCidade() { return cidade; }

    @Override
    public String toString() {
        return nome + " - " + idade + " anos - " + cidade;
    }
}
