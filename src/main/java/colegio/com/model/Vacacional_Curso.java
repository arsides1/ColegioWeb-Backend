package colegio.com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vacional_curso")
public class Vacacional_Curso implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column // no es necesario nombre de atributo de clase = nombre columna
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVacionalCurso;

    @Column(nullable = false)
    private Integer notaCurso;

    @OneToOne(mappedBy = "vacional_curso" ) // mappedBy en la clase entidad que mapea la tabla donde no existe la FK
    private Alumno alumno; // Relacion agregacion

    @OneToOne(mappedBy = "vacional_curso" ) // mappedBy en la clase entidad que mapea la tabla donde no existe la FK
    private Curso curso; // Relacion agregacion

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistro;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean Estado;
}
