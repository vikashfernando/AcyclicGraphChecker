import java.io.File;
import java.util.Scanner;

public class GraphFileReader{

    public static DirectedGraph readGraph(String fileName){
        DirectedGraph graph=new DirectedGraph();

        try{
            File file=new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextInt()){
                int from = scanner.nextInt();
                int to = scanner.nextInt();

                graph.addEdge(from,to);
            }
            scanner.close();
        } catch (Exception e){
            System.out.println("Error in reading file, pls check your input file...");
        }
        return graph;
    }
}