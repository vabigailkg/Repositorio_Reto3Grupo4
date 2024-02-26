package bbdd.pojos;

import java.util.Objects;

/**
 * Define al objeto cine.
 */
public class Cine {

	private int codigoCine = 0;
	private String nombreCine = null;
	private String direccionCine = null;

	/**
	 * Constructor del objeto cine.
	 * 
	 * @param codigoCine	 Número identificativo del cine.
	 * @param nombreCine    Cadena del nombre del cine.
	 * @param direccionCine Cadena de la dirección del cine.
	 */
	public Cine (int codigoCine, String nombreCine, String direccionCine) {
		this.codigoCine = codigoCine;
		this.nombreCine = nombreCine;
		this.direccionCine = direccionCine;
	}

	/**
	 * Obtiene el id del cine.
	 * 
	 * @return Número identificativo del cine.
	 */
	public int getcodigoCine() {
		return codigoCine;
	}

	/**
	 * Introduce el id del cine.
	 * 
	 * @param codigoCine Número identificativo del cine.
	 */
	public void setcodigoCine(int codigoCine) {
		this.codigoCine = codigoCine;
	}

	/**
	 * Obtiene el nombre del cine.
	 * 
	 * @return Cadena del nombreCine del cine.
	 */
	public String getnombreCine() {
		return nombreCine;
	}

	/**
	 * Introduce el nombre del cine.
	 * 
	 * @param nombreCine Cadena del nombre del cine.
	 */
	public void setnombreCine(String nombreCine) {
		this.nombreCine = nombreCine;
	}

	/**
	 * Obtiene la dirección del cine.
	 * 
	 * @return Cadena de la dirección del cine.
	 */
	public String getdireccionCine() {
		return direccionCine;
	}

	/**
	 * Introduce la dirección del cine.
	 * 
	 * @param nombreCine Cadena de la dirección del cine.
	 */
	public void setdireccionCine(String direccionCine) {
		this.direccionCine = direccionCine;
	}

	/**
	 * Devuelve en una cadena el id, el nombre y la dirección del cine.
	 */
	@Override
	public String toString() {
		return "Cine [codigoCine=" + codigoCine + ", nombreCine=" + nombreCine + ", direccionCine=" + direccionCine + "]";
	}

	/**
	 * Devuelve los valores id, nombre y dirección del cine si no son modificados
	 * por equals.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(direccionCine, codigoCine, nombreCine);
	}

	/**
	 * Comprueba el tipo y el nombre de los objetos id, dirección y nombre del cine.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cine other = (Cine) obj;
		return Objects.equals(direccionCine, other.direccionCine) && codigoCine == other.codigoCine && Objects.equals(nombreCine, other.nombreCine);
	}

}
