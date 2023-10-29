import java.util.Random;

class Matriz{
	private int[][] mat;
	private int tamLinha;
	private int tamColuna;

	Matriz(){
		mat = new int[6][6];
		this.setTamanhoLinha(6);	
		this.setTamanhoColuna(6);
	}

	Matriz(int numLinhas, int numColunas){
		mat = new int[numLinhas][numColunas];
		this.setTamanhoLinha(numLinhas);	
		this.setTamanhoColuna(numColunas);
	}

	public int getValor(int indiceI,int indiceJ){
		return mat[indiceI][indiceJ];
	}	
	
	public void setValor(int indiceI,int indiceJ, int novoValor){
		mat[indiceI][indiceJ] = novoValor;
	}

	public int getTamanhoLinha(){
		return tamLinha;
	}	
	
	public int getTamanhoColuna(){
		return tamColuna;
	}	

	private void setTamanhoLinha(int novoValor){
		tamLinha = novoValor;
	}

	private void setTamanhoColuna(int novoValor){
		tamColuna = novoValor;
	}

	public void imprime(){
		int conti,contj;	
		for(conti = 0; conti < this.getTamanhoLinha(); conti++){
			System.out.println();
			for(contj = 0; contj < this.getTamanhoColuna(); contj++){
				System.out.print(this.getValor(conti,contj) + " ");
			}
		}
		System.out.println();	
	}

	public void inicializaRandomico(){
		int conti,contj, novoValor;
		int ordem = this.getTamanhoLinha();
		Random gerador = new Random();
		for(conti = 0; conti < this.getTamanhoLinha(); conti++){
			for(contj = 0; contj < this.getTamanhoColuna(); contj++){
				novoValor = gerador.nextInt(ordem);
				this.setValor(conti,contj,novoValor);
			}
		}
	}

	// caso matriz nao quadrada, retorna -1
	public int retorneOrdem(){
		int numL, numC, ordem;

		numL = this.getTamanhoLinha();
		numC = this.getTamanhoColuna();
		ordem = -1;
		if(numL == numC){
			ordem = numL;
		}

		return ordem;
	}	

	private int detOrdem1(Matriz mat){
		return mat.getValor(0,0);
	}
	
	private int detOrdem2(Matriz mat){
		int diagonalP, diagonalI;

		diagonalP = mat.getValor(0,0) * mat.getValor(1,1);		
		diagonalI = mat.getValor(1,0) * mat.getValor(0,1);		

		return (diagonalP - diagonalI);
	}

	private int calculaSinal(int indiceL, int indiceC){
		int sinal;

		sinal = -1;

		if( ((indiceL + indiceC)% 2) == 0 ){
			sinal = 1;
		}

		return sinal;		
	}

	public void copiaMatrizMaiorParaMenor(Matriz maior,Matriz menor,int isqn,int jsqn){
		int contAi,contAj,contBi,contBj,temp,numL,numC;
		numL = menor.getTamanhoLinha();
		numC = menor.getTamanhoColuna();

		contAi = 0;
		for(contBi = 0; contBi < numL; contBi++){
			if(contAi == isqn){
				contAi++;
			}
			contAj = 0;
			for(contBj = 0; contBj < numC; contBj++){
				if(contAj == jsqn){
					contAj++;
				}
				temp = maior.getValor(contAi,contAj);
				menor.setValor(contBi,contBj,temp);
				contAj++;
			}
			contAi++;
		}
	}

	private int detOrdemN(Matriz mat){
		int sinal,cofator,detTemp,resposta,contC,numL,numC;
		Matriz matmenor;
		numL = this.getTamanhoLinha();
		numC = this.getTamanhoColuna();
		
		resposta = 0;
		for(contC = 0; contC < mat.getTamanhoColuna(); contC++){
			cofator = mat.getValor(0,contC);
			sinal = this.calculaSinal(0,contC);
			matmenor = new Matriz(numL-1,numC-1);
			this.copiaMatrizMaiorParaMenor(mat,matmenor,0,contC);
			detTemp = matmenor.determinante();
			resposta = resposta + (cofator * sinal * detTemp);
		}
		return (resposta);
	}

	public int determinante(){
		int ordem,det;

		ordem = this.retorneOrdem();
		det = 0;

		if(ordem > 0){
			switch (ordem) {
			    case 1:  det = this.detOrdem1(this);
				     break;
			    case 2:  det = this.detOrdem2(this);;
				     break;
			    default: det = this.detOrdemN(this);;
				     break;
			}
			
		}
		else{
			System.out.println("Matriz nao eh quadrada!! retornando 0");
		}

		return det;
	}

//---------------------------------OTIMIZACAO BASICA-------------------------------

	public int[] buscaZeros(Matriz matriz){
	
		int linhaComMaisZeros = 0;
	    int maxZerosLinha = 0;
	    int colunaComMaisZeros = 0;
	    int maxZerosColunas = 0;

		for(int contI =0; contI < matriz.getTamanhoLinha(); contI++){
			int contLinhas = 0;
			int contColunas = 0;

			for(int contJ =0; contJ < matriz.getTamanhoColuna(); contJ++){
				int elmentoLinha = matriz.getValor(contI, contJ);
				int elmentoColuna = matriz.getValor(contJ, contI);

				if(elmentoLinha == 0){
					contLinhas++;
				}

				if(elmentoColuna == 0){
					contColunas++;
				}
			}

			if(contLinhas > maxZerosLinha){
				maxZerosLinha = contLinhas;
				linhaComMaisZeros = contI;
			}

			if(contColunas > maxZerosColunas){
				maxZerosColunas = contColunas;
				colunaComMaisZeros = contI;
			}
		}

		int[] vet = new int[2];

		if(maxZerosColunas < maxZerosLinha){
			vet[0] = linhaComMaisZeros; //indica indice da linha
			vet[1] = 0; // indicador de linha
		} else{
			vet[0] = colunaComMaisZeros; //indica indice da coluna
			vet[1] = 1; // indicador de  coluna
		}


		return vet;
	}




