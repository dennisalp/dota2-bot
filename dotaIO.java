import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class dotaIO {
	
	public static boolean isDesktop(Images images) throws IOException, AWTException, InterruptedException
	{
        dotaTools.myMouseMove(1593, 885, 0, 0);
        dotaTools.myMouseClick();
        Thread.sleep(200);
        dotaTools.myMouseMove(300, 300, 0, 0);
        dotaTools.myMouseClick();
        Thread.sleep(200);
        
		int[] testpixelsx = new int[4];
		int[] testpixelsy = new int[4];
		testpixelsx[0]=2; testpixelsy[0]=2;
		testpixelsx[1]=23; testpixelsy[1]=13;
		testpixelsx[2]=48; testpixelsy[2]=13;
		testpixelsx[3]=27; testpixelsy[3]=28;
		
		BufferedImage desktop = images.getDesktop();
		
		BufferedImage capture = dotaTools.getScreenshot();

		return dotaTools.testImg(desktop, capture, testpixelsx, testpixelsy, 1);
	}
	
	public static boolean isMainMenu(Images images) throws IOException, AWTException, InterruptedException
	{
		int[] testpixelsx = new int[3];
		int[] testpixelsy = new int[3];
		testpixelsx[0]=79; testpixelsy[0]=14;
		testpixelsx[1]=302; testpixelsy[1]=14;
		testpixelsx[2]=150; testpixelsy[2]=14;
		
		BufferedImage main_menu = images.getMainMenu();
		
		BufferedImage capture = dotaTools.getScreenshot();

		return dotaTools.testImg(main_menu, capture, testpixelsx, testpixelsy, 10);
	}
	
	public static boolean isGameReady(Images images) throws IOException, AWTException, InterruptedException
	{
		int[] testpixelsx = new int[3];
		int[] testpixelsy = new int[3];
		testpixelsx[0]=515; testpixelsy[0]=292;
		testpixelsx[1]=744; testpixelsy[1]=295;
		testpixelsx[2]=1052; testpixelsy[2]=431;
		
		BufferedImage acceptMatch = images.getAcceptMatch();
		
		BufferedImage capture = dotaTools.getScreenshot();
		
		return dotaTools.testImg(acceptMatch, capture, testpixelsx, testpixelsy, 10);
	}
	
	public static boolean isInGame(Images images) throws IOException, AWTException, InterruptedException
	{
		int points = 3;
		int[] testpixelsx = new int[points];
		int[] testpixelsy = new int[points];
		testpixelsx[0]=188; testpixelsy[0]=15;
		testpixelsx[1]=217; testpixelsy[1]=15;
		testpixelsx[2]=245; testpixelsy[2]=15;
		
		BufferedImage loading_screen = images.getLoadingScreen();
		
		BufferedImage capture = dotaTools.getScreenshot();

		return dotaTools.testImg(loading_screen, capture, testpixelsx, testpixelsy, 10);
	}
	
	public static boolean isRadiant(Images images) throws IOException, AWTException, InterruptedException
	{
		int points = 3;
		int[] testpixelsx = new int[points];
		int[] testpixelsy = new int[points];
		testpixelsx[0]=62; testpixelsy[0]=864;
		testpixelsx[1]=23; testpixelsy[1]=879;
		testpixelsx[2]=214; testpixelsy[2]=702;
		
		BufferedImage radiant = images.getRadiant();
		
		BufferedImage capture = dotaTools.getScreenshot();

		return dotaTools.testImg(radiant, capture, testpixelsx, testpixelsy, 10);
	}

	public static boolean isPicking(Images images) throws IOException, AWTException, InterruptedException
	{
		int points = 3;
		int[] testpixelsx = new int[points];
		int[] testpixelsy = new int[points];
		testpixelsx[0]=67; testpixelsy[0]=17;
		testpixelsx[1]=316; testpixelsy[1]=592;
		testpixelsx[2]=362; testpixelsy[2]=753;
		
		BufferedImage pick_hero = images.getPickHero();
		
		BufferedImage capture = dotaTools.getScreenshot();

		return dotaTools.testImg(pick_hero, capture, testpixelsx, testpixelsy, 10);
	}
	
	public static int[] findColor(Images images) throws AWTException{
		BufferedImage color = images.getColor();
		BufferedImage capture = dotaTools.getScreenshot();
		int answer = 0;
		int[] x = new int[9]; int[] y = new int[9];
		y[0] = 87; y[1] = 87; y[2] = 87;
		y[3] = 78; y[4] = 78; y[5] = 78;
		y[6] = 99; y[7] = 99; y[8] = 99;
		for(int i = 0; i < 5; i++){
			x[0] = 140 + 89*i; x[1] = 165 + 89*i; x[2] = 200 + 89*i;
			x[3] = 140 + 89*i; x[4] = 165 + 89*i; x[5] = 200 + 89*i;
			x[6] = 140 + 89*i; x[7] = 165 + 89*i; x[8] = 200 + 89*i;
			if(dotaTools.testImg(color, capture, x, y, 20)){
				answer = i;
			}
		}
		for(int i = 0; i < 5; i++){
			x[0] = 1020 + 89*i; x[1] = 1030 + 89*i; x[2] = 1060 + 89*i;
			x[3] = 1020 + 89*i; x[4] = 1030 + 89*i; x[5] = 1060 + 89*i;
			x[6] = 1020 + 89*i; x[7] = 1030 + 89*i; x[8] = 1060 + 89*i;
			if(dotaTools.testImg(color, capture, x, y, 20)){
				answer = i + 5;
			}
		}
		
		int[] col = new int[4];
		if(answer == 0){
			col[0] = 38; col[1] = 97; col[2] = 213;
		}
		if(answer == 1){
			col[0] = 88; col[1] = 222; col[2] = 167;
		}
		if(answer == 2){
			col[0] = 170; col[1] = 0; col[2] = 170;
		}
		if(answer == 3){
			col[0] = 214; col[1] = 212; col[2] = 3;
		}
		if(answer == 4){
			col[0] = 221; col[1] = 92; col[2] = 0;
		}
		if(answer == 5){
			col[0] = 223; col[1] = 118; col[2] = 171;
		}
		if(answer == 6){
			col[0] = 139; col[1] = 156; col[2] = 58;
		}
		if(answer == 7){
			col[0] = 87; col[1] = 190; col[2] = 216;
		}
		if(answer == 8){
			col[0] = 0; col[1] = 107; col[2] = 20;
		}
		if(answer == 9){
			col[0] = 139; col[1] = 88; col[2] = 0;
		}
		col[3] = answer;
		return col;
	}

	public static boolean isLoadout(Images images) throws IOException, AWTException, InterruptedException
	{
		dotaTools.myMouseMove(200, 200, 100, 100);
		int points = 3;
		int[] testpixelsx = new int[points];
		int[] testpixelsy = new int[points];
		testpixelsx[0]=121; testpixelsy[0]=583;
		testpixelsx[1]=539; testpixelsy[1]=580;
		testpixelsx[2]=616; testpixelsy[2]=611;
		
		BufferedImage heroLoadout = images.getHeroLoadout();
		
		BufferedImage capture = dotaTools.getScreenshot();

		return dotaTools.testImg(heroLoadout, capture, testpixelsx, testpixelsy, 10);
	}	

	public static boolean isPickEnded(Images images) throws IOException, AWTException, InterruptedException
	{
		int points = 2;
		int[] testpixelsx = new int[points];
		int[] testpixelsy = new int[points];
		testpixelsx[0]=769; testpixelsy[0]=612;
		testpixelsx[1]=798; testpixelsy[1]=609;
		
		BufferedImage heroLoadout = images.getHeroLoadout();
		
		BufferedImage capture = dotaTools.getScreenshot();

		return dotaTools.testImg(heroLoadout, capture, testpixelsx, testpixelsy, 10);
	}	
	
	public static boolean isGameOn(Images images) throws IOException, AWTException, InterruptedException
	{
		int points = 3;
		int[] testpixelsx = new int[points];
		int[] testpixelsy = new int[points];
		testpixelsx[0]=301; testpixelsy[0]=793;
		testpixelsx[1]=947; testpixelsy[1]=888;
		testpixelsx[2]=1183; testpixelsy[2]=847;
		
		BufferedImage gameOn = images.getGameOn();
		
		BufferedImage capture = dotaTools.getScreenshot();

		return dotaTools.testImg(gameOn, capture, testpixelsx, testpixelsy, 10);
	}	
	
	public static boolean isPause(BufferedImage capture, Images images) throws IOException
	{
		int points = 3;
		int[] testpixelsx = new int[points];
		int[] testpixelsy = new int[points];
		testpixelsx[0]=950; testpixelsy[0]=370;
		testpixelsx[1]=769; testpixelsy[1]=365;
		testpixelsx[2]=759; testpixelsy[2]=296;
		
		BufferedImage paused = images.getPaused();
		
		return dotaTools.testImg(paused, capture, testpixelsx, testpixelsy, 5);
	}	
	
	public static boolean isGameOver(BufferedImage capture, Images images) throws IOException{
		int points = 3;
		int[] testpixelsx = new int[points];
		int[] testpixelsy = new int[points];
		testpixelsx[0]=390; testpixelsy[0]=156;
		testpixelsx[1]=1127; testpixelsy[1]=155;
		testpixelsx[2]=389; testpixelsy[2]=234;
		
		BufferedImage end = images.getEnd();

		return dotaTools.testImg(end, capture, testpixelsx, testpixelsy, 5);
	}
	
	public static boolean isDead(BufferedImage capture, Images images) throws IOException{
		int points = 5;
		int[] testpixelsx = new int[points];
		int[] testpixelsy = new int[points];
		testpixelsx[0]=603; testpixelsy[0]=773;
		testpixelsx[1]=909; testpixelsy[1]=780;
		testpixelsx[2]=604; testpixelsy[2]=771;
		testpixelsx[3]=821; testpixelsy[3]=380;
		testpixelsx[4]=1035; testpixelsy[4]=570;
		
		BufferedImage dead = images.getDead();

		return dotaTools.testImg(dead, capture, testpixelsx, testpixelsy, 6);
	}
	
	public static boolean isChannel(BufferedImage capture, Images images) throws IOException{
		int points = 3;
		int[] testpixelsx = new int[points];
		int[] testpixelsy = new int[points];
		testpixelsx[0]=692; testpixelsy[0]=654;
		testpixelsx[1]=676; testpixelsy[1]=675;
		testpixelsx[2]=712; testpixelsy[2]=680;
		
		BufferedImage channel = images.getChannel();

		return dotaTools.testImg(channel, capture, testpixelsx, testpixelsy, 10);
	}
	
	public static boolean isDay(BufferedImage capture, Images images) throws IOException{
		int points = 3;
		int[] testpixelsx = new int[points];
		int[] testpixelsy = new int[points];
		testpixelsx[0]=800; testpixelsy[0]=36;
		testpixelsx[1]=798; testpixelsy[1]=46;
		testpixelsx[2]=800; testpixelsy[2]=42;
		
		BufferedImage channel = images.getDay();

		return dotaTools.testImg(channel, capture, testpixelsx, testpixelsy, 10);
	}
	
	public static boolean isGrid(Images images) throws IOException, AWTException{
		BufferedImage capture = dotaTools.getScreenshot();
		int points = 3;
		int[] testpixelsx = new int[points];
		int[] testpixelsy = new int[points];
		testpixelsx[0]=24; testpixelsy[0]=612;
		testpixelsx[1]=29; testpixelsy[1]=616;
		testpixelsx[2]=35; testpixelsy[2]=622;
		
		BufferedImage grid = images.getGrid();

		return dotaTools.testImg(grid, capture, testpixelsx, testpixelsy, 10);
	}
	
	public static boolean isScore(BufferedImage capture, Images images) throws IOException, AWTException, InterruptedException
	{
		int points = 3;
		int[] testpixelsx = new int[points];
		int[] testpixelsy = new int[points];
		testpixelsx[0] = 157; testpixelsy[0] = 95;
		testpixelsx[1] = 165; testpixelsy[1] = 331;
		testpixelsx[2] = 405; testpixelsy[2] = 332;
		
		BufferedImage score = images.getScore();

		return dotaTools.testImg(score, capture, testpixelsx, testpixelsy, 3);
	}
	
	public static void launchDota() throws AWTException, InterruptedException{
		dotaTools.myMouseMove(38, 28, 0, 0);
		dotaTools.myMouseDoubleClick();
	}
	
	public static void findBotGame() throws AWTException, InterruptedException{
		dotaTools.myMouseMove(721, 20, 40, 10);
		dotaTools.myMouseClick();
		dotaTools.myMouseMove(170, 250, 60, 9);
		dotaTools.myMouseClick();
		dotaTools.myMouseMove(553, 611, 110, 14);
		dotaTools.myMouseClick();
		Thread.sleep(500);
	}
	
	public static void waitForGame(Images images) throws IOException, AWTException, InterruptedException{
		System.out.println("Checkpoint 2.1");
		boolean game_rdy = false;
		while(! game_rdy){
			game_rdy = isGameReady(images);
			if(game_rdy){
				dotaTools.myMouseMove(646, 429, 115, 15);
				dotaTools.myMouseClick();
				Thread.sleep(3000);
				System.out.println("Checkpoint 2.2");
				game_rdy = confirmMatchStart(images);
			}
		}
		Thread.sleep(500);
	}
	
	public static boolean confirmMatchStart(Images images) throws IOException, AWTException, InterruptedException{
		boolean declined = false;
		boolean started = false;
		while(! declined && ! started){
			started = isInGame(images);
			declined = isGameReady(images);
		}
		return started;
	}

	public static boolean pickEzalor(Images images) throws AWTException, InterruptedException, IOException{
		Random r = new Random();
		Robot robot = new Robot();
		int speed = 45;
		while(! dotaIO.isGrid(images)){
			robot.keyPress(KeyEvent.VK_CONTROL);
			Thread.sleep((int) (speed + speed * r.nextDouble()));
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(500);
		}
		dotaTools.myMouseMove(1128, 328, 20, 25);
		dotaTools.myMouseClick();
		dotaTools.myMouseMove(800, 595, 100, 20);
		dotaTools.myMouseClick();
		Thread.sleep(1000);
		if(!isLoadout(images)){
			dotaTools.myMouseMove(800, 595, 100, 20);
			dotaTools.myMouseClick();
			Thread.sleep(1000);
		}
		return isLoadout(images);
	}
	
	public static void startPlay(Images images) throws IOException, AWTException, InterruptedException{
		System.out.println("Checkpoint 4.1");
		while(! isPickEnded(images)){
			Thread.sleep(1000);
		}
		System.out.println("Checkpoint 4.2");
		dotaTools.myMouseMove(797, 573, 75, 50);
		dotaTools.myMouseClick();
		Thread.sleep(4500);
	}
	
	public static int[] findCreeps(boolean radiant, BufferedImage capture, Images images) throws AWTException, IOException{
		
		BufferedImage defaultMap1 = images.getDefaultMap1();
		BufferedImage defaultMap2 = images.getDefaultMap2();
		int[] creepsAt = new int[2];
		
		if(radiant){
			for(int i = 0; i < 149; i++){
				if(capture.getRGB(183-i, 696) != defaultMap1.getRGB(183-i, 696) && capture.getRGB(183-i, 696) != defaultMap2.getRGB(183-i, 696)){
					creepsAt[0] = 183-i; creepsAt[1] = 696;
					break;
				}
			}
			if(creepsAt[0] == 0){
				for(int i = 0; i < 175; i++){
					if(capture.getRGB(33, 696+i) != defaultMap1.getRGB(33, 696+i) && capture.getRGB(33, 696+i) != defaultMap2.getRGB(33, 696+i)){
						creepsAt[0] = 33; creepsAt[1] = 696+i;
						break;
					}
				}
			}
		}
		
		else{
			for(int i = 0; i < 151; i++){
				if(capture.getRGB(60+i, 873) != defaultMap1.getRGB(60+i, 873) && capture.getRGB(60+i, 873) != defaultMap2.getRGB(60+i, 873)){
					creepsAt[0] = 60+i; creepsAt[1] = 873;
					break;
				}
			}
			if(creepsAt[0] == 0){
				for(int i = 0; i < 140; i++){
					if(capture.getRGB(217, 870-i) != defaultMap1.getRGB(217, 870-i) && capture.getRGB(217, 870-i) != defaultMap2.getRGB(217, 870-i)){
						creepsAt[0] = 217; creepsAt[1] = 870-i;
						break;
					}
				}
			}
		}
		return creepsAt;
	}
	
	public static int findHealth(BufferedImage capture, Images images) throws IOException, AWTException{
		BufferedImage hp = images.getFullHealth();
		for(int i = 0; i < 4; i++){
			if(hp.getRGB(1112-124*i, 778) == capture.getRGB(1112-124*i, 778)){
				return i;
			}
		}
		return 3;
	}
	
	public static boolean spellRdy(int number, BufferedImage capture, Images images) throws AWTException, IOException{
		BufferedImage spellsUp = images.getSpells();
		BufferedImage spellsUpUlt = images.getSpellsUlt();
		int[] spellLoc = new int[4];
		spellLoc[0] = 782; spellLoc[1] = 843; spellLoc[2] = 907; spellLoc[3] = 1096;
		if(number==1){
			return (spellsUp.getRGB(spellLoc[number-1], 813) == capture.getRGB(spellLoc[number-1], 813) 
					|| (spellsUpUlt.getRGB(spellLoc[number-1], 813) == capture.getRGB(spellLoc[number-1], 813)));
		}
		return (spellsUp.getRGB(spellLoc[number-1], 813) == capture.getRGB(spellLoc[number-1], 813));
	}
	

	public static boolean lvlUp(BufferedImage capture, int lvl, Images images) throws IOException, AWTException, InterruptedException {
		BufferedImage lvlPoint = images.getLvlUp();
		Robot robot = new Robot();
		Random r = new Random();
		int speed = 45;
		if(lvlPoint.getRGB(398, 667) == capture.getRGB(398, 667) && lvlPoint.getRGB(408, 677) == capture.getRGB(408, 677) && lvlPoint.getRGB(402, 669) == capture.getRGB(402, 669)){
			lvl++;
			robot.keyPress(KeyEvent.VK_2);
			Thread.sleep((int) (speed + speed * r.nextDouble()));
			robot.keyRelease(KeyEvent.VK_2);
			Thread.sleep((int) (speed + speed * r.nextDouble()));
			if(lvl == 2 || lvl == 4 || lvl == 6 || lvl == 8){
				robot.keyPress(KeyEvent.VK_Q);
				Thread.sleep((int) (speed + speed * r.nextDouble()));
				robot.keyRelease(KeyEvent.VK_Q);
				Thread.sleep((int) (speed + speed * r.nextDouble()));
			}
			else if(lvl == 1 || lvl == 3 || lvl == 5 || lvl == 7){
				robot.keyPress(KeyEvent.VK_E);
				Thread.sleep((int) (speed + speed * r.nextDouble()));
				robot.keyRelease(KeyEvent.VK_E);
				Thread.sleep((int) (speed + speed * r.nextDouble()));
			}
			else if(lvl == 9 || lvl == 11 || lvl == 16){
				robot.keyPress(KeyEvent.VK_R);
				Thread.sleep((int) (speed + speed * r.nextDouble()));
				robot.keyRelease(KeyEvent.VK_R);
				Thread.sleep((int) (speed + speed * r.nextDouble()));
			}
			else if(lvl == 22 || lvl == 23 || lvl == 24 || lvl == 25){
				robot.keyPress(KeyEvent.VK_W);
				Thread.sleep((int) (speed + speed * r.nextDouble()));
				robot.keyRelease(KeyEvent.VK_W);
				Thread.sleep((int) (speed + speed * r.nextDouble()));
			}
			else{
				robot.keyPress(KeyEvent.VK_T);
				Thread.sleep((int) (speed + speed * r.nextDouble()));
				robot.keyRelease(KeyEvent.VK_T);
				Thread.sleep((int) (speed + speed * r.nextDouble()));
			}
			return true;
		}
		return false;
	}
	
	public static void move(int[] goodPos) throws AWTException, InterruptedException{
		dotaTools.myMouseMove(goodPos[0], goodPos[1], 1, 1);
		Thread.sleep(100);
		dotaTools.myMouseRightClick();
		dotaTools.myMouseMove(837, 450, 200, 200);
	}
	
	public static void smallMove(int[] goodPos, int[] currentPos) throws AWTException, InterruptedException{
		int dx = goodPos[0] - currentPos[0];
		int dy = goodPos[1] - currentPos[1];
		double theta = Math.atan((double) dy/dx);
		if(dx<0){
			theta = theta+Math.PI;
		}
		dotaTools.centerHero();
		dotaTools.myMouseMove(800 + (int) (250 * Math.cos(theta)), 400 + (int) (250 * Math.sin(theta)), 10, 10);
		dotaTools.myMouseRightClick();
	}
	
	public static void goHome(boolean radiant) throws AWTException, InterruptedException{
		if(radiant){
			dotaTools.myMouseMove(21, 880, 7, 8);
			dotaTools.myMouseRightClick();
			dotaTools.myMouseMove(21, 880, 7, 8);
			dotaTools.myMouseRightClick();
			dotaTools.myMouseMove(21, 880, 7, 8);
			dotaTools.myMouseRightClick();
		}
		else{
			dotaTools.myMouseMove(227, 687, 6, 6);
			dotaTools.myMouseRightClick();
			dotaTools.myMouseMove(227, 687, 6, 6);
			dotaTools.myMouseRightClick();
			dotaTools.myMouseMove(227, 687, 6, 6);
			dotaTools.myMouseRightClick();
		}
	}
	
	public static boolean inBase(Images images) throws AWTException{
		int points = 1;
		int[] testpixelsx = new int[points];
		int[] testpixelsy = new int[points];
		testpixelsx[0]=1526; testpixelsy[0]=744;

		BufferedImage base = images.getBase();
		BufferedImage capture = dotaTools.getScreenshot();
		return dotaTools.testImg(base, capture, testpixelsx, testpixelsy, 10);
	}

	public static void cast(int i, GameStats stats, int[] creeps) throws InterruptedException, AWTException {
		if(i == 1){
			dotaTools.pressQ();
			int dx = creeps[0] - stats.getPos()[0];
			int dy = creeps[1] - stats.getPos()[1];
			double theta = Math.atan((double) dy/dx);
			if(dx<0){
				theta = theta+Math.PI;
			}
			dotaTools.centerHero();
			dotaTools.myMouseMove(800 + (int) (250 * Math.cos(theta)), 400 + (int) (250 * Math.sin(theta)), 10, 10);
			dotaTools.myMouseClick();
		}
		else if(i == 4){
			dotaTools.pressR();
		}
		else if(i == 3){
			dotaTools.centerHero();
			dotaTools.pressEE();
		}
		Thread.sleep(700);
	}
	
	public static void shop() throws AWTException, InterruptedException{
		Robot robot = new Robot();
		Random r = new Random();
		int speed = 45;
		robot.keyPress(KeyEvent.VK_B);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_B);Thread.sleep((int) (speed + speed * r.nextDouble()));
		robot.keyPress(KeyEvent.VK_Q);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_Q);Thread.sleep((int) (speed + speed * r.nextDouble()));
		robot.keyPress(KeyEvent.VK_7);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_7);Thread.sleep((int) (speed + speed * r.nextDouble()));
		robot.keyPress(KeyEvent.VK_E);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_E);Thread.sleep((int) (speed + speed * r.nextDouble()));
		robot.keyPress(KeyEvent.VK_1);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_1);Thread.sleep((int) (speed + speed * r.nextDouble()));
		robot.keyPress(KeyEvent.VK_W);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_W);Thread.sleep((int) (speed + speed * r.nextDouble()));
		robot.keyPress(KeyEvent.VK_1);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_1);Thread.sleep((int) (speed + speed * r.nextDouble()));
		robot.keyPress(KeyEvent.VK_1);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_1);Thread.sleep((int) (speed + speed * r.nextDouble()));
		robot.keyPress(KeyEvent.VK_1);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_1);Thread.sleep((int) (speed + speed * r.nextDouble()));
		robot.keyPress(KeyEvent.VK_1);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_1);Thread.sleep((int) (speed + speed * r.nextDouble()));
		robot.keyPress(KeyEvent.VK_B);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_B);Thread.sleep((int) (speed + speed * r.nextDouble()));
		robot.keyPress(KeyEvent.VK_ALT);Thread.sleep((int) (speed + speed * r.nextDouble()));	robot.keyPress(KeyEvent.VK_Q);Thread.sleep((int) (speed + speed * r.nextDouble()));
		robot.keyRelease(KeyEvent.VK_Q);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_ALT);Thread.sleep((int) (speed + speed * r.nextDouble()));
	}
	
	public static void buyBoots() throws AWTException, InterruptedException{
		Robot robot = new Robot();
		Random r = new Random();
		int speed = 45;
		robot.keyPress(KeyEvent.VK_B);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_B);Thread.sleep((int) (speed + speed * r.nextDouble()));
		robot.keyPress(KeyEvent.VK_S);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_S);Thread.sleep((int) (speed + speed * r.nextDouble()));
		robot.keyPress(KeyEvent.VK_6);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_6);Thread.sleep((int) (speed + speed * r.nextDouble()));
		robot.keyPress(KeyEvent.VK_B);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_B);Thread.sleep((int) (speed + speed * r.nextDouble()));
	}
	
	public static void buyMeka() throws AWTException, InterruptedException{
		Robot robot = new Robot();
		Random r = new Random();
		int speed = 45;
		robot.keyPress(KeyEvent.VK_B);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_B);Thread.sleep((int) (speed + speed * r.nextDouble()));
		robot.keyPress(KeyEvent.VK_S);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_S);Thread.sleep((int) (speed + speed * r.nextDouble()));
		dotaTools.myMouseMove(1388, 532, 10, 7); dotaTools.myMouseRightClick();
		robot.keyPress(KeyEvent.VK_B);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_B);Thread.sleep((int) (speed + speed * r.nextDouble()));
	}
	
	public static void buyOgre() throws AWTException, InterruptedException{
		Robot robot = new Robot();
		Random r = new Random();
		int speed = 45;
		robot.keyPress(KeyEvent.VK_B);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_B);Thread.sleep((int) (speed + speed * r.nextDouble()));
		robot.keyPress(KeyEvent.VK_W);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_W);Thread.sleep((int) (speed + speed * r.nextDouble()));
		robot.keyPress(KeyEvent.VK_9);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_9);Thread.sleep((int) (speed + speed * r.nextDouble()));
		robot.keyPress(KeyEvent.VK_B);Thread.sleep((int) (speed + speed * r.nextDouble()));robot.keyRelease(KeyEvent.VK_B);Thread.sleep((int) (speed + speed * r.nextDouble()));
	}
	
	public static void useItem(int i) throws AWTException, InterruptedException{
		Robot robot = new Robot();
		Random r = new Random();
		int speed = 45;
		robot.keyPress(KeyEvent.VK_ALT);Thread.sleep((int) (speed + speed * r.nextDouble()));
		if(i == 1){
			robot.keyPress(KeyEvent.VK_Q);Thread.sleep((int) (speed + speed * r.nextDouble()));
			robot.keyRelease(KeyEvent.VK_Q);Thread.sleep((int) (speed + speed * r.nextDouble()));
		}
		else if(i == 2){
			robot.keyPress(KeyEvent.VK_W);Thread.sleep((int) (speed + speed * r.nextDouble()));
			robot.keyRelease(KeyEvent.VK_W);Thread.sleep((int) (speed + speed * r.nextDouble()));
		}
		else if(i == 3){
			robot.keyPress(KeyEvent.VK_E);Thread.sleep((int) (speed + speed * r.nextDouble()));
			robot.keyRelease(KeyEvent.VK_E);Thread.sleep((int) (speed + speed * r.nextDouble()));
		}
		else if(i == 4){
			robot.keyPress(KeyEvent.VK_A);Thread.sleep((int) (speed + speed * r.nextDouble()));
			robot.keyRelease(KeyEvent.VK_A);Thread.sleep((int) (speed + speed * r.nextDouble()));
		}
		else if(i == 5){
			robot.keyPress(KeyEvent.VK_S);Thread.sleep((int) (speed + speed * r.nextDouble()));
			robot.keyRelease(KeyEvent.VK_S);Thread.sleep((int) (speed + speed * r.nextDouble()));
		}
		else if(i == 6){
			robot.keyPress(KeyEvent.VK_D);Thread.sleep((int) (speed + speed * r.nextDouble()));
			robot.keyRelease(KeyEvent.VK_D);Thread.sleep((int) (speed + speed * r.nextDouble()));
		}
		robot.keyRelease(KeyEvent.VK_ALT);Thread.sleep((int) (speed + speed * r.nextDouble()));
	}
	
	public static void sellItem(int i, Images images, BufferedImage capture) throws AWTException, InterruptedException{
		BufferedImage invEmpty = images.getInvEmpty();
		
		if(i==0){return;}
		int j = 0;
		i-=1;
		if(i > 2){
			i-=3;
			j=1;
		}
		int[] x = new int[1]; int[] y = new int[1];
		x[0] = 1250+i*63; y[0] = 804+j*50;
		if(! dotaTools.testImg(invEmpty, capture, x, y, 10)){
			dotaTools.myMouseMove(1250+i*63, 804+j*50, 4, 4);
			dotaTools.myMouseRightClick();
			dotaTools.myMouseMove(1320+i*63, 847+j*50, 4, 4);
			dotaTools.myMouseClick();
			Thread.sleep(300);
		}
	}
	
	public static int checkInv(Images images, BufferedImage capture) throws AWTException{
		BufferedImage inv = images.getInv();
		BufferedImage invRdy = images.getInvRdy();
		int j = 0;
		for(int i = 0; i < 3; i++){
			int points = 1;
			int[] testpixelsx = new int[points];
			int[] testpixelsy = new int[points];
			testpixelsx[0]=1250+i*63; testpixelsy[0]=804+j*50;
			if(dotaTools.testImg(inv, capture, testpixelsx, testpixelsy, 10)){
				return i+j*3+1;
			}
		}
		j = 1;
		for(int i = 0; i < 3; i++){
			int points = 1;
			int[] testpixelsx = new int[points];
			int[] testpixelsy = new int[points];
			testpixelsx[0]=1250+i*63; testpixelsy[0]=804+j*50;
			if(! dotaTools.testImg(invRdy, capture, testpixelsx, testpixelsy, 10)){
				return i+j*3+1;
			}
		}
		return 0;
	}
	
	public static boolean[] checkInvRdy(Images images, BufferedImage capture) throws AWTException{
		BufferedImage invRdy = images.getInvRdy();
		boolean[] items = new boolean[6];

		for(int j = 0; j < 2; j++){
			for(int i = 0; i < 3; i++){
				int points = 1;
				int[] testpixelsx = new int[points];
				int[] testpixelsy = new int[points];
				testpixelsx[0]=1250+i*63; testpixelsy[0]=804+j*50;
				if(dotaTools.testImg(invRdy, capture, testpixelsx, testpixelsy, 5)){
					items[i+j*3]=true;
				}
				else{
					items[i+j*3]=false;
				}
			}
		}
		return items;
	}
	
	public static int[] findGoodPos(boolean radiant, boolean day, int[] creepsAt){
		int[] goodPos = new int[2];
		int stayback = 0; int pad = 4;
		if(day){
			stayback = 30;
		}
		else{
			stayback = 26;
		}
		
		if(radiant){
			if(creepsAt[0]-stayback > 45){
				goodPos[0] = creepsAt[0] - stayback;
				goodPos[1] = creepsAt[1];
			}
			else if(creepsAt[0] == 33){
				goodPos[0] = creepsAt[0];
				goodPos[1] = creepsAt[1] + stayback;
			}
			else{
				int extra = creepsAt[0] - 45;
				goodPos[0] = 33;
				goodPos[1] = creepsAt[1] + stayback - extra - pad;
			}
		}
		else{
			if(creepsAt[0] + stayback < 200){
				goodPos[0] = creepsAt[0] + stayback;
				goodPos[1] = creepsAt[1];
			}
			else if(creepsAt[0] == 217){
				goodPos[0] = creepsAt[0];
				goodPos[1] = creepsAt[1] - stayback;
			}
			else{
				int extra = 200 - creepsAt[0];
				goodPos[0] = 217;
				goodPos[1] = creepsAt[1] - stayback + extra + pad;
			}
		}
		return goodPos;
	}
	
	public static int[] findPos(BufferedImage capture, int[] color){
		int[] pos = new int[2];
		int TOL = 3;
		for(int i = 9; i < 235; i++){
			for(int j = 674; j < 890; j++){
				Color temp = new Color(capture.getRGB(i, j));
				int red = temp.getRed();
				int green = temp.getGreen();
				int blue = temp.getBlue();
				if(red < color[0]+TOL && red > color[0]-TOL && green < color[1]+TOL && green > color[1]-TOL && blue < color[2]+TOL && blue > color[2]-TOL){
					pos[0] = i; pos[1] = j;
					break;
				}
			}
		}
		return pos;
	}
	
	public static int[] checkTowers(boolean radiant, boolean day, BufferedImage capture, Images images, int[] goodPos) {
		int safedist = 20;
		BufferedImage map1 = images.getDefaultMap1();
		if(radiant){
			for(int i = 0; i < 3; i++){
				if(Math.abs(capture.getRGB(55 + i*75 - 6*i*i, 694) - map1.getRGB(55 + i*75 - 6*i*i, 693)) < 10){
					if(goodPos[0] > 55 + i*75 - 6*i*i - safedist){
						goodPos[0] = 55 + i*75 - 6*i*i - safedist;
						break;
					}
				}
			}
		}
		else{
			for(int i = 0; i < 3; i++){
				if(Math.abs(capture.getRGB(197 - 95*i + 15*i*i, 873) - map1.getRGB(197 - 95*i + 15*i*i, 873)) < 10){
					if(goodPos[0] < 197 - 95*i + 15*i*i + safedist){
						goodPos[0] = 197 - 95*i + 15*i*i + safedist;
						break;
					}
				}
			}			
		}
		return goodPos;
	}
	
	public static void reconnect() throws AWTException, InterruptedException{
		dotaTools.myMouseMove(724, 18, 50, 15);
		dotaTools.myMouseClick();
		dotaTools.myMouseMove(557, 610, 100, 13);
		dotaTools.myMouseClick();
	}

	public static void update(Images images) throws AWTException, InterruptedException{
		BufferedImage capture = dotaTools.getScreenshot();
		BufferedImage update = images.getUpdate();
		for(int i = 0; i < 1500; i++){
			for(int j = 0; j < 800; j++){
				if(capture.getRGB(i, j) == update.getRGB(620, 364) && capture.getRGB(i+37, j) == update.getRGB(657, 364) && capture.getRGB(i+80, j) == update.getRGB(700, 364)){
					dotaTools.myMouseMove(i+196, j+126, 0, 0);
					dotaTools.myMouseClick();
				}
			}
		}
	}
	
	public static void leaveGame() throws AWTException, InterruptedException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PRINTSCREEN);
		r.keyRelease(KeyEvent.VK_PRINTSCREEN);
		dotaTools.myMouseMove(1108, 571, 70, 5);
		dotaTools.myMouseClick();
	}

	public static void quitGame() throws AWTException, InterruptedException {
		dotaTools.myMouseMove(1581, 19, 5, 5);
		dotaTools.myMouseClick();
		dotaTools.myMouseMove(715, 311, 60, 6);
		dotaTools.myMouseClick();
		dotaTools.myMouseMove(715, 346, 60, 6);
		dotaTools.myMouseClick();
		Thread.sleep(30000);
	}
	
	public static void rageQuit() throws AWTException, InterruptedException{
		dotaTools.myMouseMove(20, 17, 8, 8);
		dotaTools.myMouseClick();
		quitGame();
	}
}