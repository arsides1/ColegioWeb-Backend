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






    @Column(columnDefinition = "TINYINT(1)")
    private boolean Estado;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistro;

}
