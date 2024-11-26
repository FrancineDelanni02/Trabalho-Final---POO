package dados;
import java.util.LinkedList;
import java.util.Queue;

public class TransporteColecao {
    private Queue<Transporte> transportes; //precisa ser uma fila
    private Queue<Transporte> pendentes;
    private Frota frota;

    public TransporteColecao(Frota frota){
        this.transportes = new LinkedList<>();
        this.pendentes = new LinkedList<>();
        this.frota = frota;
    }

    public boolean searchTransporte(Transporte t){
        for(Transporte tr:transportes){
            if(tr.getNumero() == t.getNumero())
                return true;
        }
         return false;
    }

    public boolean add(Transporte t) throws Exception {
        if(searchTransporte(t)){
            throw new Exception("Número de transporte repetido!");
        }
        transportes.add(t);
        pendentes.add(t);
        return true;
    }

    //verifica somente a fila de transportes com a situação como pendente
    public void alocarDrones() throws Exception {
        if(pendentes.isEmpty())
            throw new Exception("Não há transportes na fila");

            int tamanhoInicial = pendentes.size();
            for (int i=0;i<tamanhoInicial;i++) {
                Drone d = frota.getDroneDisponivel(pendentes.peek());
                if (d != null) {
                    pendentes.remove().setDrone(d); //remove primeiro elemento da fila e coloca um drone pra ele
                } else {
                    pendentes.add(pendentes.remove()); //adiciona elemento no final da fila enquanto remove primeiro elemento
                }
            }
    }

    public void alterarSituacao(Transporte t,Estado situacao){
        t.setSituacao(situacao);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(transportes.isEmpty())
            throw new RuntimeException("Não há transportes cadastrados!");

        for(Transporte t:transportes){
            sb.append(t.toString()).append("\n");
        }
        return sb.toString();
    }
}
