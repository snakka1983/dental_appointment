/**
 * 
 */
package com.ib.dental_appointment.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ib.dental_appointment.model.AppointmentRequest;
import com.ib.dental_appointment.model.DentalResult;
import com.ib.dental_appointment.model.DentalResponse;


/**
 * @author snakka
 *
 */
@Service
public class AppointmentValidatorService {
	
	@Autowired
	private AppointmentService appointmentService;
	
	/**
	 * 
	 * @param appointment
	 * @return
	 */
	public ResponseEntity<DentalResponse> validate(AppointmentRequest appointment) {
		ResponseEntity<DentalResponse> response = null;
		response = validFutureDate(appointment.getStartTime(), appointment.getEndTime());
		response = validAppointmentTime(appointment.getEndTime().getTime(), appointment.getStartTime().getTime(), response);
		response = checkIfAppointmentExists(appointment.getDentistId(), appointment.getStartTime(), response);
		return response;
	}
	
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private ResponseEntity<DentalResponse> validFutureDate(Date startDate, Date endDate) {
		if(startDate.after(Calendar.getInstance().getTime()) && endDate.after(Calendar.getInstance().getTime())) {
			return ResponseEntity.ok(new DentalResponse(new DentalResult("valid", "valid")));
		}
		return ResponseEntity.badRequest().body(new DentalResponse(new DentalResult("error", "startTime and endTime must both be valid times, and in the future")));
	}
	
	/**
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	private ResponseEntity<DentalResponse> validAppointmentTime(long time1, long time2, ResponseEntity<DentalResponse> response) {
		long diffMs = time1 - time2;
		long diffSec = diffMs / 1000;
		long min = diffSec / 60;
		if(response.getStatusCode().equals(HttpStatus.OK) && min < 30) {
			return ResponseEntity.badRequest().body(new DentalResponse(new DentalResult("error", "A dental appointment should be at least 30 minutes")));
		}
		return response;
	}
	
	/**
	 * 
	 * @param id
	 * @param startDate
	 * @return
	 */
	private ResponseEntity<DentalResponse> checkIfAppointmentExists(int id, Date startDate, ResponseEntity<DentalResponse> response) {
		if (response.getStatusCode().equals(HttpStatus.OK) && appointmentService.checkIfAppointmentExists(id, startDate)) {
			return ResponseEntity.badRequest().body(new DentalResponse(new DentalResult("error", "Two appointments for the same dentist can't start at the same time")));
		 }
		return response;
	}
	
}
