package jogoPrisioneiro;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Prisioneiro extends Frame implements ActionListener{
//Dados Globias
private static final long serialVersionUID=1l;
int altura=640,largura=960;
private final String st[] = {"Setup","Jogar","Listar","GraficosPrisioneiro","-","Abandonar"};
private final String st1[] = {"Programa","Linguagem","-","Autor"};
private final String stbt[] = {"I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI"};
private final String stbt1[] = {"Comecar 1","Acabar 1","Comecar 2","Acabar 2","Abandonar"};
static String s, output="\n\tJogador1  Pontos\t\tJogador2  Pontos";
MenuBar mnb;
Menu mn, mn1;
MenuItem it[] = new MenuItem[st.length];
MenuItem it1[] = new MenuItem[st1.length];
Panel centro,sul;
Button bt[] = new Button[stbt.length];
Button bt1[] = new Button[stbt1.length];
Label lb;
TextArea t = new TextArea(12,70);
Font arial = new Font("Arial",Font.BOLD,30);
Font arial1 = new Font("Arial",Font.BOLD,16);
Color vermelho = Color.red;
Color branco = Color.white;
int sair;
static int c=0, ct, x=0, y=28, v=1, jog=16, at=0;
static int[] exe = new int[16];
JogadoresPrisioneiros j = new JogadoresPrisioneiros();
GraficosPrisioneiro g = new GraficosPrisioneiro();

//Construtor
public Prisioneiro(){
super("Prisioneiro");

//BarraMenu
mnb = CriaMenu(mn,"File",it,st,mn1,"About",it1,st1);
setMenuBar(mnb);
//Paineis
centro = CriaPainel(bt,stbt,lb,arial);
add(centro,BorderLayout.CENTER);
sul = CriaPainel1(bt1,stbt1,arial1,vermelho,branco);
add(sul,BorderLayout.SOUTH);
//Frame
setResizable(false);
setSize(largura,altura);
setVisible(true);
}//end Construtor

//Metodos
//Criar Menus
public MenuBar CriaMenu (Menu m, String s, MenuItem i[], String si[],
						 Menu ma, String sa, MenuItem ia[], String sia[]){
MenuBar b;
b=new MenuBar();
m=new Menu(s);
for(ct=0;ct<si.length;ct++){
i[ct] = new MenuItem(si[ct]);
i[ct].addActionListener(this);
m.add(i[ct]);
}
i[0].setEnabled(true);
i[1].setEnabled(false);
i[2].setEnabled(false);
i[3].setEnabled(false);
i[5].setEnabled(true);
b.add(m);
ma=new Menu(sa);
for(ct=0;ct<sia.length;ct++){
ia[ct] = new MenuItem(sia[ct]);
ia[ct].addActionListener(this);
ma.add(ia[ct]);
}
b.add(ma);
return b;
}//end CriaMenu
//Criar Paineis
public Panel CriaPainel(Button b[], String s[], Label l, Font f){//Centro
Panel p;
int c = 0;
p = new Panel(new GridLayout(4,7,10,10));
for(ct=0;ct<28;ct++){
	if(ct==0||ct==1||ct==2||ct==4||ct==5||ct==6||ct==7||ct==8||ct==12||ct==13||ct==14||ct==20){
	l = new Label("");
	p.add(l);
	}else{
		b[c] = new Button(s[c]);
		b[c].setFont(f);
		b[c].addActionListener(this);
		b[c].setEnabled(false);
		p.add(b[c]);
		c++;
		}
}
return p;
}//end CriarPanel
public Panel CriaPainel1(Button b[], String s[], Font f, Color c, Color c1){
Panel p;
p = new Panel();
for(ct=0;ct<s.length;ct++){
		b[ct] = new Button(s[ct]);
		b[ct].setFont(f);
		b[ct].setBackground(c);
		b[ct].setForeground(c1);
		b[ct].addActionListener(this);
		if(ct!=4)
		b[ct].setEnabled(false);
		p.add(b[ct]);
}
return p;
}//end CriarPainel1
//Dialogos
public int CriaDialConf(String s, String st, int i) {
	int a = 0;
	a = JOptionPane.showConfirmDialog(this,s,st,i);
	return a;
	}//end Criação de Dialogo de Confirmação
public void CriaDialSaida (String s,String st, int i){
		JOptionPane.showMessageDialog(this, s, st, i);
	}//end Criação de Dialogo de Saida
public void CriaDialSaida (TextArea t,String s, int i){ //Com caixa de Texto
		t.setEditable(false);
		JOptionPane.showMessageDialog(this, t, s, i);
	}//end Criação de Dialogo de Saida TextA
public String CriaDialEnt (String s,String st, int i){
		String a = "";
		a = JOptionPane.showInputDialog(this, s, st, i);
		return a;
	}//end Criação de Dialogo de Entrada
public String lista(String s, String sa, String st, String sb){
	String a = "";
	a = String.format("\n%s %s %s %s",s,sa,st,sb);
	return a;
	}//end Criação da Listagem
public void actionPerformed(ActionEvent e){
	//Abandonar
	if (e.getSource()== bt1[4]||e.getSource()== it[5]){
		sair = CriaDialConf("\tConfirma Sair\nda Aplicacao?","Dialogo Abandonar",JOptionPane.YES_NO_OPTION);
			if (sair == JOptionPane.YES_OPTION){
				System.gc();
				System.exit(0);}
    }
	if (e.getSource()== it1[0]){//Programa
		CriaDialSaida("Jogo:     Prisioneiro\nVersão: 1.0\nData:     06-10-2019\nProjecto: TPSI PL 0619\nUFCD:     0789","Dialogo Programa",JOptionPane.INFORMATION_MESSAGE);
	}
	if (e.getSource()== it1[1]){//Linguagem
		CriaDialSaida("Linguagem: Java\nVersao:    8.0X\nSoftWareHouse: Oracle Corpotation\nLema:      Write Once Run Anywhere","Dialogo Linguagem",JOptionPane.INFORMATION_MESSAGE);
	}
	if (e.getSource()== it1[3]){//Autor
		CriaDialSaida("Nome: Silvio Neves\n\t      Carlos Cardoso","Dialogo Autor",JOptionPane.INFORMATION_MESSAGE);
	}
	if (e.getSource()== it[2]){//Listagem
		t.setEditable(false);
		t.setText(output);
		CriaDialSaida (t,"Dialogo Listagem", JOptionPane.INFORMATION_MESSAGE);
	}
	if (e.getSource()== it[0]){//Setup
		j.setJogador1(CriaDialEnt("Insira o Nome do Jogador 1","Dialogo Entrada",JOptionPane.QUESTION_MESSAGE));
		j.setJogador2(CriaDialEnt("Insira o Nome do Jogador 2","Dialogo Entrada",JOptionPane.QUESTION_MESSAGE));
		it[1].setEnabled(true);
		it[2].setEnabled(true);
		it[3].setEnabled(true);
	}
	if (e.getSource()== it[3]){//Grafico
		CriaDialSaida ("","Dialogo Graficos", JOptionPane.INFORMATION_MESSAGE);
	}
	if (e.getSource()== it[1]){
		bt1[0].setEnabled(true);
		bt1[2].setEnabled(true);
		}
		//começar o Jogo
	if(e.getSource()== bt1[0]){//Começou Jogador 1
		CriaDialSaida("A Jogar o jogador "+j.getJogador1(),"Dialogo Quem Joga",JOptionPane.INFORMATION_MESSAGE);
		bt1[0].setEnabled(false);
		bt1[1].setEnabled(true);
		bt1[2].setEnabled(false);
		at=1;
		c=0;
		for(ct=0;ct<28;ct++){ //Dar enable aos Buttons
				if(ct==0||ct==1||ct==2||ct==4||ct==5||ct==6||ct==7||ct==8||ct==12||ct==13||ct==14||ct==20){
				}
				else{
					if(exe[c] != 1)
				bt[c].setEnabled(true);
				c++;}
		}//end For
	}
	if(e.getSource()== bt1[2]){//Começou Jogador 2
		CriaDialSaida("A Jogar o jogador "+j.getJogador2(),"Dialogo Quem Joga",JOptionPane.INFORMATION_MESSAGE);
		bt1[0].setEnabled(false);
		bt1[3].setEnabled(true);
		bt1[2].setEnabled(false);
		at=2;
		c=0;
		for(ct=0;ct<28;ct++){ //Dar enable aos Buttons
				if(ct==0||ct==1||ct==2||ct==4||ct==5||ct==6||ct==7||ct==8||ct==12||ct==13||ct==14||ct==20){
				}
				else{
					if(exe[c] != 1)
				bt[c].setEnabled(true);
				c++;}
		}
	}
	if(e.getSource()== bt1[1]){//Acabar Jogador 1
		bt1[2].setEnabled(true);
		bt1[1].setEnabled(false);
		c=0;
		for(ct=0;ct<28;ct++){ //Dar Disable aos Buttons
				if(ct==0||ct==1||ct==2||ct==4||ct==5||ct==6||ct==7||ct==8||ct==12||ct==13||ct==14||ct==20){
					}
					else{
					bt[c].setEnabled(false);
					c++;
					}
		}
		v=1;
	}
	if(e.getSource()== bt1[3]){//Acabar Jogador 1
		bt1[0].setEnabled(true);
		bt1[3].setEnabled(false);
		c=0;
		for(ct=0;ct<28;ct++){ //Dar Disable aos Buttons
				if(ct==0||ct==1||ct==2||ct==4||ct==5||ct==6||ct==7||ct==8||ct==12||ct==13||ct==14||ct==20){
					}
					else{
					bt[c].setEnabled(false);
					c++;
					}
		}
		v=1;
	}
	for(ct=0;ct<16;ct++){//For Jogar
	if(e.getSource() == bt[ct]){
		if(v == 1){
			if(ct==0){
				x=0;
				y=0;
			}
			if(ct>0 && ct<4){
				x=1;
				y=3;
			}
			if(ct>3 && ct<9){
				x=4;
				y=8;
			}
			if(ct>8 && ct<16){
				x=9;
				y=15;
			}
		}
		v=0;
	if(ct>=x && ct<=y){
		bt[ct].setEnabled(false);
		exe[ct]=1;
		jog--;
		if(jog == 0){
			if(at == 1){
			CriaDialSaida("Ronda ganha por: "+j.getJogador2(),"Dialogo Quem Ganha",JOptionPane.INFORMATION_MESSAGE);
			j.setPontos2(10);
			output += lista("\t"+j.getJogador1(),"     0","\t\t\t "+j.getJogador2(),"       10");
			bt1[1].setEnabled(false);
				}
			if(at == 2){
			CriaDialSaida("Ronda ganha por: "+j.getJogador1(),"Dialogo Quem Ganha",JOptionPane.INFORMATION_MESSAGE);
			j.setPontos1(10);
			output += lista("\t"+j.getJogador1(),"     10","\t\t\t "+j.getJogador2(),"       0");
			bt1[3].setEnabled(false);
				}
			}
		}
		else
		CriaDialSaida("Entrada Invalida,\n a jogada esta fora da\nlinha que inicialmente\n comecou a jogar.","Dialogo de Erro",JOptionPane.ERROR_MESSAGE);
		}//end Ifs
	}//fim do For jogar
}
public static void main(String[] args){
Prisioneiro app = new Prisioneiro();
app.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e){
        System.gc();
        System.exit(0);
    }
});
}//end Main
}//end Public
