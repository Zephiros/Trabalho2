/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhom2.empresa;

/**
 *
 * @author hls
 */
public interface Funcionario
{
    public float calculaImpostoDeRenda(float salario);
    
    public float calculaINSS(float salario);
    
    public float calculaSalarioLiquido(float salario);
}
