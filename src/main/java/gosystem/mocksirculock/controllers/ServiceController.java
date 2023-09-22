package gosystem.mocksirculock.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.gosystem.commons.exceptions.ParametrizacionException;
import com.gosystem.commons.utils.UtilGson;
import com.gosystem.commons.utils.UtilsLogs;

import gosystem.clientwebservicessso.sso.dto.SessionCreateDto;
import gosystem.mocksirculock.dto.centerRequestDTO;
import gosystem.mocksirculock.dtos.TaskWebService;
import gosystem.mocksirculock.dtos.TestServicioInDto;
import gosystem.mocksirculock.enums.ServicesEnum;
import gosystem.mocksirculock.exceptions.TestWebServiceException;
import gosystem.mocksirculock.services.ISsoService;
import gosystem.mocksirculock.services.ITaksWebService;
import gosystem.mocksirculock.tasks.SsoTasks;
import gosystem.mocksirculock.utils.HashCreatorUtil;

@RestController
@RequestMapping(path = "/execute")
public class ServiceController {

	@Value("${spring.application.name}")
	private String nameApp;

	private Logger logger;

	@Autowired
	private SsoTasks task;

	public ServiceController() {
		this.logger = UtilsLogs.getLogger(ServiceController.class.getName());
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> executeCreate(@RequestBody TestServicioInDto json, HttpServletRequest req) {

		this.logger.info(nameApp + " executeCreate :: INICIO ");
		this.logger.info(nameApp + " executeCreate :: In ::  " + UtilGson.SerializeObjet(json));

		try {
			   String id = HashCreatorUtil.createMD5Hash(new Date().toString());
			   
			   
				try {
					ServicesEnum value = ServicesEnum.valueOf(json.getServiceName());
				} catch (IllegalArgumentException e) {
					this.logger.log(Level.SEVERE, TestWebServiceException.ERROR_NAME_SERVICIO);
					throw new TestWebServiceException(TestWebServiceException.ERROR_NAME_SERVICIO, e);
				}

				this.task.create(json, id);

			logger.info(nameApp + " executeCreate :: FIN ");

			return new ResponseEntity<Object>(id, HttpStatus.OK);
		} catch (TestWebServiceException e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<Object>(e.getLogicaMenssage(), HttpStatus.BAD_REQUEST);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping(value = "/{idTask}")
	public ResponseEntity<Object> getAllBySistem(@PathVariable String idTask) {
		logger.info(nameApp + " getAllBySistem :: INICIO ");
		logger.info(nameApp + " getAllBySistem :: In ::  " + idTask);
		TaskWebService response = this.task.getTask(idTask);

		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	
	
	@DeleteMapping(value = "/{idTask}")
	public ResponseEntity<Object> delete(@PathVariable String idTask) {
		logger.info(nameApp + " getAllBySistem :: INICIO ");
		logger.info(nameApp + " getAllBySistem :: In ::  " + idTask);	
		try {
			this.task.deleteTask(idTask);
		} catch (TestWebServiceException e) {
			return new ResponseEntity<Object>(e.getLogicaMenssage(), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}

	
}
