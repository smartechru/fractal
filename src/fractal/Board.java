package fractal;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Board extends Canvas {
	private static final long serialVersionUID = 423535411L;
	private int max;
	private int x, y;
	private int beginX, beginY;
	private int deltaX, deltaY;
	private int transX, transY;
	private int scale, radius;
	private Color color;
	private FractalModel obj;

	public Board(int scale) {
		setMax(30000);
		transX = 0;
		transY = 0;
		deltaX = 400;
		deltaY = 400;
		radius = 2;
		setScale(scale);
		addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				if (e.getWheelRotation() < 0) {
					setZoom(1.2);
				} else {
					setZoom(0.8);
				}
				repaint();
			}

		});
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setBeginPoint(e.getX(), e.getY());
			}

			public void mouseReleased(MouseEvent e) {
				setDelta();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				setTrans(e.getX(), e.getY());
				repaint();
			};
		});
	}

	public void paint(Graphics grh) {
		grh.setColor(color);
		x = y = 0;
		for (int i = 0; i < max; i++) {
			double ran = Math.random();
			int which = obj.selectParameter(ran);
			int nextX = getNextX(which);
			int nextY = getNextY(which);
			x = nextX;
			y = nextY;
			if (obj instanceof MapleLeaf) {
				grh.fillOval(x + deltaX - scale / 2 + transX, deltaY - y + scale / 9 + transY, radius, radius);
			} else if (obj instanceof Sierpinski) {
				grh.fillOval(x + deltaX - scale / 2 + transX, deltaY - y - scale / 5 + transY, radius, radius);
			} else {
				grh.fillOval(x + deltaX + transX, deltaY - y + transY, radius, radius);
			}
		}
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setModel(FractalModel obj) {
		this.obj = obj;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public void setZoom(double zoom) {
		scale = (int) Math.round(scale * zoom);
		radius = (int) Math.round(radius * zoom);
	}

	public void setBeginPoint(int x, int y) {
		beginX = x;
		beginY = y;
	}

	public void setTrans(int x, int y) {
		transX = x - beginX;
		transY = y - beginY;
	}

	public void setDelta() {
		deltaX += transX;
		deltaY += transY;
	}

	private int getNextX(int index) {
		double[][] ps = obj.getParameter();
		return (int) (ps[index][0] * x + ps[index][1] * y + ps[index][4] * scale);
	}

	private int getNextY(int index) {
		double[][] ps = obj.getParameter();
		return (int) (ps[index][2] * x + ps[index][3] * y + ps[index][5] * scale);
	}

}
