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
@Table(name = "curricula")
public class Curricula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurricula;

    @ManyToOne
    //fk
    @JoinColumn(name = "idDocenteniveldetallecurso",referencedColumnName = "idDocenteniveldetallecurso")
    private Docente_niveldetalle_curso idDocenteniveldetallecurso;

    @Column(length = 50, nullable = false)
    private String descripcion;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean Estado;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistro;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCurricula")
    @JsonBackReference(value = "curricula_calificacion")
    private List<Calificacion> calificacionList;



}
