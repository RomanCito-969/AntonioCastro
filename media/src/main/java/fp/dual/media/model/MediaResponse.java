package fp.dual.media.model;

import java.util.List;

public class MediaResponse {
    List<String> nombreLocalidades;
    Integer tempMaxMedia;
    Integer tempMinMedia;

    public List<String> getNombreLocalidades() {
        return nombreLocalidades;
    }

    public Integer getTempMaxMedia() {
        return tempMaxMedia;
    }

    public Integer getTempMinMedia() {
        return tempMinMedia;
    }

    public void setNombreLocalidades(List<String> nombreLocalidades) {
        this.nombreLocalidades = nombreLocalidades;
    }

    public void setTempMaxMedia(Integer tempMaxMedia) {
        this.tempMaxMedia = tempMaxMedia;
    }

    public void setTempMinMedia(Integer tempMinMedia) {
        this.tempMinMedia = tempMinMedia;
    }
}
