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
    private JPanel alterarSitTransp;
    private JPanel carregarDados;
    private JPanel salvarDados;
    private JPanel processarTranspPend;
    private JPanel mostrarTransp;
    private JPanel relatorioGeral;
    private JPanel leituraDados;

    public JanelaTelaPrincipal() {
        super();
        // Configurar painel principal com CardLayout
        painelPrincipal = new JPanel(new CardLayout());
        Frota frota = new Frota();
        TransporteColecao transporteColecao = new TransporteColecao(frota);
        GerenciadorDeDados gerenciador = new GerenciadorDeDados(frota,transporteColecao);

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

        CadastroTransporteCargaViva cadastroTransporteCargaViva = new CadastroTransporteCargaViva(painelPrincipal, transporteColecao);
        cadTransporteCargaViva = cadastroTransporteCargaViva.getPainel();

        CadastroTransporteCargaInanimada cadastroTransporteCargaInanimada = new CadastroTransporteCargaInanimada(painelPrincipal,transporteColecao);
        cadTransporteCargaInanimada = cadastroTransporteCargaInanimada.getPainel();

        TelaAlterarSituacaoTransporte telaAlterarSituacaoTransporte = new TelaAlterarSituacaoTransporte(painelPrincipal,transporteColecao);
        alterarSitTransp = telaAlterarSituacaoTransporte.getPainel();

        TelaCarregarDados telaCarregarDados = new TelaCarregarDados(painelPrincipal);
        carregarDados = telaCarregarDados.getPainel();

        TelaSalvarDados telaSalvarDados = new TelaSalvarDados(painelPrincipal,gerenciador);
        salvarDados = telaSalvarDados.getPainel();

        TelaProcessarTransportesPendentes telaProcessarTransportesPendentes = new TelaProcessarTransportesPendentes(painelPrincipal,transporteColecao,frota);
        processarTranspPend = telaProcessarTransportesPendentes.getPainel();

        TelaMostrarTransportes telaMostrarTransportes = new TelaMostrarTransportes(painelPrincipal,transporteColecao);
        mostrarTransp = telaMostrarTransportes.getPainel();

        TelaRelatorioGeral telaRelatorioGeral = new TelaRelatorioGeral(painelPrincipal,frota,transporteColecao);
        relatorioGeral = telaRelatorioGeral.getPainel();

        TelaLeituraDados telaLeituraDados = new TelaLeituraDados(painelPrincipal,gerenciador);
        leituraDados = telaLeituraDados.getPainel();

        // Adicionar as telas ao painel principal
        painelPrincipal.add(telaPrincipal.getPainel(), "telaPrincipal");
        painelPrincipal.add(escolhaTipoDrone, "telaEscolhaTipoDrone");
        painelPrincipal.add(cadastroDronePessoal, "cadastroDronePessoal");
        painelPrincipal.add(cadDroneCargaViva, "cadastroDroneDeCargaViva");
        painelPrincipal.add(cadDroneCargaInanimada, "cadastroDroneDeCargaInanimada");
        painelPrincipal.add(escolhaTipoTransporte, "escolhaTipoTransporte");
        painelPrincipal.add(cadTransporteCargaViva, "cadastroTransporteCargaViva");
        painelPrincipal.add(cadTransporteCargaInanimada, "cadastroTransporteCargaInanimada");
        painelPrincipal.add(alterarSitTransp, "telaAlterarSituacaoTransporte");
        painelPrincipal.add(carregarDados, "telaCarregarDados");
        painelPrincipal.add(salvarDados, "telaSalvarDados");
        painelPrincipal.add(processarTranspPend, "telaProcessarTransportesPendentes");
        painelPrincipal.add(mostrarTransp, "telaMostrarTransportes");
        painelPrincipal.add(relatorioGeral, "telaRelatorioGeral");
        painelPrincipal.add(leituraDados, "telaLeituraDados");

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
        telaPrincipal.getAlterarSituacaoTUmButton().addActionListener(e -> trocarTela("telaAlterarSituacaoTransporte"));
        telaPrincipal.getCarregarDadosButton().addActionListener(e -> trocarTela("telaCarregarDados"));
        telaPrincipal.getSalvarDadosButton().addActionListener(e -> trocarTela("telaSalvarDados"));
        telaPrincipal.getProcessarTransportesPendentesButton().addActionListener(e -> trocarTela("telaProcessarTransportesPendentes"));
        telaPrincipal.getMostrarTodosOsTransportesButton().addActionListener(e -> trocarTela("telaMostrarTransportes"));
        telaPrincipal.getMostrarRelatórioGeralButton().addActionListener(e -> trocarTela("telaRelatorioGeral"));
        telaPrincipal.getRealizarLeituraDeDadosButton().addActionListener(e -> trocarTela("telaLeituraDados"));
    }

    private void trocarTela(String nomeTela) {
        CardLayout layout = (CardLayout) painelPrincipal.getLayout();
        layout.show(painelPrincipal, nomeTela);
    }
}