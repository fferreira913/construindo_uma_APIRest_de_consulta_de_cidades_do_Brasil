package ti.verdant.citiesapi.cidades.distancias;

public class StringDeLocalizacao {

    public static Double[] transforma(String geolocation) {
        String result = geolocation.replace("(", "").replace(")", "");
        String[] strings = result.trim().split(",");
        return new Double[] {Double.valueOf(strings[0]), Double.valueOf(strings[1])};
    }

}
