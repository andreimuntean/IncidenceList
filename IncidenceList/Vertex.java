class Vertex
{
    final int id;
    int value;

    public Vertex(int id)
    {
        this.id = id;
    }

    public Vertex(int id, int value)
    {
        this.id = id;
        this.value = value;
    }

    public int getId()
    {
        return id;
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
        return id;
    }
}