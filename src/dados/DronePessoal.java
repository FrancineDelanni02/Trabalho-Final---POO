package dados;

public class DronePessoal extends Drone {

	public DronePessoal(int codigo, double custoFixo, double autonomia) {
		super(codigo, custoFixo, autonomia);
	}

	@Override
	public double calculaCustoKm() {
		return 0;
	}
}
