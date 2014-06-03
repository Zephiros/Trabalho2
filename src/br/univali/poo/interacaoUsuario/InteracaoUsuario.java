/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.poo.interacaoUsuario;

import br.univali.poo.empresa.Diretor;
import br.univali.poo.empresa.Empresa;
import br.univali.poo.empresa.Externo;
import br.univali.poo.empresa.Funcionario;
import br.univali.poo.empresa.Regular;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que faz a interação do usuário com as classes de processamento e de entidade.
 * @author Heverton de Lemos - Alex Batista
 */
public class InteracaoUsuario {
    Empresa empresa;
    List<Funcionario> funcionarios;
    
    public InteracaoUsuario(){
        funcionarios = new ArrayList<>();
    }
    
    /**
     * Verifica tipo de funcionario.
     * @param funcionario funcionario a ser verificado.
     * @return retorna [1]para Regular, [2]para Diretor, [3]para Externo
     * e [0] caso não for nenhum desses.
     */
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
    
    /**
     * Cria uma nova empresa, com nome e uma folha de pagamento zerada.
     * @param nome nome da empresa.
     */
    public void criaEmpresa(String nome)
    {
        this.empresa = new Empresa(nome);
    }
    
    /**
     * Metodo para inclusão de funcionários.
     * @param tipo tipo de funcionario [1]regular, [2]diretor e [3]externo.
     * @param salario salario base do funcionario
     * @param nome nome do funcionario.
     * @param departamento
     * @param cpf
     */
    public void incluirFuncionario(int tipo, float salario, String nome, String departamento, String cpf)
    {
        empresa.getFolhaPagamento().cadastraFuncionario(tipo, salario, nome);
        Funcionario ultimo = empresa.getFolhaPagamento().getFuncionarios().get(
                empresa.getFolhaPagamento().getQuantidadeFuncionario() - 1);
        if(tipo == 1){
            ((Regular)ultimo).setDepartamento(departamento);
            ((Regular)ultimo).setCpf(cpf);
        }else if(tipo == 2){
            ((Diretor)ultimo).setDepartamento(departamento);
            ((Diretor)ultimo).setCpf(cpf);
        } else {
            ((Externo)ultimo).setCpf(cpf);
        }
        //INCLUIR DEPARTAMENTO NO CONTRUTOR.
    }
    
    /**
     * Metodo que realiza a impressão da folha de pagamento 
     * informando o nome dos funcionários e o seus respectivos salários.
     */
    public void imprimirFolhaPagamento(){
        this.funcionarios = empresa.getFolhaPagamento().getFuncionarios();
        imprimirFolhaPagamento(this.funcionarios);
    }
    
    /**
     * Metodo private onde é passado como parametro uma lista e informado os dados da lista
     * @param lista lista
     */
    private void imprimirFolhaPagamento(List<Funcionario> lista)
    {
        try
        {
            for(int i = 0; i <= lista.size(); i++)
            {
                int tipo = tipoFuncionario(lista.get(i));

                switch(tipo)
                {
                    case 1: System.out.println("Nome: "+((Regular) lista.get(i)).getNome());
                            System.out.println("Salario: "+((Regular) lista.get(i)).calculaSalarioLiquidoComDesconto());
                        break;
                    case 2: System.out.println("Nome: "+((Diretor) lista.get(i)).getNome());
                            System.out.println("Salario: "+((Diretor) lista.get(i)).calculaSalarioLiquidoComDesconto());
                        break;
                    case 3: System.out.println("Nome: "+((Externo) lista.get(i)).getNome());
                            System.out.println("Salario: "+((Externo) lista.get(i)).calculaSalarioLiquidoComDesconto());
                        break;
                }
            }
        }catch(RuntimeException e)
        {
            System.out.println("Nao existe folha!");
        }
    }
    
    /**
     * Metodo que realiza a impressão da folha de pagamento informando 
     * o nome dos funcionários e o seus respectivos salários (em ordem crescente de salário).
     */
    public void imprimirFolhaDePagamentoOrdemCrescente()
    {
        this.funcionarios = empresa.getFolhaPagamento().getFuncionarios();
        List<Funcionario> copy = ordernaLista(this.funcionarios);
        imprimirFolhaPagamento(copy);
    }
    
