

package com.mycompany.endolls_solars;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class EndollsSolars {

    public static void main(String[] args) {
        System.out.println("--- Endolls Solars, S.L. ---");
        BufferedReader terminal= new BufferedReader (new InputStreamReader(System.in));
        ArrayList<Casa> llistacasa= new ArrayList<>();
        
        boolean sortir=false;
        do {
            System.out.println(">");
            String comanda= terminal.readLine();
            String[] arguments= comanda.split(" ");
            switch(arguments[0].toLowerCase()) {
                case "addcasa":
                    String nif = arguments[1];
                    String nom = arguments[2];
                    Integer superficie = Integer.parseInt(arguments[3]);
                    if (arguments.length !=4){
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                        break;
                    }
                    if (superficie <= 10){
                        System.out.println("ERROR: Superficie incorrecte. Ha de ser més gran de 10.");
                        break;
                    }
                    Casa casa = new Casa(nif,nom,superficie);
                    llistacasa.add(casa);
                    System.out.println("OK: Casa registrada.");
                    break;
                    
                case "addplaca":
                    String nifCasa = arguments[1];
                    Integer superficiePlaca = Integer.parseInt(arguments[2]);
                    Float preu = Float.parseFloat(arguments[3]);
                    Integer potencia = Integer.parseInt(arguments[4]);
                    if (arguments.length !=5){
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                        break;
                    }
                    if (superficiePlaca <= 0){
                        System.out.println("ERROR: Superficie incorrecte. Ha de ser més gran de 0.");
                        break;
                    }
                    else if (preu <= 0){
                        System.out.println("ERROR: Preu incorrecte. Ha de ser més gran de 0.");
                        break;
                    }
                    else if (potencia <= 0){
                        System.out.println("ERROR: Potencia incorrecte. Ha de ser més gran de 0.");
                        break;
                    }
                    PlacaSolar placa = new PlacaSolar(superficiePlaca,preu,potencia);
                    for (int i=0; i< llistacasa.size(); i++){
                        if (llistacasa.get(i).donamNif().equals(nifCasa)){
                            if (llistacasa.get(i).donamSuperficie() >= superficiePlaca){
                                llistacasa.get(i).afegirPlaca(placa);
                            }
                            else{
                                System.out.println("ERROR: No hi ha espai disponible per a instal·lar aquesta placa.");
                            }
                        }
                    }
                    System.out.println("OK: Placa afegida a la casa.");
                    break;
                    
                case "addaparell":
                    String nifCasa2 = arguments[1];
                    String descripcio = arguments[2];
                    if (arguments.length !=3){
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                        break;
                    }
                    Integer potenciaAparell = Integer.parseInt(arguments[3]);
                    if (potenciaAparell <= 0){
                        System.out.println("ERROR: Potencia incorrecte. Ha de ser més gran de 0.");
                        break;
                    }
                    Aparell aparell = new Aparell(descripcio,potenciaAparell);
                    for (int i=0; i<llistacasa.size();i++){
                        if (llistacasa.get(i).donamNif().equals(nifCasa2)){
                            llistacasa.get(i).afegirAparell(aparell);
                        }
                    }
                    System.out.println("OK: Aparell afegit a la casa.");
                    break;
                case "oncasa":
                    nifCasa = arguments[1];
                    if (arguments.length !=2){
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                        break;
                    }
                    for (int i=0; i<llistacasa.size();i++){
                        if (llistacasa.get(i).donamNif().equals(nifCasa)){
                            if (llistacasa.get(i).donamInterruptor()==false){
                                llistacasa.get(i).onCasa();
                                System.out.println("OK: Interruptor general activat.");
                            }
                            else{
                                System.out.println("ERROR: La casa ja té l'interruptor encès.");
                            } 
                        }
                        else{
                            System.out.println("ERROR: Nif incorrecte.");
                        }
                    }
                    
                    break;
                
                case "onaparell":
                    nifCasa = arguments[1];
                    descripcio = arguments[2];
                    if (arguments.length !=3){
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                        break;
                    }
                    for (int i=0; i<llistacasa.size();i++){
                        if (llistacasa.get(i).donamNif().equals(nifCasa)){
                            if (llistacasa.get(i).donamInterruptor()==true){
                                llistacasa.get(i).funcioAparell(descripcio);
                            }
                            else{
                                System.out.println("ERROR: No es pot encendre l'aparell. L'interruptor general està apagat.");
                            } 
                        }
                        else{
                            System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                        }
                    }
                    break;
                    
                case "offaparell":
                    nifCasa = arguments[1];
                    descripcio = arguments[2];
                    if (arguments.length !=3){
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                        break;
                    }
                    for (int i=0; i<llistacasa.size();i++){
                        if (llistacasa.get(i).donamNif().equals(nifCasa)){
                            llistacasa.get(i).funcioOffAparell(descripcio);
                        }
                        else{
                            System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                        }
                        }
                    break;
                    
                case "list":
                    if (arguments.length !=1){
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                        break;
                    }
                    System.out.println("--- Endolls Solars, S.L. ---");
                    System.out.println("Cases registrades: "+llistacasa.size());
                    
                    break;
                case "info":
                    String nifCasa3 = arguments[1];
                    if (arguments.length !=2){
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                        break;
                    }
                    for (int i=0; i<llistacasa.size();i++){
                        if (llistacasa.get(i).donamNif().equals(nifCasa3)){
                            llistacasa.get(i).infoCasa();
                        }
                        else{
                            System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                            }   
                    }
                    break;
                case "quit":
                    if (arguments.length !=1){
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                        break;
                    }
                    sortir=true;
                    break;
                    
                default: System.out.println("ERROR: Comanda incorrecta."); 
            }
        } while(!sortir);
    }
}
