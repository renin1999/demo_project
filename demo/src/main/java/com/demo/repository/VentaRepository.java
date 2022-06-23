package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {

}
