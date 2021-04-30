package dominio;

import dominio.prenda.Material;
import dominio.prenda.Prenda;
import dominio.prenda.TipoPrenda;
import dominio.prenda.Trama;

import java.awt.*;

public class Borrador {

    TipoPrenda tipoPrenda;
    Material material;
    Color colorPrincipal;
    Color colorSecundario;
    Trama trama = Trama.LISA;

    public Borrador(){};

    public void establecerTipoPrenda(TipoPrenda tipoPrenda){
        this.validarTipoPrenda(tipoPrenda);
        this.tipoPrenda = tipoPrenda;
    }

    public void establecerMaterial(Material material){
        this.validarTipoPrenda(tipoPrenda);
        this.validarMaterial(material);
        this.validarConsistenciaConTipoPrenda(material);
        this.material = material;
    }

    public void establecerColorPrincipal(Color colorPrincipal){
        this.validarColorPrincipal(colorPrincipal);
        this.colorPrincipal = colorPrincipal;
    }

    public void establecerColorSecundario(Color colorSecundario){
        this.colorSecundario = colorSecundario;
    }

    public void establecerTrama(Trama trama){
        this.trama = trama;
    }

    public Prenda crearPrenda(){
        return new Prenda(tipoPrenda,material,colorPrincipal,colorSecundario,trama);
    }

    //VALIDACIONES

    public void validarConsistenciaConTipoPrenda(Material material){

    }

    public void validarTipoPrenda(TipoPrenda tipoPrenda){
        if(tipoPrenda == null)
            throw new RuntimeException("El tipo de prenda no puede ser nulo.");
    }

    public void validarMaterial(Material material){
        if(material == null)
            throw new RuntimeException("El material no puede ser nulo.");
    }

    public void validarColorPrincipal(Color colorPrincipal){
        if(colorPrincipal == null)
            throw  new RuntimeException("El color primario no puede ser nulo.");
    }
}
