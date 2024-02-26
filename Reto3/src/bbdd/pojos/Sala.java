package bbdd.pojos;

import java.util.Objects;

public class Sala {

	private int codigoSala = 0;
    private int codigoCine = 0;
    private String nombreSala = null;
    
    public Sala (int codigoSala, int codigoCine, String nombreSala) {
		this.codigoSala = codigoSala;
		this.codigoCine = codigoCine;
		this.nombreSala = nombreSala;
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
	
	public String getNombreSala() {
		return nombreSala;
	}
	
	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoCine, codigoSala, nombreSala);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return codigoCine == other.codigoCine && codigoSala == other.codigoSala
				&& Objects.equals(nombreSala, other.nombreSala);
	}

	@Override
	public String toString() {
		return "Sala [codigoSala=" + codigoSala + ", codigoCine=" + codigoCine + ", nombreSala=" + nombreSala + "]";
	}
    
}//.
