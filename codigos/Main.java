import java.io.IOException;

class Main{
    public static void main(String[] args) throws IOException {
        Matriz matriz;
        int ordem;
        Main controlador = new Main();

        /* Inicializando vetor de ordens matriciais */
        Vetor ordens = new Vetor(6 );
        ordens.setElemento(0, 3);
        ordens.setElemento(1, 5);
        ordens.setElemento(2, 7);
        ordens.setElemento(3, 9);
        ordens.setElemento(4, 11);
        ordens.setElemento(5, 13);

        int quantidadeMatrizes = ordens.getTamanho();

        ManipuladorArquivo saidaBaselineNs = new ManipuladorArquivo("baseline_ns.txt");
        ManipuladorArquivo saidaOtimizacaoV1Ns = new ManipuladorArquivo("otimizacao_v1_ns.txt");
        ManipuladorArquivo saidaOtimizacaoV2Ns = new ManipuladorArquivo("otimizacao_v2_ns.txt");

        ManipuladorArquivo saidaBaselineMs = new ManipuladorArquivo("baseline_ms.txt");
        ManipuladorArquivo saidaOtimizacaoV1Ms = new ManipuladorArquivo("otimizacao_v1_ms.txt");
        ManipuladorArquivo saidaOtimizacaoV2Ms = new ManipuladorArquivo("otimizacao_v2_ms.txt");

        for (int i = 0; i < quantidadeMatrizes; i++) {
            ordem = ordens.getElemento(i);

            System.out.printf("\nMATRIZ - ORDEM %d\n", ordem);

            matriz = new Matriz(ordem, ordem);

            for (int j = 0; j < 3; j++) {
                System.out.printf("\nTentativa %d\n", j + 1);
                matriz.inicializaRandomico();
                matriz.imprime();

                controlador.medirTempoBaseline(matriz, saidaBaselineNs, saidaBaselineMs);
                controlador.medirTempoOtimizacaoV1(matriz, saidaOtimizacaoV1Ns, saidaOtimizacaoV1Ms);
                controlador.medirTempoOtimizacaoV2(matriz, saidaOtimizacaoV2Ns, saidaOtimizacaoV2Ms);
            }

            saidaBaselineNs.novaLinha();
            saidaOtimizacaoV1Ns.novaLinha();
            saidaOtimizacaoV2Ns.novaLinha();

            saidaBaselineMs.novaLinha();
            saidaOtimizacaoV1Ms.novaLinha();
            saidaOtimizacaoV2Ms.novaLinha();

            System.out.println();
        }
    }

    private void medirTempoBaseline(
        Matriz matriz,
        ManipuladorArquivo saidaNs,
        ManipuladorArquivo saidaMs
    ) throws IOException {
        /* Mede tempo do algoritmo da otimização extra e imprime os resultados nos arquivos de saída e no terminal */
        long inicioNano, inicioMili, tempoNano, tempoMili;
        int determinante;

        System.out.println("\nCalculando usando algoritmo baseline");
        inicioMili = System.currentTimeMillis();
        inicioNano = System.nanoTime();

        determinante = matriz.determinante();

        tempoNano = System.nanoTime() - inicioNano;
        tempoMili = System.currentTimeMillis() - inicioMili;

        //Escrevendo resultado no arquivo
        saidaNs.escrever(tempoNano + " ");
        saidaMs.escrever(tempoMili + " ");

        //Printando saída no terminal
        System.out.printf("Determinante: %d\n", determinante);
        System.out.printf("Tempo: %d ns\n", tempoNano);
        System.out.printf("Tempo: %d ms\n", tempoMili);
    }
    
    private void medirTempoOtimizacaoV1(
        Matriz matriz,
        ManipuladorArquivo saidaNs,
        ManipuladorArquivo saidaMs
    ) throws IOException {
        /* Mede tempo do algoritmo da otimização extra e imprime os resultados nos arquivos de saída e no terminal */
        long inicioNano, inicioMili, tempoNano, tempoMili;
        int determinante;

        System.out.println("\nCalculando usando algoritmo otimizado - vesao 1");
        inicioMili = System.currentTimeMillis();
        inicioNano = System.nanoTime();

        determinante = matriz.determinanteOtimizadoV1();

        tempoNano = System.nanoTime() - inicioNano;
        tempoMili = System.currentTimeMillis() - inicioMili;

        //Escrevendo resultado no arquivo
        saidaNs.escrever(tempoNano + " ");
        saidaMs.escrever(tempoMili + " ");

        //Printando saída no terminal
        System.out.printf("Determinante: %d\n", determinante);
        System.out.printf("Tempo: %d ns\n", tempoNano);
        System.out.printf("Tempo: %d ms\n", tempoMili);
    }

    private void medirTempoOtimizacaoV2(
        Matriz matriz,
        ManipuladorArquivo saidaNs,
        ManipuladorArquivo saidaMs
    ) throws IOException {
        /* Mede tempo do algoritmo da otimização extra e imprime os resultados nos arquivos de saída e no terminal */
        long inicioNano, inicioMili, tempoNano, tempoMili;
        int determinante;

        System.out.println("\nCalculando usando algoritmo otimizado - vesao 2");
        inicioMili = System.currentTimeMillis();
        inicioNano = System.nanoTime();

        determinante = matriz.determinanteOtimizadoV2();

        tempoNano = System.nanoTime() - inicioNano;
        tempoMili = System.currentTimeMillis() - inicioMili;

        //Escrevendo resultado no arquivo
        saidaNs.escrever(tempoNano + " ");
        saidaMs.escrever(tempoMili + " ");

        //Printando saída no terminal
        System.out.printf("Determinante: %d\n", determinante);
        System.out.printf("Tempo: %d ns\n", tempoNano);
        System.out.printf("Tempo: %d ms\n", tempoMili);
    }
}