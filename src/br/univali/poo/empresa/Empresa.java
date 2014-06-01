package br.univali.poo.empresa;

/**
 * Informações e metodos referente a empresa.
 * @author Heverton de Lemos - Alex Batista
 */
public class Empresa 
{
    private FolhaPagamento folhaPagamento;
    private String nome;
    
    public Empresa()
    {
        this(null);
    }
    
    /**
     * Construtor. 
     * Inicia a empresa com o nome e cria uma folha de pagamento.
     * Inicia a quantidade de folhas para uma.
     * @param nome nome da empresa.
     */
    public Empresa(String nome)
    {
        this.nome = nome;
        this.folhaPagamento = new FolhaPagamento();
    }
    
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
    public FolhaPagamento getFolhaPagamento()
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
     * @param folha folha de pagamento
     */
    public void setFolhaPagamento(FolhaPagamento folha)
    {
        this.folhaPagamento = folha;
    }
}
