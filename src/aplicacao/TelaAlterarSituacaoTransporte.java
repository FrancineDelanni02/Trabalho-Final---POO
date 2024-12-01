package aplicacao;

import dados.Estado;
import dados.Transporte;
import dados.TransporteColecao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAlterarSituacaoTransporte {
    private JTextArea textArea1;
    private JLabel labelTitulo;
    private JButton confirmarButton;
    private JTextField textFieldNmroT;
    private JComboBox comboBoxNovaSitu;
    private JButton voltarButton;
    private JButton terminarButton;
    private JLabel labelNmroT;
    private JLabel labelNovaSitu;
    private JButton limparButton;
    private JPanel painel;
    private JLabel labelNull;
    private JLabel labelNULL;
    private JPanel painelPrincipal;

    public TelaAlterarSituacaoTransporte(JPanel painelPrincipal,TransporteColecao transporteColecao) {
        this.painelPrincipal = painelPrincipal;

        comboBoxNovaSitu.setModel(new DefaultComboBoxModel<>(Estado.values()));

        terminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                textFieldNmroT.setText("");
                comboBoxNovaSitu.setSelectedIndex(0);
            }
        });

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textArea1.setText("");
                    int numero = Integer.parseInt(textFieldNmroT.getText());
                    Transporte t = transporteColecao.getTransporteNum(numero);
                    Estado estado = Estado.valueOf(comboBoxNovaSitu.getSelectedItem().toString());
                    transporteColecao.alterarSituacao(t, estado);
                    textArea1.setText(t.toString());
                } catch (Exception ex) {
                    textArea1.setText(ex.getMessage());
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
