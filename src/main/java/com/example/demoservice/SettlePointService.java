package com.example.demoservice;

import com.patientAppointmentBookingSystem.entity.SettlePoint;
import com.patientAppointmentBookingSystem.model.viewModel.SettlePointViewModel;

import java.util.List;


public interface SettlePointService {
    List<SettlePointViewModel> getAll();

    SettlePoint getById(long id);
}
