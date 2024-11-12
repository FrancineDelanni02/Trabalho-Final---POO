package aplicacao;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;

public class cadastroCarga extends JFrame {

    private JButton xButton,okButton,limparButton,mostrarButton;
    private JLabel codigo,custoFixo,autonomia;
    private JTextField Tcodigo,TcustoFixo,Tautonomia;

    public cadastroCarga(){
        super();

        JPanel container = new JPanel();
        FlowLayout flow = new FlowLayout();
        GridLayout grid = new GridLayout();

        //topo --> titulo e botão de sair
        JPanel top = new JPanel();
        top.setLayout(flow);
        JLabel cadastro = new JLabel("CADASTRO DE DRONES");
        top.add(cadastro);
        container.add(top);

        JPanel textFields = new JPanel();
        textFields.setLayout(flow);

        //campos de textos da esquerda
        JPanel leftText = new JPanel();
        leftText.setLayout(new GridLayout(3,3));
        codigo = new JLabel("Código");
        Tcodigo = new JTextField();
        leftText.add(codigo);
        leftText.add(Tcodigo);

        custoFixo = new JLabel("Custo Fixo");
        TcustoFixo = new JTextField();
        leftText.add(custoFixo);
        leftText.add(Tcodigo);

        textFields.add(leftText);
        container.add(textFields);
        this.add(container);
        this.setTitle("Cadastro de Drone");
        this.setSize(800, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
