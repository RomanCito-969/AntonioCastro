package fp.dual.aemet.controller;

import java.io.IOException;
import org.jsoup.*;
import com.google.gson.*;

import fp.dual.aemet.controller.res.RespuestaTemperatura;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/tiempo")
public class ControllerAemet {

    private final String API_URL_BASE = "https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/";
    private final String API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyMC4xMi45OS5yb21hbkBnbWFpbC5jb20iLCJqdGkiOiJmN2VjZGNiOC1kYWVhLTQ2MjUtOGIzNS1kYmNiYWEwZWUyNGUiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTY3Njg4MzA2OCwidXNlcklkIjoiZjdlY2RjYjgtZGFlYS00NjI1LThiMzUtZGJjYmFhMGVlMjRlIiwicm9sZSI6IiJ9.4kYipVKgYIgW3xYITQ8iv_xJUVpmPvF--3x5qGhd5CU";

    @GetMapping("/temperatura")
    public ResponseEntity<?> getTemperaturas(@RequestParam String codigoMunicipio) {
        Gson gson = new Gson();
        String res;
        try {
            res = request(API_URL_BASE + codigoMunicipio);
            JsonObject jsonObject = gson.fromJson(res, JsonObject.class);
            String urlData = jsonObject.get("datos").getAsString();
            String content = request(urlData);
            JsonArray jsonElements = gson.fromJson(content, JsonArray.class);
            JsonObject objectJson = jsonElements.get(0).getAsJsonObject();
            String nombreLocalidad = objectJson.get("nombre").getAsString();
            JsonObject prediccionObject = objectJson.get("prediccion").getAsJsonObject();
            JsonArray prediccionDiaArray = prediccionObject.get("dia").getAsJsonArray();
            JsonObject diaObject = prediccionDiaArray.get(0).getAsJsonObject();
            JsonObject temperaturaObject = diaObject.get("temperatura").getAsJsonObject();
            Integer tempMax = temperaturaObject.get("maxima").getAsInt();
            Integer tempMin = temperaturaObject.get("minima").getAsInt();
            RespuestaTemperatura respuesta = new RespuestaTemperatura(nombreLocalidad, tempMax,
                    tempMin);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        // RespuestaTemperatura respuesta = new RespuestaTemperatura("Ecija", 41, 10);
        // return ResponseEntity.ok(respuesta);
    }

    public String request(String url) throws IOException {
        return Jsoup.connect(url)
                .ignoreContentType(true)
                .header("accept", "application/json")
                .header("api_key", API_KEY)
                .method(Connection.Method.GET)
                .maxBodySize(0).execute().body();
    }
}
