package bbdd.pojos;

import java.util.Objects;

/**
 * Define el objeto película.
 */
public class Pelicula {

	private int id = 0;
	private String nombre = null;
	private int duracion = 0;
	private String genero = null;
	private int coste = 0;

	/**
	 * Constructor del objeto película.
	 * 
	 * @param id     Número identificativo de la película.
	 * @param nombre Cadena del nombre de la película.
	 */
	public Pelicula(int id, String nombre, int duracion, String genero, int coste) {
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.genero = genero;
		this.coste = coste;
	}

	/**
	 * Obtiene el id de la película.
	 * 
	 * @return Número identificativo de la película.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Introduce el id de la película.
	 * 
	 * @param id Número identificativo de la película.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre de la película.
	 * 
	 * @return Cadena del nombre de la película.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Introduce el nombre de la película.
	 * 
	 * @param nombre Cadena del nombre de la película.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la duración de la película.
	 * 
	 * @return Número entero de la duración de la película.
	 */
	public int getDuracion() {
		return duracion;
	}

	/**
	 * Introduce la duración de la película.
	 * 
	 * @param duracion Número entero de la duración de la película.
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	/**
	 * Obtiene el género de la película.
	 * 
	 * @return Cadena del género de la película.
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Introduce el género de la película.
	 * 
	 * @param genero Cadena del género de la película.
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Obtiene el coste de la película.
	 * 
	 * @return Número entero del coste de la película.
	 */
	public int getCoste() {
		return coste;
	}

	/**
	 * Introduce el coste de la película.
	 * 
	 * @param coste Número entero del coste de la película.
	 */
	public void setCoste(int coste) {
		this.coste = coste;
	}

	/**
	 * Devuelve en una cadena el id, nombre, duración, género y coste de la
	 * película.
	 */
	@Override
	public String toString() {
		return "pelicula [id=" + id + ", nombre=" + nombre + ", duracion=" + duracion + ", genero=" + genero
				+ ", coste=" + coste + "]";
	}

	/**
	 * Devuelve los valores id, nombre, duración, género y coste de la película si
	 * no han sido modificados por equals.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(coste, duracion, genero, id, nombre);
	}

	/**
	 * Comprueba el tipo y el nombre de los objetos id, título, género, duración y
	 * coste de la película.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return coste == other.coste && duracion == other.duracion && Objects.equals(genero, other.genero)
				&& id == other.id && Objects.equals(nombre, other.nombre);
	}

}
