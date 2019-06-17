
package model;

/**
 *
 * @author llanca
 */
public class Cliente {

    private int id_cliente;
    private String nome;
    private String telefone;
    private String endereco;

    public Cliente() {
    }

    public Cliente(int codigo, String nome, String telefone, String endereco) {
        this.id_cliente = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;

    }

    public int getCodigo() {
        return id_cliente;
    }

    public void setCodigo(int codigo) {
        this.id_cliente = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + id_cliente + ", nome=" + nome + ", telefone=" + telefone + ",endereço=" + endereco + '}';
    }
    
}
