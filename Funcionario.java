/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_gestao_petshop;

import javax.swing.JOptionPane;

/**
 *
 * @author jvmel
 */
public class Funcionario extends Pessoa{
    private String idFuncionario;
    private String Cargo;
    
    public Funcionario(String nome, String cpf,String idFuncionario,String cargo) {
        super(nome, cpf);
        this.idFuncionario = idFuncionario;
        this.Cargo = cargo;
    }
    
    public void executarServico(Servico servico){
        //servico.getClass().getSimplesName é utilizado para descobrir de forma dinamica qual tipo de servico está sendo
        //executado pelo funcionario.
        JOptionPane.showMessageDialog(null, "Executando o Serviço: "+servico.getClass().getSimpleName());
        servico.executarServico();
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "idFuncionario=" + idFuncionario + ", Cargo=" + Cargo + '}';
    }
    
    
    
    
    
}
