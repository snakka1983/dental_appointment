/**
 * 
 */
package com.ib.dental_appointment.model;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



/**
 * @author snakka
 * @param <T>
 *
 */
public class DentalResponse<T> {

    private T body;
    private  static ObjectMapper objectMapper = new ObjectMapper();


    /**
     * 
     * @param response
     */
    public DentalResponse(ResponseEntity<T> response) {
        this(response.getBody());
    }
    
    /**
     * 
     * @param status
     * @param body
     */
	public DentalResponse(T body) {
		super();
		this.body = body;
	}
	

	/**
	 * @return the body
	 */
	public T getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(T body) {
		this.body = body;
	}


}
