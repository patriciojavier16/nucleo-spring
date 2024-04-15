package com.computadorasspring.repository;

import com.computadorasspring.entity.Computadora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComputadoraRepository extends JpaRepository<Computadora, Long> {
}
