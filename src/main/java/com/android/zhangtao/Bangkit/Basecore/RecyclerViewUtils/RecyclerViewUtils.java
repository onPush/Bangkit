package com.android.zhangtao.Bangkit.Basecore.RecyclerViewUtils;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class RecyclerViewUtils {

    public static final int HORIZONTAL = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL = LinearLayoutManager.VERTICAL;

    private RecyclerViewUtils() {
    }


    public static void setLinearManagerAndAdapter(RecyclerView recyclerView,
                                                  RecyclerView.Adapter adapter) {
        setLinearManagerAndAdapter(recyclerView, adapter, LinearLayoutManager.VERTICAL);
    }

    public static void setLinearManagerAndAdapter(RecyclerView recyclerView,
                                                  RecyclerView.Adapter adapter, int orientation) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        linearLayoutManager.setOrientation(orientation);
        linearLayoutManager.setRecycleChildrenOnDetach(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }


    public static void setGridManagerAndAdapter(RecyclerView recyclerView,
                                                RecyclerView.Adapter adapter, int spanCount) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), spanCount);
        gridLayoutManager.setOrientation(VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
    /**
     * 设置HeaderView
     *
     * @param recyclerView
     * @param view
     */
//    public static void setHeaderView(RecyclerView recyclerView, View view) {
//        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();
//
//        if (outerAdapter == null || !(outerAdapter instanceof HeaderAndFooterRecyclerViewAdapter)) {
//            return;
//        }
//
//        HeaderAndFooterRecyclerViewAdapter headerAndFooterAdapter = (HeaderAndFooterRecyclerViewAdapter) outerAdapter;
//        if (headerAndFooterAdapter.getHeaderViewsCount() == 0) {
//            headerAndFooterAdapter.addHeaderView(view);
//        }
//    }
//
//    /**
//     * 设置FooterView
//     *
//     * @param recyclerView
//     * @param view
//     */
//    public static void setFooterView(RecyclerView recyclerView, View view) {
//        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();
//
//        if (outerAdapter == null || !(outerAdapter instanceof HeaderAndFooterRecyclerViewAdapter)) {
//            return;
//        }
//
//        HeaderAndFooterRecyclerViewAdapter headerAndFooterAdapter = (HeaderAndFooterRecyclerViewAdapter) outerAdapter;
//        if (headerAndFooterAdapter.getFooterViewsCount() == 0) {
//            headerAndFooterAdapter.addFooterView(view);
//        }
//    }
//
//    /**
//     * 移除FooterView
//     *
//     * @param recyclerView
//     */
//    public static void removeFooterView(RecyclerView recyclerView) {
//
//        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();
//
//        if (outerAdapter != null && outerAdapter instanceof HeaderAndFooterRecyclerViewAdapter) {
//
//            int footerViewCounter = ((HeaderAndFooterRecyclerViewAdapter) outerAdapter).getFooterViewsCount();
//            if (footerViewCounter > 0) {
//                View footerView = ((HeaderAndFooterRecyclerViewAdapter) outerAdapter).getFooterView();
//                ((HeaderAndFooterRecyclerViewAdapter) outerAdapter).removeFooterView(footerView);
//            }
//        }
//    }
//
//    /**
//     * 移除HeaderView
//     *
//     * @param recyclerView
//     */
//    public static void removeHeaderView(RecyclerView recyclerView) {
//
//        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();
//
//        if (outerAdapter != null && outerAdapter instanceof HeaderAndFooterRecyclerViewAdapter) {
//
//            int headerViewCounter = ((HeaderAndFooterRecyclerViewAdapter) outerAdapter).getHeaderViewsCount();
//            if (headerViewCounter > 0) {
//                View headerView = ((HeaderAndFooterRecyclerViewAdapter) outerAdapter).getHeaderView();
//                ((HeaderAndFooterRecyclerViewAdapter) outerAdapter).removeFooterView(headerView);
//            }
//        }
//    }
//
//    /**
//     * 请使用本方法替代RecyclerView.ViewHolder的getLayoutPosition()方法
//     *
//     * @param recyclerView
//     * @param holder
//     * @return
//     */
//    public static int getLayoutPosition(RecyclerView recyclerView, RecyclerView.ViewHolder holder) {
//        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();
//        if (outerAdapter != null && outerAdapter instanceof HeaderAndFooterRecyclerViewAdapter) {
//
//            int headerViewCounter = ((HeaderAndFooterRecyclerViewAdapter) outerAdapter).getHeaderViewsCount();
//            if (headerViewCounter > 0) {
//                return holder.getLayoutPosition() - headerViewCounter;
//            }
//        }
//
//        return holder.getLayoutPosition();
//    }
//
//    /**
//     * 请使用本方法替代RecyclerView.ViewHolder的getAdapterPosition()方法
//     *
//     * @param recyclerView
//     * @param holder
//     * @return
//     */
//    public static int getAdapterPosition(RecyclerView recyclerView, RecyclerView.ViewHolder holder) {
//        RecyclerView.Adapter outerAdapter = recyclerView.getAdapter();
//        if (outerAdapter != null && outerAdapter instanceof HeaderAndFooterRecyclerViewAdapter) {
//
//            int headerViewCounter = ((HeaderAndFooterRecyclerViewAdapter) outerAdapter).getHeaderViewsCount();
//            if (headerViewCounter > 0) {
//                return holder.getAdapterPosition() - headerViewCounter;
//            }
//        }
//
//        return holder.getAdapterPosition();
//    }
//}
