import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	private final BufferedImage desktop;
	private final BufferedImage mainMenu;
	private final BufferedImage acceptMatch;
	private final BufferedImage loadingScreen;
	private final BufferedImage pickHero;
	private final BufferedImage color;
	private final BufferedImage heroLoadout;
	private final BufferedImage paused;
	private final BufferedImage end;
	private final BufferedImage dead;
	private final BufferedImage channel;
	private final BufferedImage spells;
	private final BufferedImage spellsUlt;
	private final BufferedImage defaultMap1;
	private final BufferedImage defaultMap2;
	private final BufferedImage update;
	private final BufferedImage grid;
	private final BufferedImage invRdy;
	private final BufferedImage score;

	public Images() throws IOException {
		this.desktop = ImageIO.read(new File("C:\\Users\\Dennis\\Dropbox\\Scripts\\Java\\Bot\\images\\desktop.bmp"));
		this.mainMenu = ImageIO.read(new File("C:\\Users\\Dennis\\Dropbox\\Scripts\\Java\\Bot\\images\\mainMenu.bmp"));
		this.acceptMatch = ImageIO.read(new File("C:\\Users\\Dennis\\Dropbox\\Scripts\\Java\\Bot\\images\\acceptMatch.bmp"));
		this.loadingScreen = ImageIO.read(new File("C:\\Users\\Dennis\\Dropbox\\Scripts\\Java\\Bot\\images\\loadingScreen.bmp"));
		this.pickHero = ImageIO.read(new File("C:\\Users\\Dennis\\Dropbox\\Scripts\\Java\\Bot\\images\\pickHero.bmp"));
		this.color = ImageIO.read(new File("C:\\Users\\Dennis\\Dropbox\\Scripts\\Java\\Bot\\images\\color.bmp"));
		this.heroLoadout = ImageIO.read(new File("C:\\Users\\Dennis\\Dropbox\\Scripts\\Java\\Bot\\images\\heroLoadout.bmp"));
		this.paused = ImageIO.read(new File("C:\\Users\\Dennis\\Dropbox\\Scripts\\Java\\Bot\\images\\paused.bmp"));
		this.end = ImageIO.read(new File("C:\\Users\\Dennis\\Dropbox\\Scripts\\Java\\Bot\\images\\end.bmp"));
		this.dead = ImageIO.read(new File("C:\\Users\\Dennis\\Dropbox\\Scripts\\Java\\Bot\\images\\dead.bmp"));
		this.channel = ImageIO.read(new File("C:\\Users\\Dennis\\Dropbox\\Scripts\\Java\\Bot\\images\\channel.bmp"));
		this.spells = ImageIO.read(new File("C:\\Users\\Dennis\\Dropbox\\Scripts\\Java\\Bot\\images\\spells.bmp"));
		this.spellsUlt = ImageIO.read(new File("C:\\Users\\Dennis\\Dropbox\\Scripts\\Java\\Bot\\images\\spellsUlt.bmp"));
		this.defaultMap1 = ImageIO.read(new File("C:\\Users\\Dennis\\Dropbox\\Scripts\\Java\\Bot\\images\\defaultMap1.bmp"));
		this.defaultMap2 = ImageIO.read(new File("C:\\Users\\Dennis\\Dropbox\\Scripts\\Java\\Bot\\images\\defaultMap2.bmp"));
		this.update = ImageIO.read(new File("C:\\Users\\Dennis\\Dropbox\\Scripts\\Java\\Bot\\images\\update.bmp"));
		this.grid = ImageIO.read(new File("C:\\Users\\Dennis\\Dropbox\\Scripts\\Java\\Bot\\images\\grid.bmp"));
		this.invRdy = ImageIO.read(new File("C:\\Users\\Dennis\\Dropbox\\Scripts\\Java\\Bot\\images\\invRdy.bmp"));
		this.score = ImageIO.read(new File("C:\\Users\\Dennis\\Dropbox\\Scripts\\Java\\Bot\\images\\score.bmp"));
	}
	
	public BufferedImage getDesktop(){
		return this.desktop;
	}
	
	public BufferedImage getMainMenu(){
		return this.mainMenu;
	}
	
	public BufferedImage getAcceptMatch(){
		return this.acceptMatch;
	}
	
	public BufferedImage getRadiant(){
		return this.loadingScreen;
	}
	
	public BufferedImage getLoadingScreen(){
		return this.loadingScreen;
	}
	
	public BufferedImage getPickHero(){
		return this.pickHero;
	}
	
	public BufferedImage getColor(){
		return this.color;
	}
	
	public BufferedImage getHeroLoadout(){
		return this.heroLoadout;
	}
	
	public BufferedImage getPaused(){
		return this.paused;
	}
	
	public BufferedImage getGameOn(){
		return this.paused;
	}
	
	public BufferedImage getEnd(){
		return this.end;
	}
	
	public BufferedImage getDead(){
		return this.dead;
	}
	
	public BufferedImage getChannel(){
		return this.channel;
	}

	public BufferedImage getSpells(){
		return this.spells;
	}

	public BufferedImage getSpellsUlt(){
		return this.spellsUlt;
	}
	
	public BufferedImage getLvlUp() {
		return this.paused;
	}

	public BufferedImage getFullHealth() {
		return this.paused;
	}
	
	public BufferedImage getDay(){
		return this.paused;
	}

	public BufferedImage getDefaultMap1() {
		return this.defaultMap1;
	}

	public BufferedImage getDefaultMap2() {
		return this.defaultMap2;
	}
	
	public BufferedImage getUpdate() {
		return this.update;
	}
	
	public BufferedImage getGrid() {
		return this.grid;
	}
	
	public BufferedImage getInv() {
		return this.spells;
	}

	public BufferedImage getInvRdy() {
		return this.invRdy;
	}

	public BufferedImage getInvEmpty() {
		return this.paused;
	}
	
	public BufferedImage getBase() {
		return this.invRdy;
	}
	
	public BufferedImage getScore() {
		return this.score;
	}
}