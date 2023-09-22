package gosystem.mocksirculock.exceptions;

public class TestWebServiceException  extends Exception{
	
	/**
	 * 
	 */
	
	public static final String ERROR_BODY_SERVICIO = "Error con el cuerpo del servicio";
	public static final String ERROR_GENERAL_SERVICIO = "Error General con el servicio";
	
	private static final long serialVersionUID = 149573352317299315L;
	
	private String logicaMenssage;

	public TestWebServiceException(String logicaMenssage , Exception e) {
		super(e);
		this.logicaMenssage = logicaMenssage;
	}

	public String getLogicaMenssage() {
		return logicaMenssage;
	}


	
	
	
	
	

}
