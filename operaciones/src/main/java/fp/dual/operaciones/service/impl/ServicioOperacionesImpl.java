package fp.dual.operaciones.service.impl;

import org.springframework.stereotype.Service;

import fp.dual.operaciones.service.ServicioOperaciones;

@Service
public class ServicioOperacionesImpl implements ServicioOperaciones {

    @Override
    public Integer operacionSumar(Integer operando1, Integer operando2) {

        return operando1 + operando2;
    }

    @Override
    public Integer operacionResta(Integer operando1, Integer operando2) {

        return operando1 - operando2;
    }

    @Override
    public Integer operacionMutiplicar(Integer operando1, Integer operando2) {

        return operando1 * operando2;
    }

    @Override
    public Integer operacionDividir(Integer operando1, Integer operando2) {

        return operando1 / operando2;
    }

}
