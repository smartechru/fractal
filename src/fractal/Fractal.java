package fractal;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Fractal extends JFrame{
	private static final long serialVersionUID=52362627884324L;
	public Fractal(){
		super("Fractal Shape v2.0 - Butterfly");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane tabbedPane=new JTabbedPane();
		Board sierpinski=new Board(300);
		sierpinski.setModel(new Sierpinski());
		sierpinski.setBackground(Color.black);
		sierpinski.setColor(Color.magenta);
		tabbedPane.addTab("Sierpinski", new ImageIcon(Fractal.class.getResource("/images/Sierpinski.png")), sierpinski);
		Board fern=new Board(400);
		fern.setModel(new Fern());
		fern.setBackground(Color.black);
		fern.setColor(Color.green);
		tabbedPane.addTab("Fern", new ImageIcon(Fractal.class.getResource("/images/Fern.png")), fern);
		Board maple=new Board(450);
		maple.setModel(new MapleLeaf());
		maple.setBackground(Color.black);
		maple.setColor(Color.red);
		tabbedPane.addTab("MapleLeaf", new ImageIcon(Fractal.class.getResource("/images/Maple leaf.png")), maple);
		Board tree=new Board(700);
		tree.setModel(new FractalTree());
		tree.setBackground(Color.black);
		tree.setColor(Color.orange);
		tabbedPane.addTab("FractalTree", new ImageIcon(Fractal.class.getResource("/images/Fractal tree.png")), tree);
		add(tabbedPane);
		setSize(800, 450);
		setVisible(true);
	}
	public static void main(String[] args){
		new Fractal();
	}
}
