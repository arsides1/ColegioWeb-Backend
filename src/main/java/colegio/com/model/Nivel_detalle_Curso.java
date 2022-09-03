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
@Table(name = "nivel_detalle_Curso")
public class Nivel_detalle_Curso implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column // no es necesario nombre de atributo de clase = nombre columna
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNivelDetalleCurso;

    @ManyToOne
    //fk
    @JoinColumn(name = "idNivelDetalle",referencedColumnName = "idNivelDetalle")
    private Nivel_Detalle idNivelDetalle;

    @ManyToOne
    //fk
    @JoinColumn(name = "idCurso",referencedColumnName = "idCurso")
    private Curso idCurso;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean Estado;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistro;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "idNivelDetalleCurso")
    @JsonBackReference(value="Docenteniveldetallecurso_NivelDetalleCurso")
    private List<Docente_niveldetalle_curso> docenteniveldetallecursoList;
}
