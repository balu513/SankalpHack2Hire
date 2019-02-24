package com.example.hack2hire.view;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hack2hire.CustomDialogClass;
import com.example.hack2hire.R;
import com.example.hack2hire.adapters.GoalsAdapter;
import com.example.hack2hire.adapters.TransactionsAdapter;
import com.example.hack2hire.model.Goal;
import com.example.hack2hire.model.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoalsActivity extends AppCompatActivity  {

    private static final String TAG = "TransactionsActivity";
    private RecyclerView recyclerView;
    private ArrayList<Goal> goalList;
    private GoalsAdapter mAdapter;
    private SearchView searchView;
    private ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
        pd = new ProgressDialog(getApplicationContext());

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_goals);
        goalList = new ArrayList<>();
        mAdapter = new GoalsAdapter(this, goalList);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 36));
        recyclerView.setAdapter(mAdapter);


        ((ImageView)findViewById(R.id.add)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialogClass cdd=new CustomDialogClass(GoalsActivity.this);
                cdd.show();
            }
        });

        fetchGoals();
        mAdapter.notifyDataSetChanged();
    }

    private void fetchGoals() {

        List<Goal> mockGoals = getMockGoals();
        goalList.clear();
        goalList.addAll(mockGoals);
       // mAdapter.notifyDataSetChanged();


    }


    private List<Goal> getMockGoals() {
        ArrayList<Goal> goals = new ArrayList<>();

        goals.add(new Goal("Buying Home",3002));
        goals.add(new Goal("Buying Car",100000));
        goals.add(new Goal("Paying for School",15000));
        goals.add(new Goal("iPhone X",75000));
        return goals;
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_search, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);


        return true;
    }


    @Override
    public void onBackPressed() {
        // close search view on back button pressed
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }

    class CustomDialogClass extends Dialog implements
            android.view.View.OnClickListener {

        public Activity c;
        public Dialog d;
        public Button yes, no;
        public EditText etGoal,etGoalValue;

        public CustomDialogClass(Activity a) {
            super(a);
            // TODO Auto-generated constructor stub
            this.c = a;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.payment_dialogue);
            yes = (Button) findViewById(R.id.btn_yes);
            no = (Button) findViewById(R.id.btn_no);
            etGoal= (EditText)findViewById(R.id.goal);
            etGoalValue= (EditText)findViewById(R.id.value);
            yes.setOnClickListener(this);
            no.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_yes:
                    Toast.makeText(c, "Added Goal Successfully",Toast.LENGTH_SHORT).show();
                    List<Goal> newList = new ArrayList<Goal>();
                    newList.addAll(goalList);
                    long value = Long.parseLong(etGoalValue.getText().toString());
                    newList.add(new Goal(etGoal.getText().toString(),value));
                    goalList.clear();
                    goalList.addAll(newList);
                    mAdapter.notifyDataSetChanged();

                    //c.finish();
                    break;
                case R.id.btn_no:
                    dismiss();
                    break;
                default:
                    break;
            }
            dismiss();
        }
    }
}
