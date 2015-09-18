import java.util.HashSet;
import java.util.Set;

public class Tests
{
	public static void main(String[] args)
	{
		IncidenceList incidenceList = new IncidenceList();
		
		Vertex[] vertices = new Vertex[]
		{
			new Vertex(0), new Vertex(1), new Vertex(2), new Vertex(3), new Vertex(4),
			new Vertex(5), new Vertex(6), new Vertex(7), new Vertex(8), new Vertex(9),
			new Vertex(10), new Vertex(11), new Vertex(12), new Vertex(13), new Vertex(14),
			new Vertex(15), new Vertex(16), new Vertex(17), new Vertex(18), new Vertex(19)
		};

		Set<Edge> edges = new HashSet<Edge>()
		{{
			add(new Edge(vertices[0], vertices[2])); add(new Edge(vertices[0], vertices[11]));
			add(new Edge(vertices[1], vertices[19]));
			add(new Edge(vertices[2], vertices[10])); add(new Edge(vertices[2], vertices[19]));
			add(new Edge(vertices[6], vertices[10])); add(new Edge(vertices[6], vertices[19]));
			add(new Edge(vertices[10], vertices[12])); add(new Edge(vertices[10], vertices[18]));

			// Duplicates should be detected.
			add(new Edge(vertices[0], vertices[2])); add(new Edge(vertices[0], vertices[2]));
			add(new Edge(vertices[6], vertices[10]));
		}};

		incidenceList.add(edges.toArray(new Edge[edges.size()]));

		System.out.print("Expected: (0, 2) (0, 11)\nActual: ");

		for (Edge edge : incidenceList.getEdgesFrom(vertices[0]))
		{
			System.out.printf("(%s, %s) ", edge.getOrigin().getId(), edge.getTarget().getId());
		}

		System.out.print("\n\nExpected: \nActual: ");

		for (Edge edge : incidenceList.getEdgesTo(vertices[0]))
		{
			System.out.printf("(%s, %s) ", edge.getOrigin().getId(), edge.getTarget().getId());
		}

		System.out.print("\n\nExpected: (2, 10) (2, 19)\nActual: ");

		for (Edge edge : incidenceList.getEdgesFrom(vertices[2]))
		{
			System.out.printf("(%s, %s) ", edge.getOrigin().getId(), edge.getTarget().getId());
		}

		System.out.print("\n\nExpected: (10, 12) (10, 18)\nActual: ");

		for (Edge edge : incidenceList.getEdgesFrom(vertices[10]))
		{
			System.out.printf("(%s, %s) ", edge.getOrigin().getId(), edge.getTarget().getId());
		}

		System.out.print("\n\nExpected: (2, 10) (6, 10)\nActual: ");

		for (Edge edge : incidenceList.getEdgesTo(vertices[10]))
		{
			System.out.printf("(%s, %s) ", edge.getOrigin().getId(), edge.getTarget().getId());
		}

		incidenceList.remove(vertices[6], vertices[10]);
		
		System.out.println("\n\n-> Removed (6, 10).");
		System.out.print("\nExpected: (10, 12) (10, 18)\nActual: ");

		for (Edge edge : incidenceList.getEdgesFrom(vertices[10]))
		{
			System.out.printf("(%s, %s) ", edge.getOrigin().getId(), edge.getTarget().getId());
		}

		System.out.print("\n\nExpected: (2, 10)\nActual: ");

		for (Edge edge : incidenceList.getEdgesTo(vertices[10]))
		{
			System.out.printf("(%s, %s) ", edge.getOrigin().getId(), edge.getTarget().getId());
		}

		System.out.println();
	}
}