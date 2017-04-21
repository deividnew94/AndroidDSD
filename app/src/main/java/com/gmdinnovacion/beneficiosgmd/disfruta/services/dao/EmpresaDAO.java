package com.gmdinnovacion.beneficiosgmd.disfruta.services.dao;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.Empresa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avermes on 3/2/2017.
 */

public interface EmpresaDAO {
    public long insert(Empresa model);

    public Empresa getCurrentEmpresa();

    public void limpiarEmpresas();

    public List<Empresa> getAllEmpresasName();
}
