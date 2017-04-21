package com.gmdinnovacion.beneficiosgmd.disfruta.repository;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.DetalleDescuentoRepositorio;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.DetalleProveedor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jsaenz on 19/1/2017.
 */

public class ElementosPruebaRepositorio {
    public List<DetalleDescuentoRepositorio> getAllItemListDetalleDescuento() {
        List<DetalleDescuentoRepositorio> allItems = new ArrayList<>();

        allItems.add(new DetalleDescuentoRepositorio(1,"https://fh-uploads-hzscjv5a1k85do6fzz7kdmffiwhxul5bcoakysrttzf.netdna-ssl.com/92a1f541-57df-4066-85d2-80f44f36b375", "Pinkberry - Real Plaza","RESTAURANTE",true,(float) 4.0,"4.0","ABIERTO","a - 500M Cercado Lima", "8:60", "80",1));//pinkberry
        allItems.add(new DetalleDescuentoRepositorio(2,"https://lh5.googleusercontent.com/-ToZpbBAztQE/WCjTcRKIw0I/AAAAAAAAAps/_Tl9ZpPynKcoK-lLm1-f5MoUwGAwYWH0wCLIB/s408-k-no/", "La Choza Nautica Breña","RESTAURANTE",false,(float) 4.5,"4.5","ABIERTO","a - 100M Braña", "8:60", "60",1));//La Choza Nautica Breña
        allItems.add(new DetalleDescuentoRepositorio(3,"http://www.starbucks.com.pe/media/coffeehouse-landing_tcm92-16606_w1024_n.jpg", "Starbucks - Centro de Lima","CAFETERÍA",true,(float) 4.3,"4.3","ABIERTO","a - 1km Cercado Lima", "8:60", "50",1));//starbucks
        allItems.add(new DetalleDescuentoRepositorio(4,"https://lh5.googleusercontent.com/-dQMlrVbL_HE/WDPLsWQoRjI/AAAAAAAANAc/Aop0l7vP4To10jsV46VyTkRXBfMmqSDLgCLIB/s408-k-no/", "Lima Café","CAFETERÍA",false,(float) 4.0,"4.0","ABIERTO","a - 2km Cercado Lima", "8:60", "40",1));//lima cafe
        allItems.add(new DetalleDescuentoRepositorio(5,"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSSCdeh-ilHLB-SyQP3BKR3IFBYVzfRCyweCKozTLcqtY5azJE_", "Tanta - Centro de Lima","RESTAURANTE",false,(float) 4.0,"4.0","ABIERTO","a - 300M Cercado Lima", "8:60", "45",1));//tanta
        allItems.add(new DetalleDescuentoRepositorio(6,"http://us.media.fashionnetwork.com/m/adb4/0960/fa47/6050/4447/84ce/5110/f488/bc0d/f212/650x1019.60/f212.jpg", "Montalvo - Centro de Lima","SALUD Y BELLEZA",true,(float) 4.6,"4.6","ABIERTO","a - 3km Cercado Lima", "8:60", "35",1));//montalvo
        allItems.add(new DetalleDescuentoRepositorio(7,"http://www.culturalalbacete.com/corps/culturalalbacete/data/resources/image/2016/Feria%20de%20Teatro/flamenco%20brothers.jpg", "Teatro Municipal de Lima","ARTE Y CULTURA",false,(float) 4.6,"4.6","ABIERTO","a - 4km Cercado Lima", "8:60", "20",1));//teatro municipal
        allItems.add(new DetalleDescuentoRepositorio(8,"http://revista.pricetravel.com.mx/wp-content/uploads/carsanper/2015/07/png/Restaurantes-m%C3%A1s-famosos-del-mundo-e1440278468629.png", "Rústica - Centro de Lima","SERVICIOS Y PRODUCTOS",false,(float) 3.5,"3.5","ABIERTO","a - 200M Cercado Lima", "8:60", "15",1));//pinkberry
        allItems.add(new DetalleDescuentoRepositorio(9,"http://www.designwithpurpose.ca/wp-content/uploads/2015/03/Mega.jpg", "Frutix - Real Plaza Centro Cívico","JUGUERÍA",true,(float) 4.0,"4.0","ABIERTO","a - 100M Cercado Lima", "8:60", "60",1));//pinkberry

        return allItems;
    }

