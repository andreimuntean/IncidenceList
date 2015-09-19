class Edge
{
    final Vertex[] vertices;
    int value;

    public Edge(Vertex... vertices)
    {
        if (vertices == null || vertices.length != 2)
        {
            throw new IllegalArgumentException("An edge must have exactly two vertices.");
        }

        this.vertices = vertices;
    }

    public Vertex[] getVertices()
    {
        return vertices;
    }

    public Vertex getOrigin()
    {
        return vertices[0];
    }

    public Vertex getTarget()
    {
        return vertices[1];
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    @Override
    public int hashCode()
    {
        return 31 * vertices[0].getId() + 101 * vertices[1].getId();
    }

    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof Edge))
        {
            return false;
        }

        Edge edge = (Edge)object;

        return vertices[0].getId() == edge.vertices[0].getId()
            && vertices[1].getId() == edge.vertices[1].getId();
    }
}