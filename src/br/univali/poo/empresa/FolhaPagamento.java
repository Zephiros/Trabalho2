package br.univali.poo.empresa;

import java.util.List;

/**
 * Informações e metodos referente a folha de pagamento da empresa
 * @author Heverton de Lemos - Alex Batista
 */
public class FolhaPagamento
{
    private List<Funcionario> funcionario;

    public FolhaPagamento() {
    }
    
    /**
     * Retorna os funcionarios
     * @return os funcionarios
     */
    public List<Funcionario> getFuncionarios()
    {
        return this.funcionario;
    }
    
    /**
     * Insere um funcionario.
     * @param tipo [1]para Regular, [2]para Diretor e [3]para Externo.
     * @param salario salario do funcionario
     */
    public void cadastraFuncionario(int tipo, float salario)
    {        
        switch(tipo)
        {
            case 1: funcionario.add(new Regular(salario));
                break;
                 
            case 2: funcionario.add(new Diretor(salario));
                break;
                  
            case 3: funcionario.add(new Externo(salario));
                break;
                    
            default: break;
        }    
    }
    
    /**
     * Metodo para retornar a quantidade de funcionarios da folha de Pagamento
     * @return quantidade de funcionarios
     */
    public int getQuantidadeFuncionario()
    {
        return this.funcionario.size();
    }
    
    /**
     * Calcula o valor total da folha de pagamento.
     * @return valor total da folha de pagamento
     */
    public float totalFolhaPagamento()
    {
        float total = 0;
        for(int i = 0; i <= this.funcionario.size(); i++)
        {
            total = total + funcionario.get(i).calculaSalarioLiquidoComDesconto();
        }
        return total;
    }
    
    /**
     * Verifica se existe funcionario.
     * @return return true ou false.
     */
    public boolean existeFuncionario()
    {
        return funcionario != null;
    }
}
