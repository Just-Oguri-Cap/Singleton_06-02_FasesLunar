package org.example.singleton_0602_rpg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    public Label label1;
    @FXML
    public Label label2;
    @FXML
    public Label label3;
    @FXML
    public Label label4;

    Jogadores godfrey = new Jogadores("Godfrey","Necromante", 5,50,120,14, Mesa.getInstanciaDaMesa("mesa 1"));
    Jogadores godefroy = new Jogadores("Godefroy","Exilado", 10,100,30,16, Mesa.getInstanciaDaMesa("mesa 2"));
    Jogadores godwyn = new Jogadores("Godwyn","Clérigo", 25,200,80,20, Mesa.getInstanciaDaMesa("mesa 3"));
    Jogadores morgot = new Jogadores("Morgot","Hemomante", 50,666,67,25, Mesa.getInstanciaDaMesa("mesa 4"));

    @FXML
    public void initialize (){
        updateText();
    }

    public void updateText() {
        label1.setText(godfrey.descricao());
        label2.setText(godefroy.descricao());
        label3.setText(godwyn.descricao());
        label4.setText(morgot.descricao());
    }

    @FXML
    public void btnCallBack(ActionEvent event) {

        godfrey.setNivel(godfrey.getNivel()+1);
        godefroy.setNivel(godefroy.getNivel()+1);
        godwyn.setNivel(godwyn.getNivel()+1);
        morgot.setNivel(morgot.getNivel()+1);
        updateText();
    }
}
