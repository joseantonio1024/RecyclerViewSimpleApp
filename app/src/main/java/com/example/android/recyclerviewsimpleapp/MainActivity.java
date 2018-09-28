package com.example.android.recyclerviewsimpleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NombreAdapter.ListItemClickListener{
    private static final int LIST_ITEMS = 100;
    private NombreAdapter mAdapter;
    private RecyclerView mNombreList;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNombreList = (RecyclerView)findViewById(R.id.rv_nombre);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNombreList.setLayoutManager(layoutManager);
        mNombreList.setHasFixedSize(true);
        mAdapter = new NombreAdapter(LIST_ITEMS,this);
        mNombreList.setAdapter(mAdapter);
    }



    // COMPLETED (10) Override ListItemClickListener's onListItemClick method
    /**
     * This is where we receive our callback from
     * {@link com.example.android.recyclerviewsimpleapp.NombreAdapter.ListItemClickListener}
     *
     * This callback is invoked when you click on an item in the list.
     *
     * @param clickedItemIndex Index in the list of the item that was clicked.
     */
    @Override
    public void onListItemClick(int clickedItemIndex) {
        // COMPLETED (11) In the beginning of the method, cancel the Toast if it isn't null
        /*
         * Even if a Toast isn't showing, it's okay to cancel it. Doing so
         * ensures that our new Toast will show immediately, rather than
         * being delayed while other pending Toasts are shown.
         *
         * Comment out these three lines, run the app, and click on a bunch of
         * different items if you're not sure what I'm talking about.
         */
        if (mToast != null) {
            mToast.cancel();
        }

        // COMPLETED (12) Show a Toast when an item is clicked, displaying that item number that was clicked
        /*
         * Create a Toast and store it in our Toast field.
         * The Toast that shows up will have a message similar to the following:
         *
         *                     Item #42 clicked.
         */
        String toastMessage = "Item #" + clickedItemIndex + " clicked.";
        mToast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);

        mToast.show();
    }
}
