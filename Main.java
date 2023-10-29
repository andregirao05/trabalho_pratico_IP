import java.io.IOException;

class Main{
    public static void main(String[] args) throws IOException {
        Matriz matriz;
        int ordem, determinante;
        long inicioNano, inicioMili, tempoNano, tempoMili;

        int[] ordens = { 3, 5, 7, 9, 11, 13};
        int quantidadeMatrizes = ordens.length;

        ManipuladorArquivo arquivoBaselineNanossegundos = new ManipuladorArquivo("saida_baseline_em_ns.txt");
        ManipuladorArquivo arquivoOtimizacaoV1Nanossegundos = new ManipuladorArquivo("saida_otimizacao_v1_em_ns.txt");
        ManipuladorArquivo arquivoOtimizacaoV2Nanossegundos = new ManipuladorArquivo("saida_otimizacao_v2_em_ns.txt");

        ManipuladorArquivo arquivoBaselineMilissegundos = new ManipuladorArquivo("saida_baseline_ms.txt");
        ManipuladorArquivo arquivoOtimizacaoV1Milissegundos = new ManipuladorArquivo("saida_otimizacao_v1_em_ms.txt");
        ManipuladorArquivo arquivoOtimizacaoV2Milissegundos = new ManipuladorArquivo("saida_otimizacao_v2_em_ms.txt");

        for (int i = 0; i < quantidadeMatrizes; i++) {
            ordem = ordens[i];

            System.out.printf("\nMATRIZ - ORDEM %d\n", ordem);

            matriz = new Matriz(ordem, ordem);

            for (int j = 0; j < 3; j++) {
                System.out.printf("\nTentativa %d\n", j + 1);
                matriz.inicializaRandomico();
                matriz.imprime();

                System.out.println("\nCalculando usando algoritmo baseline");
                inicioMili = System.currentTimeMillis();
                inicioNano = System.nanoTime();
                determinante = matriz.determinante();
                tempoNano = System.nanoTime() - inicioNano;
                tempoMili = System.currentTimeMillis() - inicioMili;

                System.out.printf("Determinante: %d\n", determinante);
                System.out.printf("Tempo: %d ns\n", tempoNano);
                System.out.printf("Tempo: %d ms\n", tempoMili);
                arquivoBaselineNanossegundos.escrever(tempoNano + " ");
                arquivoBaselineMilissegundos.escrever(tempoMili + " ");


                System.out.println("\nCalculando usando algoritmo otimizado - vesao 1");
                inicioMili = System.currentTimeMillis();
                inicioNano = System.nanoTime();
                determinante = matriz.determinanteOtimizadoV1();
                tempoNano = System.nanoTime() - inicioNano;
                tempoMili = System.currentTimeMillis() - inicioMili;

                System.out.printf("Determinante: %d\n", determinante);
                System.out.printf("Tempo: %d ns\n", tempoNano);
                System.out.printf("Tempo: %d ms\n", tempoMili);
                arquivoOtimizacaoV1Nanossegundos.escrever(tempoNano + " ");
                arquivoOtimizacaoV1Milissegundos.escrever(tempoMili + " ");


                System.out.println("\nCalculando usando algoritmo otimizado - vesao 2");
                inicioMili = System.currentTimeMillis();
                inicioNano = System.nanoTime();
                determinante = matriz.determinanteOtimizadoV2();
                tempoNano = System.nanoTime() - inicioNano;
                tempoMili = System.currentTimeMillis() - inicioMili;

                System.out.printf("Determinante: %d\n", determinante);
                System.out.printf("Tempo: %d ns\n", tempoNano);
                System.out.printf("Tempo: %d ms\n", tempoMili);
                arquivoOtimizacaoV2Nanossegundos.escrever(tempoNano + " ");
                arquivoOtimizacaoV2Milissegundos.escrever(tempoMili + " ");
            }

            arquivoBaselineNanossegundos.novaLinha();
            arquivoOtimizacaoV1Nanossegundos.novaLinha();
            arquivoOtimizacaoV2Nanossegundos.novaLinha();

            arquivoBaselineMilissegundos.novaLinha();
            arquivoOtimizacaoV1Milissegundos.novaLinha();
            arquivoOtimizacaoV2Milissegundos.novaLinha();

            System.out.println();
        }
    }

}