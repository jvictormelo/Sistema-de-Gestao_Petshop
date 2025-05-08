/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_gestao_petshop;

/**
 *
 * @author jvmel
 */
public abstract class Servico implements Agendavel{
    protected Animal animal;
    
    public Servico(Animal animal){
        this.animal = animal;
    }
        public abstract void executarServico();
}
