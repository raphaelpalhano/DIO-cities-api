package com.github.raphaelpalhano.DIO.CitiesDistance.staties;

import com.github.raphaelpalhano.DIO.CitiesDistance.countries.Country;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity(name = "State")
@Table(name = "estado")
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class State {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    private String uf;

    private Integer ibge;

  // 1st
  /*@Column(name = "pais")
  private Integer countryId;*/

    // 2nd - @ManyToOne (Muitos estados sao de um Pais)
    @ManyToOne // interface que mira em algo e faz uma relação entre uma tabela e outro ou coisa do tipo
    @JoinColumn(name = "pais", referencedColumnName = "id") // a coluna que referencia é na tabela pais id
    private Country country; // indicando o pais (manyToOne muito para um)

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;

    public State() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUf() {
        return uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public List<Integer> getDdd() {
        return ddd;
    }

    public Country getCountry() {
        return country;
    }

 /* public Integer getCountryId() {
      return countryId;
  }*/
}
