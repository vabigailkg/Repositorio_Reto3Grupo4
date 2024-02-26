package bbdd.pojos;

import java.util.Objects;

public class Cliente {

	private String dniCliente = null;
    private String nombreCliente = null;
    private String apellidosCliente = null;
    private String sexoCliente = null;
    private String passwordCliente = null;
	
	public Cliente (String dniCliente, String nombreCliente, String apellidosCliente, String sexoCliente, String passwordCliente) {
		this.dniCliente = dniCliente;
		this.nombreCliente = nombreCliente;
		this.apellidosCliente = apellidosCliente;
		this.sexoCliente = sexoCliente;
		this.passwordCliente = passwordCliente;
	}

	public String getDniCliente() {
		return dniCliente;
	}
    
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	
	public String getNombreCliente() {
		return nombreCliente;
	}
	
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	public String getApellidosCliente() {
		return apellidosCliente;
	}
	
	public void setApellidosCliente(String apellidosCliente) {
		this.apellidosCliente = apellidosCliente;
	}
	
	public String getSexoCliente() {
		return sexoCliente;
	}
	
	public void setSexoCliente(String sexoCliente) {
		this.sexoCliente = sexoCliente;
	}
	
	public String getPasswordCliente() {
		return passwordCliente;
	}
	
	public void setPasswordCliente(String passwordCliente) {
		this.passwordCliente = passwordCliente;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(apellidosCliente, dniCliente, nombreCliente, passwordCliente, sexoCliente);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(apellidosCliente, other.apellidosCliente) && Objects.equals(dniCliente, other.dniCliente)
				&& Objects.equals(nombreCliente, other.nombreCliente)
				&& Objects.equals(passwordCliente, other.passwordCliente) && sexoCliente == other.sexoCliente;
	}
	
	@Override
	public String toString() {
		return "Cliente [dniCliente=" + dniCliente + ", nombreCliente=" + nombreCliente + ", apellidosCliente="
				+ apellidosCliente + ", sexoCliente=" + sexoCliente + ", passwordCliente=" + passwordCliente + "]";
	}
    
}//.
