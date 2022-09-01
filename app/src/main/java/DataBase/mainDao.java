package DataBase;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;

import androidx.room.Delete;

import androidx.room.Insert;

import androidx.room.Query;

import java.util.List;

import Models.Notes;

@Dao
public interface mainDao {

    @Insert(onConflict = REPLACE) //метод вставки данных
    void insert (Notes notes);

    @Query("SELECT * FROM notes ORDER BY id DESC") // SQL запрос сортировка списка пациентов
    List<Notes> getAll();

    @Query("UPDATE notes SET title = :title, notes = :notes WHERE ID = :id")
    void update (int id, String title, String notes); //, String price

    @Delete
    void delete (Notes notes);
}