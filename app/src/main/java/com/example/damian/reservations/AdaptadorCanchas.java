package com.example.damian.reservations;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by android on 07/10/2017.
 */

public class AdaptadorCanchas extends RecyclerView.Adapter<AdaptadorCanchas.CanchasViewHolder> {
    private ArrayList<Cancha_Establecimiento> canchas_res;
    private Resources res;
    private OnCanchaClickListener clickListener;
    private StorageReference storageReference;
    private Context micontex;
    public AdaptadorCanchas(Context contexto, ArrayList<Cancha_Establecimiento> canchas, OnCanchaClickListener clickListener){
        this.canchas_res =canchas;
        res = contexto.getResources();
        this.clickListener=clickListener;
        this.micontex=contexto;
    }
    @Override
    public CanchasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_canchas,parent,false);
        return new CanchasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CanchasViewHolder holder, int position) {

        final Cancha_Establecimiento p = canchas_res.get(position);
       // holder.foto.setImageDrawable(ResourcesCompat.getDrawable(res,R.drawable.socc,null));
        storageReference = FirebaseStorage.getInstance().getReference();
        storageReference.child(p.getFoto()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.with(micontex).load(uri).into(holder.foto);
            }
        });
        holder.tamano.setText(p.getTamano());
        holder.direccion.setText(p.getDireccion());
        holder.celular.setText(p.getCelular()+"");
        holder.establecimiento.setText(p.getNombre_establecimiento());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onCanchaClick(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return canchas_res.size();
    }

    public static class CanchasViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView establecimiento;
        private TextView tamano;
        private TextView direccion;
        private TextView celular;
        private View v;

        public CanchasViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = (ImageView)itemView.findViewById(R.id.imgFoto);
            tamano = (TextView)itemView.findViewById(R.id.lbltamano);
            direccion = (TextView)itemView.findViewById(R.id.lbldireccion);
            establecimiento =(TextView)itemView.findViewById(R.id.lblestablecimiento);
            celular =(TextView)itemView.findViewById(R.id.lblcelular);
        }
    }

    public interface OnCanchaClickListener {
        void onCanchaClick(Cancha_Establecimiento p);
    }
}
