
package com.mycompany.endolls_solars;


public class PlacaSolar {                                   //clase objecte de placas solars
    private Integer superficie;
    private Float preu;
    private Integer potencia;
    
    public PlacaSolar(Integer superficie, Float preu, Integer potencia) {       // costructor de la clase
        this.superficie=superficie;
        this.preu=preu;
        this.potencia=potencia;
        
    }
    public Integer donamPotenciaPlaca(){                // funcions per poder cridar un parametra de la clase
        return this.potencia;
    }
    public Float donamPreu(){
        return this.preu;
    }
    public Integer donamSuperficie(){
        return this.superficie;
    }
}
