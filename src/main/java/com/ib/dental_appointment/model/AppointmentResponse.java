/**
 * 
 */
package com.ib.dental_appointment.model;

import java.util.Date;

/**
 * @author snakka
 *
 */
public class AppointmentResponse {

	private int id;
	
	private int dentistId;
	
    private int patientId;
    
    private long startTime;
	 
	private long endTime;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the dentistId
	 */
	public int getDentistId() {
		return dentistId;
	}

	/**
	 * @param dentistId the dentistId to set
	 */
	public void setDentistId(int dentistId) {
		this.dentistId = dentistId;
	}

	/**
	 * @return the patientId
	 */
	public int getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the startTime
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public long getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
}
