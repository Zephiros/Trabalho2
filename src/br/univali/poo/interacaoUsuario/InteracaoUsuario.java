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
     */
    public void incluirFuncionario(int tipo, float salario, String nome)
    {
        empresa.getFolhaPagamento().cadastraFuncionario(tipo, salario, nome);
        //INCLUIR DEPARTAMENTO NO CONTRUTOR.
    }
    
    /**
     * Metodo que realiza a impressão da folha de pagamento 
     * informando o nome dos funcionários e o seus respectivos salários.
     */
    public void imprimirFolhaPagamento()
    {
        try
        {
            funcionarios = empresa.getFolhaPagamento().getFuncionarios();
        
  
            for(int i = 0; i <= funcionarios.size(); i++)
            {
                int tipo = tipoFuncionario(funcionarios.get(i));

                switch(tipo)
                {
                    case 1: System.out.println("Nome: "+((Regular) funcionarios.get(i)).getNome());
                            System.out.println("Salario: "+((Regular) funcionarios.get(i)).calculaSalarioLiquidoComDesconto());
                        break;
                    case 2: System.out.println("Nome: "+((Diretor) funcionarios.get(i)).getNome());
                            System.out.println("Salario: "+((Diretor) funcionarios.get(i)).calculaSalarioLiquidoComDesconto());
                        break;
                    case 3: System.out.println("Nome: "+((Externo) funcionarios.get(i)).getNome());
                            System.out.println("Salario: "+((Externo) funcionarios.get(i)).calculaSalarioLiquidoComDesconto());
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
        try
        {
            List<Funcionario> lista = empresa.getFolhaPagamento().getFuncionarios();
            quickSort(lista, 0, lista.size() - 1);
        }catch(RuntimeException e)
        {
            System.out.println("Nao existe folha de pagamento!");
        }
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
    
    public void acrescentarHorasParaFuncionario(String nome, int horas)
    {
        funcionarios = empresa.getFolhaPagamento().getFuncionarios();
        
        for(int i = 0; i <= funcionarios.size() - 1; i++)
        {
            int tipo = tipoFuncionario(funcionarios.get(i));
            
            switch(tipo)
            {
                case 1: ((Regular) funcionarios.get(i)).rolarTempo(horas);
                    break;
                case 2: ((Diretor) funcionarios.get(i)).rolarTempo(horas);
                    break;
                case 3:
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
     * 
     * @param lista 
     * @param left
     * @param right
     * @return 
     */
    private int partition(List<Funcionario> lista, int left, int right)
    {
        int i = left, j = right;
        Funcionario tmp;
          
        Funcionario pivot = lista.get((left + right) / 2);

        while (i <= j) {
                while (lista.get(i).calculaSalarioLiquidoComDesconto() < pivot.calculaSalarioLiquidoComDesconto())
                      i++;
                while (lista.get(i).calculaSalarioLiquidoComDesconto() > pivot.calculaSalarioLiquidoComDesconto())
                      j--;
                if (i <= j) {
                    tmp = lista.get(i);     
                    lista.set(i, lista.get(j));
                    lista.set(j, tmp);
                    i++;
                    j--;
                }
        }
        return i;
    }

    /**
     * 
     * @param lista
     * @param left
     * @param right 
     */
    private void quickSort(List<Funcionario> lista, int left, int right) {

          int index = partition(lista, left, right);

          if (left < index - 1)
                quickSort(lista, left, index - 1);
          if (index < right)
                quickSort(lista, index, right);
    }
}
