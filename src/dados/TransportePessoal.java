package dados;

public class TransportePessoal extends Transporte {

    public TransportePessoal(int numero, String nomeCliente,String descricao,double peso,double latitudeOrigem,double latitudeDestino, double longitudeOrigem, double longitudeDestino,int qtdPessoas){
        super(numero,nomeCliente,descricao,peso,latitudeOrigem,latitudeDestino,longitudeOrigem,longitudeDestino);
        this.qtdPessoas = qtdPessoas;
    }

    private int qtdPessoas;

    @Override
    public double calculaCusto(){
        double custo = calcularDistanciaKm() * getDrone().calculaCustoKm();
        custo += qtdPessoas * 10;
        return custo;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("1").append(";").append(super.toString());
        sb.append(";").append(qtdPessoas);
        return sb.toString();
    }
}