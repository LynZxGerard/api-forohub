package com.alura.forohub.domain.topico;

public enum Status {
    ABIERTO,           // Tópico recién creado y disponible para discusión
    CERRADO,           // Tópico finalizado; no se permite más participación
    ELIMINADO,         // Marcado como eliminado por un usuario o moderador
    DESTACADO          // Resaltado como importante o relevante
}
