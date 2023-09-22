package gosystem.mocksirculock.authorizations;

import java.util.List;
import java.util.Objects;

import gosystem.mocksirculock.exceptions.TestWebServiceException;

public class SSOAuthorization  extends AuthorizationBase{
	

	private final String ERROR_PARAMETROS_AUT = "Error con los parametros vacios  para la autentificacion";
	private final String ERROR_PARAMETRO_USERNAME = "Error con el parametro username esta vacio o no existe";
	private final String ERROR_PARAMETROS_JSESSIONID = "Error con el parametro jSessionId esta vacio o no existe";
	
	
	
	
	public void  validateBody() throws TestWebServiceException {
		

		
		if   (   Objects.isNull(super.getParameters())){
			throw new TestWebServiceException(ERROR_PARAMETROS_AUT,null);
		}
		
		
		AuthorizationParameter p1 = super.getParameters().stream()
				.filter( parameter -> SSOAuthorizationEnum.userName.name().equals(parameter.getName()) )
				.findAny()
				.orElse(null);
			
		AuthorizationParameter p2 = super.getParameters().stream()
				.filter( parameter -> SSOAuthorizationEnum.jSessionId.name().equals(parameter.getName()) )
				.findAny()
				.orElse(null);
		
		if ( Objects.isNull(p1) ) {
			throw new TestWebServiceException(ERROR_PARAMETRO_USERNAME,null);
		}
		
		if ( Objects.isNull(p2) ) {
			throw new TestWebServiceException(ERROR_PARAMETROS_JSESSIONID,null);
		}
			
	}
	
	public enum SSOAuthorizationEnum{
		userName,
		jSessionId
	}

}