	private int detOrdemNOtimizadoV1(Matriz mat){
		int sinal,cofator,detTemp,resposta, numL, numC, indexFixo, cont;
		Matriz matmenor;
		numL = mat.getTamanhoLinha();
		numC = mat.getTamanhoColuna();
		
		resposta = 0;
		int[] verifica = mat.buscaZeros(mat);

		indexFixo = verifica[0];

		if (verifica[1] == 0) { //Percorrer linha
			for(cont = 0; cont < mat.getTamanhoColuna(); cont++){
				cofator = mat.getValor(indexFixo, cont);
				if(cofator != 0) {
					sinal = this.calculaSinal(indexFixo, cont);
					matmenor = new Matriz(numL - 1, numC - 1);
					mat.copiaMatrizMaiorParaMenor(mat, matmenor, indexFixo, cont);
					detTemp = matmenor.determinanteOtimizadoV1();
					resposta = resposta + (cofator * sinal * detTemp);
				}
			}
		} else { //verifica[1] == 1 --> Percorrer coluna
			for(cont = 0; cont < mat.getTamanhoLinha(); cont++){
				cofator = mat.getValor(cont, indexFixo);
				if(cofator != 0) {
					sinal = this.calculaSinal(cont, indexFixo);
					matmenor = new Matriz(numL - 1, numC - 1);
					mat.copiaMatrizMaiorParaMenor(mat, matmenor, cont, indexFixo);
					detTemp = matmenor.determinanteOtimizadoV1();
					resposta = resposta + (cofator * sinal * detTemp);
				}
			}
		}
		
		return (resposta);
	}

	public int determinanteOtimizadoV1(){
		int ordem,det;

		ordem = this.retorneOrdem();
		det = 0;

		if(ordem > 0){
			switch (ordem) {
			    case 1:  det = this.detOrdem1(this);
				     break;
			    case 2:  det = this.detOrdem2(this);;
				     break;
			    default: det = this.detOrdemNOtimizadoV1(this);;
				     break;
			}
			
		}
		else{
			System.out.println("Matriz nao eh quadrada!! retornando 0");
		}

		return det;
	}
//---------------------------------OTIMIZACAO EXTRA-------------------------------
	
	public boolean comparaLinhas(int linha1, int linha2) {
		boolean ehProporcional = true;
		int i = 1;

		if (linha1 != linha2) {
			double proporcao = (double) this.getValor(linha1, 0) / this.getValor(linha2, 0);   

			while (i < this.getTamanhoLinha() && ehProporcional) {
				if ((double) this.getValor(linha1, i) /  this.getValor(linha2, i)  != proporcao) {
	        		ehProporcional =  false;
	   			}

	    		i++;
			}
		}
		

		return ehProporcional;
	}

	public boolean linhasSaoProporcionais(Matriz matriz) {
		boolean ehProporcional = false;
		int i = 0;
		int j = 0;

		while (i < matriz.getTamanhoLinha() && !ehProporcional) {				
			j = 0;

			while (j  < matriz.getTamanhoColuna() && !ehProporcional) {
		    	if (i != j && matriz.comparaLinhas(i, j)) {
		        	ehProporcional =  true;
		    	}

		    	j++;
		    }

		    i++;
		}

		return ehProporcional;
	}

	public boolean comparaColunas(int coluna1, int coluna2) {
		boolean ehProporcional = true;
		int i = 1;

		if (coluna1 != coluna2) {
			double proporcao = (double) this.getValor(0, coluna1) / this.getValor(0, coluna2);   

			while (i < this.getTamanhoColuna() && ehProporcional) {
				if ((double) this.getValor(i, coluna1) /  this.getValor(i, coluna2)  != proporcao) {
		        	ehProporcional =  false;
		   		}

		    	i++;
			}
		}

		return ehProporcional;
	}

	public boolean colunasSaoProporcionais(Matriz matriz) {
		boolean ehProporcional = false;
		int i = 0;
		int j = 0;

		while (i < matriz.getTamanhoColuna() && !ehProporcional) {				
			j = 0;

			while (j  < matriz.getTamanhoColuna() && !ehProporcional) {
		    	if (i != j && matriz.comparaColunas(i, j)) {
		        	ehProporcional =  true;
		    	}

		    	j++;
		    }

		    i++;
		}

		return ehProporcional;
	}


	public int determinanteOtimizadoV2(){
		int ordem,det;

		ordem = this.retorneOrdem();
		det = 0;

		if(ordem > 0 ){
			if (!this.linhasSaoProporcionais(this) && !this.colunasSaoProporcionais(this)) {
				switch (ordem) {
			    	case 1:  det = this.detOrdem1(this);
				    	break;
			    	case 2:  det = this.detOrdem2(this);;
				    	break;
			   		default: det = this.detOrdemNOtimizadoV1(this);;
				    	break;
				}
			}
		} else {
			System.out.println("Matriz nao eh quadrada!! retornando 0");
		}

		return det;
	}
}