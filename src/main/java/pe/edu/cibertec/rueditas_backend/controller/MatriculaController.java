package pe.edu.cibertec.rueditas_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.rueditas_backend.dto.MatriculaRequestDTO;
import pe.edu.cibertec.rueditas_backend.dto.MatriculaResponseDTO;
import pe.edu.cibertec.rueditas_backend.service.impl.MatriculaServiceImpl;

import java.io.IOException;

@RestController
@RequestMapping("/vehiculo")
public class MatriculaController {

    @Autowired
 MatriculaServiceImpl matriculaServiceImpl;

    @PostMapping("/obtener")
    public MatriculaResponseDTO ObtenerVehiculo(@RequestBody MatriculaRequestDTO matriculaRequestDTO){

        try {
            String[] automovil = matriculaServiceImpl.BusquedaPlaca(matriculaRequestDTO.placa());
            if (automovil != null){
                return new MatriculaResponseDTO("00", "", automovil[0], automovil[1], automovil[2], automovil[3], automovil[4]);
            }
                return new MatriculaResponseDTO("01", "No existe Vehiculo ", "", "", "", "", "");
        } catch (IOException e) {
            return new MatriculaResponseDTO("91", "Error : Desconocido ","", "", "", "", "");
        }

    }

}
