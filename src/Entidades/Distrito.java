package Entidades;

import java.util.Date;

public class Distrito {
    int Id;
    String Nombre;
    boolean Estado;


    public Distrito(int p_Id, String p_Nombre, boolean p_Estado) {
        //super(DNI, Nombre, Apellido, Genero, Dirección, Email, Telefono, FechaNac, Edad);
        this.Id = p_Id;
        this.Nombre = p_Nombre;
        this.Estado = p_Estado;
    }
}
