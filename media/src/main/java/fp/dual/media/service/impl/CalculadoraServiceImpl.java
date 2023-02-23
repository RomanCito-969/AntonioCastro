package fp.dual.media.service.impl;

import java.io.IOException;

import org.jsoup.*;
import org.springframework.stereotype.Service;

import fp.dual.media.service.CalculadoraService;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

    @Override
    public Integer sumarTemperaturas(Integer ope1, Integer ope2) {
        String res;
        try {
            res = request("http://localhost:8081/operaciones/suma?ope1=" + ope1 + "&ope2=" + ope2);
            Integer sumar = Integer.parseInt(res);
            return sumar;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Integer dividir(Integer totalSuma, Integer totalNumTemperaturas) {
        String res;
        try {
            res = request(
                    "http://localhost:8081/operaciones/divide?ope1=" + totalSuma + "&ope2=" + totalNumTemperaturas);
            Integer dividir = Integer.parseInt(res);
            return dividir;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String request(String url) throws IOException {
        return Jsoup.connect(url)
                .ignoreContentType(true)
                .header("accept", "application/json")
                .method(Connection.Method.GET)
                .maxBodySize(0).execute().body();
    }
}
