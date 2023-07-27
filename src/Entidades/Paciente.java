package Entidades;

import java.util.Date;


public class Paciente extends Persona{
    String tipoSangre,Enfermedad,Alergia;


    public Paciente(String tipoSangre, String Enfermedad, String Alergia, String DNI, String Nombre, String Apellido, String ApellidoM,String Genero, String Dirección, String Email, String Telefono, Date FechaNac, int Edad) {
        super(DNI, Nombre, Apellido, ApellidoM,Genero, Dirección, Email, Telefono, FechaNac, Edad);
        this.tipoSangre = tipoSangre;
        this.Enfermedad = Enfermedad;
        this.Alergia = Alergia;
    }
    
    
    @Override
    public String tipoPersona(){
        return "La persona es Paciente";
    }
    public String listar(){
        String cadena;
        cadena = Listado();
        cadena += "\n---DATOS MEDICOS---";
        cadena += "\nTipo de Sangre : "+tipoSangre;
        cadena += "\nEnfermedad     : "+Enfermedad;
        cadena += "\nAlergia        : "+Alergia;
        return cadena;
        
    }
    
     
    
}
