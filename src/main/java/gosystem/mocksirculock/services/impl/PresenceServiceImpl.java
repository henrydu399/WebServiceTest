package gosystem.mocksirculock.services.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import javax.xml.rpc.ServiceException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.gosystem.commons.utils.UtilGson;
import com.gosystem.commons.utils.UtilsLogs;

import gosystem.clientwebservicepresences.dtos.DocumentPRLOUTDTO;
import gosystem.clientwebservicepresences.dtos.ReturnCreatePresencesWSDTO;
import gosystem.clientwebservicepresences.dtos.RutaContratacionINDTO;
import gosystem.clientwebservicepresences.dtos.RutaContratacionOUTDTO;
import gosystem.clientwebservicepresences.dtos.VoidOUTDTO;
import gosystem.clientwebservicepresences.services.CreatePresencesWSService;
import gosystem.clientwebservicepresences.services.CreatePresencesWSServiceLocator;
import gosystem.clientwebservicepresences.services.CreatePresencesWSServicePortType;
import gosystem.clientwebservicepresences.services.CreatePresencesWSServicePortTypeProxy;
import gosystem.clientwebservicessso.sso.dto.Result;
import gosystem.clientwebservicessso.sso.dto.SessionCreateDto;
import gosystem.mocksirculock.dtos.TestServicioInDto;
import gosystem.mocksirculock.dtos.TestServicioOutDto;
import gosystem.mocksirculock.exceptions.TestWebServiceException;
import gosystem.mocksirculock.services.IPrecenseService;
import gosystem.mocksirculock.services.ITaksWebService;
import gosystem.mocksirculock.utils.ServiceImplUtil;

@Service
public class PresenceServiceImpl extends ITaksWebService implements IPrecenseService {

	@Value("${spring.application.name}")
	private String nameApp;

	private Logger logger;

	private CreatePresencesWSService presencesWSService;

	public PresenceServiceImpl() {
		this.logger = UtilsLogs.getLogger(PresenceServiceImpl.class.getName());
	}

	@Override
	public RutaContratacionOUTDTO getRutaContratacion(TestServicioInDto in0) throws RemoteException {
		try {
			RutaContratacionINDTO inObj = null;

			try {
				inObj = new Gson().fromJson(in0.getBodyJson(), RutaContratacionINDTO.class);
			} catch (Exception e) {
				throw new TestWebServiceException(TestWebServiceException.ERROR_BODY_SERVICIO, e);
			}

			this.presencesWSService = new CreatePresencesWSServiceLocator();

			try {
				RutaContratacionOUTDTO response = this.presencesWSService.getCreatePresencesWSServiceHttpPort()
						.getRutaContratacion(inObj);

				logger.info(nameApp + " executeCreate :: Response  ::  " + UtilGson.SerializeObjet(response));

				return response;
			} catch (RemoteException e) {
				e.printStackTrace();
				throw new TestWebServiceException(TestWebServiceException.ERROR_GENERAL_SERVICIO, e);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new TestWebServiceException(TestWebServiceException.ERROR_GENERAL_SERVICIO, e);
			}

		} catch (TestWebServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DocumentPRLOUTDTO isValidDocumentPRL(TestServicioInDto in0) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VoidOUTDTO getVersion(TestServicioInDto in0) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnCreatePresencesWSDTO createPresence(TestServicioInDto in0) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<TestServicioOutDto> run(String metodoName, TestServicioInDto obj) {
		TestServicioOutDto out = new TestServicioOutDto();
		Method m;
		try {
			Class<?> base = Class.forName("gosystem.mocksirculock.services.impl.PresenceServiceImpl");
			m = base.getMethod(metodoName, TestServicioInDto.class);

			Object rv = (Object) m.invoke(base.newInstance(), obj);
			String jsonResult = UtilGson.SerializeObjet(rv);		
			out.setResponse(jsonResult);

			return CompletableFuture.completedFuture(out);

		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.setError(e.getMessage());
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.setError(e.getMessage());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.setError(e.getMessage());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.setError(e.getMessage());
		} catch (InvocationTargetException e) {
			if (e.getCause() instanceof RemoteException) {
				RemoteException re = (RemoteException) e.getCause();
				out.setError(re.getMessage());
			}
			e.printStackTrace();
			out.setError(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.setError(e.getMessage());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.setError(e.getMessage());
		} catch (Exception e) {
			out.setError(e.getMessage());
		}

		return CompletableFuture.completedFuture(out);
	}

}
