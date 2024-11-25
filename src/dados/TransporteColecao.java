package dados;
import java.util.LinkedList;
import dados.Frota;
import java.util.ArrayList;

public class TransporteColecao {
    private ArrayList<Transporte> transportes;
    private Frota frota;

    public TransporteColecao(Frota frota){
        this.transportes = new ArrayList<>();
        this.frota = frota;
    }

    public boolean searchTransporte(Transporte t){
         return transportes.contains(t);
    }

    public boolean add(Transporte t) throws Exception {
        if(searchTransporte(t)){
            throw new Exception("Número de transporte repetido!");
        }
        transportes.add(t);
        return true;
    }

    public void alocarDrones() throws Exception {
        if(transportes.isEmpty())
            throw new Exception("Não há transportes na fila");

        for(Transporte t:transportes){
            Drone d = frota.getDroneDisponivel(t);
            if(d != null){
                t.setDrone(d);
                transportes.remove(t);
            }
        }
    }

    public void alterarSituacao(Transporte t,Estado situacao){
        t.setSituacao(situacao);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(transportes.isEmpty())
            throw new RuntimeException("Não há transportes na fila");

        for(Transporte t:transportes){
            sb.append(t.toString()).append("\n");
        }
        return sb.toString();
    }
}
