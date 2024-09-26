package pe.edu.cibertec.rueditas_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.rueditas_backend.service.MatriculaService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
@Service
public class MatriculaServiceImpl  implements MatriculaService {
    
    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] BusquedaPlaca(String nroPlaca) throws IOException {
        String[] datoVehiculo = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] dato = linea.split(";");
                if (nroPlaca.equals(dato[1])) {
                    datoVehiculo = new String[5];
                    datoVehiculo[0] = dato[2];
                    datoVehiculo[1] = dato[3];
                    datoVehiculo[2] = dato[4];
                    datoVehiculo[3] = dato[5];
                    datoVehiculo[4] = dato[6];
                    break;
                }
            }
        } catch (IOException e) {
            datoVehiculo = null;
            throw new IOException(e);
        }
        return datoVehiculo;
    }
}
