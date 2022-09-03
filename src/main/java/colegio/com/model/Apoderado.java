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
@Table(name = "apoderado")
public class Apoderado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdApoderado")
    private Long idApoderado;


    @Column(length = 50, nullable = false)
    private String tipoRelacion;

    @Column(length = 50, nullable = false)
    private String nombres;

    @Column(length = 8, unique = true, nullable = false)
    private String dni;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechNacimiento;

    @Column(nullable = false)
    private Long sexo;

    @Column(nullable = false)
    private Long estadoCivil;

    @Column( length = 100, nullable = false)
    private String ciudad;

    @Column( length = 100, nullable = false)
    private String direccion;

    @Column(length = 9, nullable=false)
    private String telefono;

    //@Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistro;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idApoderado")
    @JsonBackReference(value = "apoderado_matricula")
    private List<Matricula> matriculaList;

}
