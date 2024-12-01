package dados;

public abstract class DroneCarga extends Drone {

    public DroneCarga(int codigo,double custoFixo,double autonomia,double pesoMaximo){
        super(codigo,custoFixo,autonomia);
        this.pesoMaximo = pesoMaximo;
    }

    private double pesoMaximo;

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(";").append(pesoMaximo);
        return sb.toString();
    }
}