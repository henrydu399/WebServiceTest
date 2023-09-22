package gosystem.mocksirculock.dto;

import java.util.List;

public class CreatePrecenseNewInDTO {

	private String cosmosId;
	private List<Usuario> usuarios;
	private String site; // Centros separados por ;
	private String dates; // fecha Inicial -final Final

	
	
	public static   class Usuario{
		private String nif;
		private String nombre;
		private String telefono;
		private List<RutaContratacion> rutasContratacion;
		
	}
	
	public static class RutaContratacion{
		private String nombre;
		private Long id;
		
	}
	

}


