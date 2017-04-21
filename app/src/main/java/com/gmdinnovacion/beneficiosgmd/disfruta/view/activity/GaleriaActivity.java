package com.gmdinnovacion.beneficiosgmd.disfruta.view.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.DetalleGaleria;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter.AdapterGaleria;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GaleriaActivity extends AppCompatActivity {

    @BindView(R.id.rcvListRequestGaleria)
    RecyclerView rcvListRequestGaleria;

    GridLayoutManager lLayout;
    Context contexr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);
        setTitle("Galería");
        ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_galeria, menu);
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();

        //cargar el Adapter
        List<DetalleGaleria> rowListItem = getAllItemList();

        lLayout = new GridLayoutManager(contexr, 1);
        rcvListRequestGaleria.setLayoutManager(lLayout);
        AdapterGaleria rcAdapter = new AdapterGaleria(rowListItem,this);
        rcvListRequestGaleria.setAdapter(rcAdapter);

    }

    public List <DetalleGaleria> getAllItemList() {
        List<DetalleGaleria> allItems = new ArrayList<DetalleGaleria>();
        allItems.add(new DetalleGaleria("http://cdn.logitravel.com/wsimgresize/resize/crop/350/230/cdn.logitravel.com/microsites/logicms/images/cruceros/201508/maasdam_-gourmet.jpg", "Fiesta Gourmet Restaurant"));
        allItems.add(new DetalleGaleria("https://dietas.ninja/imagenes/ejemplo-de-comida-para-dieta-vegetariana-para-engordar-350x230.jpg", "Restaurant"));
        allItems.add(new DetalleGaleria("http://momentocomida.com.br/wp-content/uploads/2015/06/macarronada-caseira-momento-comida-350x230.jpg","Fiesta"));
        allItems.add(new DetalleGaleria("http://www.viajehotelescuba.com/data/hotels/hotel-pullman-cayo-coco_5.jpg","Fiesta Gourmet Restaurant"));
        allItems.add(new DetalleGaleria("http://www.facilfood.cl/kcfinder/upload/images/original/recetas/tomates-rellenos-con-choclo-123-350x230.jpg", "Fiesta Gourmet Restaurant Lomo"));
        allItems.add(new DetalleGaleria("http://tucocinafacil.net/wp-content/uploads/2009/03/ensaladadelaisla-350x230.jpg", "Fiesta Gourmet Restaurant"));

        return allItems;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
//            case R.id.logOut:
//                Toast.makeText(getApplicationContext(), "Prueba LogOut", Toast.LENGTH_LONG).show();
//                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
    }


}
