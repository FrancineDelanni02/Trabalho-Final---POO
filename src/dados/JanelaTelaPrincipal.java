package dados;

import aplicacao.*;

import javax.swing.*;
import java.awt.*;
public class JanelaTelaPrincipal extends JFrame {
    private JPanel painelPrincipal; // Painel com CardLayout
    private TelaPrincipal telaPrincipal; // Tela inicial
    private JPanel escolhaTipoDrone; // tela adicional para escolher o tipo de drone
    private JPanel cadastroDronePessoal; // tela adicional de cadastro de drone pessoal
    private JPanel escolhaTipoTransporte;
    private JPanel cadDroneCargaViva;
    private JPanel cadDroneCargaInanimada;
    private JPanel cadTransportePessoal;
    private JPanel cadTransporteCargaViva;
    private JPanel cadTransporteCargaInanimada;

    public JanelaTelaPrincipal() {
        super();
        // Configurar painel principal com CardLayout
        painelPrincipal = new JPanel(new CardLayout());
        Frota frota = new Frota();

        // Criar as telas
        telaPrincipal = new TelaPrincipal();

        TelaEscolhaTipoDrone telaEscolhaTipoDrone = new TelaEscolhaTipoDrone(painelPrincipal);
        escolhaTipoDrone = telaEscolhaTipoDrone.getPainel();

        CadastroDronePessoal cadastroDrone = new CadastroDronePessoal(painelPrincipal);
        cadastroDronePessoal = cadastroDrone.getPainel();

        CadastroDroneDeCargaViva cadastroDroneDeCargaViva = new CadastroDroneDeCargaViva(frota,painelPrincipal);
        cadDroneCargaViva = cadastroDroneDeCargaViva.getPainel();

        CadastroDroneDeCargaInanimada cadastroDroneDeCargaInanimada = new CadastroDroneDeCargaInanimada(frota,painelPrincipal);
        cadDroneCargaInanimada = cadastroDroneDeCargaInanimada.getPainel();

        TelaEscolhaTipoTransporte telaEscolhaTransporte = new TelaEscolhaTipoTransporte(painelPrincipal);
        escolhaTipoTransporte = telaEscolhaTransporte.getPainel();

        CadastroTransportePessoal cadastroTransportePessoal = new CadastroTransportePessoal(painelPrincipal);
        cadTransportePessoal = cadastroTransportePessoal.getPainel();

        CadastroTransporteCargaViva cadastroTransporteCargaViva = new CadastroTransporteCargaViva(painelPrincipal);
        cadTransporteCargaViva = cadastroTransporteCargaViva.getPainel();

        CadastroTransporteCargaInanimada cadastroTransporteCargaInanimada = new CadastroTransporteCargaInanimada(painelPrincipal);
        cadTransporteCargaInanimada = cadastroTransporteCargaInanimada.getPainel();

        // Adicionar as telas ao painel principal
        painelPrincipal.add(telaPrincipal.getPainel(), "telaPrincipal");
        painelPrincipal.add(escolhaTipoDrone, "telaEscolhaTipoDrone");
        painelPrincipal.add(cadastroDronePessoal, "cadastroDronePessoal");
        painelPrincipal.add(cadDroneCargaViva, "cadastroDroneDeCargaViva");
        painelPrincipal.add(cadDroneCargaInanimada, "cadastroDroneDeCargaInanimada");
        painelPrincipal.add(escolhaTipoTransporte, "escolhaTipoTransporte");
        painelPrincipal.add(cadTransportePessoal, "cadastroTransportePessoal");
        painelPrincipal.add(cadTransporteCargaViva, "cadastroTransporteCargaViva");
        painelPrincipal.add(cadTransporteCargaInanimada, "cadastroTransporteCargaInanimada");

        // Configurar a navegação
        configurarNavegacao();

        // Configurar a janela
        this.add(painelPrincipal);
        setSize(800, 600);
        setTitle("Sistema de Gerenciamento da ACMEAirDrones");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void configurarNavegacao() {
        telaPrincipal.getCadastrarDroneButton().addActionListener(e -> trocarTela("telaEscolhaTipoDrone"));
        telaPrincipal.getCadastrarTransporteButton().addActionListener(e -> trocarTela("escolhaTipoTransporte"));

    }

    private void trocarTela(String nomeTela) {
        CardLayout layout = (CardLayout) painelPrincipal.getLayout();
        layout.show(painelPrincipal, nomeTela);
    }

}