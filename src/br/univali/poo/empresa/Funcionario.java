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
     */
    public float calculaImpostoDeRenda(float salario);
    
    /**
     * Interface calculaINSS. para calculo de desconto do INSS
     * @param salario salario para calcular o desconto
     * @return valor do desconto
     */
    public float calculaINSS(float salario);
    
    /**
     * Interface calculaSalarioLiquido. para calculo do salario liquido
     * @param salario salario base para calcular o salario liquido
     * @return salario liquido
     */
    public float calculaSalarioLiquido(float salario);
}
