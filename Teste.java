public class Teste {
    public static void main(String[] args) {
        System.out.println(StringChanges("MrtyNNgMM"));
    }

    public static String runLength(String str) {
        String results = "";
        int cont = 1;

        if (str.length() > 0) {
            char current = str.charAt(0);

            for (int i = 1; i < str.length(); i++) {
                if (current == str.charAt(i)) {
                    cont++;
                } else {
                    results += cont + "" + current;
                    cont = 1;
                    current = str.charAt(i);
                }
            }
        }

        return results;
    }
    
    public static String StringChanges(String str) {
        String results = "";
        char current;
        int position = 0;

        while (position < str.length()) {
            current = str.charAt(position);

            if (current == 'M') {
                if (position > 0) {
                    results += results.charAt(results.length() - 1); // duplica o anterior que já foi adicionado
                }
            } else if (current == 'N') {
                position++; // pula uma posição
            } else {
                results += current;
            }
            
            position++; //vai para o próximo caractere da sequência
        }

        return results;
    }
}
