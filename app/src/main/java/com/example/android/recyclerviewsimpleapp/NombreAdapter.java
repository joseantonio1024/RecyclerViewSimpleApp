package com.example.android.recyclerviewsimpleapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NombreAdapter extends RecyclerView.Adapter<NombreAdapter.NombreViewHolder>{
    private int mNumberItems;
    private ListItemClickListener mOnClickListener;

    public NombreAdapter(int numberOfItems, ListItemClickListener listener){
        mNumberItems = numberOfItems;
        mOnClickListener = listener;
    }

    @Override
    public NombreViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.nombre_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, viewGroup,shouldAttachToParentImmediately);
        NombreViewHolder viewHolder = new NombreViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NombreViewHolder holder, int position){
        holder.bind(position);
    }

    @Override
    public int getItemCount(){
        return mNumberItems;
    }




    ////////////////////////////////////////////////////////////////////////////////////////////////
    class NombreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView listItemNombreView;
        public NombreViewHolder(View itemView) {
            super(itemView);
            listItemNombreView = (TextView) itemView.findViewById(R.id.tv_item_nombre);
            itemView.setOnClickListener(this);//respond to item clicks.
        }
        void bind(int listIndex){
            listItemNombreView.setText(String.valueOf(listIndex));
        }

        @Override
        public void onClick(View view){
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }

    }// End class NombreViewHolder.



    ////////////////////////////////////////////////////////////////////////////////////////////////
    public interface ListItemClickListener{
        void onListItemClick(int clickedItemIndex);
    }//End interface ListItemClickListener.

}// End class NombreAdapter.
