package aplicacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEscolhaTipoTransporte {
    private JButton transportePessoalButton;
    private JButton transporteDeCargaInanimadaButton;
    private JButton transporteDeCargaVivaButton;
    private JButton VOLTARButton;
    private JPanel painel;

    private JPanel painelPrincipal;

    public TelaEscolhaTipoTransporte(JPanel painelPrincipal) {
        this.painelPrincipal = painelPrincipal;

        VOLTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) painelPrincipal.getLayout();
                layout.show(painelPrincipal, "telaPrincipal"); // Trocar para "telaPrincipal"
            }
        });

        transportePessoalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) painelPrincipal.getLayout();
                layout.show(painelPrincipal, "cadastroTransportePessoal");
            }
        });

        transporteDeCargaVivaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) painelPrincipal.getLayout();
                layout.show(painelPrincipal, "cadastroTransporteCargaViva");
            }
        });

        transporteDeCargaInanimadaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) painelPrincipal.getLayout();
                layout.show(painelPrincipal, "cadastroTransporteCargaInanimada");
            }
        });

    }
    public JPanel getPainel() {
        return painel;
    }
}
