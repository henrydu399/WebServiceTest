package gosystem.mocksirculock.authorizations;


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
public class AuthorizationParameter {

	private String value;
	private String name;
	private boolean auto;
	
}
