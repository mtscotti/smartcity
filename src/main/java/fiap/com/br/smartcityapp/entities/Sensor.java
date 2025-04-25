package fiap.com.br.smartcityapp.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tipoSensor;

    private String localizacao;

    @OneToOne(mappedBy = "sensor", cascade = CascadeType.ALL)
    private Leitura leitura;

    @ManyToMany(mappedBy = "sensores")
    private List<Evento> eventos;

    public Sensor () { }

    public Sensor(Integer id, String tipoSensor, String localizacao) {
        this.id = id;
        this.tipoSensor = tipoSensor;
        this.localizacao = localizacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Leitura getLeitura() {
        return leitura;
    }

    public void setLeitura(Leitura leitura) {
        this.leitura = leitura;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sensor sensor = (Sensor) o;

        if (!Objects.equals(id, sensor.id)) return false;
        if (!Objects.equals(tipoSensor, sensor.tipoSensor)) return false;
        return Objects.equals(localizacao, sensor.localizacao);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tipoSensor != null ? tipoSensor.hashCode() : 0);
        result = 31 * result + (localizacao != null ? localizacao.hashCode() : 0);
        return result;
    }


}