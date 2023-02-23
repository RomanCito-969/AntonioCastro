package fp.dual.media.service;

import org.springframework.stereotype.Service;
import java.util.List;

import fp.dual.media.model.MediaResponse;
import fp.dual.media.model.TemperaturaResponse;

@Service
public interface MediaService {

    public MediaResponse calcularMedia(List<TemperaturaResponse> temperaturaResponse);
}
