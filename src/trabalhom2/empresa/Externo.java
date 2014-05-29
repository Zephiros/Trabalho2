/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhom2.empresa;

/**
 * Informações e metodos referente ao funcionario externo
 * @author Heverton de Lemos - Alex Batista
 */
public class Externo implements Funcionario
{
    private String nome;
    private String cpf;
    private float salarioLiquido;

    Externo(float salarioL)
    {
        this.salarioLiquido = salarioL;
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
     *
     * @param cpf cpf do fncionario.
     */
    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }
    
    public void setSalarioLiquido(float salarioL)
    {
        this.salarioLiquido = salarioL;
    }
    
    @Override
    public float calculaImpostoDeRenda(float salario)
    {
        //Salário líquido          / Alíquota %
        //Até 1.499,15             / -
        //De 1.499,16 até 2.246,75 / 7,5
        //De 2.246,76 até 2.995,70 / 15,0
        //De 2.995,71 até 3.743,19 / 22,5
        //Acima de 3.743,19        / 27,5
        
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
            //if(salario > 3743.19f)
                return (salario * 0.275f);
    }
    
    @Override
    public float calculaINSS(float salario)
    {
        //11% sobre o salário líquido, com teto máximo de R$ 482,93.
        float taxa = (salario * 0.11f);
        if(taxa <= 482.93)
        {
            return taxa;
        }else
            return 482.93f;
    }
    
    @Override
    public float calculaSalarioLiquido(float salario)
    {
        return salario;
    }
}
