/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.seguridad;

/**
 *
 * @author cdavi
 */
public class Marca {

    private String codigo_marca;
    private String nombre_marca;
    private String estatus_marca;

    public Marca(String codigo_marca, String nombre_marca, String estatus_marca) {
        this.codigo_marca = codigo_marca;
        this.nombre_marca = nombre_marca;
        this.estatus_marca = estatus_marca;
    }

    @Override
    public String toString() {
        return "marcas{" + "codigo_marca=" + codigo_marca + ", nombre_marca=" + nombre_marca + ", estatus_marca=" + estatus_marca + '}';
    }

    public String getCodigo_marca() {
        return codigo_marca;
    }

    public void setCodigo_marca(String codigo_marca) {
        this.codigo_marca = codigo_marca;
    }

    public String getNombre_marca() {
        return nombre_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }

    public String getEstatus_marca() {
        return estatus_marca;
    }

    public void setEstatus_marca(String estatus_marca) {
        this.estatus_marca = estatus_marca;
    }

    public Marca() {
    }
}
