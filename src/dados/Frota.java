package dados;
import java.util.LinkedList;
import java.util.TreeSet;

public class Frota {
    private TreeSet<Drone> drones,disponiveis;

    public Frota(){
        this.drones = new TreeSet<>();
        this.disponiveis = new TreeSet<>();
    }

    public boolean add(Drone d) throws Exception {
        if(searchDrone(d)){
            throw new Exception("Código de drone repetido!");
        }
        drones.add(d);
        return true;
    }

    public boolean searchDrone(Drone d){
         return drones.contains(d);
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
        for(Drone d:drones){
            sb.append(d.toString()).append("\n");
        }
        return sb.toString();
    }
}
