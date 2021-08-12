package ti.verdant.citiesapi.cidades.distancias;

public class RaioDaTerra {

    /*METERS("m", 6378168),
    KILOMETERS("km", 6378.168f),
    MILES("mi", 3958.747716f);*/

    private final String unidade;
    private final float valor;

    public RaioDaTerra(String unidade, float valor) {
        this.unidade = unidade;
        this.valor = valor;
    }

    public String getUnidade() {
        return unidade;
    }

    public float getValor() {
        return valor;
    }
}
