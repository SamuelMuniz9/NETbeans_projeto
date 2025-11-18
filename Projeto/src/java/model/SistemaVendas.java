package model;

public class SistemaVendas {
    private int id;
    private String produto;
    private String dataVendas;
    private float valor;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getProduto() { return produto; }
    public void setProduto(String produto) { this.produto = produto; }
    public String getDataVendas() { return dataVendas; }
    public void setDataVendas(String dataVendas) { this.dataVendas = dataVendas; }
    public float getValor() { return valor; }
    public void setValor(float valor) { this.valor = valor; }
}
