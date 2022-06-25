import java.awt.AWTException;
import java.io.IOException;

public class botMain {
	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		System.out.println("Welcome");
		Thread.sleep(1000);
		int k = 0; int games = 22;
		boolean debug = false;
		
		Images images = new Images();
		while(true){
			if(!debug){
				while(! dotaIO.isDesktop(images)){
					Thread.sleep(1000);
				}
				dotaIO.launchDota();
				System.out.println("Checkpoint 1");		
			
				while(! dotaIO.isMainMenu(images)){
					Thread.sleep(1000);
					dotaIO.update(images);
				}

				dotaIO.findBotGame();
				System.out.println("Checkpoint 2");
			
				boolean allLoaded = false;
				while(! allLoaded){
					dotaIO.waitForGame(images);
					System.out.println("Checkpoint 3");
				
					while(! dotaIO.isPicking(images) && ! dotaIO.isMainMenu(images)){
						Thread.sleep(1000);
					}
					if(dotaIO.isPicking(images)){
						allLoaded = true;
					}
				}
			}
			else{
				System.out.println("Debug mode");
				while(! dotaIO.isPicking(images)){Thread.sleep(1000);}
			}

			if(dotaIO.pickEzalor(images)){
				System.out.println("Checkpoint 4");
				
				boolean radiant = false;
				int[] temp = dotaIO.findColor(images);
				int[] color = new int[3]; color[0] = temp[0]; color[1] = temp[1]; color[2] = temp[2];
				if(temp[3]<5){radiant = true;}
				System.out.println(temp[3]);
	
				dotaIO.startPlay(images);
				System.out.println("Checkpoint 5");
				
				PlayDota.play(radiant, images, color);
				System.out.println("Checkpoint 6");
				
				while(! dotaIO.isDesktop(images)){
					dotaIO.quitGame();
				}
				System.out.println("Checkpoint 7");
			}
			else{
				dotaIO.rageQuit();
				Thread.sleep(5*60*1000);
			}
			if(k % games+1 == games){
				Thread.sleep(7*3600*1000);
			}
			Thread.sleep(30000);
			k++;
		}
	}
}