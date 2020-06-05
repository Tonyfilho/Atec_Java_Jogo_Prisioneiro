package jogoPrisioneiro;

public class JogadoresPrisioneiros {

		String jogador1, jogador2;
		int pontos1, pontos2;
		//Get
		public String getJogador1(){return this.jogador1;}
		public String getJogador2(){return this.jogador2;}
		public int getPontos1(){return this.pontos1;}
		public int getPontos2(){return this.pontos2;}
		//Set
		public void setJogador1(String j){this.jogador1 = j;}
		public void setJogador2(String j){this.jogador2 = j;}
		public void setPontos1(int p){this.pontos1 += p;}
		public void setPontos2(int p){this.pontos2 += p;}
		//Clear
		public void clearPontos1(int p){this.pontos1 = 0;}
		public void clearPontos2(int p){this.pontos2 = 0;}
		
}//end Class
