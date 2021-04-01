package br.com.camion.vidanceCamion.Repository;


import br.com.camion.vidanceCamion.model.Traveaux;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouRepository extends JpaRepository<Traveaux, ID> {
    Traveaux findById(Long id);
}
