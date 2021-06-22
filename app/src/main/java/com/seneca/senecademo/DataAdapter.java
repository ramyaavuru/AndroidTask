package com.seneca.senecademo;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.seneca.senecademo.db.Pojo;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.Viewholder> {

        private Context context;
        private List<Pojo> PojoArrayList;
    Bitmap myBitmap;
    int pos;
    private List<String> list;
        public DataAdapter(Context context, ArrayList<Pojo> PojoArrayList) {
            this.context = context;
            this.PojoArrayList = PojoArrayList;

        }

        @NonNull
        @Override
        public DataAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_view, parent, false);

            return new Viewholder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull final DataAdapter.Viewholder holder, final int position) {
            pos=position;

        holder.id.setText( PojoArrayList.get(position).getId().toString());
          holder.subject.setText(PojoArrayList.get(position).getSubject());
            holder.messae.setText(PojoArrayList.get(position).getMessage());
            holder.timestamp.setText(PojoArrayList.get(position).getTimestamp());
            holder.from.setText(PojoArrayList.get(position).getFrom());
            String url = PojoArrayList.get(position).getPicture();
            Glide.with(context)
                    .load(url)
                    .centerCrop()
                    .into(holder.imae);

        }

    @Override
        public int getItemCount() {
            return PojoArrayList.size();
        }

        public class Viewholder extends RecyclerView.ViewHolder {
            private ImageView imae;
            private TextView id, subject, from,timestamp, messae;

            public Viewholder(@NonNull View itemView) {
                super(itemView);
                imae = itemView.findViewById(R.id.image);
                id = itemView.findViewById(R.id.id);
                subject = itemView.findViewById(R.id.subject);
                from = itemView.findViewById(R.id.from);
                timestamp = itemView.findViewById(R.id.timestamp);
                messae = itemView.findViewById(R.id.message);
            }
        }
    }


