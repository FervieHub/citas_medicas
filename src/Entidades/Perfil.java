package Entidades;

import java.util.Date;

public class Perfil {
    int Id;
    String Descripcion;
    boolean Estado;


    public Perfil(int p_Id, String p_Descripcion, boolean p_Estado) {
        //super(DNI, Nombre, Apellido, Genero, Dirección, Email, Telefono, FechaNac, Edad);
        this.Id = p_Id;
        this.Descripcion = p_Descripcion;
        this.Estado = p_Estado;
    }
}
