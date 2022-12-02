package com.example.project_app_thu_cung;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterSanphan extends RecyclerView.Adapter<AdapterSanphan.SPViewHoler> {
    private List<SanPham> listlsp;

    Home mainActivity = new Home();

    public AdapterSanphan(List<SanPham> listlsp) {
        this.listlsp = listlsp;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SPViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listout,parent,false);
        return new SPViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SPViewHoler holder, int position) {
        SanPham SP = listlsp.get(position);
        if(SP == null){
            return;
        }
        holder.tvname.setText(SP.getName());
        holder.tvmota.setText( SP.getMota());
        holder.tvprice.setText( SP.getPrice());
        Glide.with(holder.hinh.getContext())
                .load(SP.getHinh())
                .placeholder(R.mipmap.ic_launcher) // ảnh mặt định
                .circleCrop()
                .error(R.mipmap.ic_launcher) // ảnh khi lỗi
                .into(holder.hinh);
    }

    @Override
    public int getItemCount() {
        if (listlsp != null){
            return listlsp.size();
        }
        return 0;
    }

    public class SPViewHoler  extends RecyclerView.ViewHolder {
        private TextView tvname;
        private TextView tvmota;
        private TextView tvprice;
        private ImageView hinh;
        public SPViewHoler(@NonNull View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.tv_name);
            tvmota = itemView.findViewById(R.id.tv_mota);
            tvprice = itemView.findViewById(R.id.tv_price);
            hinh = itemView.findViewById(R.id.imgsp);
        }
    }
}


