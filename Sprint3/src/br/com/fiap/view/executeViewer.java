package br.com.fiap.view;

import javax.swing.*;
import br.com.fiap.controller.MedicoController;
import br.com.fiap.controller.EquipamentoController;
import br.com.fiap.controller.InstitutoController;
import br.com.fiap.controller.TreinamentoController;

public class executeViewer {
    public static void main(String[] args) {
        int idMedico,idade,idTreinamento,idInstituto,idEquipamento,opcao1,opcao2;
        String nome,especialidade,titulo,status,endereco,descricao;
        String[] escolha1 = {"medico","treinamento","instituto","equipamento"};
        String[] escolha2 = {"inserir","alterar","excluir","listar"};
        MedicoController medicoController = new MedicoController();
        EquipamentoController equipamentoController = new EquipamentoController();
        InstitutoController institutoController = new InstitutoController();
        TreinamentoController treinamentoController = new TreinamentoController();
        do{
            try{
                opcao1 = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para decidir qual manipular", "Escolha", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,null,escolha1,escolha1[0]);
                switch(opcao1){
                    case 0:
                        opcao2 = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular o médico: ", "Escolha", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE,null,escolha2,escolha2[0]);
                        idMedico = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do médico: "));
                        switch(opcao2){
                            case 0:
                                nome = JOptionPane.showInputDialog("Digite o nome do médico: ");
                                idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do médico: "));
                                especialidade = JOptionPane.showInputDialog("Digite a especialidade do médico: ");
                                idInstituto = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do instituto: "));
                                idEquipamento = Integer.parseInt(JOptionPane.showInputDialog("Digite o id od equipamento que o aluno possui: "));
                                System.out.println(medicoController.inserirMedico(idMedico,nome,idade,especialidade,idInstituto,idEquipamento));
                                break;
                            case 1:
                                nome = JOptionPane.showInputDialog("Digite o nome do médico: ");
                                idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do médico: "));
                                especialidade = JOptionPane.showInputDialog("Digite a especialidade do médico: ");
                                idInstituto = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do instituto: "));
                                idEquipamento = Integer.parseInt(JOptionPane.showInputDialog("Digite o id od equipamento que o aluno possui: "));
                                System.out.println(medicoController.alterarMedico(idMedico,nome,idade,especialidade,idInstituto,idEquipamento));
                                break;
                            case 2:
                                System.out.println(medicoController.excluirMedico(idMedico));
                                break;
                            case 3:
                                System.out.println(medicoController.listarUmMedico(idMedico));
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                        break;
                    case 1:
                        opcao2 = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular o treinamento: ", "Escolha", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE,null,escolha2,escolha2[0]);
                        idTreinamento = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do treinamento: "));
                        switch(opcao2){
                            case 0:
                                idMedico = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do medico: "));
                                titulo = JOptionPane.showInputDialog("Digite o titulo do treinamento: ");
                                status = JOptionPane.showInputDialog("Digite o status do treinamento: ");
                                System.out.println(treinamentoController.inserirTreinamento(idTreinamento,titulo,status,idMedico));
                                break;
                            case 1:
                                idMedico = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do medico: "));
                                titulo = JOptionPane.showInputDialog("Digite o titulo do treinamento: ");
                                status = JOptionPane.showInputDialog("Digite o status do treinamento: ");
                                System.out.println(treinamentoController.alterarTreinamento(idTreinamento,titulo,status,idMedico));
                                break;
                            case 2:
                                System.out.println(treinamentoController.excluirTreinamento(idTreinamento));
                                break;
                            case 3:
                                System.out.println(treinamentoController.listarUmTreinamento(idTreinamento));
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                        break;
                    case 2:
                        opcao2 = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular o instituto: ", "Escolha", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE,null,escolha2,escolha2[0]);
                        idInstituto = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do instituto: "));
                        switch(opcao2){
                            case 0:
                                nome = JOptionPane.showInputDialog("Digite o nome do instituto:  ");
                                endereco = JOptionPane.showInputDialog("Digite o endereço: ");
                                System.out.println(institutoController.inserirInstituto(idInstituto,nome,endereco));
                                break;
                            case 1:
                                nome = JOptionPane.showInputDialog("Digite o nome do instituto:  ");
                                endereco = JOptionPane.showInputDialog("Digite o endereço: ");
                                System.out.println(institutoController.alterarInstituto(idInstituto,nome,endereco));
                                break;
                            case 2:
                                System.out.println(institutoController.excluirInstituto(idInstituto));
                                break;
                            case 3:
                                System.out.println(institutoController.listarUmInstituto(idInstituto));
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                        break;
                    case 3:
                        opcao2 = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular o instituto: ", "Escolha", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE,null,escolha2,escolha2[0]);
                        idEquipamento = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do equipamento: "));
                        switch(opcao2){
                            case 0:
                                idInstituto = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do instituto: "));
                                descricao = JOptionPane.showInputDialog("Digite a descrição do equipamento: ");
                                System.out.println(equipamentoController.inserirEquipamento(idEquipamento,descricao,idInstituto));
                                break;
                            case 1:
                                idInstituto = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do instituto: "));
                                descricao = JOptionPane.showInputDialog("Digite a descrição do equipamento: ");
                                System.out.println(equipamentoController.alterarEquipamento(idEquipamento,descricao,idInstituto));
                                break;
                            case 2:
                                System.out.println(equipamentoController.excluirEquipamento(idEquipamento));
                                break;
                            case 3:
                                System.out.println(equipamentoController.listarUmEquipamento(idEquipamento));
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            }catch(Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
        }while (JOptionPane.showConfirmDialog(null, "Deseja continuar ?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim do programa");
    }
}
