
package com.mycompany.endolls_solars;

public class Aparell {
    private String descripcio;
    private Integer potencia;
    private boolean interruptor;
    
    public Aparell(String descripcio, Integer potencia) {
        this.descripcio=descripcio;
        this.potencia=potencia;
        this.interruptor=false;
    }
    public void onAparell(){
        this.interruptor=true;
    }
    public boolean donamInterruptorAparell(){
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
