package gosystem.mocksirculock.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.gosystem.commons.utils.UtilGson;
import com.gosystem.commons.utils.UtilsLogs;

import gosystem.clientwebservicepresences.services.CreatePresencesWSService;
import gosystem.mocksirculock.dtos.TaskWS;
import gosystem.mocksirculock.dtos.TaskWebService;
import gosystem.mocksirculock.dtos.TestServicioInDto;
import gosystem.mocksirculock.dtos.TestServicioOutDto;
import gosystem.mocksirculock.enums.ServicesEnum;
import gosystem.mocksirculock.enums.TaskStateEnum;
import gosystem.mocksirculock.exceptions.TestWebServiceException;
import gosystem.mocksirculock.services.impl.PresenceServiceImpl;
import gosystem.mocksirculock.services.impl.SsoServiceImpl;

@Service
public class SsoTasks {

	@Autowired private SsoServiceImpl iSsoService;
	@Autowired private  PresenceServiceImpl presenceService;

	private static List<TaskWebService> listTask = new ArrayList<TaskWebService> ();
	
	
	private Logger logger;

	

	public SsoTasks() {
		this.logger = UtilsLogs.getLogger(SsoTasks.class.getName());
	}


	@Async(value = "taskExecutor")
	public void create(TestServicioInDto in, String id) throws TestWebServiceException {

		TaskWebService t = null;
		try {

			t = new TaskWebService();
			t.setNameService(in.getServiceName());
			t.setNameTaskService(id);
			t.setEjecuciones(in.getEjecuciones().intValue());
			t.setStatus(TaskStateEnum.executando.name());

			ServicesEnum value = ServicesEnum.valueOf(in.getServiceName());
			
			List<TaskWS> listSubTask = new ArrayList<TaskWS> ();
			
			t.setListTask(listSubTask);

			this.listTask.add(t);

			for (int a = 1; a <= in.getEjecuciones(); a++) {
				
				
				TaskWS st = new TaskWS();
				st.setIdHilo(String.valueOf(a));

				run(in, value, st);

				listSubTask.add(st);
				
				t.update(a);
			}
			
			t.setStatus( TaskStateEnum.finalizado.name());



		}catch (Exception e) {
			t.setStatus( TaskStateEnum.finalizado.name());
			e.printStackTrace();
		}

	}

	private void run(TestServicioInDto in, ServicesEnum value, TaskWS st)
			throws InterruptedException, ExecutionException {
		
		Future<TestServicioOutDto> result  = null;
		switch (value) {

		case SSOWEBSERVICES:
			result= iSsoService.run(in.getMetodoName(), in);	
			buildResponse(st, result);
			break;
			
		case PRESENCESSERVICES:
			 result = presenceService.run(in.getMetodoName(), in);
			 buildResponse(st, result);
			break;
		}
	}

	private void buildResponse(TaskWS st, Future<TestServicioOutDto> Result)
			throws InterruptedException, ExecutionException {
		if (!Objects.isNull(Result.get().getError())) {
			st.setError(Result.get().getError());
		} else {
			String jsonResult = UtilGson.SerializeObjet(Result.get().getResponse());
			st.setResponse(jsonResult);
		}
	}
	
	
	

	public TaskWebService getTask(String nameTaskService) {

		for (TaskWebService t : this.listTask) {
			if (t.getNameTaskService().equals(nameTaskService)) {
				return t;
			}
		}
		return null;
	}
	
	
	public void deleteTask(String nameTaskService ) throws TestWebServiceException{
		int a = 0;
		for ( TaskWebService t : listTask) {
			if (t.getNameTaskService().equals(nameTaskService)) {
				break;
			}
			a++;
		}
		
		try {
			this.listTask.remove(a);
		}catch (Exception e) {
			this.logger.log(Level.SEVERE, "Error no se pudo eliminar");
			throw new TestWebServiceException("Error no se pudo eliminar ",e);
		}
		
	}

}
