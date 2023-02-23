package fp.dual.aemet.controller.res;

public class RespuestaTemperatura {
    private String nombreLocalidad;
    private Integer temperaturaMaxima;
    private Integer temperaturaMinima;

    public RespuestaTemperatura(String nombre, Integer tempMax, Integer tempMin) {
        super();
        this.nombreLocalidad = nombre;
        this.temperaturaMaxima = tempMax;
        this.temperaturaMinima = tempMin;
    }

    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    public Integer getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public Integer getTemperaturaMinima() {
        return temperaturaMinima;
    }
}
