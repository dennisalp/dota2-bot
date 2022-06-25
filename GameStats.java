import java.awt.image.BufferedImage;

public class GameStats {
	final private boolean radiant;
	final private int[] color;
	private int lvl;
	private int[] pos;
	private boolean day;
	private BufferedImage capture;

	public GameStats(int lvl, boolean radiant, int[] color, int[] pos, boolean goReg, boolean day, BufferedImage capture) {
		this.lvl = lvl;
		this.radiant = radiant;
		this.color = color;
		this.pos = pos;
		this.day = day;
		this.capture = capture;
	}
	
	public int getLvl(){
		return this.lvl;
	}
	
	public boolean isRadiant(){
		return this.radiant;
	}
	
	public int[] getColor(){
		return this.color;
	}
	
	public int[] getPos(){
		return this.pos;
	}
	
	public boolean isDay(){
		return this.day;
	}
	
	public BufferedImage getCapture(){
		return this.capture;
	}
	
	public void lvlUp(boolean lvlup){
		if(lvlup){
			this.lvl++;
		}
	}
	
	public void newPos(int[] pos){
		this.pos = pos;
	}
	
	public void newDay(boolean day){
		this.day = day;
	}
	
	public void newCapture(BufferedImage newCapture){
		this.capture = newCapture;
	}
}
