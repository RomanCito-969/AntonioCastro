package fp.dual.media.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fp.dual.media.model.MediaRequest;
import fp.dual.media.model.MediaResponse;
import fp.dual.media.model.TemperaturaResponse;
import fp.dual.media.service.MediaService;
import fp.dual.media.service.TemperaturaService;

@RestController
@RequestMapping(path = "/media")
public class ControllerMedia {

    @Autowired
    TemperaturaService servicioTempereturas;

    @Autowired
    MediaService servicioMedia;

    @PostMapping()
    public ResponseEntity<?> obtenerMedia(@RequestBody MediaRequest codigoMunicipios) {
        try {
            List<TemperaturaResponse> resp = new ArrayList<>();

            for (String codigo : codigoMunicipios.getCodigoMunicipios()) {
                resp.add(servicioTempereturas.obtenerTemperaturas(codigo));
            }

            MediaResponse respuesta = servicioMedia.calcularMedia(resp);
            // TemperaturaResponse rep =
            // this.servicioTempereturas.obtenerTemperaturas("11030");
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
