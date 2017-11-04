import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		/*
		try {
			sc = new Scanner(new File(System.getProperty("user.dir") + "/src/input.txt") );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if(hm.containsKey(arr[i])) {
				hm.put(arr[i], hm.get(arr[i])+1);
			}else {
				hm.put(arr[i], 1);
			}
		}
		
		Arrays.sort(arr);
		
	
		int ans  = 0;
	    for (int i = 0; i < N; ++i)
	    {
	    		boolean found = false;
	    		int key = arr[i];
	    		if(hm.containsKey(key) && hm.get(key) >= 2) {
	    			ans +=1;
	    		}else {
	    			
	    			for (int j = 0; j < i && !found; j++) {
						int first = arr[j];
						
						int diff = 2*key - first;
						
						if(hm.containsKey(diff)) {
							found = true;
						}
				}
	    			
	    			if(found) ans +=1;
	    		}
	    		
	    		
	    }

	    //print_map(mp);

	    System.out.println(ans);
		
		
		
		
		
		
	}

}
