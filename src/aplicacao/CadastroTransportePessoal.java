package aplicacao;

import dados.DronePessoal;
import dados.Estado;
import dados.TransporteColecao;
import dados.TransportePessoal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroTransportePessoal {

    private JPanel painel;
    private JTextField textFieldNome;
    private JTextField textFieldNmro;
    private JTextField textFieldDescricao;
    private JTextField textFieldPeso;
    private JLabel labelNomeCliente;
    private JLabel labelNumero;
    private JLabel labelDescricao;
    private JLabel labelPeso;
    private JTextField textFieldLatOrig;
    private JLabel labelLatOrig;
    private JTextField textFieldLatDest;
    private JTextField textFieldLongOrig;
    private JTextField textFieldLongDest;
    private JTextField textFieldQtdPessoas;
    private JLabel labelQtdPessoas;
    private JTextArea textArea1;
    private JButton CONFIRMARCADASTRAMENTOButton;
    private JButton LIMPARTUDOButton;
    private JButton MOSTRARDADOSCADASTRADOSButton;
    private JButton TERMINARButton;
    private JButton VOLTARButton;
    private JLabel labelLatDest;
    private JLabel labelLongOrig;
    private JLabel labelLongDest;
    private JLabel labelTitulo;
    private JLabel labelNULL;
    private JLabel labelNull;
    private JLabel labelNull1;

    private JPanel painelPrincipal;
    private TransporteColecao transporteColecao;

    public CadastroTransportePessoal(JPanel painelPrincipal, TransporteColecao transporteColecao) { //------------> mudei aqui
        this.painelPrincipal = painelPrincipal;
        this.transporteColecao = transporteColecao; //-----------------> mudei aqui

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
                textFieldQtdPessoas.setText("");
            }
        });

        VOLTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) painelPrincipal.getLayout();
                layout.show(painelPrincipal, "escolhaTipoTransporte");
            }
        });

        MOSTRARDADOSCADASTRADOSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(transporteColecao.toString()); //--------------------------> testar
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
                    int qtdPessoas = Integer.parseInt(textFieldQtdPessoas.getText());

                    TransportePessoal novoTransporteP = new TransportePessoal(numero, nomeCliente, descricao, peso, latOrigem, latDest, longOrig, longDest, qtdPessoas);
                    if (transporteColecao.add(novoTransporteP)) {
                        textArea1.append("Transporte cadastrado com sucesso: " + novoTransporteP.getNumero() + "\n");
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
    }

    public JPanel getPainel() {
        return painel;
    }
}
