package colegio.com.repository;

import colegio.com.model.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeriodoRepositoryJPA extends JpaRepository<Periodo, Long>  {

    public Optional<Periodo> findByEstado(Boolean estado);

}
