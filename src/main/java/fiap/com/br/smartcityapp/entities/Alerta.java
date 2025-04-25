package fiap.com.br.smartcityapp.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_alerta")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @MapsId
    private Leitura leitura;
    private String tipoAlerta;
    private LocalDateTime dataHoraAlerta;
    private String status;
    @OneToOne(mappedBy = "alerta", cascade = CascadeType.ALL)
    private Manutencao manutencao;

    public Alerta () { }

    public Alerta(Integer id, Leitura leitura, String tipoAlerta, LocalDateTime dataHoraAlerta, String status) {
        this.id = id;
        this.leitura = leitura;
        this.tipoAlerta = tipoAlerta;
        this.dataHoraAlerta = dataHoraAlerta;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Leitura getLeitura() {
        return leitura;
    }

    public void setLeitura(Leitura leitura) {
        this.leitura = leitura;
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public LocalDateTime getDataHoraAlerta() {
        return dataHoraAlerta;
    }

    public void setDataHoraAlerta(LocalDateTime dataHoraAlerta) {
        this.dataHoraAlerta = dataHoraAlerta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Manutencao getManutencao() {
        return manutencao;
    }

    public void setManutencao(Manutencao manutencao) {
        this.manutencao = manutencao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alerta alerta = (Alerta) o;

        if (!Objects.equals(id, alerta.id)) return false;
        if (!Objects.equals(leitura, alerta.leitura)) return false;
        if (!Objects.equals(tipoAlerta, alerta.tipoAlerta)) return false;
        if (!Objects.equals(dataHoraAlerta, alerta.dataHoraAlerta))
            return false;
        return Objects.equals(status, alerta.status);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (leitura != null ? leitura.hashCode() : 0);
        result = 31 * result + (tipoAlerta != null ? tipoAlerta.hashCode() : 0);
        result = 31 * result + (dataHoraAlerta != null ? dataHoraAlerta.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}