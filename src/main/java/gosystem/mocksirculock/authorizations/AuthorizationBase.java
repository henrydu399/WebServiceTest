package gosystem.mocksirculock.authorizations;

import java.util.List;

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
public class AuthorizationBase {
	
	private String type;
	private List<AuthorizationParameter> parameters;

}
