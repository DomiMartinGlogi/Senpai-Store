package controller;

import model.storage.Place;

import java.util.ArrayList;

public class Searcher {
    String searchTerm;

    ArrayList<Searchable> searchArea;

    public Searcher(String str, ArrayList<Searchable> searchArea){
        this.searchTerm = str;
        this.searchArea = searchArea;
    }

    public ArrayList<Searchable> search(){
        ArrayList<Searchable> results= new ArrayList<>();
        for (Searchable i:searchArea){
            if (i.getName().equals(searchTerm)){
                results.add(i);
            }
        }
        return results;
    }
}
