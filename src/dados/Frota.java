package dados;
import java.util.TreeSet;

public class Frota {
    private TreeSet<Drone> drones;

    public Frota(){
        this.drones = new TreeSet<>();
    }

    public boolean add(Drone d){
        if(searchDrone(d)){return false;}
        drones.add(d);
        return true;
    }

    public boolean searchDrone(Drone d){
         return drones.contains(d);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for(Drone d:drones){
            sb.append(d.getCodigo()).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}
