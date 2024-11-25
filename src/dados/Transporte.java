package dados;

public abstract class Transporte implements Comparable<Transporte> {

	public Transporte(int numero,String nomeCliente,String descricao,double peso, double latitudeOrigem,double latitudeDestino, double longitudeOrigem, double longitudeDestino){
		this.numero = numero;
		this.nomeCliente = nomeCliente;
		this.descricao = descricao;
		this.peso = peso;
		this.latitudeOrigem = latitudeOrigem;
		this.latitudeDestino = latitudeDestino;
		this.longitudeOrigem = longitudeOrigem;
		this.longitudeDestino = longitudeDestino;
		this.situacao = Estado.PENDENTE;
	}

	private int numero;

	private String nomeCliente;

	private String descricao;

	private double peso;

	private double latitudeOrigem;

	private double latitudeDestino;

	private double longitudeOrigem;

	private double longitudeDestino;

	private Estado situacao;

	private Drone drone;

	public abstract double calculaCusto();

	@Override
	public int compareTo(Transporte t){
		return Integer.compare(this.numero,t.numero);
	}

	public int getNumero() {
		return numero;
	}

	public void setDrone(Drone drone){
		this.drone = drone;
		situacao = Estado.ALOCADO;
		drone.setEstado();
	}

	public void setSituacao(Estado situacao){
		this.situacao = situacao;
	}

	public Drone getDrone(){
		return drone;
	}

	public double calcularDistanciaKm(){
		double dLat = Math.toRadians(latitudeDestino - latitudeOrigem);
		double dLon = Math.toRadians(longitudeDestino - longitudeOrigem);

		// Fórmula de Haversine
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
				Math.cos(Math.toRadians(latitudeOrigem)) * Math.cos(Math.toRadians(latitudeDestino)) *
						Math.sin(dLon / 2) * Math.sin(dLon / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return 6371 * c;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(numero).append(";").append(nomeCliente).append(";").append(descricao).append(";").append(peso).append(";").append(latitudeOrigem);
		sb.append(";").append(latitudeDestino).append(";").append(longitudeOrigem).append(";").append(longitudeDestino).append(situacao).append(";");
		if(drone != null)
			sb.append(drone);

		sb.append(";").append(calculaCusto());
		return sb.toString();
	}

}
