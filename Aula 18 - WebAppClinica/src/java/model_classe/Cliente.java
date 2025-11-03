package model_classe;

public class Cliente {
    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private String funcao;
    private String areaDepartamento;
    private String nomeOrganizacao;
    private String paisRegiao;
    private String cep;
    private String interessePrincipal;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getFuncao() { return funcao; }
    public void setFuncao(String funcao) { this.funcao = funcao; }
    public String getAreaDepartamento() { return areaDepartamento; }
    public void setAreaDepartamento(String areaDepartamento) { this.areaDepartamento = areaDepartamento; }
    public String getNomeOrganizacao() { return nomeOrganizacao; }
    public void setNomeOrganizacao(String nomeOrganizacao) { this.nomeOrganizacao = nomeOrganizacao; }
    public String getPaisRegiao() { return paisRegiao; }
    public void setPaisRegiao(String paisRegiao) { this.paisRegiao = paisRegiao; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
    public String getInteressePrincipal() { return interessePrincipal; }
    public void setInteressePrincipal(String interessePrincipal) { this.interessePrincipal = interessePrincipal; }
}
