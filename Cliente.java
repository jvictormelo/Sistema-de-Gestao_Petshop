/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_gestao_petshop;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jvmel
 */
public class Cliente extends Pessoa {
    private List<Animal> animais;

    public Cliente(String nome, String cpf) {
        super(nome, cpf);
        this.animais = new ArrayList<>();
    }
    
    public void adicionarAnimal(Animal animal){
        animais.add(animal);
    }
    public void listarAnimal(){
        if(animais.isEmpty()){
             JOptionPane.showMessageDialog(null, "Sem animais cadastrados para este Cliente");
             
        }else{
            for (Animal a : animais) {
            JOptionPane.showMessageDialog(null, a);
           
        }
        }
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    @Override
    public String toString() {
        return "Cliente{" + "animais=" + animais + '}';
    }
    
    
    
}
    