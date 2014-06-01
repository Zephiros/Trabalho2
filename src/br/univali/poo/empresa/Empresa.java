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
     * Construtor. 
     * Inicia a empresa com o nome e cria uma folha de pagamento.
     * Inicia a quantidade de folhas para uma.
     * @param nome nome da empresa.
     */
    public Empresa(String nome)
    {
        this.nome = nome;
        this.quantidadeFolhas = 1;
        setFolhaPagamento();
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
     * Retorna uma folha de pagamento especifica.
     * @param folha numero da folha de pagamento de 0 à 11 (meses do ano)
     * @return a folha de pagamento selecionada.
     */
    public FolhaPagamento getFolhaPagamento(int folha)
    {
        return this.folhaPagamento[folha];
    }
    
    /**
     * Retorna a ultima folha de pagamento da empresa.
     * @return ultima folha de pagamento criada.
     */
    public FolhaPagamento getUltimaFolhaPagamento()
    {
        return this.folhaPagamento[this.quantidadeFolhas];
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
     */
    public void setFolhaPagamento()
    {
        //INSERIR TRY...CATCH
        if(quantidadeFolhas < 100)
            this.folhaPagamento[quantidadeFolhas++] = new FolhaPagamento();
    }
}
