package main.Cap08_greedy_algorithms;

import java.util.*;

public class SetCovering {
    public static void main(String[] args) {

        Set<String> statesNeeded = new HashSet<>(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        Map<String, Set<String>> stations = new LinkedHashMap<>();

        stations.put("kum", new HashSet<>(Arrays.asList("id", "nv", "ut")));
        stations.put("kdois", new HashSet<>(Arrays.asList("wa", "id", "mt")));
        stations.put("ktres", new HashSet<>(Arrays.asList("or", "nv", "ca")));
        stations.put("kquatro", new HashSet<>(Arrays.asList("nv", "ut")));
        stations.put("kcinco", new HashSet<>(Arrays.asList("ca", "az")));

        Set<String> finalStations = new HashSet<>();
        while(!statesNeeded.isEmpty()){

            String bestStation = null;
            Set<String> statesCovered = new HashSet<>();


            for(Map.Entry<String, Set<String>> station : stations.entrySet()){

                Set<String> covered = new HashSet<>(statesNeeded);
                covered.retainAll(station.getValue());

                if(covered.size() > statesCovered.size()){
                    bestStation = station.getKey();
                    statesCovered = covered;
                }
            }
            statesNeeded.removeIf(statesCovered::contains);

            if(bestStation != null){
                finalStations.add(bestStation);
            }
        }
        System.out.println(finalStations);
    }
}
