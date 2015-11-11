import java.util.HashSet;
import java.util.Set;

class Vertex
{
    final int id;

    // The vertices that target this vertex.
    Set<Vertex> origins = new HashSet<Vertex>();

    // The vertices targeted by this vertex.
    Set<Vertex> targets = new HashSet<Vertex>();

    public Vertex(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public Set<Vertex> getOrigins()
    {
        return origins;
    }

    public Set<Vertex> getTargets()
    {
        return targets;
    }

    public void target(Vertex vertex)
    {
        targets.add(vertex);
        vertex.origins.add(this);
    }

    public void untarget(Vertex vertex)
    {
        targets.remove(vertex);
        vertex.origins.remove(this);
    }

    @Override
    public int hashCode()
    {
        return id;
    }
}