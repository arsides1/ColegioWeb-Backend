package colegio.com.security.model;

import javax.persistence.*;

@Entity
public class MenuRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuRolId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Menu menu;

    @ManyToOne
    private Rol rol;

    public Long getMenuRolId() {
        return menuRolId;
    }

    public void setMenuRolId(Long menuRolId) {
        this.menuRolId = menuRolId;
    }
}
