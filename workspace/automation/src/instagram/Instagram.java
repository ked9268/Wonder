package instagram;

import java.awt.AWTException;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import controller.events;
import controller.string_to_key_press;

public class Instagram {
	public static void makePurchaseOnInstantFans() throws URISyntaxException, IOException, AWTException, InterruptedException{
		URI pic2txt = new URI("https://www.instantfans.info/#likes");
		Desktop desktop = Desktop.getDesktop();
		desktop.browse(pic2txt);
		events.sleep(10000);
		events.Tab(7); //7 is 2500 8 is 5000 9 is 10000;
		events.sleep(600);
		events.enter(1);
		events.move(250,250);
		events.sleep(200);
		events.click();
		events.sleep(600);
		events.Tab(1);
		events.sleep(600);
		new string_to_key_press("boycalledwonder");
		events.enter(1);
		events.sleep(10000);
		events.move(300,300);
		events.sleep(600);
		events.Tab(1); //Latest picture.
	}
}
