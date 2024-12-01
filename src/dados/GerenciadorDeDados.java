package dados;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class GerenciadorDeDados {
    private Frota frota;
    private TransporteColecao transportes;

    public GerenciadorDeDados(Frota frota,TransporteColecao transportes){
        this.frota = frota;
        this.transportes = transportes;
    }

    public void salvar(String name){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".CSV", true))) {
            writer.write(frota.toString());
            writer.write(transportes.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String lerArquivo(String name) {
        Path path = Paths.get(name+".CSV");
        String arq = null;
        try (BufferedReader br = Files.newBufferedReader(path,
                Charset.defaultCharset())) {
            String linha = null;
            while ((linha = br.readLine()) != null) {
                Scanner sc = new Scanner(linha).useDelimiter(";");
                arq = (sc.next() + ";" + sc.next() + ";" + sc.next());
            }
        } catch (IOException e) {
            System.err.format("Erro ao ler arquivo: " + e.getMessage());
        }
        return arq;
    }
}