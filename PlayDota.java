import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class PlayDota {
	
	public static void play(boolean radiant, Images images, int[] color) throws IOException, AWTException, InterruptedException{
		Random r = new Random();
		int lvl = 0;
		int[] pos = new int[2]; pos[0] = 0; pos[1] = 0;
		BufferedImage capture = dotaTools.getScreenshot();
		GameStats stats = new GameStats(lvl, radiant, color, pos, false, true, capture);
		
		dotaIO.shop();
		while(! dotaIO.isGameOver(stats.getCapture(), images)){
			Thread.sleep(100 + (int)  (r.nextDouble() * 700));
			stats = decideMove(stats, images);
			if(dotaIO.isScore(stats.getCapture(), images)){
				System.out.println("ABORTED");
				System.exit(0);
			}
			if(dotaIO.isMainMenu(images)){
				dotaIO.reconnect();
				Thread.sleep(100000);
				if(! dotaIO.isGameOn(images)){
					dotaIO.rageQuit();
					Thread.sleep(3600*1000);
					break;
				}
			}
		}
		dotaIO.leaveGame();
		Thread.sleep(2000);
	}
	
	public static GameStats decideMove(GameStats stats, Images images) throws InterruptedException, AWTException, IOException {
		BufferedImage capture = dotaTools.getScreenshot();
		stats.newCapture(capture);
		Random r = new Random();
		if(r.nextDouble() < 0.25){
			dotaTools.centerHero();
		}
		
		if(dotaIO.isPause(stats.getCapture(), images)){
			Thread.sleep(1000);
			return stats;
		}
		if(dotaIO.isDead(stats.getCapture(), images)){
			Thread.sleep(1000);
			return stats;
		}
		
		stats.newPos(dotaIO.findPos(stats.getCapture(), stats.getColor()));
		int health = dotaIO.findHealth(stats.getCapture(), images);
		boolean spell1 = dotaIO.spellRdy(1, stats.getCapture(), images);
		boolean spell3 = dotaIO.spellRdy(3, stats.getCapture(), images);
		boolean spell4 = dotaIO.spellRdy(4, stats.getCapture(), images);
		boolean channel = dotaIO.isChannel(stats.getCapture(), images);
		int itemNo = dotaIO.checkInv(images, stats.getCapture());
		boolean[] itemRdy = dotaIO.checkInvRdy(images, stats.getCapture());
		
		stats.newDay(dotaIO.isDay(stats.getCapture(), images));
		int[] creepsAt = dotaIO.findCreeps(stats.isRadiant(), stats.getCapture(), images);
		int[] goodPos = dotaIO.findGoodPos(stats.isRadiant(), stats.isDay(), creepsAt);
		goodPos = dotaIO.checkTowers(stats.isRadiant(), stats.isDay(), stats.getCapture(), images, goodPos);
		double d = Math.pow((stats.getPos()[0]-goodPos[0])*(stats.getPos()[0]-goodPos[0])+(stats.getPos()[1]-goodPos[1])*(stats.getPos()[1]-goodPos[1]), 0.5);
		
		if(health != 0){
			if(itemRdy[1]){dotaIO.useItem(2);}
			dotaIO.goHome(stats.isRadiant());
			Thread.sleep(500 + (int) (r.nextDouble() * 2000));
			if(dotaIO.inBase(images)){
				System.out.println(itemNo);
				if(itemNo==1){dotaIO.buyBoots();}
				else if(itemNo==2){dotaIO.buyMeka();}
				else if(itemNo>4){dotaIO.sellItem(itemNo, images, stats.getCapture());dotaIO.buyOgre();}
			}
			return stats;
		}

		if(! channel){
			stats.lvlUp(dotaIO.lvlUp(capture, stats.getLvl(), images));
		}
		
		if(d > 5){
			if(d>10){
				dotaIO.move(goodPos);
			}
			else{
				dotaIO.smallMove(goodPos, stats.getPos());
			}
			return stats;
		}

		if(spell3 && ! channel){
			dotaIO.cast(3, stats, creepsAt);
		}
		
		if(spell4 && ! channel){
			dotaIO.cast(4, stats, creepsAt);
		}
		
		if(spell1 && ! channel){
			dotaIO.cast(1, stats, creepsAt);
		}
		
		return stats;
	}
}