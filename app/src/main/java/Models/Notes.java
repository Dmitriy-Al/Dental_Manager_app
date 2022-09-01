package Models;


import static android.app.backup.BackupAgent.FLAG_CLIENT_SIDE_ENCRYPTION_ENABLED;
import static android.app.backup.BackupAgent.FLAG_DEVICE_TO_DEVICE_TRANSFER;

import android.app.backup.BackupDataOutput;
import android.os.Build;
import android.os.ParcelFileDescriptor;

import androidx.annotation.RequiresApi;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.IOException;
import java.io.Serializable;


@Entity (tableName = "notes")
public class Notes implements Serializable{

    @PrimaryKey(autoGenerate = true)//Загуглить что это
    int ID = 0;

    @ColumnInfo(name = "title")
    String title = "";

    @ColumnInfo(name = "notes")
    String notes = "";

    @ColumnInfo(name = "date")
    String date = "";

    @ColumnInfo(name = "pined")
    boolean pinned = false;


    public int getID() {

        return ID;
    }

    public void setID(int ID) {

        this.ID = ID;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getNotes() {

        return notes;
    }

    public void setNotes(String notes) {

        this.notes = notes;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public boolean getPinned(){

        return pinned;
    }

    public void setPinned(boolean pinned) {

        this.pinned = pinned;
    }

}
