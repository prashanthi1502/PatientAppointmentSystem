package com.example.demoservice;

import com.patientrAppointmentBookingSystem.entity.Patient;
import com.patientAppointmentBookingSystem.model.bindingModel.EditPatientModel;
import com.patientAppointmentBookingSystem.model.bindingModel.PatientRegistrationModel;
import com.patientAppointmentBookingSystem.model.viewModel.PatientBasicViewModel;
import com.patientAppointmentBookingSystem.model.viewModel.PatientViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface PatientService {
    void create(PatientRegistrationModel registrationModel);

    void save(EditPatientModel editPatientModel);

    PatientViewModel getById(long id);

    Patient getByUserId(long userId);

    EditPatientModel getEditModelByUserId(long userId);

    PatientBasicViewModel getBasicById(long id);

    List<PatientBasicViewModel> getPatientsByDoctorId(long doctorId);

    Page<PatientViewModel> getPatientsByDoctorId(Pageable pageable, long doctorId);

    Page<PatientViewModel> getAll(Pageable pageable);
}