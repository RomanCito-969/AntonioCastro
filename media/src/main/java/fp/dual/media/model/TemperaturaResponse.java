package fp.dual.media.model;

public class TemperaturaResponse {
    String nombreLocalidad;
    Integer temperaturaMaxima;
    Integer temperaturaMinima;

    public TemperaturaResponse(String nombreLocalidad, Integer temperaturaMaxima, Integer temperaturaMinima) {
        super();
        this.nombreLocalidad = nombreLocalidad;
        this.temperaturaMaxima = temperaturaMaxima;
        this.temperaturaMinima = temperaturaMinima;
    }

    public String getNombreLocalidades() {
        return nombreLocalidad;
    }

    public Integer getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public Integer getTemperaturaMinima() {
        return temperaturaMinima;
    }

    @Override
    public String toString() {
        return "Nombre" + this.nombreLocalidad + " | " + "TempMAX: " + this.temperaturaMaxima + " - TempMIN: "
                + this.temperaturaMinima;
    }
}
