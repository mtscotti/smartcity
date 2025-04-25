package fiap.com.br.smartcityapp.services;

import fiap.com.br.smartcityapp.dto.EventoDTO;
import fiap.com.br.smartcityapp.dto.SensorDTO;
import fiap.com.br.smartcityapp.entities.Evento;
import fiap.com.br.smartcityapp.entities.Sensor;
import fiap.com.br.smartcityapp.repositories.EventoRepository;
import fiap.com.br.smartcityapp.services.exceptions.DatabaseException;
import fiap.com.br.smartcityapp.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import fiap.com.br.smartcityapp.*;

import java.awt.print.Pageable;

@Service
public class EventoService {

    private EventoRepository repository;

    @Transactional(readOnly = true)
    public EventoDTO findById(Long id) {
        Evento evento = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new EventoDTO(evento);
    }

    @Transactional(readOnly = true)
    public Page<EventoDTO> findAll(String name, Pageable pageable) {
        Page<Evento> result = repository.searchByName(name, org.springframework.data.domain.Pageable.unpaged());
        return result.map(x -> new EventoDTO(x));
    }

    @Transactional
    public EventoDTO insert(EventoDTO dto) {
        Evento entity = new Evento();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new EventoDTO(entity);
    }

    @Transactional
    public EventoDTO update(Long id, EventoDTO dto) {
        try {
            Evento entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new EventoDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }




    private void copyDtoToEntity(EventoDTO dto, Evento entity) {
        entity.setEvento(dto.getEvento());
        entity.setDataHoraEvento(dto.getDataHoraEvento());
        entity.setDescricao(dto.getDescricao());

        entity.getSensores().clear();
        }
}





