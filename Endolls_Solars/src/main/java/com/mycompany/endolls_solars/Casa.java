
package com.mycompany.endolls_solars;

import java.util.ArrayList;


public class Casa {                                          //clase objecte de Casa
    private String nif;
    private String nom;
    private Integer superficie;
    private ArrayList<PlacaSolar> placalist;
    private ArrayList<Aparell> aparelllist;
    private boolean interruptor;
    
    public Casa(String nif, String nom, Integer superficie) {               // costructor de la clase
        this.nif=nif;
        this.nom=nom;
        this.superficie=superficie;
        this.placalist= new ArrayList<PlacaSolar>();
        this.aparelllist= new ArrayList<Aparell>(); 
        this.interruptor= true;
    }
    public void afegirPlaca(PlacaSolar placa){                          // funcions per guardar una llista
        this.placalist.add(placa);
    }
    public void afegirAparell(Aparell aparell){
        this.aparelllist.add(aparell);
    }
    public ArrayList<String> infoCasa (){                                       // funcions amb una arraylist que interactua amb el main
        ArrayList<String> info = new ArrayList<>();
        info.add("Client: "+nif+" - "+nom);
        info.add("Plaques solars instal·lades: "+ placalist.size());
        info.add("Potència total: "+ totalPotenciaPlaca() +"W");
        info.add("Inverció total: "+ totalPreu() +"€");
        info.add("Aparells registrats: "+ aparelllist.size());
        info.add("Consum actual: "+ consumAparell() +"W");
        if (consumAparell() > 0){
            info.add("Aparells encesos: " + aparellsEncessos());
        }
        
        return info;
    }
    public ArrayList<String> infoList(){
        ArrayList<String>info=new ArrayList<>();
        info.add("Client: "+nif+" - "+nom);
        info.add("Superfície de teulada: "+superficie);      
        info.add("Superfície disponible: "+EspaiDisponible());
        info.add("Interruptor general: "+InterruptorOnOof());
        info.add(placaSioNo());
        info.add(aparellSioNo()+"\n");
         
         return info;
    }
    public String donamNif(){                               // funcions per poder cridar un parametra de la clase
        return this.nif;
    }
    public String donamNom(){
        return this.nom;
    }
    public Integer donamSuperficie(){
        return this.superficie;
    }
    public void onCasa(){                                       // funcio que no retorna res i fixa l'interruptor per defecte en verdader
        this.interruptor=true;
    }
    public void offCasa(){
        this.interruptor=false;
    }
    public boolean donamInterruptor(){
        return this.interruptor;
    }
    public String InterruptorOnOof(){                          // funcions que pregunta e imprimeix un missatge o altre depenent de si el boolean es cert o fals
                
         return  interruptor?"encès":"apagat";
    }
    public String placaSioNo(){
        if (placalist.isEmpty()){
            return "No té plaques solars instal·lades.";
        }
        else{
        return "Plaques solars instal·lades:"+placalist.size();
        }
    }
    
    public String aparellSioNo(){
        if (aparelllist.isEmpty()){
            return "No té cap aparell elèctric registrat.";
        }
        else{
        return "Aparells registrats: "+aparelllist.size();
        }
    }
    public ArrayList<Aparell> donamAparell(){
        return this.aparelllist;
    }
    
    public String aparellsEncessos(){                                                            // funcio que printa els aparells encessos en la casa
        String llistaAparellsEncessos="";
        for (int i=0; i<aparelllist.size();i++){
            if (aparelllist.get(i).donamInterruptorAparell()==true){
                llistaAparellsEncessos+="\n"+" \t "+"- "+aparelllist.get(i).donamDescripcio();
            }
        }     
        return llistaAparellsEncessos;
    }
    public Integer EspaiDisponible(){                            // funcio que retorna el espai restant per instalar placas solars
        int EspaiDisponible=0;
        for(int i=0;i<placalist.size();i++){
            if (placalist.isEmpty()){
        }
        else{
            EspaiDisponible= superficie - placalist.get(i).donamSuperficie();
            return EspaiDisponible;
        }
        }
        return superficie;
    }
    
    public Integer totalPotenciaPlaca(){                     // funcio que retorna la potencia total de les placas solars
        Integer totalPotenciaPlaca=0;
        for (int j=0; j<placalist.size();j++){
            totalPotenciaPlaca = totalPotenciaPlaca + placalist.get(j).donamPotenciaPlaca();
        }
        return totalPotenciaPlaca;
    }
    
    public Integer consumAparell(){                         // funcio que retorna el consum total dels aparells
        Integer totalPotenciaAparell=0;
        for (int j=0; j<aparelllist.size();j++){
            if (aparelllist.get(j).donamInterruptorAparell()==true){
                totalPotenciaAparell = totalPotenciaAparell + aparelllist.get(j).donamPotencia();
            }
        }
        return totalPotenciaAparell;
    }
    
    public Float totalPreu(){                                    // funcio que retorna el total de la inversio feta
        Float totalPreuPlaca=0f;
        for (int j=0; j<placalist.size();j++){
            totalPreuPlaca = totalPreuPlaca + placalist.get(j).donamPreu();
        }
        return totalPreuPlaca;
    }
}
