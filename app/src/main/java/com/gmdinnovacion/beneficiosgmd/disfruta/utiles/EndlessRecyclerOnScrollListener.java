package com.gmdinnovacion.beneficiosgmd.disfruta.utiles;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by innovagmd on 09/01/17.
 * Clase para paginacion
 */

public abstract class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener {
    public static String TAG = EndlessRecyclerOnScrollListener.class.getSimpleName();

    private int previousTotal = 0; //
    //El número total de elementos del conjunto de datos después de la última carga
    private boolean loading = true; //
  //  Es cierto si todavía estamos esperando el último conjunto de datos para cargar.
    private int visibleThreshold = 5; //
  //  La cantidad mínima de elementos que debe tener por debajo de la posición de desplazamiento actual antes de cargar más.
    int firstVisibleItem, visibleItemCount, totalItemCount;

    private int current_page = 0;

    private LinearLayoutManager mLinearLayoutManager;

    public EndlessRecyclerOnScrollListener(LinearLayoutManager linearLayoutManager, Integer visibleThreshold) {
        this.mLinearLayoutManager = linearLayoutManager;
        this.visibleThreshold=visibleThreshold;
    }
    public EndlessRecyclerOnScrollListener(LinearLayoutManager linearLayoutManager) {
        this.mLinearLayoutManager = linearLayoutManager;

    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = mLinearLayoutManager.getItemCount();
        firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();

        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;
            }
        }
        if (!loading && (totalItemCount - visibleItemCount)
                <= (firstVisibleItem + visibleThreshold)) {
            // End has been reached

            // Do something
            current_page++;

            onLoadMore(current_page);

            loading = true;
        }
    }

    public abstract void onLoadMore(int current_page);
}