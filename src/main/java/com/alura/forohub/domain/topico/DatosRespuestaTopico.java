package com.alura.forohub.domain.topico;

import java.time.LocalDate;

public record DatosRespuestaTopico(Long id, String titulo, String mensaje, LocalDate fechacreacion, Status status, String autor, String curso
) {
}
