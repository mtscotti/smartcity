package fiap.com.br.smartcityapp.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String evento;
    private LocalDateTime dataHoraEvento;
    private String descricao;

    @ManyToMany
    @JoinTable(
            name = "tb_evento_sensor",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "sensor_id")
    )
    private List<Sensor> sensores;

    public Evento () {}

    public Evento(Long id, String evento, LocalDateTime dataHoraEvento, String descricao) {
        this.id = id;
        this.evento = evento;
        this.dataHoraEvento = dataHoraEvento;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public LocalDateTime getDataHoraEvento() {
        return dataHoraEvento;
    }

    public void setDataHoraEvento(LocalDateTime dataHoraEvento) {
        this.dataHoraEvento = dataHoraEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public void setSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Evento evento1 = (Evento) o;

        if (!Objects.equals(id, evento1.id)) return false;
        if (!Objects.equals(evento, evento1.evento)) return false;
        if (!Objects.equals(dataHoraEvento, evento1.dataHoraEvento))
            return false;
        return Objects.equals(descricao, evento1.descricao);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (evento != null ? evento.hashCode() : 0);
        result = 31 * result + (dataHoraEvento != null ? dataHoraEvento.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }
}
