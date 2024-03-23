package estudeAqui;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Ouvidoria {

	public static void main(String[] args) {
		
		
		ArrayList<String> recla= new ArrayList<String>();
		
		int opcao; // variavel para o while não dar erro, se ficar apenas dentro do while ela fica em loop infinito.
		
		
		do {
		//menu
		String opcaoStr=JOptionPane.showInputDialog("             - Manifestações -\n1) Listar os Feedbacks\n2) Adicionar um Feedback\n3) Remover um Feedback\n4) Pesquisar pelo Código\n5) Sair");
		
		opcao = Integer.parseInt(opcaoStr); //transforma a String em Integer.
		
			if(opcao==1) { //opçao deve ser igual a 1 para entrar nessa janela
				
					if(recla.size() > 0) { //Puxa o número de feedbacks registrados caso seja maior que 0
					
					String reclamacoes = "             - Lista de Reclamações -               \n"; //cria uma variavel que guarda os feedbacks
					
					for (String feedback : recla) {
						reclamacoes += "- " + feedback + "\n"; // Organiza os Feedbacks
					}
					
					JOptionPane.showMessageDialog(null, reclamacoes); //imprime os feedbacks
					
					
				} else { //caso não tenha feedbacks, ou seja, feedbacks = 0, ele imprime isso abaixo:
					
					JOptionPane.showMessageDialog(null, "Não há feedbacks registrados.");
				}
				
				
			}else if (opcao==2) { //opçao deve ser igual a 2 para entrar nessa janela
				//Adicionar Reclamação
				String reclamacao = JOptionPane.showInputDialog("             - Adicionar Reclamação -            \n\nDigite sua reclamação:");
				recla.add(reclamacao); //Adiciona no ArrayList a reclamação escrita
				JOptionPane.showMessageDialog(null, "Feedback registrado com sucesso!"); // Confirma para o cliente o feedback no ArrayList
				
			}else if (opcao==3) { //opçao deve ser igual a 3 para entrar nessa janela
				if(recla.size()>0) {
					String ListaReclamacoes = "             - Lista de Feedbacks para Remoção -             \n";
					for (int numerofeedback = 0; numerofeedback <recla.size();numerofeedback++) { //for para consultar a lista e ir de um em um (1+1+1+1+1)
						ListaReclamacoes+=numerofeedback+1 +"° Feedback: "+recla.get(numerofeedback)+"\n"; // Código para listar antes da opção de remover
					}
					JOptionPane.showMessageDialog(null, ListaReclamacoes); //Aparece na tela a lista de feedbacks
					String removerFeedbackStr = JOptionPane.showInputDialog("Digite um Feedback para removê-lo da lista: ");//Pede ao usuário para digitar um numero de feedback
					int removerFeedback = Integer.parseInt(removerFeedbackStr); //Converte de String para inteiro
					int remocaoFeedback=removerFeedback-1;
						if(remocaoFeedback>=1 && remocaoFeedback<=recla.size()) {
								recla.remove(remocaoFeedback); // remove o feedback de acordo com a numeração do usuário
								JOptionPane.showMessageDialog(null, "Feedback removido com sucesso!"); //Concluído
						}else {
						JOptionPane.showMessageDialog(null, "Posição inválida!");
						}
				}else {
					JOptionPane.showMessageDialog(null, "Não existem Feedbacks a serem removidos.\nAdicione um filme primeiro para aparecer na lista!"); // Se não tiver nada na lista, isso aparece
				}	
			
			}else if(opcao==4) { //opçao deve ser igual a 4 para entrar nessa janela
				if(recla.size()>0) {
					String pesquisarFeedbackStr=JOptionPane.showInputDialog("Digite um código de um Feedback para pesquisar:"); //Pede para digitar um código
					int pesquisarFeedback = Integer.parseInt(pesquisarFeedbackStr);//Converte String para inteiro
					if(pesquisarFeedback>=1 && pesquisarFeedback<=recla.size()) {//Se for igual a quantidade de elementos na lista, ele entra
					String feedbackBuscado=recla.get(pesquisarFeedback-1); //Pesquisa de acordo com o que o usuário quer
					JOptionPane.showMessageDialog(null, "Feedback buscado foi:\n Feedback: "+feedbackBuscado);//Concluído
					}else {
						JOptionPane.showMessageDialog(null, "Posição Inválida!"); // Se estiver com uma posição fora da lista
					}
				}else{
					JOptionPane.showMessageDialog(null, "Não existem feedbacks a serem pesquisados.");//Não há Feedbacks listados.
				}
					
			}
			else if (opcao!=5) {
				
				JOptionPane.showMessageDialog(null, "Inválido"); // Caso a opcao esteja fora do numero que está na lista, ele imprime isso.
				
			}
	
		}while (opcao!=5);
		
		JOptionPane.showMessageDialog(null, "Obrigado por usar o sistema"); //Agradecimento por usar o aplicativo, já que digitando 4 ele sai do while.
		
	}
}
