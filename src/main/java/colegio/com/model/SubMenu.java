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
@Table(name = "submenu")
public class SubMenu implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubMenu;


    @ManyToOne
    //fk
    @JoinColumn(name = "idMenu",referencedColumnName = "idMenu")
    private Menu  idMenu;


    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean Estado;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistro;

    @OneToMany(mappedBy = "idSubMenu", cascade = CascadeType.ALL)
    @JsonBackReference(value="menu_permiso")
    private List<Permiso> permisoList;

}
