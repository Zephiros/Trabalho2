package br.univali.poo.empresa;

import br.univali.poo.date.DateHandler;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Class Regular
 * @author Heverton de Lemos - Alex Batista
 */
public class Regular implements Funcionario
{
    private String nome;
    private String cpf;
    private String departamento;
    private Calendar dataAdmissao;
    private float salarioBase;
    private float horaTrabalhada;
    private List<ContraCheque> contraCheque;

    /**
     * Construtor que insere a data do dia para data de admissão.
     * @param salarioBase salario base do funcionario.
     */
    public Regular(float salarioBase){
        this.salarioBase = salarioBase;
        this.dataAdmissao = DateHandler.today();
    }
    
    /**
     * Construtor que pode ser informada a data da admisão.
     * @param salarioBase salario base do funcionario.
     * @param dataAdmissao data de admissão do funcionario.
     */
    public Regular(float salarioBase, Calendar dataAdmissao){
        this.salarioBase = salarioBase;
        this.dataAdmissao = dataAdmissao;
    }
    
    /**
     * Metodo para acessar o nome do Funcionario
     * @return nome do Funcionario 
     */
    public String getNome()
    {
        return this.nome;
    }
    
    /**
     * Metodo para acessar o cpf do Funcionario
     * @return cpf do Funcionario
     */
    public String getCpf()
    {
        return this.cpf;
    }
    
    /**
     * Metodo para acessar o departamento do Funcionario
     * @return departamento do Funcionario
     */
    public String getDepartamento()
    {
        return this.departamento;
    }
    
    /**
     * Metodo para acessar a Data de Admissao do Funcionario
     * @return Data de Admissao do Funcionario
     */
    public Calendar getDataAdmissao()
    {
        return this.dataAdmissao;
    }
    
    /**
     * Metodo para acessar o salario base do Funcionario
     * @return salario base do Funcionario
     */
    public float getSalarioBase()
    {
        return this.salarioBase;
    }
    
    /**
     * Metodo para acessar as horas trabalhadas do Funcionario
     * @return horas trabalhadas do Funcionario
     */
    public float getHoraTrabalhada()
    {
        return this.horaTrabalhada;
    }
    
    /**
     * Metodo para acessar os contra cheques dos Funcionario
     * @return contra cheques do Funcionario
     */
    public List<ContraCheque> getContracheques()
    {
            return this.contraCheque;
    }
    
    /**
     * Metodo para modificar o nome do Funcionario
     * @param nome nome do Funcionario
     */
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    /**
     * Metodo para modificar o cpf do Funcionario
     * @param cpf cpf do Funcionario
     */
    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }
    
    /**
     * Metodo para modificar o departamento do Funcionario
     * @param departamento departamento do Funcionario
     */
    public void setDepartamento(String departamento)
    {
        this.departamento = departamento;
    }
    
    /**
     * Metodo para modificar a data de admissao do Funcionario
     * @param dataAdmissao data de admissao do Funcionario
     */
    public void setDataAdmissao(Calendar dataAdmissao)
    {
        this.dataAdmissao = dataAdmissao;
    }
    
   /**
    * Metodo para modificar o salario base do Funcionario 
    * @param salarioBase salario base do Funcionario 
    */
    public void setSalarioBase(float salarioBase)
    {
        this.salarioBase = salarioBase;
    }
    
    /**
     * Metodo para modificar as horas trabalhadas do Funcionario
     * @param horaTrabalhada horas trabalhadas do Funcionario
     */
    public void setHoraTrabalhada(float horaTrabalhada)
    {
        this.horaTrabalhada = horaTrabalhada;
    }
    
    /**
     * Metodo para modificar os contra cheques do Funcionario
     * @param contraCheque contra cheques do Funcionario
     */
    public void setContracheques(List<ContraCheque> contraCheque)
    {
        this.contraCheque = contraCheque;
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
     * @see br.univali.poo.empresa.Funcionario;
     * Metodo para calcular o salario liquido de um Funcionario apartir de
     * um salario base. Base de horas - 160H
     * @param salario salario base
     * @return valor do salario liquido
     */
    @Override
    public float calculaSalarioLiquido(float salario)
    {
        float taxaHorario = (getHoraTrabalhada() * 100) / 160;
        if(taxaHorario <= 90)
            return (getSalarioBase() / 160) * getHoraTrabalhada();
        else if(taxaHorario > 100)
            return getSalarioBase() + ((getSalarioBase() / 2) * getHoraTrabalhada() - 160);
        else
            return getSalarioBase();
    }

    /**
     * @see br.univali.poo.empresa.Funcionario
     * Metodo para calcular o salario liquido final de um funcionario
     * Aplicado o salario liquido inicial com os descontos de imposto de renda e INSS
     * @return salario liquido final
     */
    @Override
    public float calculaSalarioLiquidoComDesconto() {
        float salarioLiquidoInicial = calculaSalarioLiquido(getSalarioBase());
        return salarioLiquidoInicial - 
                calculaImpostoDeRenda(salarioLiquidoInicial) - 
                calculaINSS(salarioLiquidoInicial);
    }
    
    /**
     * Verifica se existe contracheque.
     * @return retorna true ou false.
     */
    public boolean existeContraCheque()
    {
        return contraCheque != null;
    }
}
