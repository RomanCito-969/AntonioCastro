package fp.dual.media.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fp.dual.media.model.MediaResponse;
import fp.dual.media.model.TemperaturaResponse;
import fp.dual.media.service.CalculadoraService;
import fp.dual.media.service.MediaService;

@Service
public class MediaServiceImpl implements MediaService {

    @Autowired
    CalculadoraService servicioCalculadora;

    @Override
    public MediaResponse calcularMedia(List<TemperaturaResponse> listaTemperaturaResponse) {

        MediaResponse respuesta = new MediaResponse();
        List<String> nombreLocalidades = new ArrayList<>();
        Integer tempMaxAc = 0;
        Integer tempMinAc = 0;
        for (TemperaturaResponse temp : listaTemperaturaResponse) {
            nombreLocalidades.add(temp.getNombreLocalidades());
            tempMaxAc = servicioCalculadora.sumarTemperaturas(tempMaxAc, temp.getTemperaturaMaxima());
            tempMinAc = servicioCalculadora.sumarTemperaturas(tempMinAc, temp.getTemperaturaMinima());
        }
        respuesta.setNombreLocalidades(nombreLocalidades);
        respuesta.setTempMaxMedia(servicioCalculadora.dividir(tempMaxAc, nombreLocalidades.size()));
        respuesta.setTempMinMedia(servicioCalculadora.dividir(tempMinAc, nombreLocalidades.size()));
        return respuesta;
    }

}
