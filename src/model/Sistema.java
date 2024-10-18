/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author juamp
 */
public class Sistema {
    public List<Servicio> lstServicio;

    public Sistema() {
        this.lstServicio = new ArrayList<>();
    }

    public Servicio traerServicio(String codServicio) {
        for (Servicio servicio : lstServicio) {
            if (servicio.codServicio.equals(codServicio)) {
                return servicio;
            }
        }
        return null;
    }

    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> serviciosPromocion = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.enPromocion == enPromocion) {
                serviciosPromocion.add(servicio);
            }
        }
        return serviciosPromocion;
    }

    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        List<Servicio> serviciosFecha = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.enPromocion == enPromocion && servicio.calcularPrecioFinal(dia) != 0) {
                serviciosFecha.add(servicio);
            }
        }
        return serviciosFecha;
    }

    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws Exception {
        if (traerServicio(codServicio) != null) {
            throw new Exception("El servicio ya existe.");
        }
        lstServicio.add(new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc));
        return true;
    }

    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws Exception {
        if (traerServicio(codServicio) != null) {
            throw new Exception("El servicio ya existe.");
        }
        lstServicio.add(new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche));
        return true;
    }
}