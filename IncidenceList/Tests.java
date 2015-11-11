import java.util.HashSet;
import java.util.Set;

public class Tests
{
    private static void print(Vertex origin, Vertex target)
    {
        System.out.printf("(%s, %s) ", origin.getId(), target.getId());
    }

    public static void main(String[] args)
    {
        Vertex[] vertices = new Vertex[]
        {
            new Vertex(0), new Vertex(1), new Vertex(2), new Vertex(3), new Vertex(4),
            new Vertex(5), new Vertex(6), new Vertex(7), new Vertex(8), new Vertex(9),
            new Vertex(10), new Vertex(11), new Vertex(12), new Vertex(13), new Vertex(14),
            new Vertex(15), new Vertex(16), new Vertex(17), new Vertex(18), new Vertex(19)
        };

        vertices[0].target(vertices[2]);
        vertices[0].target(vertices[11]);
        vertices[1].target(vertices[19]);
        vertices[2].target(vertices[10]);
        vertices[2].target(vertices[19]);
        vertices[6].target(vertices[10]);
        vertices[6].target(vertices[19]);
        vertices[10].target(vertices[12]);
        vertices[10].target(vertices[18]);
        
        // Duplicates should be detected.
        vertices[0].target(vertices[2]);
        vertices[0].target(vertices[2]);
        vertices[6].target(vertices[10]);

        System.out.print("Expected: (0, 2) (0, 11)\nActual: ");

        for (Vertex vertex : vertices[0].getTargets())
        {
            print(vertices[0], vertex);
        }

        System.out.print("\n\nExpected: \nActual: ");

        for (Vertex vertex : vertices[0].getOrigins())
        {
            print(vertex, vertices[0]);
        }

        System.out.print("\n\nExpected: (2, 10) (2, 19)\nActual: ");

        for (Vertex vertex : vertices[2].getTargets())
        {
            print(vertices[2], vertex);
        }

        System.out.print("\n\nExpected: (10, 12) (10, 18)\nActual: ");

        for (Vertex vertex : vertices[10].getTargets())
        {
            print(vertices[10], vertex);
        }

        System.out.print("\n\nExpected: (2, 10) (6, 10)\nActual: ");

        for (Vertex vertex : vertices[10].getOrigins())
        {
            print(vertex, vertices[10]);
        }

        vertices[6].untarget(vertices[10]);
        
        System.out.println("\n\n-> Removed (6, 10).");
        System.out.print("\nExpected: (10, 12) (10, 18)\nActual: ");

        for (Vertex vertex : vertices[10].getTargets())
        {
            print(vertices[10], vertex);
        }

        System.out.print("\n\nExpected: (2, 10)\nActual: ");

        for (Vertex vertex : vertices[10].getOrigins())
        {
            print(vertex, vertices[10]);
        }

        System.out.println();
    }
}