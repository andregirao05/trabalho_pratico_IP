# Trabalho prático de IP

Trabalho prático para conclusão da disciplina de Introdução à Programação no período 2023/1.

## Autores:

- Bruna Lucas dos Santos
- André Luiz Girão Ferreira

## Como funciona

O programa para cálculo do determinante funciona da seguinte forma:

1. É definido na classe Main um vetor de inteiros que representa as ordens matriciais que serão testadas.

2. Para cada ordem no vetor descrito acima:

   1. Uma matriz aleatória (com valores de itens entre 0 e 2\*ordem^2) é inicializada.
   2. O cálculo do determinante é feito com três algoritmos (um sem otimizações, um com otimização simples e outro com otimizações extras), seus tempos de execução são medidos em nanossegundos e escritos em arquivos .txt de saída.
   3. Para fins de debug, a cada passo feito pelo programa, informações pertinentes são impressas no prompt de comando.

3. O passo 2 é executado três vezes.

## Execução

### Compilação

Para o programa principal, basta o comandos:

Para o **LINUX**:

```
javac -d bin codigos/*.java
```

Para o **WINDOWS**:

```
javac -d bin codigos\*.java
```

### Execução

Para executar, use o comando abaixo:

```
java -cp bin Main
```

## Script para criação de gráficos

Adicionalmente ao programa principal solicitado na especificação do trabalho, foi criado um Jupiter Notebook para criação dos gráficos que utilizamos para mostrar os resultados obtidos no experimento.

Para executar o script é necessário ter a linguagem Python corretamente instalada na sua máquina, bem como as bibliotecas `pandas` e `matplotlib`.

Para instalar as bibliotecas necessárias, execute:

```
pip install -r requirements.txt
```

# Arquivos de saída

Optamos por deixar neste repositório os arquivos de saída dos algoritmos para fins de inspeção dos resultados obtidos no experimento (diretório "saida"). São eles:

- Em nanossegundos: `baseline_ns.txt`, `otimizacao_v1_ns.txt` e `otimizacao_v2_ns.txt`;
- Em milissegundos: `baseline_ms.txt`, `otimizacao_v1_ms.txt` e `otimizacao_v2_ms.txt`.

Os arquivos apresentam o seguinte formato:

- Possuem uma linha para cada ordem matricial executada (3, 5, 7, 9, 11 e 13);
- Há três colunas, uma para cada execução.
