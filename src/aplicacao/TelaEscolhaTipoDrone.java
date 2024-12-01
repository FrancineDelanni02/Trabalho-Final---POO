package aplicacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEscolhaTipoDrone {
    private JPanel painel;
    private JButton dronePessoalButton;
    private JButton droneDeCargaVivaButton;
    private JButton VOLTARButton;
    private JButton droneDeCargaInanimadaButton;

    private JPanel painelPrincipal;

    public TelaEscolhaTipoDrone(JPanel painelPrincipal) {
        this.painelPrincipal = painelPrincipal; // Recebe o painel principal

        VOLTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Voltar para a tela principal
                CardLayout layout = (CardLayout) painelPrincipal.getLayout();
                layout.show(painelPrincipal, "telaPrincipal"); // Trocar para "telaPrincipal"
            }
        });

        //Navegação para drone pessoal
        dronePessoalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) painelPrincipal.getLayout();
                layout.show(painelPrincipal, "cadastroDronePessoal");
            }
        });

        droneDeCargaVivaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) painelPrincipal.getLayout();
                layout.show(painelPrincipal, "cadastroDroneDeCargaViva");
            }
        });

        droneDeCargaInanimadaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) painelPrincipal.getLayout();
                layout.show(painelPrincipal, "cadastroDroneDeCargaInanimada");
            }
        });
    }

    public JPanel getPainel() {
        return painel;
    }

}
