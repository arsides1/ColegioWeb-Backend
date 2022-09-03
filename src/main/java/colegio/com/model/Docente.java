package colegio.com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "docente")
public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocente;

    @Column(length = 5, unique=true, nullable = false)
    private String codigo;

    @Column(length = 50, nullable = false)
    private String nombres;

    @Column(length = 50, nullable = false)
    private String apellidos;

    @Column(length = 8, unique = true, nullable = false)
    private String dni;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechaNacimiento;

    @Column(length = 50, nullable = false)
    private String sexo;

    @Column(length = 100, nullable = false)
    private String gradoEstudio;

    @Column(length = 100, nullable = false)
    private String ciudad;

    @Column(length = 100, nullable = false)
    private String Direccion;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean Estado;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistro;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "idDocente")
    @JsonBackReference(value="Docenteniveldetallecurso_matri")
    private List<Docente_niveldetalle_curso> DocenteniveldetallecursoList;


}
