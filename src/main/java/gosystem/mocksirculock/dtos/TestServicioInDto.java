package gosystem.mocksirculock.dtos;



import com.fasterxml.jackson.annotation.JsonProperty;

import gosystem.mocksirculock.authorizations.AuthorizationBase;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TestServicioInDto extends AuthorizationBase {
	

	@JsonProperty("serviceName")
	private String serviceName;
	
	 @JsonProperty("metodoName")
	private String metodoName;
	 
	 @JsonProperty("ejecuciones")
	private Integer ejecuciones;
	 
	 @JsonProperty("bodyJson")
	private String bodyJson;
	
	

}
