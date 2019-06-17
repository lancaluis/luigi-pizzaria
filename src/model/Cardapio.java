package model;

public class Cardapio {
    
    private int id_pizza;
    private String nome;
    private String descricao;
    private String tamanho;
    private double preco;

    public Cardapio() {
    }

    public Cardapio(int codigo, String nome, String descricao, String tamanho, double preco) {
        this.id_pizza = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public int getCodigo() {
        return id_pizza;
    }

    public void setCodigo(int codigo) {
        this.id_pizza = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTamanho() {
        return tamanho;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Pizza{" + "codigo=" + id_pizza + ", nome=" + nome + ", tamanho=" + tamanho + ",preco=" + preco + '}';
    }

}
