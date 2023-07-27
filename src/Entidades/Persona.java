package Entidades;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public abstract class Persona {

    private String DNI, Nombre, Apellido,ApellidoM, nomCompleto, Genero, Dirección, Email, Telefono;
    Date FechaNac;
    int Edad, validacion = 0;
    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public Persona(String DNI, String Nombre, String Apellido, String ApellidoM,String Genero, String Dirección, String Email, String Telefono, Date FechaNac, int Edad) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.ApellidoM = ApellidoM;
        this.Genero = Genero;
        this.Dirección = Dirección;
        this.Email = Email;
        this.Telefono = Telefono;
        this.FechaNac = FechaNac;
        this.Edad = Edad;
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public String getNomCompleto() {
        nomCompleto = Apellido + ", " + Nombre;
        return nomCompleto;
    }

    public int getEdad() {
        return Edad;
    }

    public String getGenero() {
        String cGenero;
        if (Genero == "M") {
            cGenero = "Masculino";
        } else {
            cGenero = "Femenino";
        }

        return cGenero;
    }

    public String Listado() {
        String cadena;
        cadena = "DNI    : " + DNI;
        cadena += "\nNombres      : " + nomCompleto;
        cadena += "\nGenero       : " + getGenero();
        cadena += "\nDirección    : " + this.Dirección;
        cadena += "\nEmail        : " + this.Email;
        cadena += "\nTelefono     : " + this.Telefono;
        return cadena;
    }

    public abstract String tipoPersona();

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }
    public String getApellidoM() {
        return ApellidoM;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
     public void setApellidoM(String Apellido) {
        this.ApellidoM = Apellido;
    }

    public String getDirección() {
        return Dirección;
    }

    public void setDirección(String Dirección) {
        this.Dirección = Dirección;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public Date getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(Date FechaNac) {
        this.FechaNac = FechaNac;
    }

    public boolean validate(final String hex) {
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }

    public String validar() {
        String ok = "S";
        boolean correoValido = validate(this.Email);
        if (DNI.equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese DNI del paciente.");
            validacion++;
        }
        if (DNI.length() != 8 && validacion == 0) {
            JOptionPane.showMessageDialog(null, "El DNI consta de 8 caracteres.\nIngrese un formato valido");
            validacion++;
        }

        if (Nombre.equals("") && validacion == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el Nombre del paciente.");
            validacion++;
        }
        if (Apellido.equals("") && validacion == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el Apellido del paciente.");
            validacion++;
        }

        if (correoValido == false && validacion == 0) {
            JOptionPane.showMessageDialog(null, "Correo no valido");
            validacion++;
        }

        if (validacion
                > 0) {
            ok = "N";
        } else {
            ok = "S";
        }

        return ok;

    }

}
