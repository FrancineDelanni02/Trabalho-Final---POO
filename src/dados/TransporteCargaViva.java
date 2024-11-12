package dados;

public class TransporteCargaViva extends Transporte {

	public TransporteCargaViva(int numero, String nomeCliente,String descricao,double peso,double latitudeOrigem,double latitudeDestino, double longitudeOrigem, double longitudeDestino, double temperaturaMinima, double temperaturaMaxima){
		super(numero,nomeCliente,descricao,peso,latitudeOrigem,latitudeDestino,longitudeOrigem,longitudeDestino,Estado.PENDENTE);
		this.temperaturaMinima = temperaturaMinima;
		this.temperaturaMaxima = temperaturaMaxima;
	}

	private double temperaturaMinima;

	private double temperaturaMaxima;

	private double variacaoTemperatura(){
		return temperaturaMaxima-temperaturaMinima;
	}

	@Override
	public double calculaCusto() {
		double custo = calcularDistanciaKm() * getDrone().calculaCustoKm();
		custo += (variacaoTemperatura() > 10 ? 1000 : 0);
		return custo;
	}
}
