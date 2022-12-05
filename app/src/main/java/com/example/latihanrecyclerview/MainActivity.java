package com.example.latihanrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.latihanrecyclerview.model.Barang;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public ArrayList<Barang> all_barang;



    public class BarangHolder extends RecyclerView.ViewHolder{

        public TextView namaBarang;
        public TextView hargaBarang;
        public TextView stokBarang;
        public BarangAdapter barangAdapter;

        public BarangHolder(@NonNull View itemview, BarangAdapter barangAdapter){
            super(itemview);
            namaBarang = itemview.findViewById(R.id.namaBarang);
            hargaBarang = itemview.findViewById(R.id.hargaBarang);
            stokBarang = itemview.findViewById(R.id.stokBarang);
            this.barangAdapter = barangAdapter;
        }
    }

    public class BarangAdapter extends RecyclerView.Adapter<BarangHolder>{
        ArrayList<Barang> all_barang;
        public BarangAdapter(Context ctx, ArrayList<Barang> all_barang) {
        this.all_barang =  all_barang;
        }

        @NonNull
        @Override
        public BarangHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull BarangHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return this.all_barang.size();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        all_barang.add(new Barang("Air", 2000, 10));
        all_barang.add(new Barang("Snack", 1000, 5));
        recyclerView = findViewById(R.id.recyclerView);
    }

}