/**
 * 
 */
package com.ib.dental_appointment.model;

import java.util.Date;


/**
 * @author snakka
 *
 */
public class AppointmentRequest {

    private int dentistId;
	
    private int patientId;
    
    private Date startTime;
	 
	private Date endTime;

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
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
