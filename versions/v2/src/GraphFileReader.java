/*
 Name: Vikash Fernando
 Student ID: 20232055
 */

import java.io.File;
import java.util.Scanner;

public class GraphFileReader {

    public static DirectedGraph readGraph(String fileName){
        DirectedGraph graph=new DirectedGraph();

        try{
            File file=new File(fileName);
            Scanner scanner=new Scanner(file);

            while (scanner.hasNextLine()){
                String line=scanner.nextLine().trim();

                if(line.isEmpty()){
                    continue;
                }

                String[] parts=line.split("\\s+");

                if (parts.length != 2) {
                    System.out.println("Skipping invalid line: "+line);
                    continue;
                }

                int from=Integer.parseInt(parts[0]);
                int to=Integer.parseInt(parts[1]);

                graph.addEdge(from,to);
            }

            scanner.close();

        } catch (Exception e){
            System.out.println("Error reading file: " +fileName);
            System.out.println("Please make sure the file exists and the format is correct.");
        }

        return graph;
    }
}