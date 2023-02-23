package fp.dual.operaciones.service.impl;

import java.io.PrintWriter;
import java.net.URL;
import java.util.Objects;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.AttachmentOutInterceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.springframework.stereotype.Service;
import org.tempuri.Calculator;
import org.tempuri.CalculatorSoap;

import fp.dual.operaciones.service.ServicioClienteSoap;

@Service
public class ServicioClienteSoapImpl implements ServicioClienteSoap {

    private final String URL = "http://www.dneonline.com/calculator.asmx?wsdl";
    private Calculator servicio;
    private CalculatorSoap cliente;

    public ServicioClienteSoapImpl() {
        super();
    }

    @Override
    public CalculatorSoap getCliente() {
        if (Objects.isNull(this.servicio)) {
            try {
                this.servicio = new Calculator(new URL(this.URL));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (Objects.isNull(this.cliente)) {
            this.cliente = this.servicio.getCalculatorSoap();
            activarTrazas(this.cliente);
        }
        return this.cliente;
    }

    public void activarTrazas(CalculatorSoap cliente) {
        Client cxfClient = ClientProxy.getClient(cliente);
        AttachmentOutInterceptor outInterceptor = new AttachmentOutInterceptor();
        LoggingOutInterceptor loggingOutInterceptor = new LoggingOutInterceptor();
        LoggingInInterceptor loggingInInterceptor = new LoggingInInterceptor();
        PrintWriter io = new PrintWriter(System.out);
        loggingInInterceptor.setPrintWriter(io);
        loggingOutInterceptor.setPrintWriter(io);
        cxfClient.getInInterceptors().add(loggingInInterceptor);
        cxfClient.getOutInterceptors().add(loggingOutInterceptor);
        cxfClient.getOutInterceptors().add(outInterceptor);
    }
}
