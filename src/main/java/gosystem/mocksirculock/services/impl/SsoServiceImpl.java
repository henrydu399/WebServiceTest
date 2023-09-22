package gosystem.mocksirculock.services.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.gosystem.commons.utils.UtilGson;
import com.gosystem.commons.utils.UtilsLogs;

import gosystem.clientwebservicessso.sso.dto.Result;
import gosystem.clientwebservicessso.sso.dto.SessionCreateDto;
import gosystem.clientwebservicessso.sso.ws.SSOWebService;
import gosystem.clientwebservicessso.sso.ws.SSOWebServiceProxy;

import gosystem.mocksirculock.dtos.TestServicioInDto;
import gosystem.mocksirculock.dtos.TestServicioOutDto;
import gosystem.mocksirculock.exceptions.TestWebServiceException;

import gosystem.mocksirculock.services.ITaksWebService;

@Service
public class SsoServiceImpl extends ITaksWebService     {

	private SSOWebService ssoWebService;

	@Value("${spring.application.name}")
	private String nameApp;
	
	private Logger logger;

	public SsoServiceImpl() {
		this.logger = UtilsLogs.getLogger(SsoServiceImpl.class.getName());
	}
	
	
	

	
	public Result createSession(TestServicioInDto in) throws TestWebServiceException {
		
		SessionCreateDto inObj = null;
		
		try {
			inObj = new Gson().fromJson(in.getBodyJson(), SessionCreateDto.class);
		}catch (Exception e) {
			throw new TestWebServiceException(TestWebServiceException.ERROR_BODY_SERVICIO,e);
		}

		ssoWebService = new SSOWebServiceProxy();

		try {
			Result response = ssoWebService.createSession(inObj.getUserName(), inObj.getjSessionId());

			logger.info(nameApp + " executeCreate :: Response  ::  " + UtilGson.SerializeObjet(response));
			
			return response;
		} catch (RemoteException e) {
			e.printStackTrace();
			throw new TestWebServiceException(TestWebServiceException.ERROR_GENERAL_SERVICIO, e);
		}

		
	}


	public Result getSession(TestServicioInDto in) throws TestWebServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Async
	public Future<TestServicioOutDto> run(String metodoName , TestServicioInDto obj) {
		
		TestServicioOutDto out = new TestServicioOutDto();
		Method m;
		try {
			Class<?> base = Class.forName("gosystem.mocksirculock.services.impl.SsoServiceImpl");
			m = base.getMethod(metodoName, TestServicioInDto.class);
			
			
			Object rv = (Object) m.invoke(base.newInstance(), obj);
			String jsonResult = UtilGson.SerializeObjet(rv);		
			out.setResponse(jsonResult);
				
				return CompletableFuture.completedFuture(out) ;
			

			
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
			// TODO Auto-generated catch block
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
		}catch (Exception e) {
			out.setError(e.getMessage());
		}
		
		return CompletableFuture.completedFuture(out) ;

	
}
	

}
