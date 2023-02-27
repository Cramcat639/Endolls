
package com.mycompany.endolls_solars;

import java.util.ArrayList;


public class Casa {
    private String nif;
    private String nom;
    private Integer superficie;
    private ArrayList<PlacaSolar> placalist;
    private ArrayList<Aparell> aparelllist;
    private boolean interruptor;
    
    public Casa(String nif, String nom, Integer superficie) {
        this.nif=nif;
        this.nom=nom;
        this.superficie=superficie;
        this.placalist= new ArrayList<PlacaSolar>();
        this.aparelllist= new ArrayList<Aparell>(); 
        this.interruptor= true;
    }
    public void afegirPlaca(PlacaSolar placa){
        this.placalist.add(placa);
    }
    public void afegirAparell(Aparell aparell){
        this.aparelllist.add(aparell);
    }
    public void infoCasa (){
        System.out.println("Client: "+nif+"-"+nom);
        System.out.println("Plaques solars instal·lades: "+ placalist.size());
        System.out.println("Potència total: "+ +"W");
        System.out.println("Inverció total: "+ +"€");
        System.out.println("Aparells registrats: "+);
        System.out.println("Consum actual: "+);
    }
    public String donamNif(){
        return this.nif;
    }
    public Integer donamSuperficie(){
        return this.superficie;
    }
    public void onCasa(){
        this.interruptor=true;
    }
    public boolean donamInterruptor(){
        return this.interruptor;
    }
    public ArrayList<Aparell> donamAparell(){
    return this.aparelllist;
    }
    public void funcioOffAparell(String descripcio){
        for (int i=0; i<aparelllist.size();i++){
        if (aparelllist.get(i).donamDescripcio().equals(descripcio)){
            if (aparelllist.get(i).donamInterruptorAparell()==true){
                aparelllist.get(i).offAparell();
                System.out.println("OK: Aparell apagat.");
            }
            else{
                System.out.println("ERROR: L'aparell ja té l'interruptor encès.");
            }
        }
        else{
            System.out.println("ERROR: No hi ha cap aparell registrat amb aquesta descripció a la casa indicada.");    
            }
        }
        }
    public void funcioAparell(String descripcio){
        for (int i=0; i<aparelllist.size();i++){
            if (aparelllist.get(i).donamDescripcio().equals(descripcio)){
                if (aparelllist.get(i).donamInterruptorAparell()==false){
                    aparelllist.get(i).onAparell();
                    Integer totalPotenciaAparell=0;
                    for (int j=0; j<aparelllist.size();j++){
                        if (aparelllist.get(j).donamInterruptorAparell()==true){
                            totalPotenciaAparell = totalPotenciaAparell + aparelllist.get(j).donamPotencia();  
                        }
                    }
                    Integer totalPotenciaPlaca=0;
                    for (int j=0; j<placalist.size();j++){
                            totalPotenciaPlaca = totalPotenciaPlaca + placalist.get(j).donamPotenciaPlaca();
                    }
                    if (totalPotenciaAparell > totalPotenciaPlaca){
                        for (int j=0; j<aparelllist.size();j++){
                            if (aparelllist.get(j).donamInterruptorAparell()==true){
                                aparelllist.get(j).offAparell();
                            }
                        }
                        interruptor=false;
                        System.out.println("ERROR: Han saltat els ploms. La casa ha quedat completament apagada.");
                    }
                    else{
                        System.out.println("OK: Aparell encès.");
                    }
                }
                else{
                    System.out.println("ERROR: L'aparell ja té l'interruptor encès.");   
                }
            }
            else{
                System.out.println("ERROR: No hi ha cap aparell registrat amb aquesta descripció a la casa indicada.");       
            }
        }
    }
}
