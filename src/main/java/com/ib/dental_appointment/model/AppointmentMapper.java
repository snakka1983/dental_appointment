/**
 * 
 */
package com.ib.dental_appointment.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author snakka
 *
 */
public class AppointmentMapper implements RowMapper<AppointmentResponse> {  
	
    @Override  
    public AppointmentResponse mapRow(ResultSet rs, int rowNum) throws SQLException {  
    	AppointmentResponse response = new AppointmentResponse();  
        response.setId(rs.getInt("id"));  
        System.out.println(rs.getDate("startTime").getTime());
        response.setStartTime(rs.getDate("startTime") != null ? rs.getDate("startTime").getTime() : null);
        response.setEndTime(rs.getDate("endTime")!=null ? rs.getDate("endTime").getTime() : null);
        response.setPatientId(rs.getInt("patientId"));  
        response.setDentistId(rs.getInt("dentistId"));  

        return response;  
    }  
}  
