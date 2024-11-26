package aplicacao;

import dados.DronePessoal;
import dados.Frota;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroDronePessoal {
    private JPanel painel;
    private JTextArea textArea;
    private JButton ButtonLimparTd;
    private JButton ButtonMostrarDados;
    private JButton buttonConfirm;
    private JTextField textFieldCod;
    private JTextField textFieldAut;
    private JTextField textFieldQtdMax;
    private JTextField textFieldCustoF;
    private JLabel labelCod;
    private JLabel labelCustoF;
    private JLabel labelAut;
    private JLabel labelQtdMax;
    private JButton buttonTerminar;
    private JButton VOLTARLButton;
    private Frota frota = new Frota();

    private JPanel painelPrincipal;

    public CadastroDronePessoal(JPanel painelPrincipal) {
        this.painelPrincipal = painelPrincipal;

        buttonTerminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo = Integer.parseInt(textFieldCod.getText());
                    double custoFixo = Double.parseDouble(textFieldCustoF.getText());
                    double autonomia = Double.parseDouble(textFieldAut.getText());
                    int qtdMaxPessoas = Integer.parseInt(textFieldQtdMax.getText());

                    DronePessoal novoDrone = new DronePessoal(codigo, custoFixo, autonomia, qtdMaxPessoas);

                    if (frota.add(novoDrone)) {
                        textArea.append("Drone cadastrado com sucesso: " + novoDrone.getCodigo() + "\n");
                    } else {
                        textArea.append("Drone já existe!\n");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(painel, "Por favor, insira valores válidos.");
                }
            }
        });

        ButtonLimparTd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                textFieldCod.setText("");
                textFieldCustoF.setText("");
                textFieldAut.setText("");
                textFieldQtdMax.setText("");
            }
        });

        ButtonMostrarDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(frota.exibirDronesP());
            }
        });

        VOLTARLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Voltar para a tela de escolha de tipo de drone
                CardLayout layout = (CardLayout) painelPrincipal.getLayout();
                layout.show(painelPrincipal, "telaEscolhaTipoDrone");
            }
        });
    }

    public JPanel getPainel() {
        return painel;
    }

    public JButton getVOLTARLButton() {
        return VOLTARLButton;
    }
}
