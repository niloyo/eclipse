import java.util.HashMap;

public class NilUtils {
	
	public static void print(HashMap<Integer, Integer> example)
	{
		for (Integer name: example.keySet()){

            String key =name.toString();
            String value = example.get(name).toString();  
            System.out.println(key + " " + value);  
		
		
		}
	}

}
