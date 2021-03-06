package com.gmdinnovacion.beneficiosgmd.disfruta.domain.model;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "POINT".
*/
public class PointDao <Point, Long> {
//public class PointDao extends AbstractDao<Point, Long> {
//
//    public static final String TABLENAME = "POINT";
//
//    /**
//     * Properties of entity Point.<br/>
//     * Can be used for QueryBuilder and for referencing column names.
//    */
//    public static class Properties {
//        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
//        public final static Property IdUsuario = new Property(1, String.class, "idUsuario", false, "ID_USUARIO");
//        public final static Property Latitud = new Property(2, String.class, "latitud", false, "LATITUD");
//        public final static Property Longitud = new Property(3, String.class, "longitud", false, "LONGITUD");
//        public final static Property Hora = new Property(4, String.class, "hora", false, "HORA");
//        public final static Property Fecha = new Property(5, String.class, "fecha", false, "FECHA");
//    };
//
//
//    public PointDao(DaoConfig config) {
//        super(config);
//    }
//
//    public PointDao(DaoConfig config, DaoSession daoSession) {
//        super(config, daoSession);
//    }
//
//    /** Creates the underlying database table. */
//    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
//        String constraint = ifNotExists? "IF NOT EXISTS ": "";
//        db.execSQL("CREATE TABLE " + constraint + "\"POINT\" (" + //
//                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
//                "\"ID_USUARIO\" TEXT NOT NULL ," + // 1: idUsuario
//                "\"LATITUD\" TEXT," + // 2: latitud
//                "\"LONGITUD\" TEXT," + // 3: longitud
//                "\"HORA\" TEXT," + // 4: hora
//                "\"FECHA\" TEXT);"); // 5: fecha
//    }
//
//    /** Drops the underlying database table. */
//    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
//        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"POINT\"";
//        db.execSQL(sql);
//    }
//
//    /** @inheritdoc */
//    @Override
//    protected void bindValues(SQLiteStatement stmt, Point entity) {
//        stmt.clearBindings();
//
//        Long id = entity.getId();
//        if (id != null) {
//            stmt.bindLong(1, id);
//        }
//        stmt.bindString(2, entity.getIdUsuario());
//
//        String latitud = entity.getLatitud();
//        if (latitud != null) {
//            stmt.bindString(3, latitud);
//        }
//
//        String longitud = entity.getLongitud();
//        if (longitud != null) {
//            stmt.bindString(4, longitud);
//        }
//
//        String hora = entity.getHora();
//        if (hora != null) {
//            stmt.bindString(5, hora);
//        }
//
//        String fecha = entity.getFecha();
//        if (fecha != null) {
//            stmt.bindString(6, fecha);
//        }
//    }
//
//    /** @inheritdoc */
//    @Override
//    public Long readKey(Cursor cursor, int offset) {
//        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
//    }
//
//    /** @inheritdoc */
//    @Override
//    public Point readEntity(Cursor cursor, int offset) {
//        Point entity = new Point( //
//            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
//            cursor.getString(offset + 1), // idUsuario
//            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // latitud
//            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // longitud
//            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // hora
//            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // fecha
//        );
//        return entity;
//    }
//
//    /** @inheritdoc */
//    @Override
//    public void readEntity(Cursor cursor, Point entity, int offset) {
//        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
//        entity.setIdUsuario(cursor.getString(offset + 1));
//        entity.setLatitud(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
//        entity.setLongitud(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
//        entity.setHora(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
//        entity.setFecha(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
//     }
//
//    /** @inheritdoc */
//    @Override
//    protected Long updateKeyAfterInsert(Point entity, long rowId) {
//        entity.setId(rowId);
//        return rowId;
//    }
//
//    /** @inheritdoc */
//    @Override
//    public Long getKey(Point entity) {
//        if(entity != null) {
//            return entity.getId();
//        } else {
//            return null;
//        }
//    }
//
//    /** @inheritdoc */
//    @Override
//    protected boolean isEntityUpdateable() {
//        return true;
//    }
    
}
