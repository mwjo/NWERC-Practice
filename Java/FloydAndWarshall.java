import java.util.Scanner;

//Implements the Floyd and Warshall algorithm for returning the shortest path when traversing nodes in a graph

public class Main {

	static int shortestPath(int n, int[][] matrix, int[] route)
	{
		int[][] dist = matrix;
		for (int k = 0; k < n; k++)
		{
			for (int i = 0; i < n; i++)
			{
				for (int j = 0; j < n; j++)
				{
					if (dist[i][j] > (dist[i][k] + dist[k][j]))
					{
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		int length = dist[route[0]-1][route[1]-1] + dist[route[1]-1][route[2]-1];
		
		return length;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = Integer.valueOf(in.nextLine());
		
		String line = in.nextLine();
		String[] a_route = line.split("\\s+");
		int[] route = new int[3];
		
		for (int i = 0; i < 3; i++)
		{
			route[i] = Integer.valueOf(a_route[i]);
		}
		
		int[][] matrix = new int[n][n];
		
		for (int i = 0; i < n; i++)
		{
			String row = in.nextLine();
			String[] points = row.split("\\s+");
			for (int j = 0; j < n; j++)
			{
				matrix[i][j] = Integer.valueOf(points[j]);
			}
		}
		
		int val = shortestPath(n, matrix, route);
		System.out.println(val);
	}	
}
