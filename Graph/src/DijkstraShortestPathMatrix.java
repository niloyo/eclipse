
public class DijkstraShortestPathMatrix {
	
	static final int V = 9;
	
	public int find_minimum(boolean[] set, int[] dis) {
		
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		for (int i = 0; i < dis.length; i++) {
			if( dis[i] < min && set[i] == false ) {
				min = dis[i];
				min_index = i;
			}
		}
		
		return min_index; 
		 
	}
	
	public boolean is_empty( boolean[] set) {
		for (int i = 0; i < set.length; i++) {
			if(set[i] == false) {
				return false;
			}
		}
		
		
		return true;
	}
	
	void print( int[] dis) {
		for (int i = 0; i < dis.length; i++) {
			System.out.println(i + " " + dis[i] );
		}
	}
	
	void print( boolean[] dis) {
		for (int i = 0; i < dis.length; i++) {
			System.out.println(i + " " + dis[i] );
		}
	}
	
	public void dijkstra(int graph[][], int source) {
		
		boolean[] set = new boolean[V];
		
		for(int i = 0; i< V; i ++) {
			set[i] = false;
		}
		
		int[] dis = new int[V];
		
		for (int i = 0; i < dis.length; i++) {
			dis[i] = Integer.MAX_VALUE;
		}
		
		//set[source] = true;
		dis[source] = 0;
		
		while(!is_empty(set)) {
			int mini = find_minimum(set, dis);
			//print(dis);
			//print(set);
			//System.out.println(mini + " mini ");
			set[mini] = true;
			
			for (int i = 0; i < graph[mini].length; i++) {
				if(graph[mini][i] != 0 ) {
					if(dis[i] > dis[mini] + graph[mini][i]) {
						dis[i] = dis[mini] + graph[mini][i];
					}
				}
				
			}
		}
		
		System.out.println("prining distances ");
		print(dis);
	}
	
	
	
	public static void main (String[] args)
    {
        /* Let us create the example graph discussed above */
       int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                  {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                  {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0}
                                 };
        DijkstraShortestPathMatrix t = new DijkstraShortestPathMatrix();
        t.dijkstra(graph, 0);
    }

}
