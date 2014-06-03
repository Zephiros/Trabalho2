
package br.univali.poo.trabalhom2;

import br.univali.poo.interacaoUsuario.InteracaoUsuario;
import br.univali.poo.io.Keyboard;

/**
 *
 * @author Heverton de Lemos - Alex Batista
 */
public class TrabalhoM2 {
    private static int numero;
    private static int escolha;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InteracaoUsuario interacao = new InteracaoUsuario();
        
         while(true)
        {
            System.out.println("[0]Sair;\n"
            + "[1]Criar  empresa;\n"
            + "[2]Cadastrar funcionario;\n"
            + "[3]Imprimir a folha de pagamento informando o nome dos funcionários e o seus respectivos salários.\n"
            + "[4]Imprimir a folha de pagamento informando o nome dos funcionários e o seus respectivos salários (em ordem crescente de salário).\n"
            + "[5]Valor total da folha de pagamento.\n"
            + "[6]Funcionário que recebe o maior salário.\n"
            + "[7]Imprimir todos os funcionários alocados em um determinado departamento da empresa.\n"
            + "[8]Rolar Tempo\n");
            escolha = Keyboard.readlnInt("O que você deseja fazer? (digite o numero da opção)");

            switch(escolha)
            {
                case 0 : System.exit(0);
                
                case 1 : interacao.criaEmpresa(Keyboard.readlnString("Digite o nome da empresa: "));
                    break;

                case 2 : 
                        int tipo = Keyboard.readlnInt("Digite o tipo do usuario " +
                                "[1]regular, [2]diretor e [3]externo");
                        String nomeCadastro = Keyboard.readlnString("Digite o nome do funcionario: ");
                        String cpf = Keyboard.readlnString("Digite o cpf do funcionario: ");
                        float salario = Keyboard.readlnFloat("Digite o salario do funcionario: ");
                        if(tipo == 1 || tipo == 2){
                            String departamento = Keyboard.readlnString("Digite o departamento do funcionario: ");
                            
                            interacao.incluirFuncionario(tipo, salario, nomeCadastro, departamento, cpf);
                        } else {
                            interacao.incluirFuncionario(tipo, salario, nomeCadastro, null, cpf);
                        }
                    break;

                case 3 : interacao.imprimirFolhaPagamento();
                    break;

                case 4 : interacao.imprimirFolhaDePagamentoOrdemCrescente();
                    break;

                case 5 : interacao.totalFolhaPagamento();
                    break;

                case 6 : interacao.maiorSalario();
                    break;

                case 7 : interacao.funcionariosPorDepartamento(Keyboard.readlnString("Digite o departamento: "));
                    break;

                case 8 :
                    String nome = Keyboard.readlnString("Digite o nome: ");
                    int horas = Keyboard.readlnInt("Digite o tempo em horas: ");
                    interacao.acrescentarHorasParaFuncionario(nome, horas);
                    break;
            }
        }
    }
    
}
