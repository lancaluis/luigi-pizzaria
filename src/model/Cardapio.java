/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author llanca
 */
public class Cardapio {
    
    private int id_pizza;
    private String nome;
    private String descricao;
    private String tamanho;
    private double preco;

    public Vinho() {
    }

    public Vinho(int codigo, String nome, String descricao, String tamanho, double preco) {
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

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public int getTamanho() {
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
