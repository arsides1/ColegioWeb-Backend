package colegio.com.model;

import colegio.com.convertir.BooleanConverters;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of={"id"})
@ToString
@Table(name = "periodo")
public class Periodo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeriodo;


    @Column(length = 50, nullable = false)
    private String descripcion;

    @Column(nullable = false)
   //@Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaInicio;

    @Column(nullable = false)
   // @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaFin;

    @Column()
    @Convert(converter= BooleanConverters.CharacterConverter.class )
    private Boolean estado;




    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistro;


    @OneToMany(mappedBy = "idPeriodo", cascade = CascadeType.ALL)
    private List <Nivel> nivelList;

    @OneToMany(mappedBy = "idPeriodo", cascade = CascadeType.ALL)
    private List <Matricula> matriculaList;
}
