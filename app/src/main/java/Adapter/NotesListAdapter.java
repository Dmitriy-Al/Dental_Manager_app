package Adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dentalmanager.NotesClickListener;
import com.example.dentalmanager.NotesTakerActivity;
import com.example.dentalmanager.R;
import java.util.List;
import Models.Notes;
import java.util.ArrayList;



public class NotesListAdapter extends RecyclerView.Adapter <NotesViewHolder>{

    Context context;
    List<Notes> list;
    NotesClickListener listener;

    public NotesListAdapter(Context context, List<Notes> list, NotesClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_list, parent, false));
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {

        holder.textView_title.setText(list.get(position).getTitle()); //Метод взят мной из Notes
        holder.textView_title.setSelected(true); //Прокрутка записи

        holder.textView_notes.setText(list.get(position).getNotes());

        holder.textView_date.setText(list.get(position).getDate());
        holder.textView_date.setSelected(true); //Прокрутка записи

/*
        int color_code = getRandomColor(); //Установка рандомного цвета
        holder.notes_container.setCardBackgroundColor(holder.itemView.getResources().getColor(color_code, null));
*/
        holder.notes_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(list.get(holder.getAdapterPosition()));

                ////////////////////////////////////////////////////////
                Toast toast = Toast.makeText(context.getApplicationContext(),
                        "Длительное нажатие на иконку \"Сохранить карточку\" сохраненяет дату записи",
                        Toast.LENGTH_LONG);
                toast.show();
                ///////////////////////////////////////////////////////
            }
        });

        holder.notes_container.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onLongClick(list.get(holder.getAdapterPosition()), holder.notes_container);
                return true;
            }
        });


    }

/*
    private int getRandomColor(){ // Установка случайного цвета заметки
        List <Integer> colorCode = new ArrayList<>();
        colorCode.add(R.color.blue);
        colorCode.add(R.color.green);

        Random random = new Random();
        int random_color = random.nextInt(colorCode.size()); //Рандомный цвет. Поменять метод на другой
        return colorCode.get(random_color);
    }
*/
    @Override
    public int getItemCount() {
        return list.size();
    }//Метод поиска заметок

    public void filterList(List<Notes> filteredList){
        list = filteredList;
        notifyDataSetChanged();
    }

}

class NotesViewHolder extends RecyclerView.ViewHolder{

    CardView notes_container;
    TextView textView_title; //Все элементы textView можно писать одной строкой один за другим
    TextView textView_date;
    TextView textView_notes;
    ImageView imageView_pin;

    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);

        notes_container = itemView.findViewById(R.id.notes_container);
        textView_title = itemView.findViewById(R.id.textView_title);
        textView_date = itemView.findViewById(R.id.textView_date);
        textView_notes = itemView.findViewById(R.id.textView_notes);

    }
}