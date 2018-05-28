package structures;

import java.io.*;
import java.util.*;

public class JavaExamples {

	public static void main(String[] args) {
		JavaExamples je = new JavaExamples();
		
		//je.createArrayList(args);
		
		//je.createLinkedList(args);
		
		je.createHashMap(args);
	}
	
	public void createArrayList(String[] args) {
		
		int count = args.length;
		
		ArrayList<String> list = new ArrayList<String>(count);
		
		for (int i=0; i < count; i++) {
			list.add(args[i]);
		}
		
		
		for (int i = 0; i < count; i++) {
			System.out.println(args[i]);
		}
		
	}
	
	public void createLinkedList(String [] args) {
		
		LinkedList ll = new LinkedList<Object>();
		
		for (int i=0;i<args.length;i++) {
			ll.add(args[i]);
		}
		
		if (ll.contains("dude"))
			ll.remove("dude");
		
		Iterator<Object> iterator = ll.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}
	
	public void createHashMap(String [] args) {
		
		HashMap<String, String> hm = new HashMap<String, String>();
		
		for (int i=0;i<args.length;i++) {
			hm.put(args[i], args[i]);
		}
		
		if (hm.containsKey("dude"))
			hm.remove("dude");
		
		for (String blah : hm.values()) {
			System.out.println(blah);
		}
	}
}
