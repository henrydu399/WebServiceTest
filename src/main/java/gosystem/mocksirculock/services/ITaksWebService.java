package gosystem.mocksirculock.services;

import java.util.concurrent.Future;

import gosystem.mocksirculock.dtos.TestServicioInDto;
import gosystem.mocksirculock.dtos.TestServicioOutDto;

public abstract  class  ITaksWebService {
	
	public abstract Future<TestServicioOutDto> run (String metodoName , TestServicioInDto obj) ;

}
