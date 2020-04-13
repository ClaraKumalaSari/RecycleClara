package com.example.recycleclara;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {
   private ArrayList<Mahasiswa> dataList;
   public MahasiswaAdapter(ArrayList<Mahasiswa>dataList) {

       this.dataList = dataList;

   }
    @NonNull
    @Override
    public MahasiswaAdapter.MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mahasiswa_list, parent, false);
        return new MahasiswaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaAdapter.MahasiswaViewHolder holder, int i) {
    holder.txtNama.setText("Nama :"+dataList.get(i).getNama());
    holder.txtNim.setText("Nim :"+dataList.get(i).getNim());
    holder.txtNohp.setText(dataList.get(i).getNohp());
    }

    @Override
    public int getItemCount() { return (dataList !=null) ? dataList.size():0; }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder {
       public TextView txtNama,txtNim, txtNohp;

       public MahasiswaViewHolder(@NonNull View itemView) {
           super(itemView);
           txtNama =(TextView) itemView.findViewById(R.id.nama);
           txtNim =(TextView) itemView.findViewById(R.id.nim);
           txtNohp =(TextView) itemView.findViewById(R.id.nohp);
       }

    }
}
