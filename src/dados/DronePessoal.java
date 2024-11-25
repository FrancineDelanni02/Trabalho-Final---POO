package dados;

public class DronePessoal extends Drone {
	private int qtdPessoas;

	public DronePessoal(int codigo, double custoFixo, double autonomia,int qtdPessoas) {
		super(codigo, custoFixo, autonomia);
		this.qtdPessoas = qtdPessoas;
	}

	@Override
	public boolean podeAlocar(Transporte transporte){
		return transporte instanceof TransportePessoal;
	}

	//juntar depois
	@Override
	public double calculaCustoKm() {
		return 0;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append(";").append(qtdPessoas).append(";").append(calculaCustoKm());
		return sb.toString();
	}
}
