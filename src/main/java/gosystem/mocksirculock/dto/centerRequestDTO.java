package gosystem.mocksirculock.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class centerRequestDTO {

	private   List<Site> sites;
	
	
	@Getter 
	@Setter 
	@NoArgsConstructor
	@AllArgsConstructor
	@ToString
	private static  class Site{
		private String action;
		private String site;
		private String name;
		private String uo;
		private String zone;
		private String region;
		private String state;
		private String coordinates;
	}
	
}



