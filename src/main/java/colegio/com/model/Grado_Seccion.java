package colegio.com.model;

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
@Table(name = "grado_seccion")
public class Grado_Seccion implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdGradoSeccion")
    private Long idGradoSeccion;

    @Column(length = 50, nullable = false)
    private String descripcionGrado;

    @Column(length = 100, nullable = false)
    private String descripcionSeccion;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean Estado;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistro;


    @OneToMany(mappedBy = "IdGradoSeccion", cascade = CascadeType.ALL)
    private List<Nivel_Detalle> niveldetalleList;
}
