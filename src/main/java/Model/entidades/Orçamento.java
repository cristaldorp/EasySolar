/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

/**
 *
 * @author rafae
 */
public class Orçamento {
    private Integer idOrçamento;
    private Funcionarios funcionarios;

    public Integer getIdOrçamento() {
        return idOrçamento;
    }

    public void setIdOrçamento(Integer idOrçamento) {
        this.idOrçamento = idOrçamento;
    }

    public Funcionarios getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    
}
