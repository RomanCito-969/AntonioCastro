package fp.dual.operaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fp.dual.operaciones.service.ServicioClienteSoap;
import fp.dual.operaciones.service.ServicioOperaciones;

@RestController
@RequestMapping("/operaciones")
public class ControllerOperaciones {

    @Autowired
    ServicioOperaciones servicioOperaciones;
    @Autowired
    ServicioClienteSoap servicioClienteSoap;

    @GetMapping(path = "/suma")
    public ResponseEntity<?> operacionSumar(@RequestParam Integer ope1, @RequestParam Integer ope2) {

        Integer respuesta = this.servicioClienteSoap.getCliente().add(ope1, ope2);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);

        // Integer respuesta = this.servicioOperaciones.operacionesSuma(op1,ope2);
        // return new ResponseEntity<>(respuesta, HttpStatus.OK);

    }

    @GetMapping(path = "/resta")
    public ResponseEntity<?> operacionRestar(@RequestParam Integer ope1, @RequestParam Integer ope2) {
        Integer respuesta = this.servicioClienteSoap.getCliente().subtract(ope1, ope2);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping(path = "/multiplica")
    public ResponseEntity<?> operacionMultiplicar(@RequestParam Integer ope1, @RequestParam Integer ope2) {

        Integer respuesta = this.servicioClienteSoap.getCliente().multiply(ope1, ope2);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);

        // Double respuesta = this.servicioOperaciones.operacionMutiplicar(op1, ope2);
        // return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping(path = "/divide")
    public ResponseEntity<?> operacionDividir(@RequestParam Integer ope1, @RequestParam Integer ope2) {

        Integer respuesta = this.servicioClienteSoap.getCliente().divide(ope1, ope2);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);

        // try {
        // Double respuesta = this.servicioOperaciones.operacionDividir(op1, ope2);
        // return new ResponseEntity<>(respuesta, HttpStatus.OK);
        // } catch (ArithmeticException ae) {
        // return new ResponseEntity<>(ae.getMessage(), HttpStatus.BAD_REQUEST);
        // }
    }
}
