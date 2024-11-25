package aplicacao;
import javax.swing.*;
import dados.Frota;

public class JanelaCadastroDrone extends JFrame {
    private CadastroDrones cadastro;
    private CadastroDroneDeCargaInanimada cadastro1;
    private CadastroDroneDeCargaViva cadastro2;

    public JanelaCadastroDrone(Frota frota) {
        super();

        cadastro = new CadastroDrones(this);
        cadastro1 = new CadastroDroneDeCargaInanimada(frota);
        cadastro2 = new CadastroDroneDeCargaViva(frota);
        this.add(cadastro.getPainel());
        setSize(800, 600);
        setTitle("Cadastro de drones");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void mudaPainel(int number){
        switch(number) {
            case 1:
                this.setContentPane(cadastro1.getPainel());
                break;
            case 2:
                this.setContentPane(cadastro2.getPainel());
                break;
        }
        this.revalidate();
        this.repaint();
    }
}
