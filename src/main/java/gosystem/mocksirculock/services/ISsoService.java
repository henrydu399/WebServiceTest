package gosystem.mocksirculock.services;

import gosystem.clientwebservicessso.sso.dto.Result;
import gosystem.clientwebservicessso.sso.dto.SessionCreateDto;
import gosystem.mocksirculock.dtos.TestServicioInDto;
import gosystem.mocksirculock.exceptions.TestWebServiceException;

public interface ISsoService {
	
	
	    public Result createSession(TestServicioInDto in) throws TestWebServiceException;
	    public Result getSession(TestServicioInDto in) throws TestWebServiceException;

}
