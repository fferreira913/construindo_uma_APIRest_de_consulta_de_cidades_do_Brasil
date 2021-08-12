package ti.verdant.citiesapi.cidades;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TypeDefs(value = {
        @TypeDef(name = "point", typeClass = TipoPonto.class)
})
public class Cidade {

    @Id
    private long id;
    private String nome;
    private Integer uf;
    private Integer ibge;

    @Column(name = "lat_lon")
    private String geolocalizacao;

    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point lat_lon;

    public Cidade(){

    }

    public Cidade(long id, String nome, Integer uf, Integer ibge, String geolocalizacao, Point lat_lon) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
        this.ibge = ibge;
        this.geolocalizacao = geolocalizacao;
        this.lat_lon = lat_lon;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getUf() {
        return uf;
    }

    public void setUf(Integer uf) {
        this.uf = uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

    public Point getLat_lon() {
        return lat_lon;
    }

    public void setLat_lon(Point lat_lon) {
        this.lat_lon = lat_lon;
    }

    public String getGeolocalizacao() {
        return geolocalizacao;
    }

    public void setGeolocalizacao(String geolocalizacao) {
        this.geolocalizacao = geolocalizacao;
    }
}
