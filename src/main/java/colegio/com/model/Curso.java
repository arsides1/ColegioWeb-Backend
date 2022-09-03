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
@Table(name = "curso")
public class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column // no es necesario nombre de atributo de clase = nombre columna
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCurso;
	
	@Column( length = 50, nullable = false)
	private String descripcion;


	@Column(columnDefinition = "TINYINT(1)")
	private boolean Estado;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaRegistro;


	@OneToMany(cascade = CascadeType.ALL,mappedBy = "idCurso")
	@JsonBackReference(value="Curso_NivelDetalleCurso")
	private List<Nivel_detalle_Curso> nivelDetalleCursoList;

	/*@OneToMany(cascade = CascadeType.ALL,mappedBy = "idcur")
	@JsonBackReference(value="cur_not")
	private List<Nota> notaList;
	*/
	//@JsonIgnore
	//@JsonBackReference
	/*@ManyToMany(mappedBy = "cursoList")
	private List<Profesor> profesorList;
	
	
	@ManyToMany(mappedBy = "cursoList")
	private List<Grado_Seccion> gradoList;*/

	@OneToOne
	//Si necesito mapear la FK , clase entidad unida a la tabla debil!!!.
	@JoinColumn(name = "idVacionalCurso",nullable = false,unique = true,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(idVacionalCurso) references vacional_curso(idVacionalCurso)"))
	@JsonBackReference //cortoBucle
	private Vacacional_Curso vacional_curso; // composicion.
}
