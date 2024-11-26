package aplicacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroTransporteCargaViva {
    private JPanel painel;
    private JLabel labelTitulo;
    private JLabel labelNomeCliente;
    private JTextField textFieldNome;
    private JLabel labelNumero;
    private JTextField textFieldNmro;
    private JTextField textFieldDescricao;
    private JTextField textFieldPeso;
    private JLabel labelPeso;
    private JLabel labelDescricao;
    private JLabel labelLatOrig;
    private JTextField textFieldLatOrig;
    private JLabel labelLatDest;
    private JTextField textFieldLatDest;
    private JLabel labelLongOrig;
    private JLabel labelLongDest;
    private JTextField textFieldLongOrig;
    private JTextField textFieldLongDest;
    private JLabel labelEstado;
    private JComboBox estadoComboBox;
    private JLabel labelTempMax;
    private JTextField textFieldTempMax;
    private JTextArea textArea1;
    private JButton CONFIRMARCADASTRAMENTOButton;
    private JButton LIMPARTUDOButton;
    private JButton MOSTRARDADOSCADASTRADOSButton;
    private JButton TERMINARButton;
    private JButton VOLTARButton;
    private JTextField textFieldTempMin;
    private JLabel labelNULL;
    private JLabel labelTempMin;
    private JLabel labelNull;
    private JLabel labelNull1;

    private JPanel painelPrincipal;

    public CadastroTransporteCargaViva(JPanel painelPrincipal) {
        this.painelPrincipal = painelPrincipal;

        //falta os botoes de confirmar cadastramento e de mostrar dados cadastrados

        TERMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        LIMPARTUDOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                textFieldNome.setText("");
                textFieldNmro.setText("");
                textFieldDescricao.setText("");
                textFieldPeso.setText("");
                textFieldLatOrig.setText("");
                textFieldLatDest.setText("");
                textFieldLongOrig.setText("");
                textFieldLongDest.setText("");
                textFieldTempMax.setText("");
                textFieldTempMin.setText("");
                estadoComboBox.setSelectedIndex(0);
            }
        });

        VOLTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) painelPrincipal.getLayout();
                layout.show(painelPrincipal, "escolhaTipoTransporte");
            }
        });

        CONFIRMARCADASTRAMENTOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //cod aq
            }
        });

        MOSTRARDADOSCADASTRADOSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //cod aq
            }
        });
    }
    public JPanel getPainel() {
        return painel;
    }
}
