package aplicacao;
import dados.*;

public class ACMEAirDrones {
    private Frota frota;
    private TransporteColecao transportes;

    public ACMEAirDrones(){
        this.frota = new Frota();
        this.transportes = new TransporteColecao(frota);
    }

    public void executar() throws Exception {
        new JanelaTelaPrincipal();
    }
}