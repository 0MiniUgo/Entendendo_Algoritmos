package main.Cap06_breadth_first_search;

import java.util.*;

public class BreadthFirstSearch {

    private static Map<String, List<String>> graph = new HashMap<>();
    public static void main(String[] args) {
        graph.put("you", Arrays.asList("alice", "bob", "claire"));
        graph.put("bob", Arrays.asList("anuj", "peggy"));
        graph.put("alice", Arrays.asList("peggy"));
        graph.put("claire", Arrays.asList("thom", "jonny"));
        graph.put("anuj", Collections.emptyList());
        graph.put("peggy", Collections.emptyList());
        graph.put("thom", Collections.emptyList());
        graph.put("jonny", Collections.emptyList());

        search("you");
    }

    private static boolean search(String name){

        Queue<String> searchQueue = new ArrayDeque<>(graph.get(name));
        List<String> searched = new ArrayList<>();

        while (!searchQueue.isEmpty()){
            String person = searchQueue.poll();

            if(!searched.contains(person)){
                if(isSeller(person)){
                    System.out.println(person + " is a seller");
                    return true;
                }else {
                    searchQueue.addAll(graph.get(person));
                    searched.add(person);
                }
            }
        }

        return false;
    }

    private static boolean isSeller(String name){

        return name.endsWith("m");
    }
}
