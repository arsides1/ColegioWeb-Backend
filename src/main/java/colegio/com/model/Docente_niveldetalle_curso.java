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
@Table(name = "docente_niveldetalle_curso")
public class Docente_niveldetalle_curso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocenteniveldetallecurso;


    @ManyToOne
    //fk
    @JoinColumn(name = "idNivelDetalleCurso",referencedColumnName = "idNivelDetalleCurso")
    private Nivel_detalle_Curso idNivelDetalleCurso;

    @ManyToOne
    //fk
    @JoinColumn(name = "idDocente",referencedColumnName = "idDocente")
    private Docente idDocente;


    @Column(columnDefinition = "TINYINT(1)")
    private boolean Estado;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistro;



}
