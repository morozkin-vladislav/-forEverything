package com.example.sweater.repository;

import com.example.sweater.domain.Massage;
import org.springframework.data.repository.CrudRepository;

public interface MassageRepo extends CrudRepository<Massage, Integer> {
}
