package gosystem.mocksirculock.utils;

import com.google.gson.Gson;

import gosystem.mocksirculock.exceptions.TestWebServiceException;

public class ServiceImplUtil <T> {
	
	
	public   static Object getBody(Class c , String jsonBody) throws TestWebServiceException {
		try {
			Object body =  new Gson().fromJson(jsonBody, c.getClass());
			return body;
		}catch (Exception e) {
			throw new TestWebServiceException(TestWebServiceException.ERROR_BODY_SERVICIO,e);
		}
	}

}
