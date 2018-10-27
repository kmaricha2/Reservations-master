package com.example.damian.reservations;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by android on 07/10/2017.
 */
public class AdaptadorReservas extends RecyclerView.Adapter<AdaptadorReservas.ReservasViewHolder> {
    private ArrayList<Cancha_Reserva> reservas;
    private Resources res;
    private OnCanchaClickListener clickListener;
    private StorageReference storageReference;
private Context micontex;
    public AdaptadorReservas(Context contexto, ArrayList<Cancha_Reserva> reservas, OnCanchaClickListener clickListener){
        this.reservas =reservas;
        res = contexto.getResources();
        this.clickListener=clickListener;
        this.micontex=contexto;
    }
    @Override
    public ReservasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_reserva,parent,false);
        return new ReservasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ReservasViewHolder holder, int position) {

        final Cancha_Reserva p = reservas.get(position);
        if (p.isEstado()){
            holder.estado.setBackground(res.getDrawable(R.drawable.res_active));
        }else{
            holder.estado.setBackground(res.getDrawable(R.drawable.res_incactive));
        }
        storageReference = FirebaseStorage.getInstance().getReference();
        storageReference.child(p.getFoto()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.with(micontex).load(uri).into(holder.foto);
            }
        });
      //  holder.foto.setImageDrawable(ResourcesCompat.getDrawable(res,R.drawable.socc,null));
        holder.fecha_hora.setText(p.getFecha());
        holder.establecimiento.setText(p.getNombre_establecimiento());
        holder.num_cancha.setText("Cancha "+ p.getNumero_cancha() +" - Hora: "+p.getHora_tras());
        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onCanchaClick(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return reservas.size();
    }

    public static class ReservasViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView establecimiento;
        private TextView fecha_hora,num_cancha,estado;

        private View v;

        public ReservasViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = (ImageView)itemView.findViewById(R.id.imgFoto_res);
            fecha_hora = (TextView)itemView.findViewById(R.id.lblfecha_hora);
            establecimiento =(TextView)itemView.findViewById(R.id.lblestablecimiento_res);
            num_cancha =(TextView)itemView.findViewById(R.id.lbl_num_cancha);
            estado =(TextView)itemView.findViewById(R.id.lbl_estado);

        }
    }

    public interface OnCanchaClickListener {
        void onCanchaClick(Cancha_Reserva p);
    }
   /* public String Estado_Reserva(String fecha_reserva){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        String fechaactual = simpleDateFormat.format(calendar.getTime());

        return fechaactual;
    }*/
}