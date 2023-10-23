import java.io.IOException;

class Main{
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Matriz matriz;
        int ordem;
        long tempo;

        int[] ordens = { 3, 5, 7, 9, 11, 13 };
        int quantidadeMatrizes = ordens.length;

        ManipuladorArquivo arquivoBaseline = new ManipuladorArquivo("saida_baseline.txt");
        ManipuladorArquivo arquivoOtimizacaoV1 = new ManipuladorArquivo("saida_otimizacao_v1.txt");
        ManipuladorArquivo arquivoOtimizacaoV2 = new ManipuladorArquivo("saida_otimizacao_v2.txt");

        for (int i = 0; i < quantidadeMatrizes; i++) {
            ordem = ordens[i];

            System.out.printf("Realizando medicoes em matriz de ordem %d\n", ordem);

            matriz = new Matriz(ordem);
            matriz.inicializaRandomico();

            System.out.println("Calculando usando algoritmo baseline");
            for (int j = 0; j < 3; j++) {
                tempo = main.medirTempoDeterminanteBaseLine(matriz);
                arquivoBaseline.escrever(tempo + " ");
            }
            arquivoBaseline.novaLinha();

            System.out.println("Calculando usando algoritmo otimizado - vesao 1");
            for (int j = 0; j < 3; j++) {
                tempo = main.medirTempoDeterminanteOtimizacaoV1(matriz);
                arquivoOtimizacaoV1.escrever(tempo + " ");
            }
            arquivoOtimizacaoV1.novaLinha();

            System.out.println("Calculando usando algoritmo otimizado - vesao 2");
            for (int j = 0; j < 3; j++) {
                tempo = main.medirTempoDeterminanteOtimizacaoV2(matriz);
                arquivoOtimizacaoV2.escrever(tempo + " ");
            }
            arquivoOtimizacaoV2.novaLinha();

            System.out.println();
        }
    }
    
    public long medirTempoDeterminanteBaseLine(Matriz matriz) {
        long inicio, tempo;
        int determinante;

        int ordem = matriz.retorneOrdem();

        if (ordem < 9) { // Mede tempo em nano segundos
            inicio = System.nanoTime();
            determinante = matriz.determinante();
            tempo = System.nanoTime() - inicio;
        } else {
            // Mede tempo em milissegundos (para ordens superiores)
            inicio = System.currentTimeMillis();
            determinante = matriz.determinante();
            tempo = System.currentTimeMillis() - inicio;
        }

        return tempo;
    }
    
    public long medirTempoDeterminanteOtimizacaoV1(Matriz matriz) {
        long inicio, tempo;
        int determinante;

        int ordem = matriz.retorneOrdem();

        if (ordem < 9) { // Mede tempo em nano segundos
            inicio = System.nanoTime();
            determinante = matriz.determinanteOtimizadoV1();
            tempo = System.nanoTime() - inicio;
        } else {
            // Mede tempo em milissegundos (para ordens superiores)
            inicio = System.currentTimeMillis();
            determinante = matriz.determinanteOtimizadoV1();
            tempo = System.currentTimeMillis() - inicio;
        }

        return tempo;
    }
    
    public long medirTempoDeterminanteOtimizacaoV2(Matriz matriz) {
        long inicio, tempo;
        int determinante;
        
        int ordem = matriz.retorneOrdem();

        if (ordem < 9) { // Mede tempo em nano segundos
            inicio = System.nanoTime();
            determinante = matriz.determinanteOtimizadoV2();
            tempo = System.nanoTime() - inicio;
        } else {
            // Mede tempo em milissegundos (para ordens superiores)
            inicio = System.currentTimeMillis();
            determinante = matriz.determinanteOtimizadoV2();
            tempo = System.currentTimeMillis() - inicio;
        }

        return tempo;
    }
}