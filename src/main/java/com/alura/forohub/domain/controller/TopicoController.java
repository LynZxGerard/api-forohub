package com.alura.forohub.domain.controller;
import com.alura.forohub.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<?> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {
        // Verificar si ya existe un tópico con el mismo título y mensaje
        boolean existe = topicoRepository.existsByTituloAndMensaje(
                datosRegistroTopico.titulo(),
                datosRegistroTopico.mensaje()
        );

        if (existe) {
            // Retornar un error 400
            return ResponseEntity
                    .badRequest()
                    .body("Ya existe un tópico con el mismo título y mensaje.");
        }

        Topico topico = new Topico(datosRegistroTopico);
        topicoRepository.save(topico);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Tópico registrado correctamente.");
    }

    @GetMapping
    public Page<DatosListadoTopico> listadoTopicos(@PageableDefault(size = 2) Pageable paginacion) {
        return topicoRepository.findByActivoTrue(paginacion)
                .map(DatosListadoTopico::new); // Mapeamos cada Topico a DatosListadoTopico
    }



    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id) {
        var topico = topicoRepository.findByIdAndActivoTrue(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El tópico no existe o está inactivo"));

        var datosTopico = new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechacreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );

        return ResponseEntity.ok(datosTopico);
    }

    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El tópico no existe"));

        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }


}
