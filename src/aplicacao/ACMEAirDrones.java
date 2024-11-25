package aplicacao;
import dados.*;

public class ACMEAirDrones {
	private Frota frota;
	private TransporteColecao transportes;

	public ACMEAirDrones(){
		this.frota = new Frota();
		this.transportes = new TransporteColecao(frota);
	}

	public void executar() {
		GerenciadorDeDados gerenciador = new GerenciadorDeDados(frota,transportes);
		//JanelaCadastroDrone cadastro = new JanelaCadastroDrone(frota);

		TransportePessoal tp1 = new TransportePessoal(1, "João Silva", "Viagem rápida", 70.0, -23.55, -23.56, -46.63, -46.64, 1);
		TransportePessoal tp2 = new TransportePessoal(2, "Maria Oliveira", "Transfer aeroporto", 65.0, -22.91, -22.92, -43.17, -43.18, 2);
		TransportePessoal tp3 = new TransportePessoal(3, "Carlos Santos", "Passeio turístico", 80.0, -25.42, -25.43, -49.27, -49.28, 3);
		TransportePessoal tp4 = new TransportePessoal(4, "Ana Costa", "Viagem trabalho", 55.0, -19.93, -19.94, -43.94, -43.95, 1);
		TransportePessoal tp5 = new TransportePessoal(5, "Pedro Lima", "Visita familiar", 72.0, -12.97, -12.98, -38.51, -38.52, 4);
		TransportePessoal tp6 = new TransportePessoal(6, "Juliana Farias", "Retorno ao lar", 68.0, -3.72, -3.73, -38.54, -38.55, 1);
		TransportePessoal tp7 = new TransportePessoal(7, "Roberto Pereira", "Viagem urgente", 75.0, -8.05, -8.06, -34.88, -34.89, 2);
		TransportePessoal tp8 = new TransportePessoal(8, "Camila Almeida", "Excursão universitária", 90.0, -16.68, -16.69, -49.25, -49.26, 5);
		TransportePessoal tp9 = new TransportePessoal(9, "Ricardo Lopes", "Visita profissional", 78.0, -22.51, -22.52, -43.18, -43.19, 2);
		TransportePessoal tp10 = new TransportePessoal(10, "Fernanda Ramos", "Viagem de férias", 65.0, -15.78, -15.79, -47.93, -47.94, 3);

		TransporteCargaInanimada tci1 = new TransporteCargaInanimada(1, "Empresa A", "Entrega de documentos", 10.0, -23.55, -23.56, -46.63, -46.64, false);
		TransporteCargaInanimada tci2 = new TransporteCargaInanimada(2, "Empresa B", "Entrega de eletrônicos", 50.0, -22.91, -22.92, -43.17, -43.18, false);
		TransporteCargaInanimada tci3 = new TransporteCargaInanimada(3, "Empresa C", "Entrega de material químico", 120.0, -25.42, -25.43, -49.27, -49.28, true);
		TransporteCargaInanimada tci4 = new TransporteCargaInanimada(4, "Empresa D", "Carga de móveis", 200.0, -19.93, -19.94, -43.94, -43.95, false);
		TransporteCargaInanimada tci5 = new TransporteCargaInanimada(5, "Empresa E", "Entrega de peças automotivas", 80.0, -12.97, -12.98, -38.51, -38.52, false);
		TransporteCargaInanimada tci6 = new TransporteCargaInanimada(6, "Empresa F", "Transporte de produtos químicos", 100.0, -3.72, -3.73, -38.54, -38.55, true);
		TransporteCargaInanimada tci7 = new TransporteCargaInanimada(7, "Empresa G", "Entrega de caixas de papelão", 45.0, -8.05, -8.06, -34.88, -34.89, false);
		TransporteCargaInanimada tci8 = new TransporteCargaInanimada(8, "Empresa H", "Entrega de vidros", 150.0, -16.68, -16.69, -49.25, -49.26, true);
		TransporteCargaInanimada tci9 = new TransporteCargaInanimada(9, "Empresa I", "Transporte de materiais médicos", 30.0, -22.51, -22.52, -43.18, -43.19, false);
		TransporteCargaInanimada tci10 = new TransporteCargaInanimada(10, "Empresa J", "Entrega de equipamentos", 60.0, -15.78, -15.79, -47.93, -47.94, false);

		TransporteCargaViva tcv1 = new TransporteCargaViva(1, "Fazenda A", "Transporte de aves", 100.0, -23.55, -23.56, -46.63, -46.64, 5.0, 15.0);
		TransporteCargaViva tcv2 = new TransporteCargaViva(2, "Fazenda B", "Transporte de peixes", 120.0, -22.91, -22.92, -43.17, -43.18, 0.0, 10.0);
		TransporteCargaViva tcv3 = new TransporteCargaViva(3, "Zoológico", "Transporte de felinos", 300.0, -25.42, -25.43, -49.27, -49.28, 15.0, 25.0);
		TransporteCargaViva tcv4 = new TransporteCargaViva(4, "Fazenda C", "Transporte de bovinos", 500.0, -19.93, -19.94, -43.94, -43.95, 10.0, 20.0);
		TransporteCargaViva tcv5 = new TransporteCargaViva(5, "Aviário", "Transporte de galinhas", 80.0, -12.97, -12.98, -38.51, -38.52, 5.0, 15.0);
		TransporteCargaViva tcv6 = new TransporteCargaViva(6, "Aquário", "Transporte de tartarugas", 50.0, -3.72, -3.73, -38.54, -38.55, 18.0, 28.0);
		TransporteCargaViva tcv7 = new TransporteCargaViva(7, "Fazenda D", "Transporte de porcos", 400.0, -8.05, -8.06, -34.88, -34.89, 8.0, 18.0);
		TransporteCargaViva tcv8 = new TransporteCargaViva(8, "Fazenda E", "Transporte de ovelhas", 300.0, -16.68, -16.69, -49.25, -49.26, 10.0, 20.0);
		TransporteCargaViva tcv9 = new TransporteCargaViva(9, "Zoo Safári", "Transporte de aves exóticas", 30.0, -22.51, -22.52, -43.18, -43.19, 12.0, 22.0);
		TransporteCargaViva tcv10 = new TransporteCargaViva(10, "Fazenda F", "Transporte de cavalos", 600.0, -15.78, -15.79, -47.93, -47.94, 10.0, 18.0);

		DroneCargaInanimada dci1 = new DroneCargaInanimada(1, 1500.0, 300.0, 100.0, true);
		DroneCargaInanimada dci2 = new DroneCargaInanimada(2, 1800.0, 350.0, 150.0, false);
		DroneCargaInanimada dci3 = new DroneCargaInanimada(3, 2000.0, 400.0, 200.0, true);
		DroneCargaInanimada dci4 = new DroneCargaInanimada(4, 1200.0, 250.0, 80.0, false);
		DroneCargaInanimada dci5 = new DroneCargaInanimada(5, 2200.0, 500.0, 300.0, true);

		DronePessoal dp1 = new DronePessoal(1, 1000.0, 200.0, 1);
		DronePessoal dp2 = new DronePessoal(2, 1200.0, 250.0, 2);
		DronePessoal dp3 = new DronePessoal(3, 1500.0, 300.0, 3);
		DronePessoal dp4 = new DronePessoal(4, 900.0, 180.0, 1);
		DronePessoal dp5 = new DronePessoal(5, 2000.0, 400.0, 4);

		DroneCargaViva dcv1 = new DroneCargaViva(1, 2500.0, 400.0, 34,true);
		DroneCargaViva dcv2 = new DroneCargaViva(2, 2000.0, 350.0, 450,false);
		DroneCargaViva dcv3 = new DroneCargaViva(3, 3000.0, 500.0, 34,true);
		DroneCargaViva dcv4 = new DroneCargaViva(4, 1800.0, 300.0, 30,false);
		DroneCargaViva dcv5 = new DroneCargaViva(5, 3500.0, 600.0, 50,true);


	}

	public String relatorioGeral(){
		if(frota.toString().equals("") && transportes.toString().equals(""))
			throw new RuntimeException("Nenhum dado para ser lido");

		StringBuilder sb = new StringBuilder();
		sb.append(frota.toString()).append(transportes.toString());
		return sb.toString();
	}
}
