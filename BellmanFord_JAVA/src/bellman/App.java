package bellman;

public class App {
	


	public static void main(String[] args) {
		
		int[][] weight = {{0, 6, 0, 7, 0}, 
						  {0, 0, 5, 8, -4},
						  {0, -2, 0, 0, 0},
						  {0, 0, -3, 9, 0},
						  {2, 0, 7, 0, 0}};
		
		BellmanFord bf = new BellmanFord();
		
		bf.createEdgesArray(weight);
		bf.printEdges();
		
		boolean workable = bf.bellmanFord(0);
		
		if(workable){
			bf.printDistance(0);
		}
		
		
	}

}
