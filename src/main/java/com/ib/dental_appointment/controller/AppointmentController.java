/**
 * 
 */
package com.ib.dental_appointment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class AppointmentController {
	
	   @Autowired
	   private AppointmentValidatorService validator;
	
	   @Autowired
	   private AppointmentService appointmentService;
	   
	   /**
	    * 
	    * @param appointment
	    * @return
	    */
	   /*---Add new appointment---*/
	   @RequestMapping(value="/appointment", method=RequestMethod.POST)
	   public ResponseEntity<?> save(@RequestBody AppointmentRequest appointment) {
		  ResponseEntity<DentalResponse> response = validator.validate(appointment);
		  if(response.getStatusCode().equals(HttpStatus.OK)) {
			  int id = appointmentService.save(appointment);
		      if(id > 0) {
		    	  DentalResponse dentalResponse = new DentalResponse(new DentalResult("success", "New appointment has been saved with ID:" + id));
		    	  return ResponseEntity.ok(dentalResponse);
		      }
		  }
	      return response;
	   }

	   /**
	    * 
	    * @param id
	    * @return
	    */
	   /*---Get a appointment by id---*/
	   @RequestMapping(value="/appointment/{id}", method=RequestMethod.GET)
	   public ResponseEntity<AppointmentResponse> get(@PathVariable("id") int id) {
		   AppointmentResponse appointment = appointmentService.get(id);
	      return ResponseEntity.ok().body(appointment);
	   }

}
