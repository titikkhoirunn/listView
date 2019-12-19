package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterPahlawan extends BaseAdapter {
    private Context context;
    private ArrayList<Model_pahlawan>pahlawans= new ArrayList<>();

    public void setPahlawans(ArrayList<Model_pahlawan> pahlawans) {
        this.pahlawans = pahlawans;
    }

    public AdapterPahlawan(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return pahlawans.size();
    }

    @Override
    public Object getItem(int i) {
        return pahlawans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView==null){
            itemView= LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);

        Model_pahlawan ModelPahlawan= (Model_pahlawan)getItem(i);
        viewHolder.bind(ModelPahlawan);
        return itemView;
    }
    private class ViewHolder {
        private  TextView txtNama;
        private ImageView imgFoto;
        public ViewHolder(View itemView) {
            txtNama = itemView.findViewById(R.id.tv_nama);
            imgFoto = itemView.findViewById(R.id.iv_foto);
        }

        void bind(Model_pahlawan ModelPahlawan){
            txtNama.setText(ModelPahlawan.getNama());
            imgFoto.setImageResource(ModelPahlawan.getFoto());
        }

    }
}
