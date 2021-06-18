package com.example.demo.jpa;

import com.example.demo.model.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<T extends GenericEntity> extends JpaRepository<T, Long> {
}
