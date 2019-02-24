package com.example.hack2hire.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hack2hire.R;
import com.example.hack2hire.model.Goal;

import java.util.List;

public class GoalsAdapter extends RecyclerView.Adapter<GoalsAdapter.MyViewHolder> {
    private Context context;
    private final List<Goal> goals;



    public GoalsAdapter(Context context, List<Goal> goals){

        this.context = context;
        this.goals = goals;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, amount;
       // public TextView date;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            amount = view.findViewById(R.id.value);
           // date = view.findViewById(R.id.date);
        }
    }




    @Override
    public GoalsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.goal_row_item, parent, false);

        return new GoalsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GoalsAdapter.MyViewHolder holder, final int position) {
        final Goal goal = goals.get(position);
        holder.name.setText(goal.getName());
        holder.amount.setText(goal.getAmount()+"$");
        //holder.date.setText("10-09-2019");

    }

    @Override
    public int getItemCount() {
        return goals.size();
    }

}