/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.poo.interacaoUsuario;

import br.univali.poo.empresa.Diretor;
import br.univali.poo.empresa.Empresa;
import br.univali.poo.empresa.Externo;
import br.univali.poo.empresa.FolhaPagamento;
import br.univali.poo.empresa.Funcionario;
import br.univali.poo.empresa.Regular;

/**
 *  Classe que faz a interação do usuário com as classes de processamento e de entidade.
 * @author Heverton de Lemos - Alex Batista
 */
public class InteracaoUsuario {
    Empresa empresa;
    FolhaPagamento folhaPagamento;
    Funcionario[] funcionario;
    
    /**
     * Cria uma nova empresa, com nome e uma folha de pagamento zerada.
     * @param nome nome da empresa.
     */
    public void criaEmpresa(String nome)
    {
        this.empresa = new Empresa(nome);
    }
    
    //Permitir a inclusão de funcionários.
    public void incluirFuncionario(int tipo, float salarioL)
    {
        folhaPagamento = empresa.getUltimaFolhaPagamento();
        folhaPagamento.cadastraFuncionario(tipo, salarioL);
    }
    
    //Permitir a impressão da folha de pagamento informando o nome dos funcionários e o seus respectivos salários.
    public void imprimiFolhaPagamento()
    {
        folhaPagamento = empresa.getUltimaFolhaPagamento();
        funcionario = folhaPagamento.getFuncionarios();
        
        for(int i = 0; i <= folhaPagamento.getQuantidadeFuncionario(); i++)
        {
            int tipo = tipoFuncionario(funcionario[i]);
            
            switch(tipo)
            {
                case 1: System.out.println(((Regular) funcionario[i]).getNome());
                        System.out.println(((Regular) funcionario[i]).getSalarioBase());
                    break;
                case 2: System.out.println(((Diretor) funcionario[i]).getNome());
                        System.out.println(((Diretor) funcionario[i]).getSalarioBase());
                    break;
                case 3: System.out.println(((Externo) funcionario[i]).getNome());
                        System.out.println(((Externo) funcionario[i]).getsalarioLiquido());
                    break;
            }
        }
    }
    
    public int tipoFuncionario(Funcionario funcionario)
    {
        if(funcionario instanceof Regular)
            return 1;
        else
            if(funcionario instanceof Diretor)
                return 2;
        else
            if(funcionario instanceof Externo)
                return 3;
        else
                return 0;
    }
    //Permitir a impressão da folha de pagamento informando o nome dos funcionários e o seus respectivos salários (em ordem crescente de salário).
    //Permitir a visualização do valor total da folha de pagamento.
    //Permitir a consulta do funcionário (independente do tipo de funcionário) que recebe o maior salário.
    //Permitir a consulta de todos os funcionários alocados em um determinado departamento da empresa.

}
