

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Avarage {
	
	
	
	public static void main(String[] args) {
		
		
		
		int input_tye = 1;
		Scanner sc = new Scanner(System.in);
		switch (input_tye) {
		case 0:
			///Users/nilmadhab/eclipse-workspace/Competative/src
			File file = new File(System.getProperty("user.dir") + "/src/input.txt");
			
			try {
				sc = new Scanner(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(1);
			}
			break;
		case 1:
			sc = new Scanner(System.in);
			break;

		default:
			sc = new Scanner(System.in);
			break;
		}
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			hm.put(arr[i], 1+ hm.getOrDefault(arr[i], 0));
		}
		
		//NilUtils.print(hm);
		
		int ans  = 0;
	    for (int i = 0; i < N; ++i)
	    {
	        for(int j = i+1; j < N ; j++)
	        {
	            int avg = (arr[i]+arr[j])/2;
	            if((arr[i]+arr[j]) % 2 == 0 && hm.containsKey(avg)){
	                ans += hm.get(avg);
	          }
	        }
	    }

	    //print_map(mp);

	    System.out.println(ans);
		
		
		
		
		
		
	}

}
