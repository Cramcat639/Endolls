
package com.mycompany.endolls_solars;

public class Aparell {                                      //clase objecte d' Aparells
    private String descripcio;
    private Integer potencia;
    private boolean interruptor;
    
    public Aparell(String descripcio, Integer potencia) {       // costructor de la clase
        this.descripcio=descripcio;
        this.potencia=potencia;
        this.interruptor=false;
    }
    public void onAparell(){                                                        // funcio que no retorna res i fixa l'interruptor per defecte en verdader
        this.interruptor=true;
    }
    public boolean donamInterruptorAparell(){                           // funcions per poder cridar un parametra de la clase
        return this.interruptor;
    }
    public String donamDescripcio(){                            
        return this.descripcio;
    }
    public Integer donamPotencia(){
        return this.potencia;
    }
    public void offAparell(){
        this.interruptor=false;
    }  
}
