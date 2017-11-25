package fractal;

public class MapleLeaf implements FractalModel{
	private double[] p;
	private double[][] ps;
	public MapleLeaf(){
		init();
	}
	private void init(){
		p=new double[4];
		ps=new double[4][6];
		p[0]=0.32; p[1]=0.216; p[2]=0.232; p[3]=0.232;
		ps[0][0]=0.8; ps[0][1]=0; ps[0][2]=0; ps[0][3]=0.8; ps[0][4]=0.1; ps[0][5]=0.04;
		ps[1][0]=0.5; ps[1][1]=0; ps[1][2]=0; ps[1][3]=0.5; ps[1][4]=0.25; ps[1][5]=0.4;
		ps[2][0]=0.355; ps[2][1]=-0.355; ps[2][2]=0.355; ps[2][3]=0.355; ps[2][4]=0.26; ps[2][5]=0.078;
		ps[3][0]=0.355; ps[3][1]=0.355; ps[3][2]=-0.355; ps[3][3]=0.355; ps[3][4]=0.378; ps[3][5]=0.434;
	}
	public double[][] getParameter(){
		return ps;
	}
	public int selectParameter(double ran){
		if (0<=ran && ran<=p[0]){
			return 0;
		}else if (p[0]<ran && ran<=p[0]+p[1]){
			return 1;
		}else if (p[0]+p[1]<ran && ran<=p[0]+p[1]+p[2]){
			return 2;
		}else if (p[0]+p[1]+p[2]<ran && ran<=1){
			return 3;
		}else{
			return -1;
		}
	}
}