package com.example.quanlycauthu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewCauThu_Adapter extends BaseAdapter {
    Context context;
    int LayoutResource;
    ArrayList<CauThu> arrayList;

    public ListViewCauThu_Adapter(Context context, int layoutResource, ArrayList<CauThu> arrayList) {
        this.context = context;
        LayoutResource = layoutResource;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView  = inflater.inflate(LayoutResource,null);

        TextView tvten = convertView.findViewById(R.id.TVtenCauthu);
        TextView tvsoao = convertView.findViewById(R.id.TVsoAo);
        TextView tvdiachi = convertView.findViewById(R.id.TVDiaChi);

        tvten.setText(arrayList.get(position).getTen().toString());
        tvsoao.setText(arrayList.get(position).getSoao()+"");
        tvdiachi.setText(arrayList.get(position).getDiachi().toString());

        return convertView;
    }
}
