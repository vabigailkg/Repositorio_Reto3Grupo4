package bbdd.pojos;

import java.util.Objects;

/**
 * Define el objeto película.
 */
public class Pelicula {

	private int codigoPelicula = 0;
	private String nombrePelicula = null;
	private int duracionPelicula = 0;
	private String generoPelicula = null;
	private int costePelicula = 0;

	/**
	 * Constructor del objeto película.
	 * 
	 * @param codigoPelicula     Número identificativo de la película.
	 * @param nombrePelicula Cadena del nombre de la película.
	 */
	public Pelicula(int codigoPelicula, String nombrePelicula, int duracionPelicula, String generoPelicula, int costePelicula) {
		this.codigoPelicula = codigoPelicula;
		this.nombrePelicula = nombrePelicula;
		this.duracionPelicula = duracionPelicula;
		this.generoPelicula = generoPelicula;
		this.costePelicula = costePelicula;
	}

	/**
	 * Obtiene el id de la película.
	 * 
	 * @return Número identificativo de la película.
	 */
	public int getcodigoPelicula() {
		return codigoPelicula;
	}

	/**
	 * Introduce el id de la película.
	 * 
	 * @param codigoPelicula Número identificativo de la película.
	 */
	public void setcodigoPelicula(int codigoPelicula) {
		this.codigoPelicula = codigoPelicula;
	}

	/**
	 * Obtiene el nombre de la película.
	 * 
	 * @return Cadena del nombre de la película.
	 */
	public String getNombrePelicula() {
		return nombrePelicula;
	}

	/**
	 * Introduce el nombre de la película.
	 * 
	 * @param nombrePelicula Cadena del nombre de la película.
	 */
	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}

	/**
	 * Obtiene la duración de la película.
	 * 
	 * @return Número entero de la duración de la película.
	 */
	public int getDuracionPelicula() {
		return duracionPelicula;
	}

	/**
	 * Introduce la duración de la película.
	 * 
	 * @param duracionPelicula Número entero de la duración de la película.
	 */
	public void setDuracionPelicula(int duracionPelicula) {
		this.duracionPelicula = duracionPelicula;
	}

	/**
	 * Obtiene el género de la película.
	 * 
	 * @return Cadena del género de la película.
	 */
	public String getGeneroPelicula() {
		return generoPelicula;
	}

	/**
	 * Introduce el género de la película.
	 * 
	 * @param generoPelicula Cadena del género de la película.
	 */
	public void setGeneroPelicula(String generoPelicula) {
		this.generoPelicula = generoPelicula;
	}

	/**
	 * Obtiene el coste de la película.
	 * 
	 * @return Número entero del coste de la película.
	 */
	public int getCostePelicula() {
		return costePelicula;
	}

	/**
	 * Introduce el coste de la película.
	 * 
	 * @param costePelicula Número entero del coste de la película.
	 */
	public void setCostePelicula(int costePelicula) {
		this.costePelicula = costePelicula;
	}

	/**
	 * Devuelve en una cadena el id, nombre, duración, género y coste de la
	 * película.
	 */
	@Override
	public String toString() {
		return "pelicula [codigoPelicula=" + codigoPelicula + ", nombrePelicula=" + nombrePelicula + ", duracionPelicula=" + duracionPelicula + ", generoPelicula=" + generoPelicula
				+ ", costePelicula=" + costePelicula + "]";
	}

	/**
	 * Devuelve los valores id, nombre, duración, género y coste de la película si
	 * no han sido modificados por equals.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(costePelicula, duracionPelicula, generoPelicula, codigoPelicula, nombrePelicula);
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
		return costePelicula == other.costePelicula && duracionPelicula == other.duracionPelicula && Objects.equals(generoPelicula, other.generoPelicula)
				&& codigoPelicula == other.codigoPelicula && Objects.equals(nombrePelicula, other.nombrePelicula);
	}

}
