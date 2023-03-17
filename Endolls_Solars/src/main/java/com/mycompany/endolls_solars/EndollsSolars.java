
package com.mycompany.endolls_solars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class EndollsSolars {

    public static void main(String[] args) throws IOException {
        System.out.println("--- Endolls Solars, S.L. ---");
        BufferedReader terminal= new BufferedReader (new InputStreamReader(System.in));                 //terminal per l'usuari
        ArrayList<Casa> llistacasa= new ArrayList<>();                                                                                  //declar-ho una arraylist on guardare les cases
        
        boolean sortir=false;                                                                                                                   //control per acabar definida com a fals
        do {                                                                                                        //inici del bucle
            System.out.print("> ");
            String comanda= terminal.readLine();
            String[] arguments= comanda.split(" ");                                     //separo on hi ha un espai la comanda de l'usuari per paraules = arguments 
            boolean controlNif=false;                                                   //defineixo els controls de les condicions en fals
            boolean controlGeneral=false;
            boolean controlDescripcio=false;
            boolean controlEnces=false;
            switch(arguments[0].toLowerCase()) {                                    //defineixo la primera paraula per entrar en els diferents case i faig que ho llegeixi tot en minuscules per evitar erros
                case "addcasa":                                                                         // primer case addcasa
                    if (arguments.length !=4){                                                                                          // comprova si el numero d'aguments es diferent a 4 detecta que la comanda es erronea i amb el break torna enrera
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                        break;
                    }
                    String nif = arguments[1];                                                                          //guardo els arguments per posicio en variables
                    String nom = arguments[2];
                    Integer superficie = Integer.parseInt(arguments[3]);
                    
                    if (superficie <= 10){                                                                                                              //condicio per comprovar que la superficie de la casa sigui més gran de 10
                        System.out.println("ERROR: Superficie incorrecte. Ha de ser més gran de 10.");
                        break;
                    }
                    Casa casaNova = new Casa(nif,nom,superficie);                                                   //declaro la clase casa
                    llistacasa.add(casaNova);                                                                           //afegeixo la casa a l'Arraylisty de cases
                    System.out.println("OK: Casa registrada.");
                    break;
                    
                case "addplaca":
                    if (arguments.length !=5){
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                        break;
                    }
                    nif = arguments[1];
                    Integer superficiePlaca = Integer.parseInt(arguments[2]);
                    Float preu = Float.parseFloat(arguments[3]);
                    Integer potencia = Integer.parseInt(arguments[4]);
                    
                    if (superficiePlaca <= 0){                                                                                                          //comprovo que  la superficie de la placa es més gran que 0, en cas contrari marca error i torna enrera
                        System.out.println("ERROR: Superficie incorrecte. Ha de ser més gran de 0.");
                        break;
                    }
                    else if (preu <= 0){                                                                                                                    //comprovo que el preu es més gran que 0, en cas contrari marca error i torna enrera
                        System.out.println("ERROR: Preu incorrecte. Ha de ser més gran de 0.");
                        break;
                    }
                    else if (potencia <= 0){                                                                                                                //comprovo que  la potencia de la placa es més gran que 0, en cas contrari marca error i torna enrera
                        System.out.println("ERROR: Potencia incorrecte. Ha de ser més gran de 0.");
                        break;
                    }
                    controlNif=false;                                                                                                                       //control que comprova el nif definit en fals
                    PlacaSolar placa = new PlacaSolar(superficiePlaca,preu,potencia);                              //declaro la clase placa solar
                    for (int i=0; i< llistacasa.size(); i++){                                                                                           //recorro la llista de casa
                        if (llistacasa.get(i).donamNif().equals(nif)){                                                      //comprovo que el nif de la casa coincideixi amb el de la placa
                            controlNif=true;                                                                                                                //en cas contrari entra el control de l'altre condicio
                            if (llistacasa.get(i).donamSuperficie() >= superficiePlaca){                                          //comprovo que la superficie més gran o igual al tamany de les placas
                                llistacasa.get(i).afegirPlaca(placa);                                                                           //afageixo a la llista de placas
                                System.out.println("OK: Placa afegida a la casa.");
                            }
                            else{
                                System.out.println("ERROR: No hi ha espai disponible per a instal·lar aquesta placa.");
                            }
                        }
                    }
                    if (controlNif==false){                                                                                                                         
                      System.out.println("ERROR: No hi ha cap casa amb aquest Nif.");
                     }
                    break;
                    
                case "addaparell":
                    if (arguments.length !=4){
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                        System.out.println("Ús: addAparell [nif] [descripció] [potència]");
                        break;
                    }
                    nif = arguments[1];
                    String descripcio = arguments[2];
                    Integer potenciaAparell = Integer.parseInt(arguments[3]);
                    if (potenciaAparell <= 0){                                                                                                                  //comprovo que la potencia del aparell sigui més gran que 0
                        System.out.println("ERROR: Potencia incorrecte. Ha de ser més gran de 0.");
                        break;
                    }
                    Aparell aparell = new Aparell(descripcio,potenciaAparell);                                              //declaro la clase Aparell
                    controlNif=false;
                    for (int i=0; i<llistacasa.size();i++){                                                                                             //recorro la llista de casa
                        if (llistacasa.get(i).donamNif().equals(nif)){                                                      //comprovo que el nif de la casa coincideixi amb el nif del aparell
                            llistacasa.get(i).afegirAparell(aparell);                                                                         //afageix a la llista d'aparells
                            controlNif=true;                                                                                                                    
                            System.out.println("OK: Aparell afegit a la casa.");
                        }
                    }
                   if (controlNif==false){
                      System.out.println("ERROR: No hi ha cap casa amb aquest Nif.");
                     }
                    break;
                    
                case "oncasa":
                    if (arguments.length !=2){
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                        break;
                    }
                    nif = arguments[1];
                    controlNif=false;
                    for (int i=0; i<llistacasa.size();i++){                                                                                         //recorro la llista de casa
                        if (llistacasa.get(i).donamNif().equals(nif)){                                                  //comprovo que el nif de la casa coincideixi amb el nif introduit per l'usuari
                            controlNif=true;
                            if (llistacasa.get(i).donamInterruptor()==false){                                                   //comprovo que l'interruptor estigui apagat
                                llistacasa.get(i).onCasa();                                                                                 //aplica la funcio que engega l'interruptor de la casa
                                System.out.println("OK: Interruptor general activat.");
                            }
                            else{
                                System.out.println("ERROR: La casa ja té l'interruptor encès.");
                            } 
                        }
                    }
                        if (controlNif==false){
                            System.out.println("ERROR: Nif incorrecte.");
                        }
                    
                    
                    break;
                
                case "onaparell":
                    if (arguments.length !=3){
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                        System.out.println("Ús: onAparell [nif] [descripció aparell]");
                        break;
                    }
                    nif = arguments[1];
                    descripcio = arguments[2];
                    controlNif=false;                                                                   //controls per entrar en les diferents condicions
                    controlGeneral=false;
                    controlDescripcio=false;
                    controlEnces=false;
                    for (int i=0; i<llistacasa.size();i++){                                                         //recorro la llista de casa
                        if (llistacasa.get(i).donamNif().equals(nif)){                  //comprovo que el nif de la casa coincideixi amb el nif del aparell
                            Casa casa=llistacasa.get(i);                                                    //guardo la llista de casa en una variable
                            controlNif=true;
                            if (casa.donamInterruptor()==true){                                                 //comprovo si l'interruptor esta encès
                                controlGeneral=true;
                                for (int z=0; z<casa.donamAparell().size() ;z++){                              //recorro la llista de d'aparells de la casa
                                    if (casa.donamAparell().get(z).donamDescripcio().equals(descripcio)){           //comprovo que la descripcio coincideixi amb la descripcio de l'aparell
                                        controlDescripcio=true;
                                        if (casa.donamAparell().get(z).donamInterruptorAparell()==false){                   //comprovo que l'interruptor estigui apagat
                                            casa.donamAparell().get(z).onAparell();                                                             //executa la funcio per encendre l'aparell
                                            controlEnces=true;

                                            Integer totalPotenciaAparell=casa.consumAparell();              
                                            Integer totalPotenciaPlaca=casa.totalPotenciaPlaca();
                                            if (totalPotenciaAparell > totalPotenciaPlaca){                                                 //comprovo que si la potencia de l'aparell sigui més gran que la potencia de las placas
                                                for (int j=0; j<casa.donamAparell().size();j++){                                               //recorro la llista d'aparells
                                                    if (casa.donamAparell().get(j).donamInterruptorAparell()==true){    //comprovo que l'aparell estigui encés
                                                        casa.donamAparell().get(j).offAparell();                                            //utilitzo la funcio per apagar l'aparell
                                                    }
                                                }
                                                casa.offCasa();                                                                                                 //utilitzo la funcio per apagar l'interruptor general de la casa en cas que la potencia dels aparells sigui superior a la potencia de les placas
                                                System.out.println("ERROR: Han saltat els ploms. La casa ha quedat completament apagada.");
                                            }
                                        
                                            else{
                                                System.out.println("OK: Aparell encès.");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
            
                                        if ( controlEnces==false && controlDescripcio ==true){                                                          //les altres condicions amb els seus controls 
                                            System.out.println("ERROR: L'aparell ja té l'interruptor encès.");   
                                        }

                                    if (controlDescripcio==false && controlGeneral==true){
                                        System.out.println("ERROR: No hi ha cap aparell registrat amb aquesta descripció a la casa indicada.");       
                                    }
                    
                            if (controlGeneral==false && controlNif==true){
                                System.out.println("ERROR: No es pot encendre l'aparell. L'interruptor general està apagat.");
                            } 
                        
                        if (controlNif==false){
                            System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                        }
                    break;
                    
                case "offaparell":
                    if (arguments.length !=3){
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                        System.out.println("Ús: offAparell [nif] [descripció aparell]");
                        break;
                    }
                    nif = arguments[1];
                    descripcio = arguments[2];
                    controlNif=false;
                    controlDescripcio=false;
                    controlEnces=false;
                    for (int i=0; i<llistacasa.size();i++){                                                                 //recorro la llista de cases
                        if (llistacasa.get(i).donamNif().equals(nif)){                          //comprovo que el nif de la casa coincideixi amb el nif del aparell
                            controlNif=true;
                            Casa casa=llistacasa.get(i);                                                            //guardo la llista de casa en una variable                                            
                            for (int j=0; j<casa.donamAparell().size();j++){                                        //recorro la llista d'aprells de les cases
                                if (casa.donamAparell().get(j).donamDescripcio().equals(descripcio)){       //comprovo la descripcio de l'aparell
                                    controlDescripcio=true;
                                    if (casa.donamAparell().get(j).donamInterruptorAparell()==true){        //comprovo que l'interruptor de l'aparell esta encès
                                        controlEnces=true;
                                        casa.donamAparell().get(j).offAparell();                        //utilitzo la funcio per apagar l'aparell
                                        System.out.println("OK: Aparell apagat.");
                                    }
                                    
                                }
                            }
                        }
                    }
                         if ( controlEnces==false && controlDescripcio ==true){                                     //les altres condicions amb els seus controls
                                        System.out.println("ERROR: L'aparell ja està apagat.");
                                    }
                        if (controlDescripcio==false && controlNif==true){
                                    System.out.println("ERROR: No hi ha cap aparell registrat amb aquesta descripció a la casa indicada.");    
                                }
                        if (controlNif==false){
                            System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                        }
                    break;
                    
                case "list":
                    if (arguments.length !=1){
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                        System.out.println("Ús: list");
                        break;
                    }
                    if (llistacasa.isEmpty()){                                                                          //condicio per que mostri un missatge que no hi cases si la llista es buida
                        System.out.println("No hi ha cases registrades.");
                        break;
                    }
                    System.out.println("--- Endolls Solars, S.L. ---");
                    System.out.println("Cases registrades: "+llistacasa.size());
                    System.out.println("");
                    int contador = 1;                                                                            //declaro una variable per contar cases amb valor inicial 1
                    for(int i=0;i<llistacasa.size();i++){                                                   //recorro la llista de cases
                        contador+=i;                                                                               //la variable més el valor de cada iteracio(i)
                        System.out.println("Casa "+contador);
                        contador=1;                                                                                 //reinici-ho la variable amb valor 1
                        ArrayList<String>llistaList = llistacasa.get(i).infoList();         //declaro la Arraylist de la funcio de la clase casa
                        for (int j=0; j<llistaList.size(); j++){                                                //recorro la llista de cases i mostro per pantalla la informacio que conte la funcio
                             System.out.println(llistaList.get(j)); 
                        }
                    }
                    break;

                case "info":
                    if (arguments.length !=2){
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                        break;
                    }
                    nif = arguments[1];
                    controlNif=false;
                    for (int i=0; i<llistacasa.size();i++){                                                                     //recorro la llista de cases
                        if (llistacasa.get(i).donamNif().equals(nif)){                              //comprovo que coincideixi el nif introduit per l'usuari amb el de la casa
                            ArrayList <String>llistaInfo = llistacasa.get(i).infoCasa();                //declaro la Arraylist de la funcio de la clase casa
                            controlNif=true;
                            for (int j=0; j<llistaInfo.size(); j++){                                                            //recorro la llista de cases i mostro per pantalla la informacio que conte la funcio
                                System.out.println(llistaInfo.get(j));
                            }
                        }
                    }
                        if (controlNif==false){
                            System.out.println("ERROR: No hi ha cap casa registrada amb aquest nif.");
                            }   
                    
                    break;
                case "quit":                                                                                                                        //case per acabar el programa
                    if (arguments.length !=1){
                        System.out.println("ERROR: Número de paràmetres incorrecte.");
                        break;
                    }
                    System.out.println("Fins aviat!");
                    sortir=true;                                                                                                                        //control per acabar definit com a cert
                    break;
                    
                default: System.out.println("ERROR: Comanda incorrecta.");                                          //control en cas que no entri en cap case per no introduir una comanda correcta
            }
        } while(!sortir);                                                                                                                   //fi del bucle
    }
}
