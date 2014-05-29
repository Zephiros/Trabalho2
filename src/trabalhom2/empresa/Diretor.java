/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhom2.empresa;

import trabalhom2.date.DateHandler;

/**
 * Metodos do diretor
 * @author Heverton de Lemos - Alex Batista
 */
public class Diretor extends Regular
{

    /**
     * Calcula o anuenio do diretor conforme seu tempo de serviço.
     * @return a porcentagem referente ao anuenio.
     */
    public float getAnuenio()
    {
        int tempo = DateHandler.yearsFromToday(this.getDataAdmissao());
        if(tempo > 1 && tempo <= 40)
        {
            return this.calculaSalarioLiquido(this.getSalarioBase()) * (float)(tempo * 5f);
        }
        return 0f;
    }
}
