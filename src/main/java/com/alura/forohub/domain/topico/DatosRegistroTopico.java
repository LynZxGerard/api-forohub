package com.alura.forohub.domain.topico;

import jakarta.validation.constraints.PastOrPresent;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import jakarta.validation.constraints.Size;

public record DatosRegistroTopico(
        @NotNull
        @Size(min = 3, max = 100, message = "El título debe tener entre 3 y 100 caracteres")
        String titulo,

        @NotNull
        @Size(min = 10, max = 500, message = "El mensaje debe tener entre 10 y 500 caracteres")
        String mensaje,

        @NotNull
        @PastOrPresent(message = "La fecha de creación no puede ser futura")
        LocalDate fechacreacion,

        @NotNull
        Status status,

        @NotNull
        @Size(min = 3, max = 50, message = "El nombre del autor debe tener entre 3 y 50 caracteres")
        String autor,

        @NotNull
        @Size(min = 3, max = 50, message = "El nombre del curso debe tener entre 3 y 50 caracteres")
        String curso
) {
}

