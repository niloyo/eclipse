
public class SegmentTree {
	
	private int N;
	
	private int[] seg;
	
	private int[] ar;
	
	public SegmentTree(int n) {
		// TODO Auto-generated constructor stub
		N = n;
		seg = new int[2*N];
		ar = new int[N];
		
	}
	
	public void construct() {
		
		for(int i = N; i <2*N ; i++) {
			seg[i+N] = ar[i]; 
		}
		
		for(int i=N-1; i>= 1; i++) {
			seg[i] = Math.min(seg[i*2], seg[i*2+1]);
		}
	}
	
	public int getMin(int l, int r) {
		check_bound(l);
		check_bound(r);
		
		int ans = Integer.MAX_VALUE;
		
		l +=N;
		r += N;
		
		while(l < r) {
			if(l%2 == 1) {
				ans = Math.min(ans, seg[l]);
				l +=1;
			}
			
			if(r%2 == 1) {
				ans = Math.min(ans, seg[l]);
				r -=1;
			}
			l/=2;
			r /= 2;
		}
		
		
		return ans;
	}
	
	public void check_bound(int i) {
		if(!( i >= 0 && i < N )) {
			throw new AssertionError(" array out of bound index");
		}
	}
	
	public void update(int ind,  int newVal ) {
		
		check_bound(ind);
		
		seg[ind+N] = newVal;
		ind = (ind+N)/2;
		while(ind > 1) {
			seg[ind] = Math.min(seg[ind*2], seg[ind*2 + 1]);
			ind = ind/2;
		}
		
		
		
		
	   
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println("Nilmadhab Here");
		int n = 8;
		SegmentTree sg = new SegmentTree(8);
		
		for(int i=0; i < n ; i++) {
			sg.ar[i] = (int) (10*Math.random()) ;
			
		}
		sg.construct();
		
		
	}

}
