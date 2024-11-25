package dados;
import java.util.LinkedList;
import dados.Frota;
import java.util.ArrayList;

public class TransporteColecao {
    private ArrayList<Transporte> transportes; //ArrayList com todos os transportes criados
    private ArrayList<Transporte> pendentes; //ArrayList somente para os transporte com estado PENDENTE
    private Frota frota;

    public TransporteColecao(Frota frota){
        this.transportes = new ArrayList<>();
        this.pendentes = new ArrayList<>();
        this.frota = frota;
    }

    public boolean searchTransporte(Transporte t){
        for(Transporte tr:transportes){
            if(tr.getNumero() == t.getNumero())
                return true;
        }
         return false;
    }

    public boolean add(Transporte t) throws Exception {
        if(searchTransporte(t)){
            throw new Exception("Número de transporte repetido!");
        }
        transportes.add(t);
        pendentes.add(t);
        return true;
    }

    //verifica somente a fila de transportes com a situação como pendente
    public void alocarDrones() throws Exception {
        if(pendentes.isEmpty())
            throw new Exception("Não há transportes na fila");

        for(Transporte t:pendentes){
            Drone d = frota.getDroneDisponivel(t);
            if(d != null){
                t.setDrone(d);
                pendentes.remove(t);
            }
        }
    }

    public void alterarSituacao(Transporte t,Estado situacao){
        t.setSituacao(situacao);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(transportes.isEmpty())
            throw new RuntimeException("Não há transportes cadastrados!");

        for(Transporte t:transportes){
            sb.append(t.toString()).append("\n");
        }
        return sb.toString();
    }
}
