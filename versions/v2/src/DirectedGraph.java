/*
 Name: Vikash Fernando
 Student ID: 20232055
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DirectedGraph{

    private Map<Integer,List<Integer>>adjList;

    public DirectedGraph(){
        adjList=new HashMap<>();
    }

    public void addVertex(int vertex){
        if(!adjList.containsKey(vertex)){
            adjList.put(vertex,new ArrayList<>());
        }
    }

    public void addEdge(int from, int to){
        addVertex(from);
        addVertex(to);
        adjList.get(from).add(to);
    }

    public Map<Integer, List<Integer>> getGraph(){
        return adjList;
    }

    public Set<Integer> getVertices(){
        return adjList.keySet();
    }

    public List<Integer> getNeighbours(int vertex){
        return adjList.getOrDefault(vertex,new ArrayList<>());
    }

    public Integer findSink(){
        for (Integer vertex : adjList.keySet()){
            if (adjList.get(vertex).isEmpty()){
                return vertex;
            }
        }
        return null;
    }

    public void removeVertex(Integer vertex){
        adjList.remove(vertex);

        for(List<Integer> neighbours : adjList.values()){
            neighbours.remove(vertex);
        }
    }

    public boolean isEmpty(){
        return adjList.isEmpty();
    }

    public int size(){
        return adjList.size();
    }

    public DirectedGraph copy(){
        DirectedGraph copyGraph=new DirectedGraph();

        for(Integer vertex : adjList.keySet()){
            copyGraph.addVertex(vertex);
        }

        for(Integer from : adjList.keySet()){
            for(Integer to : adjList.get(from)){
                copyGraph.addEdge(from,to);
            }
        }

        return copyGraph;
    }

    public void printGraph(){
        List<Integer> sortedVertices=new ArrayList<>(adjList.keySet());
        Collections.sort(sortedVertices);

        for(Integer vertex : sortedVertices){
            System.out.print(vertex + " -> ");

            List<Integer> neighbours=new ArrayList<>(adjList.get(vertex));
            Collections.sort(neighbours);

            if(neighbours.isEmpty()){
                System.out.println("(no outgoing edges)");
            }else{
                for(int i = 0; i < neighbours.size(); i++){
                    System.out.print(neighbours.get(i));
                    if(i < neighbours.size() - 1){
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }
    }

    public int getEdgeCount(){
        int count = 0;
        for(List<Integer> neighbours : adjList.values()){
            count += neighbours.size();
        }
        return count;
    }
}