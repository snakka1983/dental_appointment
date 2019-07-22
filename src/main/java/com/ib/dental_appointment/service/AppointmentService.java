/**
 * 
 */
package com.ib.dental_appointment.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.ib.dental_appointment.model.AppointmentRequest;
import com.ib.dental_appointment.model.AppointmentResponse;

/**
 * @author snakka
 *
 */
@Service
public interface AppointmentService {

	int save(AppointmentRequest appointment);
	AppointmentResponse get(int id);
	boolean checkIfAppointmentExists(int id, Date startDate);
}
