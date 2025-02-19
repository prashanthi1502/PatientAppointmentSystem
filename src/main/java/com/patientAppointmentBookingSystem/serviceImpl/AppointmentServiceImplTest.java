package com.patientAppointmentBookingSystem.serviceImpl;


import com.patientAppointmentBookingSystem.entity.Appointment;
import com.patientAppointmentBookingSystem.entity.AppointmentType;
import com.patientAppointmentBookingSystem.entity.Doctor;
import com.patientAppointmentBookingSystem.entity.Patient;
import com.patientAppointmentBookingSystem.exception.AppointmentNotFoundException;
import com.patientAppointmentBookingSystem.model.viewModel.AppointmentViewModel;
import com.patientAppointmentBookingSystem.repository.AppointmentRepository;
import com.patientAppointmentBookingSystem.service.AppointmentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AppointmentServiceImplTest {
    private static final long VALID_ID = 1;

    private static final long INVALID_ID = -1;

    private static final String DESCRIPTION = "Pain in the knees";

    private static Calendar calendarDate = Calendar.getInstance();
    private static Calendar calendarBeforeDate = Calendar.getInstance();
    private static Calendar calendarAfterDate = Calendar.getInstance();

    @Autowired
    private ModelMapper modelMapper;

    @MockBean
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentService appointmentService;

    @Before
    public void setUp() throws Exception {
        Appointment appointment = new Appointment();
        appointment.setId(VALID_ID);
        appointment.setDescription(DESCRIPTION);

        calendarDate.set(2000, 0, 1);
        calendarBeforeDate.set(1999, 0, 1);
        calendarAfterDate.set(2001, 0, 1);
        appointment.setDate(calendarDate.getTime());
        appointment.setPatient(new Patient());
        appointment.setDoctor(new Doctor());
        appointment.setAppointmentType(new AppointmentType());
        when(this.appointmentRepository.findOne(VALID_ID)).thenReturn(appointment);
    }

    @Test
    public void findByIdGivenValidAppointment_ShouldReturnValidModelId() throws Exception {
        //Act
        AppointmentViewModel appointmentViewModel = this.appointmentService.getById(VALID_ID);

        //Assert Id
        assertEquals(VALID_ID, appointmentViewModel.getId());
    }

    @Test
    public void findByIdGivenValidAppointment_ShouldReturnValidModelDescription() throws Exception {
        //Act
        AppointmentViewModel appointmentViewModel = this.appointmentService.getById(VALID_ID);

        //Assert Model
        assertEquals(DESCRIPTION, appointmentViewModel.getDescription());
    }

    @Test
    public void findByIdGivenValidAppointment_ShouldCallRepositoryFindById() throws Exception {
        this.appointmentService.getById(VALID_ID);

        //Assert Database Call
        verify(this.appointmentRepository, times(1)).findOne(VALID_ID);
    }

    @Test(expected = AppointmentNotFoundException.class)
    public void findByIdGivenInvalidAppointment_ShouldThrowException() throws Exception {
        //Act
        this.appointmentService.getById(INVALID_ID);
    }
}