package com.example.hack2hire.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hack2hire.R;
import com.example.hack2hire.model.Goal;
import com.example.hack2hire.model.Transaction;

import java.util.List;

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.MyViewHolder> {
    private Context context;
    private List<Transaction> transactionList;


    public TransactionsAdapter(Context context, List<Transaction> transactionList) {
        this.context = context;
        this.transactionList = transactionList;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, amount,date;
 
        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            amount = view.findViewById(R.id.value);
            date= view.findViewById(R.id.date);


        }
    }
 

 
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trans_row_item, parent, false);
 
        return new MyViewHolder(itemView);
    }
 
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Transaction transaction = transactionList.get(position);
        holder.name.setText(transaction.getName());
        holder.amount.setText(transaction.getAmount()+"$");
        holder.date.setText("09-03-2018");

       // holder.thumbnail.setImageBitmap(BitmapFactory.decodeResource(R.drawable.ic_menu_camera,null));
 
   /*     Glide.with(context)
                .load(transaction.getImage())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.thumbnail);*/
    }
 
    @Override
    public int getItemCount() {
        return transactionList.size();
    }

}