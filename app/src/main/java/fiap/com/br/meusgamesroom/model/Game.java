package fiap.com.br.meusgamesroom.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by logonrm on 24/01/2018.
 */
@Entity
public class Game {

    //A anotacao PrimaryKey indica que a variável id será chave primária
    //da nossa base dados e ativamos o autoGenerate para que o id
    //seja gerado automaticamente
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nome;
    private String plataforma;

    public Game(){}

    public Game(String plataforma, String nome) {
        this.plataforma = plataforma;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
}
