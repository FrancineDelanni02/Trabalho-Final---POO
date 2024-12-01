package aplicacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCarregarDados {
    private JPanel painel;
    private JLabel labelTitulo;
    private JTextField textField1;
    private JButton OKButton;
    private JButton voltarButton;

    private JPanel painelPrincipal;

    public TelaCarregarDados(JPanel painelPrincipal) {
        this.painelPrincipal = painelPrincipal;

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
