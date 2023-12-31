import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ManipuladorArquivo {
    private String path;

    public ManipuladorArquivo(String filename) throws IOException {
        /* Define o path para */
        this.setPath(filename);
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
}