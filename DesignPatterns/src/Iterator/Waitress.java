package Iterator;

import java.util.Iterator;

public class Waitress {
	
	Menu panCakeHouseMenu;
	Menu dinerMenu;
	public Waitress(Menu panCakeHouseMenu, Menu dinerMenu) {
		super();
		this.panCakeHouseMenu = panCakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}
	
	public void printMenu(Iterator iterator) {
		while(iterator.hasNext()) {
			MenuItem menuItem = (MenuItem) iterator.next();
			menuItem.print();
		}
	}
	
	

}
