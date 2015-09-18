import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class IncidenceList
{
	Map<Vertex, Set<Edge>> data = new HashMap<Vertex, Set<Edge>>();

	public IncidenceList()
	{

	}

	public IncidenceList(Edge... edges)
	{
		add(edges);
	}

	public Set<Vertex> getVertices()
	{
		return data.keySet();
	}

	public Set<Edge> getEdgesFrom(Vertex origin)
	{
		if (!data.containsKey(origin))
		{
			return new HashSet<Edge>();
		}

		return data.get(origin);
	}

	public Set<Edge> getEdgesTo(Vertex target)
	{
		Set<Edge> edges = new HashSet<Edge>();

		for (Vertex vertex : data.keySet())
		{
			for (Edge edge : data.get(vertex))
			{
				if (target.equals(edge.getTarget()))
				{
					edges.add(edge);
				}
			}
		}

		return edges;
	}

	public void add(Edge... edges)
	{
		for (Edge edge : edges)
		{
			if (!data.containsKey(edge.getOrigin()))
			{
				data.put(edge.getOrigin(), new HashSet<Edge>());
			}

			data.get(edge.getOrigin()).add(edge);
		}
	}

	public boolean contains(Edge... edges)
	{
		for (Edge edge : edges)
		{
			Set<Edge> edgesFromOrigin = data.get(edge.getOrigin());

			if (edgesFromOrigin != null && !edgesFromOrigin.contains(edge))
			{
				return false;
			}
		}

		return true;
	}

	public void remove(Edge... edges)
	{
		for (Edge edge : edges)
		{
			Set<Edge> edgesFromOrigin = data.get(edge.getOrigin());

			if (edgesFromOrigin != null)
			{
				edgesFromOrigin.remove(edge);

				if (edgesFromOrigin.isEmpty())
				{
					data.remove(edge.getOrigin());
				}
			}
		}
	}

	public void remove(Vertex origin, Vertex target)
	{
		if (data.containsKey(origin))
		{
			data.get(origin).remove(new Edge(origin, target));
		}
	}
}