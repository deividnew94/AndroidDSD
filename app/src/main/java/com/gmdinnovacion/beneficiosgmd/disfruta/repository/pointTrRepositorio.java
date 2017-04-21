package com.gmdinnovacion.beneficiosgmd.disfruta.repository;

import android.content.Context;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.Point;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.PointDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by innovagmd on 06/09/16.
 */
public class pointTrRepositorio {
    public static void insertOrUpdate(Context context, Point Usuario) {
       // clearUsuarios(context);
        //getPointDao(context).insertOrReplace(Usuario);
    }
    public static void clearUsuarios(Context context) {

        //getPointDao(context).deleteAll();
    }

    private static PointDao getPointDao(Context c) {
        //return ((concarSOS) c.getApplicationContext()).getDaoSession().getPointDao();
        return null;
    }
    public static Point getUsersForId(Context context, long id) {
        //return getPointDao(context).loadByRowId(id);
        return null;
    }
    /*
    public static User getUsersForName(Context context, String name){

        QueryBuilder qb = getUserDao(context).queryBuilder().where(UserDao.Properties.Usuario.eq("fids"));
        return qb.l
    }*/
    public static List<Point> getAllPoints(Context context) {
//        restaurante   1
//        servicios y productos 2
//        cafeteria 3
//        jugueria  4
//        salud y belleza   5
//        arte y cultura    6

        List<Point> lstPoint = new ArrayList<>();
        lstPoint.add(new Point((long) 1,1,"-12.05633549","-77.03691937","",""));//pinkberry
        lstPoint.add(new Point((long) 1,2,"-12.0586936","-77.04232872","",""));//choza nautica breña
        lstPoint.add(new Point((long) 3,3,"-12.0469989","-77.0320589","",""));//starbucks
        lstPoint.add(new Point((long) 3,4,"-12.0492069","-77.032209","",""));//lima cafe
        lstPoint.add(new Point((long) 1,5,"-12.04517288","-77.03159988","",""));//tanta
        lstPoint.add(new Point((long) 5,6,"-12.04823278","-77.03855116","",""));//montalvo
        lstPoint.add(new Point((long) 6,7,"-12.0453848","-77.0348665","",""));//teatro municipal
        lstPoint.add(new Point((long) 2,8,"-12.050689","-77.034651","",""));//rustica
        lstPoint.add(new Point((long) 4,9,"-12.056878","-77.037235","",""));//frutix

         //return getPointDao(context).queryBuilder().orderDesc(PointDao.Properties.Id).limit(1).list();
        return lstPoint;
    }
    public static void deleteUserWithId(Context context, long id) {
        //getPointDao(context).delete(getUsersForId(context, id));
    }
}
