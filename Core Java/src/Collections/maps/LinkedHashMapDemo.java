package Collections.maps;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapDemo {

	public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
		
		map.put("jhon",70);
		map.put("tom",73);
		map.put("Lee",74);
		map.put("Brad",76);
		
		System.out.println("map :: "+map);
		
		Set<String> keySet = map.keySet();
		System.out.println("keySet :: "+keySet);
		
		Collection<Integer> values = map.values();
		System.out.println("values :: "+values);
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("entry :: "+entry+"      entry key :: "+entry.getKey()+"     entry val :: "+entry.getValue());
		}
	}
}
