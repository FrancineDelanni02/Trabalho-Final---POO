package aplicacao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dados.Frota;
import dados.TransporteColecao;

public class TelaRelatorioGeral {
    private JPanel painel;
    private JTextArea textArea1;
    private JButton mostrarRelatorioButton;
    private JButton voltarButton;
    private JLabel labelTitulo;
    private JLabel lab;
    private JLabel labelNull;
    private JLabel labelNUll;
    private JPanel painelPrincipal;

    public TelaRelatorioGeral(JPanel painelPrincipal,Frota frota,TransporteColecao transporteColecao) {
        this.painelPrincipal = painelPrincipal;

        mostrarRelatorioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                try {
                    textArea1.append(transporteColecao.toString());
                    textArea1.append(frota.toString());
                    System.out.println(frota);
                } catch (RuntimeException exception) {
                    textArea1.append("");
                }
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) painelPrincipal.getLayout();
                layout.show(painelPrincipal, "telaPrincipal"); // Trocar para "telaPrincipal"
            }
        });
    }
    public JPanel getPainel() {
        return painel;
    }
}
