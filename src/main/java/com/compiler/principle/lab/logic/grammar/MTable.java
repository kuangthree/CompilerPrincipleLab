package com.compiler.principle.lab.logic.grammar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MTable {
    public MTable(){

    }
    private HashMap<Symbol,HashMap<TerminalSymbol,ArrayList<Production>>> map = new HashMap<>();
    private Set<TerminalSymbol> mTerminalSymbols = new HashSet<>();

    public HashMap<Symbol, HashMap<TerminalSymbol, ArrayList<Production>>> getMap() {
        return map;
    }

    public void setMap(HashMap<Symbol, HashMap<TerminalSymbol, ArrayList<Production>>> map) {
        this.map = map;
    }

    public Set<TerminalSymbol> getmTerminalSymbols() {
        return mTerminalSymbols;
    }

    public void setmTerminalSymbols(Set<TerminalSymbol> mTerminalSymbols) {
        this.mTerminalSymbols = mTerminalSymbols;
    }

    public Set<TerminalSymbol> getTerminalSymbols() {
        return mTerminalSymbols;
    }

    public Set<Symbol> getNoTerminalSymbols(){
        return map.keySet();
    }

    public ArrayList<Production> get(Symbol a, TerminalSymbol b){
        if(!map.containsKey(a))return new ArrayList<>();
        HashMap<TerminalSymbol,ArrayList<Production>> iMap = map.get(a);
        if(!iMap.containsKey(b))
            return new ArrayList<>();
        return iMap.get(b);
    }

    public void add(Symbol a,TerminalSymbol b,Production p){
        if(!b.isNull())
            mTerminalSymbols.add(b);
        if(!map.containsKey(a)){
            HashMap<TerminalSymbol,ArrayList<Production>> iMap = new HashMap<>();
            ArrayList<Production> arrayList = new ArrayList<>();
            arrayList.add(p);
            iMap.put(b,arrayList);
            map.put(a,iMap);
            return;
        }
        HashMap<TerminalSymbol,ArrayList<Production>> iMap = map.get(a);
        if(!iMap.containsKey(b)){
            ArrayList<Production> arrayList = new ArrayList<>();
            arrayList.add(p);
            iMap.put(b,arrayList);
            return;
        }
        iMap.get(b).add(p);
    }

    @Override
    public String toString() {
        return "MTable{" +
                "map=" + map +
                '}';
    }
}
