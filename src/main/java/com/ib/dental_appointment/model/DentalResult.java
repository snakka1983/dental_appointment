/**
 * 
 */
package com.ib.dental_appointment.model;


/**
 * @author snakka
 *
 */
public class DentalResult  {
	 
	private String code;
	
    private String message;
    
	public DentalResult(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
    
    
}


