package bbdd.pojos;

import java.util.Objects;

/**
 * Define al objeto cine.
 */
public class Cine {

	private long id = 0;
	private String nombre = null;
	private String direccion = null;

	/**
	 * Constructor del objeto cine.
	 * 
	 * @param id        Número identificativo del cine.
	 * @param nombre    Cadena del nombre del cine.
	 * @param direccion Cadena de la dirección del cine.
	 */
	public Cine(long id, String nombre, String direccion) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	/**
	 * Obtiene el id del cine.
	 * 
	 * @return Número identificativo del cine.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Introduce el id del cine.
	 * 
	 * @param id Número identificativo del cine.
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre del cine.
	 * 
	 * @return Cadena del nombre del cine.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Introduce el nombre del cine.
	 * 
	 * @param nombre Cadena del nombre del cine.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la dirección del cine.
	 * 
	 * @return Cadena de la dirección del cine.
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Introduce la dirección del cine.
	 * 
	 * @param nombre Cadena de la dirección del cine.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Devuelve en una cadena el id, el nombre y la dirección del cine.
	 */
	@Override
	public String toString() {
		return "Cine [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}

	/**
	 * Devuelve los valores id, nombre y dirección del cine si no son modificados
	 * por equals.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(direccion, id, nombre);
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
		return Objects.equals(direccion, other.direccion) && id == other.id && Objects.equals(nombre, other.nombre);
	}

}
