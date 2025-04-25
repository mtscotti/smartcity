package fiap.com.br.smartcityapp.dto;

import fiap.com.br.smartcityapp.entities.Evento;
import fiap.com.br.smartcityapp.entities.Sensor;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

public class EventoDTO {

    private Integer id;
    @Size(min = 10, max = 30, message = "Entre 10 e 30 caracteres")
    @NotBlank(message = "Campo requerido")
    private String evento;
    private LocalDateTime dataHoraEvento;
    private String descricao;
    @NotEmpty(message = "Deve ter pelo menos 1 sensor")
    private List<Sensor> sensores;

    public EventoDTO(Integer id, String evento, LocalDateTime dataHoraEvento, String descricao) {
        this.id = id;
        this.evento = evento;
        this.dataHoraEvento = dataHoraEvento;
        this.descricao = descricao;
    }

    public EventoDTO(Evento entity) {
        id = entity.getId();
        evento = entity.getEvento();
        dataHoraEvento = entity.getDataHoraEvento();
        descricao = entity.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public String getEvento() {
        return evento;
    }

    public LocalDateTime getDataHoraEvento() {
        return dataHoraEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    private void copyDtoToEntity(EventoDTO dto, Evento entity) {
        entity.setEvento(dto.getEvento());
        entity.setDataHoraEvento(dto.getDataHoraEvento());
        entity.setDescricao(dto.getDescricao());

        entity.getSensores().clear();
    }

}
