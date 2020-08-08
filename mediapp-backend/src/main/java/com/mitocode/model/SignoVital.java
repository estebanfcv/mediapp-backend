package com.mitocode.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Información del paciente")
@Entity
@Table(name = "signo_vital")//, schema = ""
public class SignoVital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSignoVital;
	
	@Schema(description = "temperatura del paciente")
	@Size(min = 2, message = "temperatura debe tener minimo 2 caracteres")
	@Column(name = "temperatura", nullable = false, length = 5)
	private String temperatura;
	
	@Schema(description = "pulso del paciente")
	@Size(min = 1, max = 3, message = "pulso debe tener minimo 3 caracteres")
	@Column(name = "pulso", nullable = false, length = 3)
	private String pulso;
	
	@Schema(description = "ritmo respiratorio del paciente")
	@Size(min = 1, max = 3, message = "ritmo respiratorio debe tener minimo 3 caracteres")
	@Column(name = "ritmo_respiratorio", nullable = false, length = 3)
	private String ritmoRespiratorio;
	
	@Column(name = "fecha", nullable = false)
	private LocalDateTime fecha;
	
	@ManyToOne // FK
	@JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "FK_signo_paciente"))
	private Paciente paciente;

	public Integer getIdSignoVital() {
		return idSignoVital;
	}

	public void setIdSignoVital(Integer idSignoVital) {
		this.idSignoVital = idSignoVital;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public String getPulso() {
		return pulso;
	}

	public void setPulso(String pulso) {
		this.pulso = pulso;
	}

	public String getRitmoRespiratorio() {
		return ritmoRespiratorio;
	}

	public void setRitmoRespiratorio(String ritmoRespiratorio) {
		this.ritmoRespiratorio = ritmoRespiratorio;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
