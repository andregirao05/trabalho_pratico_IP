import java.io.IOException;

class Main{
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Matriz matriz;
        int ordem;
        long tempo;

        int[] ordens = { 3, 5, 7, 9, 11, 13};
        int quantidadeMatrizes = ordens.length;

        ManipuladorArquivo arquivoBaseline = new ManipuladorArquivo("saida_baseline.txt");
        ManipuladorArquivo arquivoOtimizacaoV1 = new ManipuladorArquivo("saida_otimizacao_v1.txt");
        ManipuladorArquivo arquivoOtimizacaoV2 = new ManipuladorArquivo("saida_otimizacao_v2.txt");

        for (int i = 0; i < quantidadeMatrizes; i++) {
            ordem = ordens[i];

            System.out.printf("\nMATRIZ - ORDEM %d\n", ordem);

            matriz = new Matriz(ordem);

            for (int j = 0; j < 3; j++) {
                System.out.printf("\nTentativa %d\n", j + 1);
                matriz.inicializaRandomico();
                matriz.imprime();

                System.out.println("\nCalculando usando algoritmo baseline");
                tempo = main.medirTempoDeterminanteBaseLine(matriz);
                arquivoBaseline.escrever(tempo + " ");

                System.out.println("\nCalculando usando algoritmo otimizado - vesao 1");
                tempo = main.medirTempoDeterminanteOtimizacaoV1(matriz);
                arquivoOtimizacaoV1.escrever(tempo + " ");

                System.out.println("\nCalculando usando algoritmo otimizado - vesao 2");
                tempo = main.medirTempoDeterminanteOtimizacaoV2(matriz);
                arquivoOtimizacaoV2.escrever(tempo + " ");
            }

            arquivoBaseline.novaLinha();
            arquivoOtimizacaoV1.novaLinha();
            arquivoOtimizacaoV2.novaLinha();

            System.out.println();
        }
    }
    
    public long medirTempoDeterminanteBaseLine(Matriz matriz) {
        long inicio, tempo;
        int determinante;

        inicio = System.nanoTime();
        determinante = matriz.determinante();
        tempo = System.nanoTime() - inicio;

        System.out.printf("Determinante: %d\n", determinante);
        System.out.printf("Tempo: %d ns\n", tempo);

        return tempo;
    }
    
    public long medirTempoDeterminanteOtimizacaoV1(Matriz matriz) {
        long inicio, tempo;
        int determinante;

        inicio = System.nanoTime();
        determinante = matriz.determinanteOtimizadoV1();
        tempo = System.nanoTime() - inicio;
        
        System.out.printf("Determinante: %d\n", determinante);
        System.out.printf("Tempo: %d ns\n", tempo);

        return tempo;
    }
    
    public long medirTempoDeterminanteOtimizacaoV2(Matriz matriz) {
        long inicio, tempo;
        int determinante;
        
        inicio = System.nanoTime();
        determinante = matriz.determinanteOtimizadoV2();
        tempo = System.nanoTime() - inicio;

        System.out.printf("Determinante: %d\n", determinante);
        System.out.printf("Tempo: %d ns\n", tempo);

        return tempo;
    }
}