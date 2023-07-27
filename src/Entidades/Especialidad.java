package Entidades;

import java.util.Date;

public class Especialidad {
    int Id;
    String Nombre;
    boolean Estado;


    public Especialidad(int p_Id, String p_Nombre, boolean p_Estado) {
        //super(DNI, Nombre, Apellido, Genero, Dirección, Email, Telefono, FechaNac, Edad);
        this.Id = p_Id;
        this.Nombre = p_Nombre;
        this.Estado = p_Estado;
    }
}