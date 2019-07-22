/**
 * 
 */
package com.ib.dental_appointment.dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.PreparedStatementCreator;  
import org.springframework.jdbc.support.GeneratedKeyHolder;  
import org.springframework.jdbc.support.KeyHolder; 
import org.springframework.stereotype.Repository;

import com.ib.dental_appointment.model.AppointmentMapper;
import com.ib.dental_appointment.model.AppointmentRequest;
import com.ib.dental_appointment.model.AppointmentResponse;


/**
 * @author snakka
 *
 */
@Repository
public class AppointmentDaoImpl implements AppointmentDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(AppointmentRequest appointment) {
		String query = "INSERT INTO Appointment(startTime, endTime, dentistId, patientId) VALUES(?,?,?,?)";  
		
		  
        KeyHolder holder = new GeneratedKeyHolder();  
        jdbcTemplate.update(new PreparedStatementCreator() {  
            @Override  
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {  
                PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);  
                ps.setTimestamp(1, convertUtilToSqlDate(appointment.getStartTime()));  
                ps.setTimestamp(2, convertUtilToSqlDate(appointment.getEndTime()));  
                ps.setInt(3, appointment.getDentistId());  
                ps.setInt(4, appointment.getPatientId());  
                return ps;  
            }  
        }, holder);  
  
        int newUserId = holder.getKey().intValue();  
        return newUserId;  
	}
	

	@Override
	public AppointmentResponse get(int id) {
		String query = "SELECT * FROM Appointment WHERE patientId = ?";  
        return jdbcTemplate.queryForObject(query, new Object[] { id }, new AppointmentMapper());  
    }
	
	@Override
	public boolean checkIfAppointmentExists(int id, Date date) {
		String query = "SELECT count(*) FROM Appointment WHERE dentistId = ? and startTime = ?";  
		int count = jdbcTemplate.queryForObject(query, new Object[] { id,  convertUtilToSqlDate(date)}, Integer.class);
		if(count > 0)
			return true;
        return false;  
    }
	
	/**
	 * 
	 * @param uDate
	 * @return
	 */
	private static java.sql.Timestamp convertUtilToSqlDate(Date uDate) {
		java.sql.Timestamp sDate = null;;
		SimpleDateFormat sm = new SimpleDateFormat("mm-dd-yyyy");
	    String strDate = sm.format(uDate);
		try {
			Date dt = sm.parse(strDate);
			sDate = new java.sql.Timestamp(dt.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return sDate;
    }
	
	/**
	 * 
	 * @param sDate
	 * @return
	 */
	private static java.util.Date convertSqlToUtilDate(java.sql.Timestamp sDate) {
		java.util.Date utilDate = new java.util.Date(sDate.getTime());
		return utilDate;
	}
	

}
