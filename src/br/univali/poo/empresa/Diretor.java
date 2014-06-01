package br.univali.poo.empresa;

import br.univali.poo.date.DateHandler;

/**
 * Metodos do diretor
 * @author Heverton de Lemos - Alex Batista
 */
public class Diretor extends Regular
{

    public Diretor(float salarioBase) {
        super(salarioBase);
    }    
    
    /**
     * Calcula o anuenio do diretor conforme seu tempo de serviço.
     * @return a porcentagem referente ao anuenio.
     */
    public float getAnuenio()
    {
        int tempo = DateHandler.yearsFromToday(this.getDataAdmissao());
        if(tempo > 1 && tempo <= 40)
        {
            return calculaSalarioLiquido(getSalarioBase()) * (float)(tempo * 5f);
        }
        return 0f;
    }
    
    /**
     * @see br.univali.poo.empresa.Regular
     * Metodo chama calcularSalarioLiquidoComDesconto e adiciona o bonus de diretor 
     * @return salario liquido final
     */
    @Override
    public float calculaSalarioLiquidoComDesconto(){
        return super.calculaSalarioLiquidoComDesconto() + getAnuenio();
    }
}
