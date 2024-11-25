package dados;

public class DroneCargaInanimada extends DroneCarga {

	public DroneCargaInanimada(int codigo, double custoFixo, double autonomia, double pesoMaximo, boolean protecao){
		super(codigo,custoFixo,autonomia,pesoMaximo);
		this.protecao = protecao;
	}

	private boolean protecao;

	@Override
	public double calculaCustoKm() {
		double custo = getCustoFixo();
		custo += (protecao ? 10 : 5);
		return custo;
	}

	@Override
	public boolean podeAlocar(Transporte transporte){
		return transporte instanceof TransporteCargaInanimada;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append(";").append(protecao).append(";").append(calculaCustoKm());
		return sb.toString();
	}
}
