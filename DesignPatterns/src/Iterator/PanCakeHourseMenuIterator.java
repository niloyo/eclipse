package Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class PanCakeHourseMenuIterator implements Iterator {
	
	ArrayList<MenuItem> menuItems;
	
	int position = 0;
	
	public PanCakeHourseMenuIterator(ArrayList<MenuItem> menuItems) {
		super();
		this.menuItems = menuItems;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(menuItems == null || position >= menuItems.size())
			return false;
		
		return true;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return menuItems.get(position++);
	}

}
