package aplicacao;

import dados.TransporteColecao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMostrarTransportes {
    private JTextArea textArea1;
    private JButton mostrarTransportesButton;
    private JButton voltarButton;
    private JLabel labelNULL;
    private JLabel labelNull;
    private JLabel labelTitulo;
    private JPanel painel;

    private JPanel painelPrincipal;
    private TransporteColecao transporteColecao;

    public TelaMostrarTransportes(JPanel painelPrincipal, TransporteColecao transporteColecao) {
        this.painelPrincipal = painelPrincipal;
        this.transporteColecao = transporteColecao;

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) painelPrincipal.getLayout();
                layout.show(painelPrincipal, "telaPrincipal"); // Trocar para "telaPrincipal"
            }
        });

        mostrarTransportesButton.addActionListener(new ActionListener() { //-------------------------------------->revisar e ver se eh isso
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String transportes = transporteColecao.toString();
                    textArea1.setText(transportes); // Exibir transportes na área de texto
                } catch (RuntimeException ex) {
                    textArea1.setText("Não há transportes cadastrados."); // Mensagem de erro
                }
            }
        });
    }
    public JPanel getPainel() {
        return painel;
    }
}
