package dados;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroDronePessoal {
    private JPanel painel;
    private JTextArea textArea;
    private JButton ButtonLimparTd;
    private JButton ButtonMostarDados;
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


    public CadastroDronePessoal() {
        buttonTerminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto1 = textFieldCod.getText();
                String texto2 = textFieldCustoF.getText();
                String texto3 = textFieldAut.getText();
                String texto4 = textFieldQtdMax.getText();
                textArea.append(texto1+"; "+texto2+"; "+texto3+"; "+texto4+"\n");
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
    }

    public JPanel getPainel() {
        return painel;
    }
}
