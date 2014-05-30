package br.univali.poo.empresa;

/**
 * Informações e metodos referente a folha de pagamento da empresa
 * @author Heverton de Lemos - Alex Batista
 */
public class FolhaPagamento
{
    private Funcionario[] funcionario;
    private int quantidadeFuncionario;

    /**
     * Construtor Folha de Pagamento.
     * Iniciar a quantidade de funcionarios com 0
     */
    public FolhaPagamento() {
        this.quantidadeFuncionario = 0;
    }
    
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
     * @param tipo [1]para Regular, [2]para Diretor e [3]para Externo.
     * @param salarioL se o funcionario for externo deve ser inserido 
     * o salario dele, no caso dos outros tipos o salario é zero.
     */
    public void cadastraFuncionario(int tipo, float salarioL)
    {
        if (quantidadeFuncionario < 100)
        {
            switch(tipo)
            {
                case 1: this.funcionario[this.quantidadeFuncionario++] = new Regular();
                    break;
                    
                case 2: this.funcionario[this.quantidadeFuncionario++] = new Diretor();
                    break;
                    
                case 3: this.funcionario[this.quantidadeFuncionario++] = new Externo(salarioL);
                    break;
                    
                default: break;
            }
        }
    }
}
