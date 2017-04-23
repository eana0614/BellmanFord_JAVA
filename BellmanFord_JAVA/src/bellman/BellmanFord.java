package bellman;

public class BellmanFord {
	
	Edge[] edges;
	int[] distance;
	int INFINITY = Integer.MAX_VALUE;
	
	public void createEdgesArray(int[][] weight){
		int vertexNum = weight.length;
		int count = 0;
		
		Edge[] tempEdge = new Edge[vertexNum*vertexNum];
		
		for(int i=0; i < vertexNum; i++){
			for(int j=0; j<vertexNum; j++){
				if(weight[i][j] != 0){
					tempEdge[count] = new Edge();
					tempEdge[count].startVertex = i;
					tempEdge[count].endVertex = j;
					tempEdge[count].weight = weight[i][j];
					count++;
				}
			}
		}
		
		edges = new Edge[count];
		for(int i=0; i<count; i++){
			edges[i] = tempEdge[i];
		}
		
		distance = new int[vertexNum];
	}

	public void printEdges(){
		System.out.println("!] Print Edges.");
		
		for(int i=0; i<edges.length; i++){
			System.out.println(i+"th Edge = start Vertex("+edges[i].startVertex+"), end Vertex("+edges[i].endVertex+")"
								+"), weight("+edges[i].weight+")");
		}
	}
	
	public boolean bellmanFord(int start){

		for(int i=0; i<distance.length; i++){
			distance[i] = INFINITY;
		}
		
		distance[start] = 0;
		
		for(int i=0; i<distance.length; i++){
			for(int j=0; j<edges.length; j++){
				relax(edges[j].startVertex, edges[j].endVertex, edges[j].weight);
			}
		}
		
		for(int i=0; i<edges.length; i++){
			if(distance[edges[i].endVertex] > distance[edges[i].startVertex]+edges[i].weight){
				return false;
			}
		}
		
		return true;
	}

	private void relax(int startVertex, int endVertex, int weight) {
		
		if(distance[endVertex] > distance[startVertex]+weight){
			distance[endVertex] = distance[startVertex]+weight;
		}
	}

	
	public void printDistance(int start) {
		
		System.out.println("\n!] Print Distance. ");
		for(int i=0; i<distance.length; i++){
			System.out.println(start+"->"+i+" = "+distance[i]);
		}
	}
}
