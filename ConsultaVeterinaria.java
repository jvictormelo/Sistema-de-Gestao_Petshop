/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_gestao_petshop;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author jvmel
 */
public class ConsultaVeterinaria extends Servico {

    public ConsultaVeterinaria(Animal animal, Funcionario funcionario) {
        super(animal);
    }

    @Override
    public void executarServico() {
        JOptionPane.showMessageDialog(null, "Consultando"+animal.getNome());
    }

    @Override
    public void agendar(LocalDateTime data) {
        JOptionPane.showMessageDialog(null, "Consultando"+data);
        
    }
    
    
    
    
}
