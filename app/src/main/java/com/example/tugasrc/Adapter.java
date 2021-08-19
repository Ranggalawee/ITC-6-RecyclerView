package com.example.tugasrc;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    public Adapter(Context ct, String[] s1, String[] s2, int[] img){
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Judul.setText(data1[position]);
        holder.Deskripsi.setText(data2[position]);
        holder.Gambar.setImageResource(images[position]);

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity2.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("gambar", images[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Judul, Deskripsi;
        ImageView Gambar;
        LinearLayout itemLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Judul = itemView.findViewById(R.id.Judul);
            Deskripsi = itemView.findViewById(R.id.Deskripsi);
            Gambar = itemView.findViewById(R.id.Gambar);
            itemLayout = itemView.findViewById(R.id.itemLayout);
        }
    }
}
