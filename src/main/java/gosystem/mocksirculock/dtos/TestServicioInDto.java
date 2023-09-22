package gosystem.mocksirculock.dtos;



import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestServicioInDto  {
	

	@JsonProperty("serviceName")
	private String serviceName;
	
	 @JsonProperty("metodoName")
	private String metodoName;
	 
	 @JsonProperty("numeroHilos")
	private Integer numeroHilos;
	 
	 @JsonProperty("bodyJson")
	private String bodyJson;
	
	

}
