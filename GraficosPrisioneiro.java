package jogoPrisioneiro;
import java.awt.*;
public class GraficosPrisioneiro extends Panel {
	
	
	public int arc, arc1;

	public void desenha(Graphics g){
		g.setColor(Color.orange);
		g.fillArc(50-5,30-5,150,150,0,arc);

		g.setColor(Color.green);
		g.fillArc(50-5,30-5,150,150,arc,arc1);

		g.setColor(Color.black);
		g.drawString("Total:",55,15);

		g.setColor(Color.orange);
		g.fillRect(5,5,15,15);

		g.setColor(Color.green);
		g.fillRect(20,20,15,15);
		}
	}




