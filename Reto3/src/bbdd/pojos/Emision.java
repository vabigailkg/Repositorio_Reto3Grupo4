package bbdd.pojos;

import java.util.Objects;

public class Emision {

	private int codigoEmision = 0;
    private int codigoSala = 0;
    private int codigoCine = 0;
    private int precioEmision = 0;
    private String fechaEmision = null;
    private String horaEmision = null;
    private int codigopelicula = 0;
    
	public Emision (int codigoEmision, int codigoSala, int codigoCine, int precioEmision, String fechaEmision, String horaEmision, int codigoPelicula) {
		this.codigoEmision = codigoEmision;
		this.codigoSala = codigoSala;
		this.codigoCine = codigoCine;
		this.precioEmision = precioEmision;
		this.fechaEmision = fechaEmision;
		this.horaEmision = horaEmision;
		this.horaEmision = horaEmision;
	}
    
	public int getCodigoEmision() {
		return codigoEmision;
	}
	
	public void setCodigoEmision(int codigoEmision) {
		this.codigoEmision = codigoEmision;
	}
	
	public int getCodigoSala() {
		return codigoSala;
	}
	
	public void setCodigoSala(int codigoSala) {
		this.codigoSala = codigoSala;
	}
	
	public int getCodigoCine() {
		return codigoCine;
	}
	
	public void setCodigoCine(int codigoCine) {
		this.codigoCine = codigoCine;
	}
	
	public int getPrecioEmision() {
		return precioEmision;
	}
	
	public void setPrecioEmision(int precioEmision) {
		this.precioEmision = precioEmision;
	}
	
	public String getFechaEmision() {
		return fechaEmision;
	}
	
	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	
	public String getHoraEmision() {
		return horaEmision;
	}
	
	public void setHoraEmision(String horaEmision) {
		this.horaEmision = horaEmision;
	}
	
	public int getCodigopelicula() {
		return codigopelicula;
	}
	
	public void setCodigopelicula(int codigopelicula) {
		this.codigopelicula = codigopelicula;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoCine, codigoEmision, codigoSala, codigopelicula, fechaEmision, horaEmision,
				precioEmision);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emision other = (Emision) obj;
		return codigoCine == other.codigoCine && codigoEmision == other.codigoEmision && codigoSala == other.codigoSala
				&& codigopelicula == other.codigopelicula && Objects.equals(fechaEmision, other.fechaEmision)
				&& Objects.equals(horaEmision, other.horaEmision) && precioEmision == other.precioEmision;
	}

	@Override
	public String toString() {
		return "Emision [codigoEmision=" + codigoEmision + ", codigoSala=" + codigoSala + ", codigoCine=" + codigoCine
				+ ", precioEmision=" + precioEmision + ", fechaEmision=" + fechaEmision + ", horaEmision=" + horaEmision
				+ ", codigopelicula=" + codigopelicula + "]";
	}
	
}//.
