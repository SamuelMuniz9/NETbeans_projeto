package model_classe;

public class Produtos {
    private int id;
    private String nome;
    private double preco;
    private String dataV;
    private int qtd;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public String getDataV() { return dataV; }
    public void setDataV(String dataV) { this.dataV = dataV; }
    public int getQtd() { return qtd; }
    public void setQtd(int qtd) { this.qtd = qtd; }
}
