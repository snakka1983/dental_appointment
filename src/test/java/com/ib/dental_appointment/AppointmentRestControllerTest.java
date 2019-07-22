/**
 * 
 */
package com.ib.dental_appointment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ib.dental_appointment.controller.AppointmentController;
import com.ib.dental_appointment.model.AppointmentRequest;
import com.ib.dental_appointment.model.AppointmentResponse;
import com.ib.dental_appointment.model.DentalResponse;
import com.ib.dental_appointment.model.DentalResult;
import com.ib.dental_appointment.service.AppointmentService;
import com.ib.dental_appointment.service.AppointmentValidatorService;



/**
 * @author snakka
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AppointmentRestControllerTest {
	
	
	@InjectMocks
	private AppointmentController appointmentController;
	
	@Mock
	private AppointmentValidatorService validator;
	
	@Mock
	private AppointmentService appointmentService;
	
	
	
	@Test
	public void save() {
		AppointmentRequest request = loadRequest();
		ResponseEntity<DentalResponse> response = loadDentalResponse();
		when(validator.validate(request)).thenReturn(response);
		when(appointmentService.save(request)).thenReturn(1);
		response = (ResponseEntity<DentalResponse>) appointmentController.save(request);
		assertNotNull(response);
		assertNotNull(response.getStatusCode().equals(HttpStatus.OK));
		
	}
	
	@Test
	public void get() throws Exception {
		when(appointmentService.get(11)).thenReturn(loadResponse());
		ResponseEntity<AppointmentResponse> response = appointmentController.get(11);
		assertNotNull(response);
		assertEquals(response.getBody().getId(), 4);
		assertEquals(response.getBody().getDentistId(), 11);
		assertEquals(response.getBody().getPatientId(), 11);
		assertEquals(response.getBody().getStartTime(), 1560211200000l);
		assertEquals(response.getBody().getEndTime(), 1560211200000l);
	}
	
	private AppointmentResponse loadResponse() {
		AppointmentResponse response = new AppointmentResponse();
		response.setId(4);
		response.setDentistId(11);
		response.setPatientId(11);
		response.setStartTime(1560211200000l);
		response.setEndTime(1560211200000l);
		return response;
	}
	
	private AppointmentRequest loadRequest() {
		AppointmentRequest request = new AppointmentRequest();
		request.setDentistId(1);
		request.setPatientId(1);
		request.setStartTime(loadDate(0));
		request.setEndTime(loadDate(100));
		return request;
	}
	
	private ResponseEntity<DentalResponse> loadDentalResponse() {
		return ResponseEntity.ok(new DentalResponse(new DentalResult("valid", "valid")));
	}
	
	private Date loadDate(int addMins) {
		Calendar now = Calendar.getInstance();
		if(addMins > 0)
			now.add(Calendar.MINUTE, addMins);
	    Date date = now.getTime();
	    return date;
	}
	
}
