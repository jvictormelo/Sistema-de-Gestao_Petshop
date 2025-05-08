/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_gestao_petshop;


import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.time.LocalDateTime;
import java.time.LocalDate;
import javax.swing.JOptionPane;
/**
 *
 * @author jvmel
 */
public class SistemaPetShop {
    private List<Cliente> clientes;
    private List<Funcionario> funcionarios;
    //porque a utilização de map? basicamente precisamos de uma agenda com os servicos do dia e horario
    private Map<LocalDateTime, List<Servico>> agenda;

    public SistemaPetShop() {
        this.clientes = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        //Detalhe, a agenda só funciona se declararmos o Hashmap no construtor
        this.agenda = new HashMap<>();
    }
    
    //metodo para adicionar clientes
    public void cadastrarCliente(Cliente cliente){
        
        clientes.add(cliente); 
}
    //metodo para adicionar Funcionarios
    
    public void cadastrarFuncionario(Funcionario funcionario){
        
        funcionarios.add(funcionario);
    }
    //metodo para listar Clientes
    
    public void listarClientes(){
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não possui clientes cadastrados");
           
        }else{
        for(Cliente c : clientes){
           JOptionPane.showMessageDialog(null, c);
        }
            
        }
    }
    //metodo para listar Funcionarios
    public void listarFuncionarios(){
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não possui Funcionarios cadastrados");
            
        }else{
        for(Funcionario f : funcionarios){
            JOptionPane.showMessageDialog(null, f);
         
        }
            
        }
    }
    //metodo para agendar Servico
    public void agendarServico(Servico servico, LocalDateTime dataHora){
        agenda.putIfAbsent(dataHora,new ArrayList<>());
        agenda.get(dataHora).add(servico);
         JOptionPane.showMessageDialog(null, "Serviço agendado: "+ servico.getClass().getSimpleName()+  
                            " para "+ servico.animal.getNome() +
                            " em "+dataHora);
    }
    //metodo para consultar Agenda
    
    public void consultarAgenda(LocalDate data){
        boolean encontrou = false;
        for(Map.Entry<LocalDateTime, List<Servico>> entrada: agenda.entrySet()) {
            if(entrada.getKey().toLocalDate().equals(data)){
                if (!encontrou) {
                    JOptionPane.showMessageDialog(null, " Serviços agendados para "+data+" :");
                    encontrou = true;
                    
                }
                for(Servico s: entrada.getValue()){
                    JOptionPane.showMessageDialog(null, "- "+s.getClass().getSimpleName()+
                                        " para "+s.animal.getNome()+
                                         " ás " +entrada.getKey().toLocalTime());
            }
        }
    }if (!encontrou) {
          JOptionPane.showMessageDialog(null, " Nenhum Serviço agendado para "+data);
        }
    }
        public List<Cliente> getClientes() {
        return this.clientes;
    }

        public List<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    @Override
    public String toString() {
        return "SistemaPetShop{" + "clientes=" + clientes + ", funcionarios=" + funcionarios + ", agenda=" + agenda + '}';
    }
    
    
    
}












