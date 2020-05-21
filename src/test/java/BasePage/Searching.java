package BasePage;

import java.util.ArrayList;
import java.util.List;


public class Searching {
	public String name ;
	public Searching(String username) {
		this.name=username;
//		System.out.println(username);
	}
	
	public static String[] xpath() {

		String[] names= {"fname", "fname", "fristName"};
		List<Searching> listOfXpath = new ArrayList<Searching>();
		int i =0;
		while(i< names.length) {
			listOfXpath.add(new Searching(names[i]));
			i++;
		}
		return names;
		
	
	}
	
	
}
