package gosystem.mocksirculock.services;

import gosystem.clientwebservicepresences.dtos.DocumentPRLOUTDTO;
import gosystem.clientwebservicepresences.dtos.ReturnCreatePresencesWSDTO;
import gosystem.clientwebservicepresences.dtos.RutaContratacionOUTDTO;
import gosystem.clientwebservicepresences.dtos.VoidOUTDTO;
import gosystem.mocksirculock.dtos.TestServicioInDto;

public interface IPrecenseService {
	
	    public RutaContratacionOUTDTO getRutaContratacion(TestServicioInDto in0) throws java.rmi.RemoteException;
	    public DocumentPRLOUTDTO isValidDocumentPRL(TestServicioInDto in0) throws java.rmi.RemoteException;
	    public VoidOUTDTO getVersion(TestServicioInDto in0) throws java.rmi.RemoteException;
	    public ReturnCreatePresencesWSDTO createPresence(TestServicioInDto in0) throws java.rmi.RemoteException;

}
