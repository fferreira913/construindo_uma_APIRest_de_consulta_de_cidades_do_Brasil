package ti.verdant.citiesapi.cidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cidade {

    @Id
    private long id;
    private String nome;
    private Integer uf;
    private Integer ibge;
    private String lat_lon;

    public Cidade(){

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

    public String getLat_lon() {
        return lat_lon;
    }

    public void setLat_lon(String lat_lon) {
        this.lat_lon = lat_lon;
    }
}
