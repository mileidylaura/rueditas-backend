package pe.edu.cibertec.rueditas_backend.service;

import org.springframework.stereotype.Service;


import java.io.IOException;

public interface MatriculaService {

    public String[] BusquedaPlaca(String nroPlaca) throws IOException;

}