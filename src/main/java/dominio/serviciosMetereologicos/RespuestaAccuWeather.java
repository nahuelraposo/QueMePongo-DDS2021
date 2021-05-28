package dominio.serviciosMetereologicos;

import java.time.LocalDateTime;
import java.util.Map;

public class RespuestaAccuWeather {
    Map<String, Object> estadoDelTiempo;
    LocalDateTime expiracion;

    public RespuestaAccuWeather(Map<String, Object> estadoDelTiempo, LocalDateTime expiracion){
        this.estadoDelTiempo = estadoDelTiempo;
        this.expiracion = expiracion;
    }

    public boolean expiro() {
        return this.expiracion.isAfter(LocalDateTime.now());
    }

    public Map<String, Object> getEstadoDelTiempo(){
        return estadoDelTiempo;
    }
}
