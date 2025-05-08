package sistema_gestao_petshop;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args) {
      boolean rodando = true;
      SistemaPetShop sistema = new SistemaPetShop();
      
      while(rodando){
          String iniciar = JOptionPane.showInputDialog("Você gostaria de iniciar o Sistema de Gestão? ");
            if (!iniciar.equalsIgnoreCase("sim")) {
                JOptionPane.showMessageDialog(null,"Encerrando sistema...");
                rodando = false;
      }else{
                do {            
            
                
                String escolhaStr = JOptionPane.showInputDialog(    "\n----------  Sistema de Gestão ----------"+
                                                "\n 1 - Cadastrar Cliente"+
                                                "\n 2 - Cadastrar Funcionario"+
                                                "\n 3 - Agendar Servico"+
                                                "\n 4 - Listar Clientes"+ 
                                                "\n 5 - Listar Funcionarios"+
                                                "\n 6 - Consultar Agenda "+
                                                "\n 7 - Sair do menu");  
                int escolha = Integer.parseInt(escolhaStr);
                
                switch (escolha) {
                    case 1:
                            String nome = JOptionPane.showInputDialog("Entre com o nome do Cliente: ");
                            String cpf = JOptionPane.showInputDialog("Entre com o cpf do Cliente");
                            
                            Cliente cliente = new Cliente(nome,cpf);
                            sistema.cadastrarCliente(cliente);
                            
                            String especie = JOptionPane.showInputDialog("Entre com o tipo do Animal: Cachorro ou Gato ");
                            nome = JOptionPane.showInputDialog("Entre com o nome do Animal: ");
                            String idadeStr = JOptionPane.showInputDialog("Entre com a idade da "+nome);
                            int idade = Integer.parseInt(idadeStr);
                            if (especie.equalsIgnoreCase("Cachorro")) {
                            
                            Animal animal = new Cachorro(nome,idade);
                            cliente.adicionarAnimal(animal);
                        }else{
                               Animal animal = new Gato(nome,idade);
                               cliente.adicionarAnimal(animal);
                            }
                        break;
                    case 2:
                            
                             nome = JOptionPane.showInputDialog("Entre com o nome do Funcionario: ");
                             cpf = JOptionPane.showInputDialog("Entre com o cpf do Funcionario" + nome);
                             String id = JOptionPane.showInputDialog("Entre com a ID do Funcionario "+nome );
                             String adm = JOptionPane.showInputDialog("Entre com o Cargo do Funcionario "+nome);
                             Funcionario funcionario = new Funcionario(nome,cpf,id,adm);
                             sistema.cadastrarFuncionario(funcionario);
                             break;
                             
                    case 3: 
                            try{
                                List<Cliente> clientes = sistema.getClientes();
                            if (clientes.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado.");
                                break;
                            }

                            String listCli = "";
                            for (int i = 0; i < clientes.size(); i++) {
                                listCli += i + " - " + clientes.get(i).getNome() + "\n";
                            }
                            int idxCliente = Integer.parseInt(JOptionPane.showInputDialog("Escolha o cliente:\n" + listCli));
                            Cliente clienteSel = clientes.get(idxCliente);

                            List<Animal> animais = clienteSel.getAnimais();
                            if (animais.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Este cliente não possui animais cadastrados.");
                                break;
                            }

                            String listAni = "";
                            for (int i = 0; i < animais.size(); i++) {
                                listAni += i + " - " + animais.get(i).getNome() + "\n";
                            }
                            int idxAnimal = Integer.parseInt(JOptionPane.showInputDialog("Escolha o animal:\n" + listAni));
                            Animal animalSel = animais.get(idxAnimal);

                            // Buscar funcionário
                            List<Funcionario> funcionarios = sistema.getFuncionarios();
                            if (funcionarios.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Nenhum funcionário cadastrado.");
                                break;
                            }

                            String listFunc = "";
                            for (int i = 0; i < funcionarios.size(); i++) {
                                listFunc += i + " - " + funcionarios.get(i).getNome() + "\n";
                            }
                            int idxFunc = Integer.parseInt(JOptionPane.showInputDialog("Escolha o funcionário:\n" + listFunc));
                            Funcionario funcSel = funcionarios.get(idxFunc);

                            // Tipo de serviço
                            int tipo = Integer.parseInt(JOptionPane.showInputDialog("Tipo de serviço:\n1 - Banho\n2 - Tosa \n3 - Consulta Veterinária"));
                            Servico servico;
                            if (tipo == 1) {
                                servico = new Banho(animalSel, funcSel);
                            }else if (tipo == 2) {
                                servico = new Tosa(animalSel, funcSel);
                            }
                            else if(tipo == 3){
                                servico = new ConsultaVeterinaria(animalSel, funcSel);
                            }else{
                                JOptionPane.showMessageDialog(null, "Opção invalida, tente novamente!");
                                break;
                            }
                                

                            // Data e hora
                            String dataStr = JOptionPane.showInputDialog("Digite a data (AAAA-MM-DD):");
                            LocalDate data = LocalDate.parse(dataStr);
                            int hora = Integer.parseInt(JOptionPane.showInputDialog("Digite a hora (0-23):"));
                            int minuto = Integer.parseInt(JOptionPane.showInputDialog("Digite os minutos (0-59):"));
                            LocalDateTime dataHora = LocalDateTime.of(data, LocalTime.of(hora, minuto));

                            // Agendar
                            sistema.agendarServico(servico, dataHora);
                            JOptionPane.showMessageDialog(null, "Serviço agendado com sucesso!");

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Erro ao agendar serviço: " + e.getMessage());
                        }
                        break;
                            
                            
                    case 4:
                            sistema.listarClientes();
                            break;
                            
                    case 5: 
                            sistema.listarFuncionarios();
                            break;
                    case 6:try {
                            String entrada = JOptionPane.showInputDialog("Entre com a data desejada (AAAA-MM-DD):");
                            LocalDate dataConsulta = LocalDate.parse(entrada); // formato ISO: 2025-04-23, por exemplo
                            sistema.consultarAgenda(dataConsulta);
                            } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Data inválida! Use o formato AAAA-MM-DD.");
                            }
                        break;
                    case 7:
                        rodando = false;
                        System.out.println("saindo...");
                        break;
                        
                    default:
                        System.out.println("Numero Invalido! Tente novamente");
                        break;
                }
                
              String iniciando = JOptionPane.showInputDialog("Você gostaria de continuar o Sistema de Gestão? ");
            if (!iniciando.equalsIgnoreCase("sim")) {
                JOptionPane.showMessageDialog(null,"Encerrando sistema...");
                rodando = false;
            }else{
                rodando = true;
                
            }

        } while (rodando); 
            }
      }
      
      
       
        
//      SistemaPetShop sistema = new SistemaPetShop();
//      
//      
//      Cliente c1 = new Cliente("Pietra","01221093924");
//      sistema.cadastrarCliente(c1);
//      Animal atena = new Cachorro("Atena", 7);
//      c1.adicionarAnimal(atena);
//      Funcionario f1 = new Funcionario("João","012.210.939.24", "01", "Administrador");
//      sistema.cadastrarFuncionario(f1);
//      sistema.listarClientes();
//      sistema.listarFuncionarios();
//      Servico servico = new Banho(atena);
//      sistema.agendarServico(servico, LocalDateTime.of(2025, Month.APRIL, 28, 15, 20));
//      sistema.consultarAgenda(LocalDate.of(2025, Month.APRIL, 28));
    }
    
}
