package com.example.hack2hire.view;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;


import com.example.hack2hire.R;
import com.example.hack2hire.adapters.TransactionsAdapter;
import com.example.hack2hire.model.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionsActivity extends AppCompatActivity {

    private static final String TAG = "TransactionsActivity";
    private RecyclerView recyclerView;
    private ArrayList<Transaction> transactionsList;
    private TransactionsAdapter mAdapter;
    private SearchView searchView;
    private ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);
         pd = new ProgressDialog(getApplicationContext());



        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        transactionsList = new ArrayList<>();
        mAdapter = new TransactionsAdapter(this, transactionsList);



        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 36));
        recyclerView.setAdapter(mAdapter);

        fetchContacts();
    }

    private void fetchContacts() {

        List<Transaction> mockTransactionsList = getMockTransactionsList();
        transactionsList.clear();
        transactionsList.addAll(mockTransactionsList);
        mAdapter.notifyDataSetChanged();




    }

    private List<Transaction> getMockTransactionsList() {
        ArrayList<Transaction> transactions = new ArrayList<>();

            Date date =new Date();
        transactions.add(new Transaction("Buy Coat",500,date));
        transactions.add(new Transaction("Spending on Travel",9000,date));
        transactions.add(new Transaction("Buy Watch",7800,date));

        transactions.add(new Transaction("Biryani",2300,date));;

        return transactions;
    }

    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.WHITE);
        }
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
       // searchView.setVisibility(View.GONE);

        return true;
    }

    private void showProgress()
    {

        pd.setMessage("loading");
        pd.show();

    }
    private void dismissProgress()
    {

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
}
