package com.bmunoz.firebasebrayan;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.bmunoz.firebasebrayan.modelo.Usuario;

import java.util.List;

public class MyArrayAdapter<U> extends BaseAdapter {
    List<Usuario> usurioList;
    Context context;

    public MyArrayAdapter(List<Usuario> usurioList, Context context, LayoutInflater layoutInflater) {
        this.usurioList = usurioList;
        this.context = context;
        this.layoutInflater = layoutInflater;
    }

    LayoutInflater layoutInflater;

    @Override
    public int getCount() {
        return usurioList.size();
    }

    @Override
    public Object getItem(int i) {
        return usurioList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vHolder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.usuario_layout,null);

            vHolder = new ViewHolder();
            //vHolder.tvId = view.findViewById(R.id.tv_id_usurio);
            vHolder.tvNomSensor = view.findViewById(R.id.tv_nomSensor);
            //vHolder.tvTipo = view.findViewById(R.id.tv_Tipo);
            vHolder.tvValor = view.findViewById(R.id.tv_Valor);
            //vHolder.tvFechaIngreso = view.findViewById(R.id.tv_fecha_ingreso);
            view.setTag(vHolder);
        } else {
            vHolder = (ViewHolder) view.getTag();
        }
        Usuario u = usurioList.get(i);
        //vHolder.tvId.setText(u.getUserId());
        vHolder.tvNomSensor.setText(u.getNomSensor());
        //vHolder.tvTipo.setText(u.getTipo());
        vHolder.tvValor.setText(u.getValor());
        //vHolder.tvFechaIngreso.setText(LocalDateTime.ofInstant(u.getFechaIngreso().toInstant(), ZoneId.systemDefault()).toString());
        //vHolder.tvFechaIngreso.setText(u.getFechaIngreso().toString());
        return view;
    }
    static class ViewHolder{
        //TextView tvId;
        TextView tvNomSensor;
        //TextView tvTipo;
        TextView tvValor;
        //TextView tvFechaIngreso;
    }
}

