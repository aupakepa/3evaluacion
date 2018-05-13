	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.Map;
	import java.util.Map.Entry;
public class Recorrer_Mapa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1,"value1");
		map.put(2,"value2");
		map.put(3,"value3");

		System.out.println("Mapa con foreach de entrySet");

		for (Entry<Integer, String> e: map.entrySet()) {
			System.out.println("["+e.getKey() + "=" + e.getValue()+"]");
		}
		System.out.println("Mapa con iterador de MapEntry");

		Iterator it = map.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			System.out.println("["+e.getKey() + "=" + e.getValue()+"]");

		}

		System.out.println("Mapa con foreach de keySet");

		for (Integer e: map.keySet()) {
			System.out.println("["+e + "=" + map.get(e)+"]");
		}

		System.out.println("Mapa con iterador de keySet");

		Iterator it2 = map.keySet().iterator();

		while (it2.hasNext()) {
			Integer e = (Integer) it2.next();
			System.out.println("["+e + "=" + map.get(e)+"]");
		}

	}

}
