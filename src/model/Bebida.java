package model;

public class Bebida {
    
    private int id_bebida;
    private String nome;
    private String tamanho;
    private double preco;

    public Bebida() {
    }

    public Bebida(int codigo, String nome, String tamanho, double preco) {
        this.id_bebida = codigo;
        this.nome = nome;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public int getCodigo() {
        return id_bebida;
    }

    public void setCodigo(int codigo) {
        this.id_bebida = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        return "Bebida{" + "codigo=" + id_bebida + ", nome=" + nome + ", tamanho=" + tamanho + ",preco=" + preco + '}';
    }

}
