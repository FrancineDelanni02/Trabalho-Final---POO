package aplicacao;

import dados.Estado;
import dados.TransporteCargaInanimada;
import dados.TransporteColecao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroTransporteCargaInanimada {
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
    private JTextArea textArea1;
    private JButton CONFIRMARCADASTRAMENTOButton;
    private JButton LIMPARTUDOButton;
    private JButton MOSTRARDADOSCADASTRADOSButton;
    private JButton TERMINARButton;
    private JButton VOLTARButton;
    private JLabel labelNULL;
    private JLabel labelNull;
    private JLabel labelNull1;
    private JRadioButton cargaPerigosaRadioButton;

    private JPanel painelPrincipal;
    private TransporteColecao transporteColecao;

    public CadastroTransporteCargaInanimada(JPanel painelPrincipal, TransporteColecao transporteColecao) {
        this.painelPrincipal = painelPrincipal;
        this.transporteColecao = transporteColecao;

        estadoComboBox.setModel(new DefaultComboBoxModel<>(Estado.values()));

        TERMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        VOLTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) painelPrincipal.getLayout();
                layout.show(painelPrincipal, "escolhaTipoTransporte");
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
                cargaPerigosaRadioButton.setSelected(false);
                estadoComboBox.setSelectedIndex(0);
            }
        });
        CONFIRMARCADASTRAMENTOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldNome.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(painel, "O campo Nome não pode estar vazio!");
                    return;
                }
                try {
                    int numero = Integer.parseInt(textFieldNmro.getText());
                    String nomeCliente = textFieldNome.getText(); //ver se isso ta certo
                    String descricao = textFieldDescricao.getText();
                    double peso = Double.parseDouble(textFieldPeso.getText());
                    double latOrigem = Double.parseDouble(textFieldLatOrig.getText());
                    double latDest = Double.parseDouble(textFieldLatDest.getText());
                    double longOrig = Double.parseDouble(textFieldLongOrig.getText());
                    double longDest = Double.parseDouble(textFieldLongDest.getText());
                    boolean radioButton = cargaPerigosaRadioButton.isSelected();
                    Estado situacao = (Estado) estadoComboBox.getSelectedItem(); //nao tenho certeza se vai funcionar

                    TransporteCargaInanimada novoTransporteCIn = new TransporteCargaInanimada(numero, nomeCliente, descricao, peso, latOrigem, latDest, longOrig, longDest, radioButton);
                    if (transporteColecao.add(novoTransporteCIn)) {
                        textArea1.append("Transporte cadastrado com sucesso: " + novoTransporteCIn.getNumero() + "\n");
                    } else {
                        textArea1.append("Transporte já existe!" + "\n");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(painel, "Por favor, insira valores válidos.");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(painel, "Erro ao cadastrar transporte: " + ex.getMessage());
                }
            }
        });

        MOSTRARDADOSCADASTRADOSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(transporteColecao.toString()); //--------------------------> testar
            }
        });
    }
    public JPanel getPainel() {
        return painel;
    }
}
