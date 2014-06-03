package br.univali.poo.empresa;

/**
 * Interface Funcionario
 * @author Heverton de Lemos - Alex Batista
 */
public interface Funcionario
{
    /**
     * Interface calculaImpostoDeRenda. para calculo de desconto do Imposto de Renda
     * @param salario salario para calcular o desconto
     * @return valor do desconto
     * @throws java.lang.Exception
     */
    public float calculaImpostoDeRenda(float salario) throws Exception;
    
    /**
     * Interface calculaINSS. para calculo de desconto do INSS
     * @param salario salario para calcular o desconto
     * @return valor do desconto
     * @throws java.lang.Exception
     */
    public float calculaINSS(float salario) throws Exception;
    
    /**
     * Interface calculaSalarioLiquido. para calculo do salario liquido
     * @param salario salario base para calcular o salario liquido
     * @return salario liquido
     * @throws java.lang.Exception
     */
    public float calculaSalarioLiquido(float salario) throws Exception;
    
    /**
     * Interface calculaSalarioLiquidoComDesconto. para calculo do salario liquido final
     * @return salario liquido final
     * @throws java.lang.Exception
     */
    public float calculaSalarioLiquidoComDesconto() throws Exception;
}
