package dados;
import java.util.LinkedList;
import java.util.TreeSet;

public class Frota {
    private TreeSet<Drone> drones;

    public Frota(){
        this.drones = new TreeSet<>();
    }

    public boolean add(Drone d) throws Exception {
        if(searchDrone(d)){
            throw new Exception("Código de drone repetido!");
        }
        drones.add(d);
        return true;
    }

    public boolean searchDrone(Drone d){
        for(Drone dr:drones){
            if(dr.getCodigo() == d.getCodigo())
                return true;
        }
        return false;
    }

    public Drone getDroneDisponivel(Transporte transporte){
        for(Drone d:drones){
            if(d.podeAlocar(transporte) && !d.getEstado()) //se alocado for falso
                return d;
        }
        return null;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(drones.isEmpty())
            throw new RuntimeException("Não há transportes cadastrados!");

        for(Drone d:drones){
            sb.append(d.toString()).append("\n");
        }
        return sb.toString();
    }

    public String exibirDronesP() {
        StringBuilder sb = new StringBuilder();
        for (Drone d : drones) {
            sb.append("Código: ").append(d.getCodigo())
                    .append(", Custo Fixo: ").append(d.getCustoFixo())
                    .append(", Autonomia: ").append(d.getAutonomia());
            if (d instanceof DronePessoal) {
                sb.append(", Quantidade Máxima de Pessoas: ")
                        .append(((DronePessoal) d).getQtdMaxPessoas());
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}