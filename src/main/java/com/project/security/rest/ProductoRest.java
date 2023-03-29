package com.project.security.rest;

import com.project.security.models.Producto;
import com.project.security.security.dto.Mensaje;
import com.project.security.security.enumerados.RolNombre;
import com.project.security.services.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping ("/producto")
@CrossOrigin (origins = "*")
public class ProductoRest {

    private final static Logger logger = LoggerFactory.getLogger(ProductoRest.class);

    @Autowired
    ProductoService productoService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<?> findAllProductos () {
        return new ResponseEntity<>(productoService.findAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping ("/{id}")
    public ResponseEntity<?> findProductoById (@PathVariable("id") Integer idProducto) {
        Optional<Producto> producto = productoService.findById(idProducto);
        if(producto.isEmpty()) {
            return new ResponseEntity<>(new Mensaje("no exite el producto con el id solicitado"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(producto.get(), HttpStatus.OK);
    }

    @PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE, value = "/create")
    public ResponseEntity<?> createProducto (@Valid @RequestBody Producto producto, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
            }
            if (productoService.existsByCodigo(producto.getCodigo()) > 0){
                return new ResponseEntity<>(new Mensaje("el codigo del producto que desea crear ya existe"),
                        HttpStatus.BAD_REQUEST);
            }
            productoService.save(producto);
        } catch (Exception exception) {
            logger.error("error en el metodo createProducto: -> "+ exception.getMessage());
            return new ResponseEntity<>(new Mensaje(exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Mensaje("producto creado"),HttpStatus.CREATED);
    }
}
