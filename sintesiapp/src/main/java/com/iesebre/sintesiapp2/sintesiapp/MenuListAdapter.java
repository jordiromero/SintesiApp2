package com.iesebre.sintesiapp2.sintesiapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jordi on 11/06/14.
 */
public class MenuListAdapter extends BaseAdapter {

    private Activity activity;
    private List<Menu> menus;
    private LayoutInflater inflater = null;

    public MenuListAdapter(Activity a, List<Menu> menus){
        activity = a;
        this.menus = menus;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    public int getCount(){
        return menus.size();
    }

    public Object getItem(int position){
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View vi = convertView;
        ViewHolder holder;
        if(convertView==null){
            vi = inflater.inflate(R.layout.menu_tot,null);
            holder = new ViewHolder();
            holder.image = (ImageView) vi.findViewById(R.id.image_tot);
            holder.name = (TextView) vi.findViewById(R.id.nom_tot);
            holder.description = (TextView) vi.findViewById(R.id.descrip_tot);
            holder.m_type = (TextView) vi.findViewById(R.id.tipus_m_tot);
            holder.price = (TextView) vi.findViewById(R.id.preu_tot);
            vi.setTag(holder);

        }else{
            holder = (ViewHolder)vi.getTag();
        }
        Menu item = new Menu();
        item = menus.get(position);

        Picasso.with(activity).load(item.getImage()).into(holder.image);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.m_type.setText(item.getM_type());
        holder.price.setText(item.getPrice());
        return vi;
    }

    public void setData(List<Menu> menu){
        this.menus.addAll(menu);
        this.notifyDataSetChanged();
    }

    public class ViewHolder{
        ImageView image;
        TextView name;
        TextView description;
        TextView m_type;
        TextView price;
    }
}
