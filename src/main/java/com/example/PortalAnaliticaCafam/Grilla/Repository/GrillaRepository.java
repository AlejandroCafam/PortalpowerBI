package com.example.PortalAnaliticaCafam.Grilla.Repository;

import com.example.PortalAnaliticaCafam.Grilla.Entity.Grilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrillaRepository extends JpaRepository<Grilla, Long> {
}
