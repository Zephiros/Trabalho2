/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhom2.empresa;

import java.util.Calendar;

/**
 *
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
    private ContraCheque contraCheque;
    
    public String getNome()
    {
        return this.nome;
    }
    
    public String getCpf()
    {
        return this.cpf;
    }
    
    public String getDepartamento()
    {
        return this.departamento;
    }
    
    public Calendar getDataAdmissao()
    {
        return this.dataAdmissao;
    }
    
    public float getSalarioBase()
    {
        return this.salarioBase;
    }
    
    public float getHoraTrabalhada()
    {
        return this.horaTrabalhada;
    }
    
    public ContraCheque getContracheques()
    {
        return this.contraCheque;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }
    
    public void setDepartamento(String departamento)
    {
        this.departamento = departamento;
    }
    
    public void setDataAdmissao(Calendar dataAdmissao)
    {
        this.dataAdmissao = dataAdmissao;
    }
    
    public void setSalarioBase(float salarioB)
    {
        this.salarioBase = salarioB;
    }
    
    public void setHoraTrabalhada(float horaTrabalhada)
    {
        this.horaTrabalhada = horaTrabalhada;
    }
    
    public void setContracheques(ContraCheque contraCheque)
    {
        this.contraCheque = contraCheque;
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
        float taxaHorario = (getHoraTrabalhada() * 100) / 160;
        if(taxaHorario <= 90)
            return (getSalarioBase() / 160) * getHoraTrabalhada();
        else if(taxaHorario > 100){
            return getSalarioBase() + ((getSalarioBase() / 2) * getHoraTrabalhada() - 160);
        }            
        else
            return getSalarioBase();
    }
}
