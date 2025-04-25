package fiap.com.br.smartcityapp.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_leitura")
public class Leitura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @MapsId
    @OneToOne
    private Sensor sensor;
    private BigDecimal valor;
    private LocalDate dataHora;
    @OneToOne(optional = true, mappedBy = "leitura")
    private Alerta alerta;

    public Leitura() {
    }

    public Leitura(Integer id, Sensor sensor, BigDecimal valor, LocalDate dataHora) {
        this.id = id;
        this.sensor = sensor;
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public Alerta getAlerta() {
        return alerta;
    }

    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Leitura leitura = (Leitura) o;

        if (!Objects.equals(id, leitura.id)) return false;
        if (!Objects.equals(valor, leitura.valor)) return false;
        return Objects.equals(dataHora, leitura.dataHora);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        result = 31 * result + (dataHora != null ? dataHora.hashCode() : 0);
        return result;
    }
}