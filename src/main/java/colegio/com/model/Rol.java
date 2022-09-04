package colegio.com.model;

import colegio.com.convertir.BooleanConverters;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of={"id"})
@ToString
@Table(name = "rol")
public class Rol implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column // no es necesario nombre de atributo de clase = nombre columna
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Column(length = 50, nullable = false)
    private String Descripcion;


    @Column()
    @Convert(converter= BooleanConverters.CharacterConverter.class )
    private Boolean estado;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistro;


    @OneToMany(mappedBy = "idRol", cascade = CascadeType.ALL)
    @JsonBackReference(value="rol_permiso")
    private List<Permiso> permisoList;

    @OneToMany(mappedBy = "idRol", cascade = CascadeType.ALL)
    @JsonBackReference(value="rol_usuario")
    private List<Usuario> usuarioList;
}
