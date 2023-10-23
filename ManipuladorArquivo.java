import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ManipuladorArquivo {
    private String path;
    private BufferedWriter buffWrite;

    public ManipuladorArquivo(String path) throws IOException {
        this.setPath(path);
        this.setBuffWrite(new BufferedWriter(new FileWriter(path)));
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BufferedWriter getBuffWrite() {
        return this.buffWrite;
    }

    public void setBuffWrite(BufferedWriter buffWrite) {
        this.buffWrite = buffWrite;
    }

    public void escrever(String texto) throws IOException {
		this.getBuffWrite().append(texto);
	}

    public void close() {
        try {
            this.getBuffWrite().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}