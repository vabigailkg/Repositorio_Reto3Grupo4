package bbdd.pojos;

import java.util.Objects;

public class Entrada {

	private int codEntrada = 0;
    private String cine = null;
    private String sala = null;
    private String genero = null;
    private String pelicula = null;
    private String fecha = null; 
    private String hora = null;
    private int precio = 0;
    private String dniCliente = null;
	
    public Entrada (int codEntrada, String cine, String sala, String genero, String pelicula, String fecha, String hora, int precio, String dniCliente) {
		this.codEntrada = codEntrada;
		this.cine = cine;
		this.sala = sala;
		this.genero = genero;
		this.pelicula = pelicula;
		this.fecha = fecha;
		this.hora = hora;
		this.precio = precio;
		this.dniCliente = dniCliente;
	}
    
	public int getCodEntrada() {
		return codEntrada;
	}
    
	public void setCodEntrada(int codEntrada) {
		this.codEntrada = codEntrada;
	}
	
	public String getCine() {
		return cine;
	}
	
	public void setCine(String cine) {
		this.cine = cine;
	}
	
	public String getSala() {
		return sala;
	}
	
	public void setSala(String sala) {
		this.sala = sala;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getPelicula() {
		return pelicula;
	}
	
	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getHora() {
		return hora;
	}
	
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public String getDniCliente() {
		return dniCliente;
	}
	
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cine, codEntrada, dniCliente, fecha, genero, hora, pelicula, precio, sala);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrada other = (Entrada) obj;
		return Objects.equals(cine, other.cine) && codEntrada == other.codEntrada
				&& Objects.equals(dniCliente, other.dniCliente) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(genero, other.genero) && Objects.equals(hora, other.hora)
				&& Objects.equals(pelicula, other.pelicula) && precio == other.precio
				&& Objects.equals(sala, other.sala);
	}

	@Override
	public String toString() {
		return "Entrada [codEntrada=" + codEntrada + ", cine=" + cine + ", sala=" + sala + ", genero=" + genero
				+ ", pelicula=" + pelicula + ", fecha=" + fecha + ", hora=" + hora + ", precio=" + precio
				+ ", dniCliente=" + dniCliente + "]";
	}
	
}//.
