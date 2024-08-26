package com.example.demo.ServiceImpl;

import com.patientAppointmentBookingSystem.repository.RatingRepository;
import com.patientAppointmentBookingSystem.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RatingServiceImpl implements RatingService {
    private RatingRepository ratingRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }
}
