package dados;

public class DronePessoal extends Drone{
    private int qtdMaxPessoas;

    public DronePessoal(int codigo, double custoFixo, double autonomia, int qtdMaxPessoas) {
        super(codigo, custoFixo, autonomia);
        this.qtdMaxPessoas = qtdMaxPessoas;
    }

    public int getQtdMaxPessoas() {
        return qtdMaxPessoas;
    }

    public void setQtdMaxPessoas(int qtdMaxPessoas) {
        this.qtdMaxPessoas = qtdMaxPessoas;
    }

    @Override
    public double calculaCustoKm() {
        //valor do custo do quilometro do drone = custo fixo + custo variado ----> 2 reias por pessoa
        double custo = getCustoFixo() + (getQtdMaxPessoas() * 2);
        return custo;
    }

    @Override
    public boolean podeAlocar(Transporte transporte){
        return transporte instanceof TransportePessoal;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("1").append(";").append(super.toString()).append(";").append(qtdMaxPessoas).append(";").append(calculaCustoKm());
        return sb.toString();
    }
}
