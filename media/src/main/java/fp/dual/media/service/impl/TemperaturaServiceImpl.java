package fp.dual.media.service.impl;

import java.io.IOException;

import org.jsoup.*;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import fp.dual.media.model.TemperaturaResponse;
import fp.dual.media.service.TemperaturaService;

@Service
public class TemperaturaServiceImpl implements TemperaturaService {

    @Override
    public TemperaturaResponse obtenerTemperaturas(String codigoMunicipio) {
        Gson gson = new Gson();
        String res;
        try {
            // "http://localhost:8082/tiempo/temperatura?codigoMunicipio="
            // "http://192.168.1.38:8083/tiempo/temperatura?codigoMunicipio="
            res = request("http://localhost:8082/tiempo/temperatura?codigoMunicipio=" + codigoMunicipio);
            TemperaturaResponse temperaturaResponse = gson.fromJson(res, TemperaturaResponse.class);
            return temperaturaResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTemperaturas'");
    }

    public String request(String url) throws IOException {
        return Jsoup.connect(url)
                .ignoreContentType(true)
                .header("accept", "application/json")
                .method(Connection.Method.GET)
                .maxBodySize(0).execute().body();
    }

}
