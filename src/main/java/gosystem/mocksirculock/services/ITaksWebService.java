package gosystem.mocksirculock.services;

import gosystem.mocksirculock.dtos.TestServicioInDto;

public abstract  class  ITaksWebService {
	
	public abstract Object run (String metodoName , TestServicioInDto obj) ;

}
