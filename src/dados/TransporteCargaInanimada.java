package dados;

public class TransporteCargaInanimada extends Transporte {
	public TransporteCargaInanimada(int numero, String nomeCliente,String descricao,double peso,double latitudeOrigem,double latitudeDestino, double longitudeOrigem, double longitudeDestino, boolean cargaPerigosa){
		super(numero,nomeCliente,descricao,peso,latitudeOrigem,latitudeDestino,longitudeOrigem,longitudeDestino,Estado.PENDENTE);
  		this.cargaPerigosa = cargaPerigosa;
    }

	private boolean cargaPerigosa;
}
