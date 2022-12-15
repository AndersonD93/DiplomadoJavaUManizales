package com.diplomado.claro.proyecto.adapters.controller;

import com.diplomado.claro.proyecto.adapters.controller.dto.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"api/v1/proyecto"})
@CrossOrigin(
        origins = {"*"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}
)
@AllArgsConstructor
public class SaleController {

    @PostMapping({"/prueba"})
    public ResponseEntity<Response> post() {
        return new ResponseEntity(Response.builder().message("Prueba Post").build(), HttpStatus.CREATED);
    }
}
