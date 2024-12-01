package aplicacao;

import dados.GerenciadorDeDados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLeituraDados {
    private JPanel painel;
    private JTextField textFieldNomeArq;
    private JButton OKButton;
    private JTextArea textArea1;
    private JButton voltarButton;
    private JLabel labelTitulo;
    private JLabel labelNome;
    private JLabel labelNULL;

    private JPanel painelPrincipal;

    public TelaLeituraDados(JPanel painelPrincipal, GerenciadorDeDados gerenciador) {
        this.painelPrincipal = painelPrincipal;

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textFieldNomeArq.getText();
                textArea1.append(gerenciador.lerArquivo(name));
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