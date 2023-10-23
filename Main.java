import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

class Main{
		
    public static void main(String[] args) throws IOException {
        Matriz matriz;
        int det, ordem;
        long inicio, fim, resultado;

        Vetor ordens = new Vetor(4);
        ordens.setElemento(0, 3);
        ordens.setElemento(1, 5);
        ordens.setElemento(2, 7);
        ordens.setElemento(3, 9);
        
        long[][] tempoBaseline, tempoOtimizacao1, tempoOtimizacao2;
        tempoBaseline = new long[ordens.getTamanho()][3];
        tempoOtimizacao1 = new long[ordens.getTamanho()][3];
        tempoOtimizacao2 = new long[ordens.getTamanho()][3];

        for (int i = 0; i < ordens.getTamanho(); i++) {
            ordem = ordens.getElemento(i);

            matriz = new Matriz(ordem);
            matriz.inicializaRandomico();
            matriz.imprime();

            for (int j = 0; j < 3; j++) {
                if (ordem < 9) {
                    inicio = System.nanoTime();
                    det = matriz.determinante();
                    fim = System.nanoTime();
                } else {
                    inicio = System.currentTimeMillis();
                    det = matriz.determinante();
                    fim = System.currentTimeMillis();
                }
                
                resultado = fim - inicio;
                tempoBaseline[i][j] = resultado;
            }

            for (int j = 0; j < 3; j++) {
                if (ordem < 9) {
                    inicio = System.nanoTime();
                    det = matriz.determinanteOtimizadoV1();
                    fim = System.nanoTime();
                } else {
                    inicio = System.currentTimeMillis();
                    det = matriz.determinanteOtimizadoV1();
                    fim = System.currentTimeMillis();
                }
                resultado = fim - inicio;
                tempoOtimizacao1[i][j] = resultado;
            }

            for (int j = 0; j < 3; j++) {
                if (ordem < 9) {
                    inicio = System.nanoTime();
                    det = matriz.determinanteOtimizadoV2();
                    fim = System.nanoTime();
                } else {
                    inicio = System.currentTimeMillis();
                    det = matriz.determinanteOtimizadoV2();
                    fim = System.currentTimeMillis();
                }

                resultado = fim - inicio;
                tempoOtimizacao2[i][j] = resultado;
            }
        }

        for (int i = 0; i < tempoBaseline.length; i++) {
            for (int j = 0; j < tempoBaseline[0].length; j++) {
                System.out.printf(tempoBaseline[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < tempoOtimizacao1.length; i++) {
            for (int j = 0; j < tempoOtimizacao1[0].length; j++) {
                System.out.printf(tempoOtimizacao1[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < tempoOtimizacao2.length; i++) {
            for (int j = 0; j < tempoOtimizacao2[0].length; j++) {
                System.out.printf(tempoOtimizacao2[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }
}