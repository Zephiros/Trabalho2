/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhom2.empresa;

/**
 * Informações e metodos referente a empresa.
 * @author Heverton de Lemos - Alex Batista
 */
public class Empresa 
{
    private FolhaPagamento[] folhaPagamento;
    private String nome;
    private int quantidadeFolhas = 0;
    
    /**
     * Recupera nome da empresa
     * @return nome da empresa
     */
    public String getNome()
    {
        return this.nome;
    }
    
    /**
     * Retorna as folhas de pagemento da empresa.
     * @return as folhas de pagamento da empresa
     */
    public FolhaPagamento[] getFolhasPagamento()
    {
        return this.folhaPagamento;
    }
    
    /**
     * Insere o nome da empresa
     * @param nome nome da empresa
     */
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    /**
     * Insere uma nova folha de pagamento.
     * @param folha folha de pagamento nova
     */
    public void setFolhaPagamento(FolhaPagamento folha)
    {
        if(quantidadeFolhas < 100)
        {
            this.folhaPagamento[quantidadeFolhas++] = new FolhaPagamento();
        }else
            System.out.println("oi");//algo para informar que ta cheia.
            //ou criar uma exeção
    }
}
