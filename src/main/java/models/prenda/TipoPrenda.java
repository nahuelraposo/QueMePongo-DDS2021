package models.prenda;
import java.util.Arrays;
import java.util.List;

public class TipoPrenda {
    Categoria categoria;
    List<Material> materialesAdecuados;

    //PENSAR UNA MEJOR OPCIÓN PARA ESTO//
    //PARTE SUPERIOR//
    public static final TipoPrenda CHOMBA = new TipoPrenda(Categoria.PARTE_SUPERIOR, Arrays.asList(Material.ALGODON,Material.LYCRA,Material.PIQUE));
    public static final TipoPrenda CAMISA = new TipoPrenda(Categoria.PARTE_SUPERIOR,Arrays.asList(Material.ALGODON,Material.LYCRA));
    public static final TipoPrenda REMERA_MANGA_CORTA = new TipoPrenda(Categoria.PARTE_SUPERIOR, Arrays.asList(Material.ALGODON,Material.LYCRA));
    public static final TipoPrenda REMERA_MANGA_LARGA = new TipoPrenda(Categoria.PARTE_SUPERIOR, Arrays.asList(Material.ALGODON,Material.LYCRA));
    public static final TipoPrenda MUSCULOSA = new TipoPrenda(Categoria.PARTE_SUPERIOR, Arrays.asList(Material.ALGODON,Material.LYCRA));
    //PARTE_INFERIOR
    public static final TipoPrenda PANTALON = new TipoPrenda(Categoria.PARTE_INFERIOR,Arrays.asList(Material.ALGODON,Material.LYCRA));
    public static final TipoPrenda PANTALON_DE_VESTIR = new TipoPrenda(Categoria.PARTE_INFERIOR,Arrays.asList(Material.ALGODON,Material.LYCRA));
    public static final TipoPrenda JEANS = new TipoPrenda(Categoria.PARTE_INFERIOR,Arrays.asList(Material.ALGODON,Material.LYCRA, Material.POLIESTIRENO));
    public static final TipoPrenda POLLERA = new TipoPrenda(Categoria.PARTE_INFERIOR, Arrays.asList(Material.ALGODON,Material.LYCRA));
    //CALZADOS//
    public static final TipoPrenda BOTAS = new TipoPrenda(Categoria.CALZADO, Arrays.asList(Material.CUERO));
    public static final TipoPrenda CROCS = new TipoPrenda(Categoria.CALZADO, Arrays.asList(Material.GOMA));
    public static final TipoPrenda ZAPATILLAS = new TipoPrenda(Categoria.CALZADO, Arrays.asList(Material.CUERO));
    public static final TipoPrenda ZAPATOS = new TipoPrenda(Categoria.CALZADO, Arrays.asList(Material.CUERO));
    //ACCESORIOS//
    public static final TipoPrenda ANTEOJOS= new TipoPrenda(Categoria.ACCESORIO, Arrays.asList(Material.PLASTICO));
    public static final TipoPrenda PAÑUELO = new TipoPrenda(Categoria.ACCESORIO, Arrays.asList(Material.ALGODON));


    public TipoPrenda( Categoria categoria, List<Material> materialesAdecuados)
    {
        this.categoria = categoria;
        this.materialesAdecuados = materialesAdecuados;
    }

    public void validarSiAdmiteMaterial(Material material) {
        if(!getMaterialesAdecuados().contains(material))
            throw new RuntimeException("El tipo de prenda es incompatible con el material elegido.");
    }

    private List<Material> getMaterialesAdecuados() {
        return materialesAdecuados;
    }

    public Categoria getCategoria() {
        return categoria;
    }


}


