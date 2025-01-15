package com.alura.forohub.domain.topico;

import java.time.LocalDate;

public record DatosListadoTopico(Long id, String titulo, String mensaje, LocalDate fechacreacion, Status status, String autor, String curso
) {
    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechacreacion(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }

}
