
package com.mycompany.endolls_solars;


public class PlacaSolar {
    private Integer superficie;
    private Float preu;
    private Integer potencia;
    
    public PlacaSolar(Integer superficie, Float preu, Integer potencia) {
        this.superficie=superficie;
        this.preu=preu;
        this.potencia=potencia;
        
    }
    public Integer donamPotenciaPlaca(){
        return this.potencia;
    }
    public Float donamPreu(){
        return this.preu;
    }
}
