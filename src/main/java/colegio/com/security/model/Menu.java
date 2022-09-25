package colegio.com.security.model;

import colegio.com.convertir.BooleanConverters;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of={"id"})
@ToString
@Table(name = "menu")
public class Menu implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column // no es necesario nombre de atributo de clase = nombre columna
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMenu;




    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 50)
    private String icono;

    @Column()
    @Convert(converter= BooleanConverters.CharacterConverter.class )
    private boolean estado;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistro;

    @Column(name = "url", length = 50)
    private String url;
}
