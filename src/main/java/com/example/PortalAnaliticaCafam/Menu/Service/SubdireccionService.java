package com.example.PortalAnaliticaCafam.Menu.Service;
import com.example.PortalAnaliticaCafam.Menu.Entity.Subdireccion;
import com.example.PortalAnaliticaCafam.Menu.Repository.SubdireccionRepository;
import com.example.PortalAnaliticaCafam.Tablero.Entity.Tablero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SubdireccionService {
    @Autowired
    private SubdireccionRepository subdireccionRepository;

    public List<Subdireccion> encontrarSubdirecciones() {
        return subdireccionRepository.findByPadreIsNull();
    }

    public List<Subdireccion> encontrarNegocios() {
        return subdireccionRepository.findByPadreNotNull();
    }
    public List<Subdireccion> encontrarNegocios2() {
        return subdireccionRepository.findByPadre_PadreNotNull();
    }

    public Subdireccion guardarSubdireccion(Subdireccion subdireccion) {
        return subdireccionRepository.save(subdireccion);
    }

    public Optional<Subdireccion> obtenerSubdireccionPorId(Long id) {
        return subdireccionRepository.findById(id);
    }

    public void eliminarSubdireccion(Long id) {
        subdireccionRepository.deleteById(id);
    }

    /*public List<Subdireccion> findSubdireccionesByParentId(Long parentId) {
        return subdireccionRepository.findById_Padre(parentId);
    }*/

    public List<Subdireccion> findHijosByPadreId(Long idPadre) {
        List<Subdireccion> hijos = subdireccionRepository.findHijosByPadreId(idPadre);
        return hijos;
    }
}

