package br.univali.poo.funcionario;

/**
 *
 * @author Alex
 */
public interface Externo {
    
    public double calculaSalarioLiquido();
    
    public void descontoImpostoDeRenda(double salario);
    
    public double descontoImpostoDeRenda();
    
    public void descontoINSS();
    
    public double descontoINSS(double salario);
}
