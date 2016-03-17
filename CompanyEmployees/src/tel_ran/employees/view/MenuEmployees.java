package tel_ran.employees.view;

import tel_ran.collections.Array;
import tel_ran.view.AbstractView;

public class MenuEmployees {
Array items; //array of items (class ItemNumbers)
AbstractView view;
public MenuEmployees(Array items, AbstractView view) {
	super();
	this.items = items;
	this.view = view;
}
public void runMenu() throws Exception {
	int nItems=items.size();
	while(true){
		System.out.println("============ MENU ==============");
		for(int i=0;i<nItems; i++){
			ItemEmployees item=(ItemEmployees) items.get(i);
			view.display(i+". "+item.getDisplayedName());
		}
		System.out.println("================================");
		int index=view.getIntValue("please select item number", 0, nItems-1);
		ItemEmployees item=(ItemEmployees)items.get(index);
		item.action();
	}
}
}
