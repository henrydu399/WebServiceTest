package gosystem.mocksirculock.dto;

import java.util.List;

public class AccessoRequestDTO {
	
	private String cosmosId;
	private String sites;
	private Dates dates;
	private  List<Usuario> usuarios;
	
	

	
	
	
	public String getCosmosId() {
		return cosmosId;
	}

	public void setCosmosId(String cosmosId) {
		this.cosmosId = cosmosId;
	}

	public String getSites() {
		return sites;
	}

	public void setSites(String sites) {
		this.sites = sites;
	}

	public Dates getDates() {
		return dates;
	}

	public void setDates(Dates dates) {
		this.dates = dates;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public static class Dates{
		private String fechaInicial;
		private String fechaFinal;
		public String getFechaInicial() {
			return fechaInicial;
		}
		public void setFechaInicial(String fechaInicial) {
			this.fechaInicial = fechaInicial;
		}
		public String getFechaFinal() {
			return fechaFinal;
		}
		public void setFechaFinal(String fechaFinal) {
			this.fechaFinal = fechaFinal;
		}
		
		
	}
	
	public static class Usuario{
		private String nif;
		private String nombre;
		private String telefono;
		private String cif;
		private List<RutaContratacion> rutasContratacion;
		public String getNif() {
			return nif;
		}
		public void setNif(String nif) {
			this.nif = nif;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		public String getCif() {
			return cif;
		}
		public void setCif(String cif) {
			this.cif = cif;
		}
		public List<RutaContratacion> getRutasContratacion() {
			return rutasContratacion;
		}
		public void setRutasContratacion(List<RutaContratacion> rutasContratacion) {
			this.rutasContratacion = rutasContratacion;
		}
		
		
		
	}
	
	public static class RutaContratacion {
		private String nombre;
		private Long id;
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		
	}
	
}
