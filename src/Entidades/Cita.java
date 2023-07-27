
package Entidades;

/**
 *
 * @author USER
 */
public class Cita {
   int id_personal,id_paciente,id_tuno,id_horario,id_espe;
   String cita_fecha;

    public Cita(int id_personal, int id_paciente, int id_tuno, int id_horario, int id_espe, String cita_fecha) {
        this.id_personal = id_personal;
        this.id_paciente = id_paciente;
        this.id_tuno = id_tuno;
        this.id_horario = id_horario;
        this.id_espe = id_espe;
        this.cita_fecha = cita_fecha;
    }
public Cita(){
    
}
    public int getId_personal() {
        return id_personal;
    }

    public void setId_personal(int id_personal) {
        this.id_personal = id_personal;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_tuno() {
        return id_tuno;
    }

    public void setId_tuno(int id_tuno) {
        this.id_tuno = id_tuno;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public int getId_espe() {
        return id_espe;
    }

    public void setId_espe(int id_espe) {
        this.id_espe = id_espe;
    }

    public String getCita_fecha() {
        return cita_fecha;
    }

    public void setCita_fecha(String cita_fecha) {
        this.cita_fecha = cita_fecha;
    }
   
   
   
    
    
}
