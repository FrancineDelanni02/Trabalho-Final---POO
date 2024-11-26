package dados;
import java.util.ArrayList;

public abstract class Drone implements Comparable<Drone> {
	private int codigo;

	private double custoFixo;

	private double autonomia;

	private boolean alocado;

	public Drone(int codigo,double custoFixo,double autonomia){
		this.codigo = codigo;
		this.custoFixo = custoFixo;
		this.autonomia = autonomia;
		this.alocado = false;
		this.transporte = new ArrayList<>();
	}

	private ArrayList<Transporte> transporte;

	@Override
	public int compareTo(Drone d){
		return Integer.compare(this.codigo,d.codigo);
	}

	public void setEstado(){
		alocado = alocado ? false : true;
	}

	public boolean getEstado(){
		return alocado;
	}

	public double getCustoFixo() {
		return custoFixo;
	}

	public double getAutonomia(){
		return autonomia;
	}

	public int getCodigo(){
		return codigo;
	}

	private void adicionarTransporte(Transporte t){
		transporte.add(t);
	}

	public abstract double calculaCustoKm();

	public abstract boolean podeAlocar(Transporte transporte);

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(codigo).append(";").append(custoFixo).append(";").append(autonomia).append(";").append(alocado);
		return sb.toString();
	}
}
