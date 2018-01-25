package fiap.com.br.meusgamesroom.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import fiap.com.br.meusgamesroom.model.Game;

/**
 * Created by logonrm on 24/01/2018.
 */
@Dao
public interface GameDAO {

    @Insert
    void inserir(Game game);

    @Query("SELECT * FROM Game")
    LiveData<List<Game>> lerGames();

    @Query("SELECT * FROM Game WHERE id = :id" )
    Game buscarPorId(int id);

    @Update
    void atualizar(Game game);

    @Delete
    void apagar(Game game);
}
