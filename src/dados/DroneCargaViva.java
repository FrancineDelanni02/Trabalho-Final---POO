package dados;

public class DroneCargaViva extends DroneCarga {
	 public DroneCargaViva(int codigo, double custoFixo, double autonomia, double pesoMaximo, boolean climatizado){
		 super(codigo,custoFixo,autonomia,pesoMaximo);
		 this.climatizado = climatizado;
	 }

	private boolean climatizado;

	@Override
	public double calculaCustoKm() {
		double custo = getCustoFixo();
		custo += (climatizado ? 20 : 10);
		return custo;
	}

	@Override
	public boolean podeAlocar(Transporte transporte){
		return transporte instanceof TransporteCargaViva;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("3").append(";").append(super.toString()).append(";").append(climatizado).append(";").append(calculaCustoKm());
		return sb.toString();
	}
}
