package com.alura.forohub.domain.topico;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Table(name = "topicos")
@Entity(name = "Topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private LocalDate fechacreacion;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String autor;
    private String curso;

    private boolean activo;


    // Constructor sin argumentos
    public Topico() {
    }

    // Constructor con todos los argumentos
    public Topico(Long id, String titulo, String mensaje, LocalDate fechacreacion, Status status, String autor, String curso, Boolean activo) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechacreacion = fechacreacion;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
        this.activo = activo;
    }

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.activo = true;
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechacreacion = datosRegistroTopico.fechacreacion();
        this.status = datosRegistroTopico.status();
        this.autor = datosRegistroTopico.autor();
        this.curso = datosRegistroTopico.curso();
    }

    // Getters y setters


    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDate getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(LocalDate fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topico topico = (Topico) o;
        return Objects.equals(id, topico.id) && Objects.equals(titulo, topico.titulo) && Objects.equals(mensaje, topico.mensaje) && Objects.equals(fechacreacion, topico.fechacreacion) && status == topico.status && Objects.equals(autor, topico.autor) && Objects.equals(curso, topico.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, mensaje, fechacreacion, status, autor, curso);
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {

        if (datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }

        if(datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();
        }

        if(datosActualizarTopico.fechacreacion() != null){
            this.fechacreacion = datosActualizarTopico.fechacreacion();
        }

        if(datosActualizarTopico.status() != null){
            this.status = datosActualizarTopico.status();
        }

        // No vamos a dejar que se actualice el autor de un Topico
        // this.autor = datosActualizarTopico.autor();

        if(datosActualizarTopico.curso() != null){
            this.curso = datosActualizarTopico.curso();
        }

    }

    public void desactivarTopico() {
        this.activo=false;
    }
}
