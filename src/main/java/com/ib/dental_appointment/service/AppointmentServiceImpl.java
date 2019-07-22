/**
 * 
 */
package com.ib.dental_appointment.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ib.dental_appointment.dao.AppointmentDao;
import com.ib.dental_appointment.model.AppointmentRequest;
import com.ib.dental_appointment.model.AppointmentResponse;

/**
 * @author snakka
 *
 */
@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	private AppointmentDao AppointmentDao;

	@Override
	public int save(AppointmentRequest appointment) {
		return AppointmentDao.save(appointment);
	}

	@Override
	public AppointmentResponse get(int id) {
		return AppointmentDao.get(id);
	}

	@Override
	public boolean checkIfAppointmentExists(int id, Date startDate) {
		return AppointmentDao.checkIfAppointmentExists(id, startDate);
	}


}
