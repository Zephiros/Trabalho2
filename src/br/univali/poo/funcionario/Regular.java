package br.univali.poo.funcionario;

import br.univali.poo.empresa.ContraCheque;

/**
 *
 * @author Alex
 */
public class Regular extends Funcionario{

    private String departamento;
    private ContraCheque[] contraCheque;

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public ContraCheque[] getContraCheque() {
        return contraCheque;
    }

    public void setContraCheque(ContraCheque[] contraCheque) {
        this.contraCheque = contraCheque;
    }
    
    @Override
    public double calculaSalarioLiquido(){
        return 0;
    }
    
}
