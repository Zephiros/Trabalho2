package br.univali.poo.empresa;

import br.univali.poo.date.DateHandler;
import java.util.Calendar;

/**
 * Metodos do diretor
 * @author Heverton de Lemos - Alex Batista
 */
public class Diretor extends Regular
{
    /**
     * @see br.univali.poo.empresa.Regular
     * Construtor
     * @param salarioBase salario
     */
    public Diretor(float salarioBase) {
        super(salarioBase);
    }
    
    /**
     * @see br.univali.poo.empresa.Regular
     * Construtor
     * @param salarioBase salario
     * @param dataAdmissao data de admissao
     */
    public Diretor(float salarioBase, Calendar dataAdmissao){
        super(salarioBase, dataAdmissao);
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
