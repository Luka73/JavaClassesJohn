package aula01.interfaces;

import aula01.entities.Empresa;

public interface IEmpresaRepository {
    void exportarDados(Empresa empresa) throws Exception;
}
