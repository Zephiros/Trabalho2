/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhom2.empresa;

/**
 * Informações e metodos referente a folha de pagamento da empresa
 * @author Heverton de Lemos - Alex Batista
 */
public class FolhaPagamento
{
    private Funcionario[] funcionario;
    private int quantidadeFuncionario = 0;
    
    /**
     * Retorna os funcionarios
     * @return os funcionarios
     */
    public Funcionario[] getFuncionarios()
    {
        return this.funcionario;
    }
    
    /**
     * Insere um funcionario.
     * @param funcionario o funcionario.
     * @param tipo [1]para Regular, [2]para Diretor e [3]para Externo.
     * @param salarioL se o funcionario for externo deve ser inserido 
     * o salario dele, no caso dos outros tipos o salario é zero.
     */
    public void setFuncionario(Funcionario funcionario, int tipo, float salarioL)
    {
        if (quantidadeFuncionario < 100)
        {
            switch(tipo)
            {
                case 1: this.funcionario[quantidadeFuncionario++] = new Regular();
                    break;
                    
                case 2: this.funcionario[quantidadeFuncionario++] = new Diretor();
                    break;
                    
                case 3: this.funcionario[quantidadeFuncionario++] = new Externo(salarioL);
                    break;
            }
        }else
            System.out.println("oi");//mesmo caso de empresa
           
    }
}
