package br.mackenzie.ps2.cmdcrud;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="bancos")
public class Banco {
    @Id
    private long nroBanco;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String quantidadeAgencias;
    public Banco() {}
    public Banco(long nro, String n, String r, String c, String q) {
        nroBanco = nro;
        nomeFantasia = n;
        razaoSocial = r;
        cnpj = c;
        quantidadeAgencias = q;
    }
    public long getNroBanco() {
        return nroBanco;
    }
    public void setNroBanco(long nroBanco) {
        this.nroBanco = nroBanco;
    }
    public String getNomeFantasia() { return nomeFantasia; }
    public void setNomeFantasia(String n) { nomeFantasia = n; }
    public String getRazaoSocial() { return razaoSocial; }
    public void setRazaoSocial(String r) { razaoSocial = r; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String c) { cnpj = c; }  
    public String getQuantidadeAgencias() { return quantidadeAgencias; }
    public void setQuantidadeAgencias(String q) { quantidadeAgencias = q; }   
}
