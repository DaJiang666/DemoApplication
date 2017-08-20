package com.example.williamwallae.demoapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder> {

    private List<Person> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public MyRecycleViewAdapter(Context context, List<Person> datas){
        this. mContext=context;
        this. mDatas=datas;
        inflater=LayoutInflater. from(mContext);
    }

    @Override
    public int getItemCount() {

        return mDatas.size();
    }

    //填充onCreateViewHolder方法返回的holder中的控件
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Person person = mDatas.get(position);

        holder.tv.setText(person.name + " :: " + person.age);
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    class MyViewHolder extends ViewHolder {

        TextView tv;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.id_num);
            view.setOnLongClickListener(new OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = getAdapterPosition();
                    setTop(position);
                    return false;
                }
            });
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    toast(position);

                }
            });
        }

    }

    private void toast(int position) {
        Person person = mDatas.get(position);

        Toast.makeText(mContext, "name::" +person.name + " age::" + person.age + " "
            + "&&&  position==" + position,Toast.LENGTH_LONG).show();
    }

    public void setTop(int position){
        Toast.makeText(mContext, "删出",Toast.LENGTH_SHORT).show();
        Person person = mDatas.get(position);
        person.name  = "置顶";
        mDatas.remove(position);
        notifyItemRemoved(position);
        if (position < mDatas.size()) {
            notifyItemRangeChanged(position, mDatas.size() - position);
        }


    }
//
//    public void setTop(int position){
//        Toast.makeText(mContext, "置顶",Toast.LENGTH_SHORT).show();
//        Person person = mDatas.get(position);
//        person.name  = "置顶";
//        mDatas.remove(position);
//        mDatas.add(0, person);
//        notifyItemMoved(position, 0);
//        notifyItemChanged(0);
//
//    }
}
