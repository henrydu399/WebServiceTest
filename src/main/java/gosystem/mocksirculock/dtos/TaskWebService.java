package gosystem.mocksirculock.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class TaskWebService {
	
	private List<TaskWS> listTask;
	private String status;
	private String nameService;
	private String nameTaskService;
	private int porcentaje;
	private int ejecuciones;
	
	
	
	public   synchronized void update(int ejecuciones) {
		double total = ((ejecuciones * 100 )/this.ejecuciones);
		this.porcentaje = (int) total;
	}

}
