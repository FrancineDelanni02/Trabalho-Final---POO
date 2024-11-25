package aplicacao;
import dados.Frota;
import dados.GerenciadorDeDados;
import dados.TransporteColecao;

public class ACMEAirDrones {
	private Frota frota;
	private TransporteColecao transportes;

	public ACMEAirDrones(){
		this.frota = new Frota();
		this.transportes = new TransporteColecao(frota);
	}

	public void executar() {
		GerenciadorDeDados gerenciador = new GerenciadorDeDados(frota,transportes);
		JanelaCadastroDrone cadastro = new JanelaCadastroDrone(frota);
	}

	public String relatorioGeral(){
		if(frota.toString().equals("") && transportes.toString().equals(""))
			throw new RuntimeException("Nenhum dado para ser lido");

		StringBuilder sb = new StringBuilder();
		sb.append(frota.toString()).append(transportes.toString());
		return sb.toString();
	}
}
