import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ManipuladorArquivo {
    private String path;

    public ManipuladorArquivo(String path) throws IOException {
        this.setPath(path);
        this.limparArquivo();
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void escrever(String texto) throws IOException {
        FileWriter fileWriter = new FileWriter(this.getPath(), true);
        BufferedWriter buffWrite = new BufferedWriter(fileWriter);
        buffWrite.append(texto);
        buffWrite.close();
    }
    
    public void escrever(int numero) throws IOException {
        this.escrever(Integer.toString(numero));;
    }
    
    public void novaLinha() throws IOException {
        this.escrever("\n");
    }

    public void escreverComNovaLinha(String texto) throws IOException {
        this.escrever(texto + "\n");
    }

    private void limparArquivo() throws IOException {
        FileWriter fileWriter = new FileWriter(this.getPath());
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
        ManipuladorArquivo arquivo = new ManipuladorArquivo("teste.txt");
        arquivo.escreverComNovaLinha("oi");
        arquivo.escreverComNovaLinha("qualquer coisa");
    }


}