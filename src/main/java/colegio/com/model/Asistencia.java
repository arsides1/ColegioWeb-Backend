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
@Table(name = "asistencia")
public class Asistencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column // no es necesario nombre de atributo de clase = nombre columna
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsistencia;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaIngreso;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean ingresoConfirmado;

    @ManyToOne
    //fk
    @JoinColumn(name = "idAlumno",referencedColumnName = "idAlumno")
    private Alumno idAlumno;

}
