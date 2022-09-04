package colegio.com.model;

import colegio.com.convertir.BooleanConverters;
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
@Table(name = "permiso")
public class Permiso implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPermiso;

    @ManyToOne
    //fk
    @JoinColumn(name = "idRol",referencedColumnName = "idRol")
    private Rol  idRol;



    @ManyToOne
    //fk
    @JoinColumn(name = "idSubMenu",referencedColumnName = "idSubMenu")
    private SubMenu  idSubMenu;






    @Column()
    @Convert(converter= BooleanConverters.CharacterConverter.class )
    private Boolean estado;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistro;

}
