package fiap.com.br.smartcityapp.repositories;

import fiap.com.br.smartcityapp.entities.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    @Query("SELECT obj FROM Evento obj " +
            "WHERE UPPER(obj.evento) LIKE UPPER(CONCAT('%', :evento, '%'))")
    Page<Evento> searchByName(String evento, Pageable pageable);

}
