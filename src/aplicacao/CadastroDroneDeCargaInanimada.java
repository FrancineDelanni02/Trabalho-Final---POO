package aplicacao;
import dados.DroneCargaInanimada;
import dados.Drone;
import dados.Frota;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroDroneDeCargaInanimada extends JPanel{

        private JPanel painel;
        private JTextArea textArea;
        private JButton ButtonLimparTd;
        private JButton ButtonMostarDados;
        private JButton buttonConfirm;
        private JLabel labelCod;
        private JLabel labelAuto;
        private JLabel labelPesoMax;
        private JLabel labelCusto;
        private JTextField textFieldAuto;
        private JTextField textFieldPesoMax;
        private JTextField textFieldCod;
        private JTextField textFieldCustoF;
        private JButton buttonTerminar;
        private JRadioButton protecaoRadioButton;
        private Frota frota;

    public CadastroDroneDeCargaInanimada(Frota frota) {
            super();
            this.frota = frota;

            buttonTerminar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            buttonConfirm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setText("");
                    Integer cod = Integer.parseInt(textFieldCod.getText());
                    double custo = Double.parseDouble(textFieldCustoF.getText());
                    double auto = Double.parseDouble(textFieldAuto.getText());
                    double peso = Double.parseDouble(textFieldPesoMax.getText());
                    boolean radioButton = protecaoRadioButton.isSelected();
                    Drone drone = new DroneCargaInanimada(cod,custo,auto,peso,radioButton);
                    try{
                        frota.add(drone);
                        textArea.append("Drone cadastrado com sucesso!");
                    }catch(Exception exception){
                        textArea.append(exception.getMessage());
                    }
                }
            });

            ButtonMostarDados.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setText("");
                    textArea.append(frota.toString());
                }
            });

            ButtonLimparTd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setText("");
                    textFieldAuto.setText("");
                    textFieldPesoMax.setText("");
                    textFieldCod.setText("");
                    textFieldCustoF.setText("");
                    protecaoRadioButton.setSelected(false);
                }
            });
        }

        public JPanel getPainel() {
            painel.setPreferredSize(new Dimension(800, 600));
            return painel;
        }
    }
