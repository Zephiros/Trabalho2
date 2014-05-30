package br.univali.poo.empresa;

/**
 * Referente ao contracheque
 * @author Heverton de Lemos - Alex Batista
 */
public class ContraCheque
{
    private String relatorio;
    
    /**
     *  Retorna um contracheque.
     * @return o contra cheque no formato:
     * "departamento - nome - dataAdmissao - salarioBase - horaReferencia - 
     * horaTrabalhada - salarioLiquido - INSS - impostoDeRenda - anuenio - 
     * salarioFinal"
     */
    public String getRelatorio()
    {
        return this.relatorio;
    }
    
    /**
     * Insere dados no contracheque
     * @param relatorio string com os dados no formato:
     * "departamento - nome - dataAdmissao - salarioBase - horaReferencia - 
     * horaTrabalhada - salarioLiquido - INSS - impostoDeRenda - anuenio - 
     * salarioFinal"
     */
    public void setRelatorio(String relatorio)
    {
        this.relatorio = relatorio; 
    }
}
