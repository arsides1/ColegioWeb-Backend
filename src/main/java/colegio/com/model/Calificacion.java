package colegio.com.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "calificacion")
public class Calificacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCalificacion;

    @ManyToOne
    //fk
    @JoinColumn(name = "idAlumno",referencedColumnName = "idAlumno")
    private Alumno idAlumno;

    @ManyToOne
    //fk
    @JoinColumn(name = "idCurricula",referencedColumnName = "idCurricula")
    private Curricula idCurricula;



    @Column (length = 2, nullable = false)
    private Integer nota1;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean Estado;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistro;
}
