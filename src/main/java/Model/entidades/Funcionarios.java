/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;


/**
 *
 * @author rafae
 */
public class Funcionarios extends Dados implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer IdFuncionario;
    private String CPF;
    private Clientes clientes;
    private Fornecedores fornecedores;

    public Funcionarios() {
    }

    public Funcionarios(Integer IdFuncionario, String CPF, Clientes clientes, Fornecedores fornecedores) {
        this.IdFuncionario = IdFuncionario;
        this.CPF = CPF;
        this.clientes = clientes;
        this.fornecedores = fornecedores;
    }

    public Integer getIdFuncionario() {
        return IdFuncionario;
    }

    public void setIdFuncionario(Integer IdFuncionario) {
        this.IdFuncionario = IdFuncionario;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Fornecedores getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(Fornecedores fornecedores) {
        this.fornecedores = fornecedores;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.IdFuncionario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionarios other = (Funcionarios) obj;
        if (!Objects.equals(this.IdFuncionario, other.IdFuncionario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionarios{" + "IdFuncionario=" + IdFuncionario + ", CPF=" + CPF + ", clientes=" + clientes + ", fornecedores=" + fornecedores + '}';
    }

}
