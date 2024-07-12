package com.application.rest.controller;

import com.application.rest.controller.dto.MakerDTO;
import com.application.rest.entities.Maker;
import com.application.rest.service.IMakerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

//! Es mala practica recibir o retornar entidades para eso se usa los dto

@RestController
@RequestMapping("/api/maker")
public class MakerController {

    //Inyección por constructor - Buena práctica
    private final IMakerService makerService;

    //Este enfoque garantiza que makerService se
    //inicialice al crear MakerController y nunca se modifique posteriormente.
    @Autowired
    public MakerController(IMakerService makerService){
        this.makerService = makerService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<MakerDTO> findById(@PathVariable Long id){
        Optional<Maker> makerOptional = this.makerService.findById(id);

        if (makerOptional.isPresent()){
            // esto es un entities
            Maker maker = makerOptional.get();

            MakerDTO makerDTO = MakerDTO.builder()
                    .id(maker.getId())
                    .name(maker.getName())
                    .productList(maker.getProductList())
                    .build();
            return ResponseEntity.ok(makerDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<MakerDTO>> findAll(){
        List<MakerDTO> makerList = this.makerService.findAll()
                .stream()
                .map(maker -> MakerDTO.builder()
                        .id(maker.getId())
                        .name(maker.getName())
                        .productList(maker.getProductList())
                        .build())
                .toList();
        return ResponseEntity.ok(makerList);

    }
    @PostMapping("/save")
    //@Valid maneja los errores que puede llegar a tener
    public ResponseEntity<?> save(@Valid @RequestBody MakerDTO makerDTO) throws URISyntaxException {
       this.makerService.save(
               Maker.builder()
                       .name(makerDTO.getName())
                       .build()
       );
       //codigo de estado 201 created y el encabezado
       return ResponseEntity.created(new URI("/api/maker/save" + makerDTO.getId())).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>updateMaker(@PathVariable Long id, @RequestBody MakerDTO makerDTO){
        Optional<Maker> makerOptional = this.makerService.findById(id);
        if(makerOptional.isPresent()){
            Maker maker = makerOptional.get();
            maker.setName(makerDTO.getName());
            this.makerService.save(maker);
            return ResponseEntity.ok("Registro Actualizado");
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        Optional<Maker> makerOptional = this.makerService.findById(id);
        if (makerOptional.isPresent()){
            this.makerService.deleteById(id);
            return ResponseEntity.ok("Maker Borrado");
        }
        return ResponseEntity.badRequest().build();
    }
}
