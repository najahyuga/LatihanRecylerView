package com.example.latihanrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
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
        private LayoutInflater inflater;
        public BarangAdapter(Context ctx, ArrayList<Barang> all_barang) {
            this.all_barang =  all_barang;
            inflater = LayoutInflater.from(ctx);
        }

        @NonNull
        @Override
        public BarangHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View item = inflater.inflate(R.layout.listbarang, parent, false);
            return new BarangHolder(item, this);
        }

        @Override
        public void onBindViewHolder(@NonNull BarangHolder holder, int position) {
            Barang perBarang = this.all_barang.get(position);
            holder.namaBarang.setText(perBarang.nama_barang);
            holder.hargaBarang.setText(String.valueOf(perBarang.harga_barang));
            holder.stokBarang.setText(String.valueOf(perBarang.stok_barang));
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
        this.all_barang = new ArrayList<Barang>();
        all_barang.add(new Barang("Air", 2000, 10));
        all_barang.add(new Barang("Snack", 1000, 5));
        recyclerView = findViewById(R.id.recyclerView);
        BarangAdapter adapter = new BarangAdapter(this, this.all_barang);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}