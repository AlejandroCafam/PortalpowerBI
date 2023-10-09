package com.example.PortalAnaliticaCafam.Menu.Repository;
import com.example.PortalAnaliticaCafam.Menu.Entity.Subdireccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SubdireccionRepository extends JpaRepository<Subdireccion, Long> {
    List<Subdireccion> findByPadreIsNull(); // Consulta para obtener las subdirecciones
    List<Subdireccion> findByPadreNotNull(); // Consulta para obtener negocios de subdirecciones (subordinadas)
    List<Subdireccion> findByPadre_PadreNotNull();
}


