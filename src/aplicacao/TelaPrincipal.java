package aplicacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal {
    private JLabel labelNome;
    private JPanel painel;
    private JLabel labelMenu;
    private JButton cadastrarDroneButton;
    private JButton cadastrarTransporteButton;
    private JButton mostrarRelatórioGeralButton;
    private JButton processarTransportesPendentesButton;
    private JButton realizarLeituraDeDadosButton;
    private JButton alterarSituacaoTUmButton;
    private JButton salvarDadosButton;
    private JButton mostrarTodosOsTransportesButton;
    private JButton carregarDadosButton;
    private JButton finalizarSistemaButton;
    private JLabel labelNULL;

    public JPanel getPainel() {
        return painel;
    }
     public TelaPrincipal() {

         finalizarSistemaButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 System.exit(0);
             }
         });
     }

    public JButton getCadastrarTransporteButton() {
        return cadastrarTransporteButton;
    }

    public JButton getCadastrarDroneButton() {
        return cadastrarDroneButton;
    }

    public JButton getAlterarSituacaoTUmButton() {
        return alterarSituacaoTUmButton;
    }

    public JButton getCarregarDadosButton() {
        return carregarDadosButton;
    }

    public JButton getSalvarDadosButton() {
        return salvarDadosButton;
    }

    public JButton getProcessarTransportesPendentesButton() {
        return processarTransportesPendentesButton;
    }

    public JButton getMostrarTodosOsTransportesButton() {
        return mostrarTodosOsTransportesButton;
    }

    public JButton getRealizarLeituraDeDadosButton() {
        return realizarLeituraDeDadosButton;
    }

    public JButton getMostrarRelatórioGeralButton() {
        return mostrarRelatórioGeralButton;
    }
}
