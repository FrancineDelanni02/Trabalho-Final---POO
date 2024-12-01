package aplicacao;

import dados.Frota;
import dados.TransporteColecao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaProcessarTransportesPendentes {
    private JPanel painel;
    private JTextArea textArea1;
    private JButton processarTransportesPendentesButton;
    private JButton voltarButton;
    private JLabel labelNULL;

    private JPanel painelPrincipal;
    private TransporteColecao transporteColecao;
    private Frota frota;


    public TelaProcessarTransportesPendentes(JPanel painelPrincipal, TransporteColecao transporteColecao, Frota frota) {
        this.painelPrincipal = painelPrincipal;
        this.transporteColecao = transporteColecao;
        this.frota = frota;

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) painelPrincipal.getLayout();
                layout.show(painelPrincipal, "telaPrincipal"); // Trocar para "telaPrincipal"
            }
        });

        processarTransportesPendentesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    transporteColecao.alocarDrones(); // Processa os transportes
                    textArea1.setText("Transportes processados com sucesso:\n"
                            + transporteColecao.toString()
                            + "\n\nDrones disponíveis:\n"
                            + frota.exibirDronesP());
                } catch (Exception ex) {
                    textArea1.setText("Erro: " + ex.getMessage());
                }
            }
        });
    }
    public JPanel getPainel() {
        return painel;
    }
}
