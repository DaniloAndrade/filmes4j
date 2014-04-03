package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by danilo on 15/03/14.
 */

@Entity
public class Diretor extends Model {

    @Id
    public Long id;
    @Constraints.Required
    public String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static Finder<Long,Diretor> find = new Finder<>(Long.class,Diretor.class);
}
