package colegio.com.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pago_matricula")
public class PagoMatricula implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column // no es necesario nombre de atributo de clase = nombre columna
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPago;
	
	@ManyToOne
	//fk
	@JoinColumn(name = "idMatricula",referencedColumnName = "idMatricula")
	private Matricula idMatricula;
	@Column(nullable = false)
	private Integer monto;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaRegistro;


	@Column(columnDefinition = "TINYINT(1)")
	private boolean Estado;
}
