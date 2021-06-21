package lambda;

import java.util.HashMap;
import java.util.Map;

public class ForEachTest3 {

	public static void main(String[] args) {
		Map<String, Integer> items = new HashMap<String, Integer>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		
		//기존 방식
		for(Map.Entry<String, Integer> entry : items.entrySet()) {
			System.out.println("Item : " +entry.getKey()+"Count : " +entry.getValue());
		}
		System.out.println();
		
		//forEach
		items.forEach((k,v)-> System.out.println("Item : " +k+" Count : "+v));
	}

}
