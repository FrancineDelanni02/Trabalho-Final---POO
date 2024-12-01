package aplicacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dados.GerenciadorDeDados;
import dados.TransporteColecao;
import dados.Frota;

public class TelaSalvarDados {
    private JPanel painel;
    private JButton voltarButton;
    private JTextField textField1;
    private JButton OKButton;

    private JPanel painelPrincipal;

    public TelaSalvarDados(JPanel painelPrincipal,GerenciadorDeDados gerenciador) {
        this.painelPrincipal = painelPrincipal;

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = textField1.getText();
                    gerenciador.salvar(name);
                }catch(RuntimeException rte){
                    JOptionPane.showMessageDialog(painel, "Erro ao gravar em arquivo: " + rte.getMessage());
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
