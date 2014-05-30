package br.univali.poo.empresa;

/**
 * Informações e metodos referente a empresa.
 * @author Heverton de Lemos - Alex Batista
 */
public class Empresa 
{
    private FolhaPagamento[] folhaPagamento;
    private String nome;
    private int quantidadeFolhas;

    /**
     * Construtor. Inicia quantidade de folhas
     */
    public Empresa() {
        this.quantidadeFolhas = 0;
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
        //INSERIR TRY...CATCH
        if(quantidadeFolhas < 100)
            this.folhaPagamento[quantidadeFolhas++] = new FolhaPagamento();
    }
}
