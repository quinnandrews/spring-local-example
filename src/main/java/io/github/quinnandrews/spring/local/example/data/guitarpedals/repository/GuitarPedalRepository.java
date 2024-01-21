package io.github.quinnandrews.spring.local.example.data.guitarpedals.repository;

import io.github.quinnandrews.spring.local.example.data.guitarpedals.GuitarPedal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GuitarPedalRepository extends JpaRepository<GuitarPedal, Long>,
                                               JpaSpecificationExecutor<GuitarPedal> {
}
