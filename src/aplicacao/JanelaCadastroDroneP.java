package dados;

import javax.swing.*;
import java.awt.*;

public class JanelaCadastroDroneP extends JFrame {
    private CadastroDronePessoal form;

    public JanelaCadastroDroneP() {
        super();
        form = new CadastroDronePessoal(); //cria um painel
        this.add(form.getPainel());//adicionar o painel que esta no form
        setSize(800,600);
        setTitle("Cadastro de drones pessoais");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