    public List<String> listaGaleria (String categoriaPro){
        List<String> listaGaleriaResult = new ArrayList<>();
        if(categoriaPro.equalsIgnoreCase("1")){
            listaGaleriaResult.add("http://static.notinerd.com/wp-content/uploads/2014/05/771.jpg");
            listaGaleriaResult.add("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSSCdeh-ilHLB-SyQP3BKR3IFBYVzfRCyweCKozTLcqtY5azJE_");
            listaGaleriaResult.add("http://revista.pricetravel.com.mx/wp-content/uploads/carsanper/2015/07/png/Restaurantes-m%C3%A1s-famosos-del-mundo-e1440278468629.png");
            listaGaleriaResult.add("https://media-cdn.tripadvisor.com/media/photo-s/07/0f/7e/ba/a-punto-parrilla-restaurante.jpg");
            listaGaleriaResult.add("https://media-cdn.tripadvisor.com/media/photo-s/06/14/44/ac/getlstd-property-photo.jpg");
            listaGaleriaResult.add("http://static.notinerd.com/wp-content/uploads/2014/05/771.jpg");
            listaGaleriaResult.add("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSSCdeh-ilHLB-SyQP3BKR3IFBYVzfRCyweCKozTLcqtY5azJE_");
            listaGaleriaResult.add("http://revista.pricetravel.com.mx/wp-content/uploads/carsanper/2015/07/png/Restaurantes-m%C3%A1s-famosos-del-mundo-e1440278468629.png");
            listaGaleriaResult.add("https://media-cdn.tripadvisor.com/media/photo-s/07/0f/7e/ba/a-punto-parrilla-restaurante.jpg");
            listaGaleriaResult.add("https://media-cdn.tripadvisor.com/media/photo-s/06/14/44/ac/getlstd-property-photo.jpg");
        }else{
            listaGaleriaResult.add("http://static.notinerd.com/wp-content/uploads/2014/05/771.jpg");
            listaGaleriaResult.add("https://media-cdn.tripadvisor.com/media/photo-s/06/14/44/ac/getlstd-property-photo.jpg");
            listaGaleriaResult.add("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSSCdeh-ilHLB-SyQP3BKR3IFBYVzfRCyweCKozTLcqtY5azJE_");
            listaGaleriaResult.add("https://media-cdn.tripadvisor.com/media/photo-s/07/0f/7e/ba/a-punto-parrilla-restaurante.jpg");
            listaGaleriaResult.add("https://media-cdn.tripadvisor.com/media/photo-s/06/14/44/ac/getlstd-property-photo.jpg");
            listaGaleriaResult.add("http://revista.pricetravel.com.mx/wp-content/uploads/carsanper/2015/07/png/Restaurantes-m%C3%A1s-famosos-del-mundo-e1440278468629.png");
            listaGaleriaResult.add("http://static.notinerd.com/wp-content/uploads/2014/05/771.jpg");
            listaGaleriaResult.add("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSSCdeh-ilHLB-SyQP3BKR3IFBYVzfRCyweCKozTLcqtY5azJE_");
            listaGaleriaResult.add("https://media-cdn.tripadvisor.com/media/photo-s/07/0f/7e/ba/a-punto-parrilla-restaurante.jpg");
            listaGaleriaResult.add("http://revista.pricetravel.com.mx/wp-content/uploads/carsanper/2015/07/png/Restaurantes-m%C3%A1s-famosos-del-mundo-e1440278468629.png");
        }


        return listaGaleriaResult;
    }

