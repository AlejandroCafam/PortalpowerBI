package com.example.PortalAnaliticaCafam.Menu.Repository;
import com.example.PortalAnaliticaCafam.Menu.Entity.Subdireccion;
import com.example.PortalAnaliticaCafam.Tablero.Entity.Tablero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SubdireccionRepository extends JpaRepository<Subdireccion, Long> {
    List<Subdireccion> findByPadreIsNull(); // Consulta para obtener las subdirecciones
    List<Subdireccion> findByPadreNotNull(); // Consulta para obtener negocios de subdirecciones (subordinadas)
    List<Subdireccion> findByPadre_PadreNotNull();

    //List<Subdireccion> findById_Padre(Long idPadreId);

    @Query("SELECT s FROM Subdireccion s WHERE s.padre.id = :idPadre")
    List<Subdireccion> findHijosByPadreId(@Param("idPadre") Long idPadre);
}


