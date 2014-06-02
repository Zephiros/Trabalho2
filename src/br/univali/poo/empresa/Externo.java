package br.univali.poo.empresa;

/**
 * Informações e metodos referente ao funcionario externo
 * @author Heverton de Lemos - Alex Batista
 */
public class Externo implements Funcionario
{
    private String nome;
    private String cpf;
    private float salarioLiquido;

    /**
     * Construtor
     * @param salarioL Funcionario Externo precisa de um salario inicial
     * @param nome nome do funcionario
     */
    Externo(float salarioL, String nome)
    {
        this.salarioLiquido = salarioL;
        this.nome = nome;
    }
    
    /**
     * Retorna nome do funcionario
     * @return nome do funcionario.
     */
    public String getNome()
    {
        return this.nome;
    }
    
    /**
     * Retorna o cpf do funcionario
     * @return cpf do funcionario.
     */
    public String getCpf()
    {
        return this.cpf;
    }
    
    /**
     * retorna o salario liquido do funcionario
     * @return salario liquido do funcionario.
     */
    public float getsalarioLiquido()
    {
        return this.salarioLiquido;
    }
    
    /**
     * Insere nome do funcionario
     * @param nome nome do funcionario.
     */
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    /**
     * Insere cpf do funcionario
     * @param cpf cpf do fncionario.
     */
    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }
    
    /**
     * insere salario liquido do funcionario
     * @param salarioL salario liquido do funcionario
     */
    public void setSalarioLiquido(float salarioL)
    {
        this.salarioLiquido = salarioL;
    }
    
    /**
     * @see br.univali.poo.empresa.Funcionario
     * Metodo para calcular o valor de desconto do
     * imposto de Renda sobre um salario
     * Salário líquido               Alíquota %
     *   Até 1.499,15                   -
     *   De 1.499,16 até 2.246,75      7,5
     *   De 2.246,76 até 2.995,70     15,0
     *   De 2.995,71 até 3.743,19     22,5
     *   Acima de 3.743,19            27,5
     * @param salario salario a ser calculado o imposto sobre
     * @return valor do desconto
     */
    @Override
    public float calculaImpostoDeRenda(float salario)
    {
        if(salario <= 1499.15f)
            return 0f;
        else
            if(salario >= 1499.16f && salario <= 2246.75f)
                return (salario * 0.075f);
        else
            if(salario >= 22466.76f && salario <= 2995.70f)
                return (salario * 0.15f);
        else
            if(salario >= 2995.71f && salario <= 3743.19f)
                return (salario * 0.225f);
        else
            return (salario * 0.275f);
    }
    
    /**
     * @see br.univali.poo.empresa.Funcionario
     * Metodo para calcular o desconto de INSS em cima de um salario
     * 11% sobre o salário líquido, com teto máximo de R$ 482,93.
     * @param salario salario a ser calculado
     * @return valor de desconto
     */
    @Override
    public float calculaINSS(float salario)
    {
        float taxa = (salario * 0.11f);
        if(taxa <= 482.93)
            return taxa;
        return 482.93f;
    }
    
    /**
     * @see br.univali.poo.empresa.Funcionario
     * Metodo para calcular o salario liquido de um Funcionario Externo
     * O salario liquido não altera
     * @param salario salario a ser calculado
     * @return valor do salario
     */
    @Override
    public float calculaSalarioLiquido(float salario)
    {
        return salario;
    }
    
    /**
     * @see br.univali.poo.empresa.Funcionario
     * Metodo para calcular o salario liquido final de um funcionario
     * Aplicado o salario liquido inicial com os descontos de imposto de renda e INSS
     * @return salario liquido final
     */
    @Override
    public float calculaSalarioLiquidoComDesconto()
    {
        float salarioLiquidoInicial = calculaSalarioLiquido(getsalarioLiquido());
        return salarioLiquidoInicial -
                calculaImpostoDeRenda(salarioLiquidoInicial) -
                calculaINSS(salarioLiquidoInicial);
    }
}
