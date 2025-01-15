package com.alura.forohub.domain.topico;

import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

public record DatosActualizarTopico(
        @NotNull
        Long id,

        String titulo,

        String mensaje,

        LocalDate fechacreacion,

        Status status,

        // El autor de un Topico no se va a poder modificar
//        @NotNull
//        @Size(min = 3, max = 50, message = "El nombre del autor debe tener entre 3 y 50 caracteres")
//        String autor,

        String curso
) {
}
