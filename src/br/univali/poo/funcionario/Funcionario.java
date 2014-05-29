package br.univali.poo.funcionario;

/**
 *
 * @author Alex
 */
public class Funcionario implements Externo{
        
    private String nome;
    private int horasDeTrabalho;
    private double salarioBase;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasDeTrabalho() {
        return horasDeTrabalho;
    }

    public void setHorasDeTrabalho(int horasDeTrabalho) {
        this.horasDeTrabalho = horasDeTrabalho;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }  
    
    @Override
    public double calculaSalarioLiquido() {        
        float taxaHorario = (getHorasDeTrabalho() * 100) / 160;
        if(taxaHorario <= 90)
            return (getSalarioBase() / 160) * getHorasDeTrabalho();
        else if(taxaHorario > 100){
            return getSalarioBase() + ((getSalarioBase() / 2) * getHorasDeTrabalho() - 160);
        }            
        else
            return getSalarioBase();
    }

    @Override
    public void descontoImpostoDeRenda(double salario) {
        
    }

    @Override
    public double descontoImpostoDeRenda() {
        return 0;
    }

    @Override
    public void descontoINSS() {
        
    }

    @Override
    public double descontoINSS(double salario) {
        return 0;
    }
    
    
      
}