    /**
     * Metodo que imprime o valor total da folha de pagamento.
     */
    public void totalFolhaPagamento()
    {
       try
       {
           System.out.println("O total da folha de pagamento eh: ");
           System.out.println(empresa.getFolhaPagamento().totalFolhaPagamento());
       }catch(RuntimeException e)
       {
            System.out.println("Nao existe folha de pagamento!");
        }
    }
    
    /**
     * Metodo para acrescentar horas trabalhadas aos funcionarios
     * @param nome nome do funcionario
     * @param horas horas trabalhadas do funcionario
     */
    public void acrescentarHorasParaFuncionario(String nome, int horas)
    {
        funcionarios = empresa.getFolhaPagamento().getFuncionarios();
        
        for (Funcionario funcionario : funcionarios) {
            int tipo = tipoFuncionario(funcionario);
            switch (tipo) {
                case 1:
                    if (((Regular) funcionario).getNome().equals(nome)) {
                        ((Regular) funcionario).rolarTempo(horas);
                    }
                    break;
                case 2:
                    if (((Diretor) funcionario).getNome().equals(nome)) {
                        ((Diretor) funcionario).rolarTempo(horas);
                    }
                    break;
                default:
                    break;
            }
        }
    }
    
    /**
     * Metodo que imprime o funcionário que recebe o maior salário.
     */
    public void maiorSalario()
    {
        Funcionario func1 = null;
        if(funcionarios.size() <= 1)
        {
            try
            {
                func1 = funcionarios.get(0);
            }catch(RuntimeException e)
            {
                System.out.println("Nao existe funcionario!");
            }
        }else
        {
            funcionarios = empresa.getFolhaPagamento().getFuncionarios();
        
            func1 = funcionarios.get(0);
            Funcionario func2 = funcionarios.get(1);
            int i = 1;

            while(i <= funcionarios.size()-1)
            {   
                if(func1.calculaSalarioLiquidoComDesconto() > func2.calculaSalarioLiquidoComDesconto())
                    func2 = funcionarios.get(i++);
                else
                {
                    func1 = func2;
                    func2 = funcionarios.get(i++);
                }
            }
        }
        switch(tipoFuncionario(func1))
        {
            case 1: System.out.println("Nome: "+((Regular) func1).getNome());
                    System.out.println("Salario: "+((Regular) func1).calculaSalarioLiquidoComDesconto());
                break;
            case 2: System.out.println("Nome: "+((Diretor) func1).getNome());
                    System.out.println("Salario: "+((Diretor) func1).calculaSalarioLiquidoComDesconto());
                break;
            case 3: System.out.println("Nome: "+((Externo) func1).getNome());
                    System.out.println("Salario: "+((Externo) func1).calculaSalarioLiquidoComDesconto());
                break;
        }
    }
    
    /**
     * Metodo que imprime todos os funcionários alocados em um determinado departamento da empresa.
     * @param departamento departamento que deseja ver os funcionarios.
     */
    public void funcionariosPorDepartamento(String departamento){
        
        funcionarios = empresa.getFolhaPagamento().getFuncionarios();
        
        for (Funcionario funcionario1 : funcionarios) {
            int tipo = tipoFuncionario(funcionario1);
            switch (tipo) {
                case 1:
                    if (((Regular) funcionario1).getDepartamento().equalsIgnoreCase(departamento)) {
                        System.out.println("Nome: " + ((Regular) funcionario1).getNome());
                    }
                    break;
                case 2:
                    if (((Diretor) funcionario1).getDepartamento().equalsIgnoreCase(departamento)) {
                        System.out.println("Nome: " + ((Diretor) funcionario1).getNome());
                    }
                    break;
                case 3:
            default:
                break;
            }
        }
    }
    
    /**
     * Metodo para ordenar uma lista com o salarioLiquidoComDesconto crescente
     * @param listaf lista a ordernar
     * @return lista ordenada
     */
    private List<Funcionario> ordernaLista(List<Funcionario> listaf){
        if(listaf.size() == 1)
            return listaf;
        else{
            for(int i = 0;i < listaf.size();i++){
                for(int j = 0;j < listaf.size();j++){
                    if(listaf.get(i).calculaSalarioLiquidoComDesconto() < 
                       listaf.get(j).calculaSalarioLiquidoComDesconto())
                    {
                        Funcionario tmp = listaf.get(i);
                        listaf.set(i, listaf.get(j));
                        listaf.set(j, tmp);
                    }
                }
            }
        }                
        return listaf;
    }    
}