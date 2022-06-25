import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class dotaTools {
	
	public static int[] myMousePos() throws AWTException{
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int x = (int) b.getX();
		int y = (int) b.getY();
		int[] pos = new int[2];
		pos[0] = x; pos[1] = y;
		return pos;
	}
	
	public static BufferedImage getScreenshot() throws AWTException{
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		return new Robot().createScreenCapture(screenRect);
	}
	
	public static void myMouseMove(int x, int y, int tolx, int toly) throws AWTException, InterruptedException{
		int[] pos = dotaTools.myMousePos();
		Random r = new Random();
		Robot robot = new Robot();
		
		x = (int) (x + Math.round((r.nextDouble() * 2 - 1) * tolx));
		y = (int) (y + Math.round((r.nextDouble() * 2 - 1) * toly));
		int dx = x - pos[0];
		int dy = y - pos[1];
		int steps = (int) Math.pow(dx*dx+dy*dy, 0.5)*30;
		double c1 = (double) dx/200 + 0.5;
		double k1 = Math.round((r.nextDouble() * 20 -10)/steps);
		double m1 = Math.round((r.nextDouble() * 20 -10));
		double c2 = (double) dy/200 + 0.5;
		double k2 = Math.round((r.nextDouble() * 20 -10)/steps);
		double m2 = Math.round((r.nextDouble() * 20 -10));
		
		for(int i = 0; i < steps; i++){
			int newx = (int) (pos[0] + (Math.round(dx*(double) i/steps)) + c1*Math.sin(2*Math.PI/steps*i)*(k1*i+m1));
			int newy = (int) (pos[1] + (Math.round(dy*(double) i/steps)) + c2*Math.sin(2*Math.PI/steps*i)*(k2*i+m2));
			robot.mouseMove(newx, newy);
		}
		Thread.sleep((int) (70 + 70 * r.nextDouble()));
	}
	
	public static void myMouseClick() throws InterruptedException, AWTException{
		Robot robot = new Robot();
		Random r = new Random();
		robot.mousePress(InputEvent.BUTTON1_MASK);
		Thread.sleep((int) (100 +  50 * r.nextDouble()));
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep((int) (200 +  50 * r.nextDouble()));
	}
    
	public static void myMouseDoubleClick() throws AWTException, InterruptedException{
		Robot robot = new Robot();
		Random r = new Random();
        robot.mousePress(InputEvent.BUTTON1_MASK);
        Thread.sleep((int) (100 +  50 * r.nextDouble()));
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        Thread.sleep((int) (100 +  50 * r.nextDouble()));
        robot.mousePress(InputEvent.BUTTON1_MASK);
        Thread.sleep((int) (100 +  50 * r.nextDouble()));
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        Thread.sleep((int) (200 +  50 * r.nextDouble()));
	}
	
	public static void myMouseRightClick() throws AWTException, InterruptedException{
		Robot robot = new Robot();
		Random r = new Random();
        robot.mousePress(InputEvent.BUTTON3_MASK);
        Thread.sleep((int) (100 +  50 * r.nextDouble()));
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
        Thread.sleep((int) (200 +  50 * r.nextDouble()));
	}
	
	public static void centerHero() throws AWTException, InterruptedException{
		Robot robot = new Robot();
		Random r = new Random();
		robot.keyPress(KeyEvent.VK_C);
		Thread.sleep((int) (30 + 30 * r.nextDouble()));
		robot.keyRelease(KeyEvent.VK_C);
		Thread.sleep((int) (30 + 30 * r.nextDouble()));
		robot.keyPress(KeyEvent.VK_C);
		Thread.sleep((int) (30 + 30 * r.nextDouble()));
		robot.keyRelease(KeyEvent.VK_C);
	}
	
	public static void pressQ() throws AWTException, InterruptedException{
		Random r = new Random();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_Q);
		Thread.sleep((int) (30 + 30 * r.nextDouble()));
		robot.keyRelease(KeyEvent.VK_Q);
	}
	
	public static void pressR() throws AWTException, InterruptedException{
		Random r = new Random();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_R);
		Thread.sleep((int) (30 + 30 * r.nextDouble()));
		robot.keyRelease(KeyEvent.VK_R);
	}
	
	public static void pressEE() throws AWTException, InterruptedException{
		Robot robot = new Robot();
		Random r = new Random();
		robot.keyPress(KeyEvent.VK_E);
		Thread.sleep((int) (30 + 30 * r.nextDouble()));
		robot.keyRelease(KeyEvent.VK_E);
		Thread.sleep((int) (30 + 30 * r.nextDouble()));
		robot.keyPress(KeyEvent.VK_E);
		Thread.sleep((int) (30 + 30 * r.nextDouble()));
		robot.keyRelease(KeyEvent.VK_E);
	}
	
	public static boolean testImg(BufferedImage a, BufferedImage b, int[] x, int[] y, int TOL){
		int c = 0;
		int n = x.length;
		int pad = 0;
		if(n > 5){
			pad = 3;
		}
		for(int i = 0; i < n; i++){
			Color temp = new Color(a.getRGB(x[i], y[i]));
			int red = temp.getRed();
			int green = temp.getGreen();
			int blue = temp.getBlue();
			Color temp2 = new Color(b.getRGB(x[i], y[i]));
			int red2 = temp2.getRed();
			int green2 = temp2.getGreen();
			int blue2 = temp2.getBlue();
			if(red < red2+TOL && red > red2-TOL && green < green2+TOL && green > green2-TOL && blue < blue2+TOL && blue > blue2-TOL){
				c++;
			}
		}
		return c >= n-pad;
	}
	
	public static void myKeyPress(Character c) throws AWTException, InterruptedException{
		Robot rob = new Robot();
		Random rand = new Random();
		int speed = 10;
		int d = 10;
		
		int i = (int) c;
		if(i > 96){
			i = i - 32;
		}
		else if(i > 64){
			rob.keyPress(KeyEvent.VK_SHIFT);
			Thread.sleep((int) (speed +  d * rand.nextDouble()));
		}
		
		rob.keyPress(i);
		Thread.sleep((int) (speed +  d * rand.nextDouble()));
		rob.keyRelease(i);
		Thread.sleep((int) (speed +  d * rand.nextDouble()));
		
		if(i < 97){
			rob.keyRelease(KeyEvent.VK_SHIFT);
			Thread.sleep((int) (speed +  d * rand.nextDouble()));
		}
	}
	
	public static int[] id2col(int answer){
		int[] col = new int[3];
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
		return col;
	}
	
	public static void sayAll(String s) throws AWTException, InterruptedException{
		Robot rob = new Robot();
		Random rand = new Random();
		int speed=5;
		int d = 20;
		
		rob.keyPress(KeyEvent.VK_SHIFT);
		Thread.sleep((int) (speed +  d * rand.nextDouble()));
		rob.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep((int) (speed +  d * rand.nextDouble()));
		rob.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep((int) (speed +  d * rand.nextDouble()));
		rob.keyRelease(KeyEvent.VK_SHIFT);
		Thread.sleep((int) (speed +  d * rand.nextDouble()));
		
		for(int i = 0; i < s.length(); i++){
			myKeyPress(s.charAt(i));
		}

		rob.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep((int) (speed +  d * rand.nextDouble()));
		rob.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep((int) (speed +  d * rand.nextDouble()));
	}
}