package dominio.prenda;

public class TipoPrenda {
    Categoria categoria;

    //PENSAR UNA MEJOR OPCIÓN PARA ESTO//
    public static final TipoPrenda ZAPATO = new TipoPrenda(Categoria.CALZADO);
    public static final TipoPrenda ANTEOJOS= new TipoPrenda(Categoria.ACCESORIO);
    public static final TipoPrenda REMERA_MANGA_CORTA = new TipoPrenda(Categoria.PARTE_SUPERIOR);
    public static final TipoPrenda REMERA_MANGA_LARGA = new TipoPrenda(Categoria.PARTE_SUPERIOR);
    public static final TipoPrenda PANTALON = new TipoPrenda(Categoria.PARTE_INFERIOR);
    public static final TipoPrenda ZAPATILLAS = new TipoPrenda(Categoria.CALZADO);
    public static final TipoPrenda PAÑUELO = new TipoPrenda(Categoria.ACCESORIO);
    public static final TipoPrenda JEANS = new TipoPrenda(Categoria.PARTE_INFERIOR);
    public static final TipoPrenda BOTAS = new TipoPrenda(Categoria.CALZADO);
    public static final TipoPrenda MUSCULOSA = new TipoPrenda(Categoria.PARTE_SUPERIOR);
    public static final TipoPrenda POLLERA = new TipoPrenda(Categoria.PARTE_INFERIOR);
    public static final TipoPrenda CROCS = new TipoPrenda(Categoria.CALZADO);

    public TipoPrenda( Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}


