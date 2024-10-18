/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author juamp
 */
public class Hospedaje extends Servicio {
    private String hospedaje;
    private double precioPorNoche;
    
    
    
    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws Exception {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        if (enPromocion && dia.getDayOfWeek().getValue() <= 5) {  
            return precioPorNoche * (1 - porcentajeDescuento / 100);
        }
        return precioPorNoche;
    }
    
    
    
    // GETTERS Y SETTERS , TOSTRING :
    @Override
    public String toString() {
        return "Hospedaje{" + " hospedaje = " + hospedaje + ", precioPorNoche = " + precioPorNoche + '}';
    }

    public String getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(String hospedaje) {
        this.hospedaje = hospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }
}
    