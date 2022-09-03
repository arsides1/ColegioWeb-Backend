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
@Table(name = "matricula")
public class Matricula implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdMatricula")
	private Long idMatricula;

	@Column(length = 5, unique=true, nullable = false)
	private String codigoMatricula;

	@Column( length = 50, nullable = false)
	private String situacion;


	@ManyToOne
	//fk
	@JoinColumn(name = "idNivelDetalle",referencedColumnName = "idNivelDetalle", unique=true)
	private Nivel_Detalle idNivelDetalle;

	@ManyToOne
	//fk
	@JoinColumn(name = "idApoderado",referencedColumnName = "idApoderado", unique=true)
	private Apoderado idApoderado;


	@ManyToOne
	//fk
	@JoinColumn(name = "idAlumno",referencedColumnName = "idAlumno", unique=true)
	private Alumno idAlumno;

	@ManyToOne
	//fk
	@JoinColumn(name = "idPeriodo",referencedColumnName = "idPeriodo", unique=true)
	private Periodo idPeriodo;



	@Column( length = 100, nullable = false)
	private String colegioProcedencia;

	@Column( length = 2, nullable = false)
	private String esRepitente;

	@Column(columnDefinition = "TINYINT(1)")
	private boolean Estado;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaRegistro;


	@OneToMany(cascade = CascadeType.ALL,mappedBy = "idMatricula")
	@JsonBackReference(value="Pagomatri_matricula")
	private List<PagoMatricula> pagomatriculaList;

}
