package dados;
import java.util.ArrayList;

public abstract class Drone implements Comparable<Drone> {
	public Drone(int codigo,double custoFixo,double autonomia){
		this.codigo = codigo;
		this.custoFixo = custoFixo;
		this.autonomia = autonomia;
		this.transporte = new ArrayList<>();
	}

	private int codigo;

	private double custoFixo;

	private double autonomia;

	private ArrayList<Transporte> transporte;

	@Override
	public int compareTo(Drone d){
		return Integer.compare(this.codigo,d.codigo);
	}

	public double getCustoFixo() {
		return custoFixo;
	}

	public int getCodigo(){
		return codigo;
	}

	private void adicionarTransporte(Transporte t){
		transporte.add(t);
	}

	public abstract double calculaCustoKm();

}
