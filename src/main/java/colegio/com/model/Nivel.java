package colegio.com.model;

import colegio.com.convertir.BooleanConverters;
import colegio.com.fecha_hora.JsonLocalDateDeserializer;
import colegio.com.fecha_hora.JsonLocalDateSerializer;
import colegio.com.fecha_hora.JsonLocalDateTimeDeserializer;
import colegio.com.fecha_hora.JsonLocalDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of={"id"})
@ToString
@Table(name = "nivel")
public class Nivel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNivel;

/*    @ManyToOne
    //fk
    @JoinColumn(name = "idPeriodo",nullable=false,  foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(idPeriodo) references periodo(idPeriodo)"))
    private Periodo idPeriodo;*/


    @ManyToOne
    //fk
    @JoinColumn(name = "idPeriodo",referencedColumnName = "idPeriodo")
    private Periodo idPeriodo;
/*    @ManyToOne
    @JoinColumn(name = "instructor_id",nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(instructor_id) references instructores(instructor_id)"))
    @JsonBackReference
    private Instructor instructor;*/


    @Column(length = 100, nullable = false)
    private String descripcionNivel;

    @Column(length = 50, nullable = false)
    private String descpricionTurno;

    @Column(length = 5, nullable = false)
    //@JsonDeserialize( using = JsonLocalDateTimeDeserializer.class )
    //@JsonSerialize( using = JsonLocalDateTimeSerializer.class )
    private String horaInicio;

    @Column(length = 5, nullable = false)
    //@JsonDeserialize( using = JsonLocalDateTimeDeserializer.class )
    //@JsonSerialize( using = JsonLocalDateTimeSerializer.class )
    private String horaFin;

    @Column()
    @Convert(converter= BooleanConverters.CharacterConverter.class )
    private Boolean estado;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistro;

    @OneToMany(mappedBy = "idNivel", cascade = CascadeType.ALL)
    private List<Nivel_Detalle> nivelDetalleList;

}
