/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author rafae
 */
public class itensOS {
    private OrdemDeServiço deServiço;
    private Materiais materiais;

    public Materiais getMateriais() {
        return materiais;
    }

    public void setMateriais(Materiais materiais) {
        this.materiais = materiais;
    }

    public OrdemDeServiço getDeServiço() {
        return deServiço;
    }

    public void setDeServiço(OrdemDeServiço deServiço) {
        this.deServiço = deServiço;
    }
    
}
