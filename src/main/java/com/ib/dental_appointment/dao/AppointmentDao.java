/**
 * 
 */
package com.ib.dental_appointment.dao;

import java.util.Date;

import com.ib.dental_appointment.model.AppointmentRequest;
import com.ib.dental_appointment.model.AppointmentResponse;

/**
 * @author snakka
 *
 */
public interface AppointmentDao {

	int save(AppointmentRequest appointment);

	AppointmentResponse get(int id);
	
	boolean checkIfAppointmentExists(int id, Date startDate);
}
