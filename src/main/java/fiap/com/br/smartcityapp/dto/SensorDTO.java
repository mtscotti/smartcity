package fiap.com.br.smartcityapp.dto;

import fiap.com.br.smartcityapp.entities.Sensor;


import java.util.List;

public class SensorDTO {

    private Integer id;

    private String tipoSensor;

    private String localizacao;



    public SensorDTO(Integer id, String tipoSensor, String localizacao) {
        this.id = id;
        this.tipoSensor = tipoSensor;
        this.localizacao = localizacao;
    }

    public SensorDTO(Sensor entity) {
        id = entity.getId();
        tipoSensor = entity.getTipoSensor();
        localizacao = entity.getLocalizacao();
    }

    public Integer getId() {
        return id;
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    public String getLocalizacao() {
        return localizacao;
    }
}
