package dados;

public abstract class Transporte {

	public Transporte(int numero,String nomeCliente,String descricao,double peso, double latitudeOrigem,double latitudeDestino, double longitudeOrigem, double longitudeDestino,Estado situacao){
		this.numero = numero;
		this.nomeCliente = nomeCliente;
		this.descricao = descricao;
		this.peso = peso;
		this.latitudeOrigem = latitudeOrigem;
		this.latitudeDestino = latitudeDestino;
		this.longitudeOrigem = longitudeOrigem;
		this.longitudeDestino = longitudeDestino;
		this.situacao = situacao;
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

	public void setDrone(Drone drone){
		this.drone = drone;
		situacao = Estado.ALOCADO;
	}

	public Drone getDrone(){
		return drone;
	}

	//apenas para teste, incrementar depois
	public void finalizarTransporte(){
		situacao = Estado.TERMINADO;
	}

	public void cancelarTransporte(){
		situacao = Estado.CANCELADO;
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

}
