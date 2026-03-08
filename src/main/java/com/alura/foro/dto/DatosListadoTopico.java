package com.alura.foro.dto;

import com.alura.foro.domain.Topico;
import java.time.LocalDateTime;

public record DatosListadoTopico(

        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        String autor,
        String curso

) {

    public DatosListadoTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}