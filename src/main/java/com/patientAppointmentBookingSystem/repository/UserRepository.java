package com.patientAppointmentBookingSystem.repository;

import com.patientAppointmentBookingSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByUsername(String username);
}