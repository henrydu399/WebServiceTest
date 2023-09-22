package gosystem.mocksirculock.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.gosystem.commons.utils.UtilGson;

import gosystem.mocksirculock.dtos.TaskWS;
import gosystem.mocksirculock.dtos.TaskWebService;
import gosystem.mocksirculock.dtos.TestServicioInDto;
import gosystem.mocksirculock.dtos.TestServicioOutDto;
import gosystem.mocksirculock.exceptions.TestWebServiceException;
import gosystem.mocksirculock.services.impl.SsoServiceImpl;



@Service
public class SsoTasks {
	
	
	@Autowired private SsoServiceImpl iSsoService;
	
	private  static  List<TaskWebService > listTask  =  new ArrayList();
	
	
	@Async(value = "taskExecutor")
	public void  create(  TestServicioInDto in  , String id)  throws TestWebServiceException{
		
		try {
			
			 	
			TaskWebService t =  new TaskWebService();
			t.setNameService("SSO");
			t.setNameTaskService(id);
			
			List<TaskWS> listSubTask = new ArrayList();
			
			
			for( int a = 0  ; a < in.getNumeroHilos() ; a++) {
				
				TaskWS st = new  TaskWS();
				st.setIdHilo(  String.valueOf(a) );
				
				switch (in.getServiceName()) {
				
				case "SSO":
					 Future<TestServicioOutDto> Result = 	iSsoService.run(in.getMetodoName(), in);
					if ( !Objects.isNull( Result.get().getError() )) {
						st.setError( Result.get().getError() );
					}else {
						String jsonResult =  UtilGson.SerializeObjet( Result.get().getObj());
						st.setResponse( jsonResult);
					}
				
				break;

				
				}
						
				listSubTask.add(st);
			}
			
			t.setListTask(listSubTask);
			
			listTask.add(t);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
		
		
	}
	
	
	
	
	public  TaskWebService getTask(String nameTaskService) {
		
		for ( TaskWebService t : this.listTask) {
			if( t.getNameTaskService().equals(nameTaskService)){
				return t;
			}
		}
		return null;
	}
	
	
	

}
