package aplicacao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroDrones extends JPanel{
    private JButton inanimadaButton;
    private JPanel panel1;
    private JButton vivaButton;

    public CadastroDrones(JanelaCadastroDrone janela){
        super();
        inanimadaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela.mudaPainel(1);
            }
        });

        vivaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela.mudaPainel(2);
            }
        });
    }

    public JPanel getPainel(){
        panel1.setPreferredSize(new Dimension(800, 600));
        return panel1;
    }
}
