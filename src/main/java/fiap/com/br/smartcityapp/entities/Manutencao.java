package fiap.com.br.smartcityapp.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_manutencao")
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "alerta_id")
    private Alerta alerta;
    private String tipoManutencao;
    private LocalDateTime dataHoraManutencao;
    private String descricao;

    public Manutencao () { }

    public Manutencao(Integer id, String tipoManutencao, LocalDateTime dataHoraManutencao, String descricao) {
        this.id = id;
        this.tipoManutencao = tipoManutencao;
        this.dataHoraManutencao = dataHoraManutencao;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alerta getAlerta() {
        return alerta;
    }

    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }

    public String getTipoManutencao() {
        return tipoManutencao;
    }

    public void setTipoManutencao(String tipoManutencao) {
        this.tipoManutencao = tipoManutencao;
    }

    public LocalDateTime getDataHoraManutencao() {
        return dataHoraManutencao;
    }

    public void setDataHoraManutencao(LocalDateTime dataHoraManutencao) {
        this.dataHoraManutencao = dataHoraManutencao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manutencao that = (Manutencao) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(tipoManutencao, that.tipoManutencao))
            return false;
        if (!Objects.equals(dataHoraManutencao, that.dataHoraManutencao))
            return false;
        return Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tipoManutencao != null ? tipoManutencao.hashCode() : 0);
        result = 31 * result + (dataHoraManutencao != null ? dataHoraManutencao.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }
}