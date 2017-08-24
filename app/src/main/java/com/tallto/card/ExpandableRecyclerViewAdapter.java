package com.tallto.card;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

class ExpandableRecyclerViewAdapter extends RecyclerView.Adapter<BindingViewHolder> {
    private static final String TAG = ExpandableRecyclerViewAdapter.class.getSimpleName();
    private ValueAnimator marginAnimator = ValueAnimator.ofFloat(16, 2);

    private List<CardItem> data = new ArrayList<>();
    private boolean isListExpanded;

    ExpandableRecyclerViewAdapter(List<CardItem> originData) {
        this.data = originData;
        marginAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                for (CardItem m :
                        data) {
                    m.setMargin(((Float) animation.getAnimatedValue()).intValue());
                }
            }
        });
        marginAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
//                isListExpanded = !isListExpanded;
            }
        });
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BindingViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.rv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(final BindingViewHolder holder, int position) {
        holder.getBinding().setVariable(BR.item,data.get(holder.getAdapterPosition()));
        holder.getBinding().setVariable(BR.isLast,holder.getAdapterPosition()==data.size()-1);
        holder.getBinding().setVariable(BR.isFirst,holder.getAdapterPosition()==0);
        holder.getBinding().setVariable(BR.onClick, new ClickAdapter() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                data.get(holder.getAdapterPosition()).setExpanded(!data.get(holder.getAdapterPosition()).isExpanded());
                invalidateExpandedState();
            }
        });

        holder.getBinding().setVariable(BR.onCheckBalance, new ClickCheckBalanceAdapter(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "checkBalanceCardMsg: ");
                checkCardMsg(data.get(holder.getAdapterPosition()));
            }
        });

        holder.getBinding().setVariable(BR.onCheckBill, new ClickCheckBillAdapter(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "checkBillCardMsg: ");
                checkCardMsg(data.get(holder.getAdapterPosition()));
            }
        });


        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private void invalidateExpandedState(){
        boolean isAnyExpanded = false;
        for (CardItem item :
                data) {
            isAnyExpanded = isAnyExpanded || item.isExpanded();
        }

        if (isListExpanded != isAnyExpanded){
            if (!isAnyExpanded) {
                isListExpanded = false;
                marginAnimator.start();
            }
            else {
                isListExpanded = true;
                marginAnimator.reverse();
            }
        }
    }

    private void checkCardMsg(CardItem item){
//        for (item : data) {
//            data.get(holder.getAdapterPosition())
            Log.e(TAG,"this title = " + item.getBankName());
//        }
    }
}