    public List<DetalleProveedor> listDetalleProveedorLista (){
        List<DetalleProveedor> newListDetalleProv = new ArrayList<DetalleProveedor>();

        DetalleProveedor objDetProveedor1 = new DetalleProveedor();
        objDetProveedor1.setIdProveedor(1);
        objDetProveedor1.setPhotoRestaurante("https://fh-uploads-hzscjv5a1k85do6fzz7kdmffiwhxul5bcoakysrttzf.netdna-ssl.com/92a1f541-57df-4066-85d2-80f44f36b375");
        objDetProveedor1.setNombreRestaurante("Pinkberry");
        objDetProveedor1.setCategoria("Restaurante");
        objDetProveedor1.setDireccion("Garcilaso De La Vega 1337");
        objDetProveedor1.setDistrito("Cercado de Lima");
        objDetProveedor1.setAppCompatRatingBarDcto((float) 4.5);
        objDetProveedor1.setRatingText("4.5");
        objDetProveedor1.setTelefonos("800-600");
        objDetProveedor1.setAbierto("ABIERTO");
        objDetProveedor1.setUrlWeb("www.pinkberry.com.pe");
        objDetProveedor1.setLatitud("-12.05633549");
        objDetProveedor1.setLongitud("-77.03691937");
        objDetProveedor1.setDescripcion("Pinkberry, líder en frozen yogurt, lanza nuevo dúo de sabores para esta temporada y un Pinkberry Deluxe para que los Pinkberry lovers puedan darse un gustito perfecto en cualquier momento del día. ");
        objDetProveedor1.setReservas("NO");
        objDetProveedor1.setTarjetasCredito("SI");
        objDetProveedor1.setWifi("SI");
        objDetProveedor1.setEstacionamiento("NO");
        objDetProveedor1.setHoraDscto("0");

        newListDetalleProv.add(objDetProveedor1);

        DetalleProveedor objProveedor2 = new DetalleProveedor();
        objProveedor2.setIdProveedor(2);
        objProveedor2.setPhotoRestaurante("https://lh5.googleusercontent.com/-ToZpbBAztQE/WCjTcRKIw0I/AAAAAAAAAps/_Tl9ZpPynKcoK-lLm1-f5MoUwGAwYWH0wCLIB/s408-k-no/");
        objProveedor2.setNombreRestaurante("La Choza Nautica Breña");
        objProveedor2.setCategoria("Restaurante");
        objProveedor2.setDireccion("Breña 204, Distrito de Lima 15082");
        objProveedor2.setDistrito("Breña");
        objProveedor2.setAppCompatRatingBarDcto((float) 4.5);
        objProveedor2.setRatingText("4.5");
        objProveedor2.setTelefonos("268-1598");
        objProveedor2.setUrlWeb("bookersnap.com/LaChozaNautica");
        objProveedor2.setAbierto("ABIERTO");
        objProveedor2.setLatitud("-12.0586936");
        objProveedor2.setLongitud("-77.04232872");
        objProveedor2.setDescripcion("Si compraste cupones o boletos, o quieres asistir por tu cumpleaños y/o visita casual, realiza una reserva para mejorar tu atención.");
        objProveedor2.setReservas("SI");
        objProveedor2.setTarjetasCredito("SI");
        objProveedor2.setWifi("SI");
        objProveedor2.setEstacionamiento("SI");
        objProveedor2.setHoraDscto("0");

        newListDetalleProv.add(objProveedor2);


        DetalleProveedor objProveedor3 = new DetalleProveedor();
        objProveedor3.setIdProveedor(3);
        objProveedor3.setPhotoRestaurante("http://www.starbucks.com.pe/media/coffeehouse-landing_tcm92-16606_w1024_n.jpg");
        objProveedor3.setNombreRestaurante("Starbucks");
        objProveedor3.setCategoria("Cafetería");
        objProveedor3.setDireccion("Jirón de la Unión 498, Distrito de Lima 15001");
        objProveedor3.setDistrito("Cercado de Lima");
        objProveedor3.setAppCompatRatingBarDcto((float) 4.2);
        objProveedor3.setRatingText("4.2");
        objProveedor3.setTelefonos("505-5000");
        objProveedor3.setUrlWeb("www.starbucks.com.pe");
        objProveedor3.setAbierto("ABIERTO");
        objProveedor3.setLatitud("-12.0469989");
        objProveedor3.setLongitud("-77.0320589");
        objProveedor3.setDescripcion("Nos apasiona nuestra labor de abastecedores de café, así como todo lo relacionado con el disfrute de una experiencia gratificante en una de nuestras tiendas. ");
        objProveedor3.setReservas("NO");
        objProveedor3.setTarjetasCredito("SI");
        objProveedor3.setWifi("SI");
        objProveedor3.setEstacionamiento("NO");
        objProveedor3.setHoraDscto("0");
        newListDetalleProv.add(objProveedor3);

        DetalleProveedor objProveedor4 = new DetalleProveedor();
        objProveedor4.setIdProveedor(4);
        objProveedor4.setPhotoRestaurante("https://lh5.googleusercontent.com/-dQMlrVbL_HE/WDPLsWQoRjI/AAAAAAAANAc/Aop0l7vP4To10jsV46VyTkRXBfMmqSDLgCLIB/s408-k-no/");
        objProveedor4.setNombreRestaurante("Lima café");
        objProveedor4.setCategoria("Cafetería");
        objProveedor4.setDireccion("Jirón Camaná 758, Distrito de Lima 15001");
        objProveedor4.setDistrito("Cercado de Lima");
        objProveedor4.setAppCompatRatingBarDcto((float) 4.3);
        objProveedor4.setRatingText("4.3");
        objProveedor4.setTelefonos("428-4658");
        objProveedor4.setUrlWeb("https://es-la.facebook.com/LIMA-CAFE-225053500856713/");
        objProveedor4.setAbierto("ABIERTO");
        objProveedor4.setLatitud("-12.0492069");
        objProveedor4.setLongitud("-77.032209");
        objProveedor4.setDescripcion("Disfruta lo mejor de café y más  - Sirve desayuno, almuerzo, cena, café y bebidas");
        objProveedor4.setReservas("NO");
        objProveedor4.setTarjetasCredito("SI");
        objProveedor4.setWifi("SI");
        objProveedor4.setEstacionamiento("NO");
        objProveedor4.setHoraDscto("0");
        newListDetalleProv.add(objProveedor4);

        DetalleProveedor objProveedor5 = new DetalleProveedor();
        objProveedor5.setIdProveedor(5);
        objProveedor5.setPhotoRestaurante("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSSCdeh-ilHLB-SyQP3BKR3IFBYVzfRCyweCKozTLcqtY5azJE_");
        objProveedor5.setNombreRestaurante("Tanta");
        objProveedor5.setCategoria("Restaurante");
        objProveedor5.setDireccion("Nicolás de Rivera 142, Distrito de Lima 15001");
        objProveedor5.setDistrito("Cercado de Lima");
        objProveedor5.setAppCompatRatingBarDcto((float) 4.0);
        objProveedor5.setRatingText("4");
        objProveedor5.setTelefonos("428-3115");
        objProveedor5.setUrlWeb("http://tantaperu.com/");
        objProveedor5.setAbierto("ABIERTO");
        objProveedor5.setLatitud("-12.04517288");
        objProveedor5.setLongitud("-77.03159988");
        objProveedor5.setDescripcion("Tanta es tu sala, comedor o terraza. Celebramos en familia la cocina y su diversidad, sobre todo la comida casera peruana, esa comida que nos han preparado nuestras madres y abuelas toda la vida.");
        objProveedor5.setReservas("NO");
        objProveedor5.setTarjetasCredito("SI");
        objProveedor5.setWifi("SI");
        objProveedor5.setEstacionamiento("NO");
        objProveedor5.setHoraDscto("0");
        newListDetalleProv.add(objProveedor5);

        DetalleProveedor objProveedor6 = new DetalleProveedor();
        objProveedor6.setIdProveedor(6);
        objProveedor6.setPhotoRestaurante("http://us.media.fashionnetwork.com/m/adb4/0960/fa47/6050/4447/84ce/5110/f488/bc0d/f212/650x1019.60/f212.jpg");
        objProveedor6.setNombreRestaurante("Montalvo");
        objProveedor6.setCategoria("Salud y Belleza");
        objProveedor6.setDireccion("Av. Tacna 677, Lima 15001");
        objProveedor6.setDistrito("Cercado de Lima");
        objProveedor6.setAppCompatRatingBarDcto((float) 4.6);
        objProveedor6.setRatingText("4.6");
        objProveedor6.setTelefonos("428-3115");
        objProveedor6.setUrlWeb("www.montalvospa.com/");
        objProveedor6.setAbierto("ABIERTO");
        objProveedor6.setLatitud("-12.04823278");
        objProveedor6.setLongitud("-77.03855116");
        objProveedor6.setDescripcion("Renuévate con los mejores estilistas del país en Montalvo Salón & Spa, donde recibirás un servicio completo para un cambio de imagen ideal.");
        objProveedor6.setReservas("SI");
        objProveedor6.setTarjetasCredito("SI");
        objProveedor6.setWifi("SI");
        objProveedor6.setEstacionamiento("NO");
        objProveedor6.setHoraDscto("0");
        newListDetalleProv.add(objProveedor6);

        DetalleProveedor objProveedor7 = new DetalleProveedor();
        objProveedor7.setIdProveedor(7);
        objProveedor7.setPhotoRestaurante("http://www.culturalalbacete.com/corps/culturalalbacete/data/resources/image/2016/Feria%20de%20Teatro/flamenco%20brothers.jpg");
        objProveedor7.setNombreRestaurante("Teatro Municipal de Lima");
        objProveedor7.setCategoria("Arte y Cultura");
        objProveedor7.setDireccion("Jirón Ica 377, Distrito de Lima 15001");
        objProveedor7.setDistrito("Cercado de Lima");
        objProveedor7.setAppCompatRatingBarDcto((float) 4.6);
        objProveedor7.setRatingText("4.6");
        objProveedor7.setTelefonos("125 9598");
        objProveedor7.setUrlWeb("http://www.limacultura.pe/teatros/teatro-municipal-de-lima.html");
        objProveedor7.setAbierto("ABIERTO");
        objProveedor7.setLatitud("-12.0453848");
        objProveedor7.setLongitud("-77.0348665");
        objProveedor7.setDescripcion("El Teatro Municipal de Lima fue inaugurado el 28 de julio de 1920 con la ópera Aida de Giuseppe Verdi, interpretada por la Gran Compañía de Ópera Italiana de Adolfo Bracale.");
        objProveedor7.setReservas("SI");
        objProveedor7.setTarjetasCredito("SI");
        objProveedor7.setWifi("SI");
        objProveedor7.setEstacionamiento("SI");
        objProveedor7.setHoraDscto("0");
        newListDetalleProv.add(objProveedor7);


        DetalleProveedor objProveedor8 = new DetalleProveedor();
        objProveedor8.setIdProveedor(8);
        objProveedor8.setPhotoRestaurante("http://revista.pricetravel.com.mx/wp-content/uploads/carsanper/2015/07/png/Restaurantes-m%C3%A1s-famosos-del-mundo-e1440278468629.png");
        objProveedor8.setNombreRestaurante("Rústica Centro de Lima");
        objProveedor8.setCategoria("Servicios y Productos");
        objProveedor8.setDireccion("Jirón de la Unión 822, Distrito de Lima");
        objProveedor8.setDistrito("Cercado de Lima");
        objProveedor8.setAppCompatRatingBarDcto((float) 3.5);
        objProveedor8.setRatingText("3.5");
        objProveedor8.setTelefonos("125 9598");
        objProveedor8.setUrlWeb("www.rustica.com.pe/");
        objProveedor8.setAbierto("ABIERTO");
        objProveedor8.setLatitud("-12.050689");
        objProveedor8.setLongitud("-77.034651");
        objProveedor8.setDescripcion("Descuentos en servicio de catering.");
        objProveedor8.setReservas("NO");
        objProveedor8.setTarjetasCredito("SI");
        objProveedor8.setWifi("NO");
        objProveedor8.setEstacionamiento("NO");
        objProveedor8.setHoraDscto("0");
        newListDetalleProv.add(objProveedor8);

        DetalleProveedor objProveedor9 = new DetalleProveedor();
        objProveedor9.setIdProveedor(9);
        objProveedor9.setPhotoRestaurante("http://www.designwithpurpose.ca/wp-content/uploads/2015/03/Mega.jpg");
        objProveedor9.setNombreRestaurante("Frutix - Real Plaza Centro Cívico");
        objProveedor9.setCategoria("Juguería");
        objProveedor9.setDireccion("Real Plaza Centro Civico, Av. Garcilaso de la Vega 1337");
        objProveedor9.setDistrito("Cercado de Lima");
        objProveedor9.setAppCompatRatingBarDcto((float) 4.6);
        objProveedor9.setRatingText("4.6");
        objProveedor9.setTelefonos("593-5131");
        objProveedor9.setUrlWeb("http://frutix.com.pe/wordpress/");
        objProveedor9.setAbierto("ABIERTO");
        objProveedor9.setLatitud("-12.056878");
        objProveedor9.setLongitud("-77.037235");
        objProveedor9.setDescripcion("Ofrecerte un producto natural sin componentes artificiales, seleccionar los mejores ingredientes, atenderlos siempre con una sonrisa y esforzarnos cada día más en mejorar nuestros productos.");
        objProveedor9.setReservas("NO");
        objProveedor9.setTarjetasCredito("SI");
        objProveedor9.setWifi("NO");
        objProveedor9.setEstacionamiento("NO");
        objProveedor9.setHoraDscto("0");
        newListDetalleProv.add(objProveedor9);

        return newListDetalleProv;

    }


    public int categoriaProveedor (String categoria){
        int cat=0;
        String cate = categoria.toUpperCase();
         switch (cate){
             case "RESTAURANTE": cat=1 ;break;
             case "SERVICIOS Y PRODUCTOS":cat=2;break;
             case "CAFETERÍA":cat =3;break;
             case "JUGUERÍA":cat=4;break;
             case "SALUD Y BELLEZA":cat =5;break;
             case "ARTE Y CULTURA":cat=6;break;
             default: cat=1;break;
         }
        return cat;

    }

}
