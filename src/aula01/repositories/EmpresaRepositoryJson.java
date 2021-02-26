package aula01.repositories;

import aula01.entities.Empresa;
import aula01.entities.Funcionario;
import aula01.interfaces.IEmpresaRepository;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.util.HashMap;

public class EmpresaRepositoryJson implements IEmpresaRepository {

    @Override
    public void exportarDados(Empresa empresa) throws Exception {
        HashMap<String, Object> item = new HashMap<>();
        item.put("idEmpresa", empresa.getIdEmpresa());
        item.put("razaoSocial", empresa.getRazaoSocial());
        item.put("cnpj", empresa.getCnpj());


        HashMap<String, Object> funcionarios = new HashMap<>();
        for(Funcionario f : empresa.getFuncionarios()) {
            funcionarios.put("idFuncionario", f.getIdFuncionario());
            funcionarios.put("nome", f.getNome());
            funcionarios.put("matricula", f.getMatricula());
            funcionarios.put("tipoContratacao", f.getTipoContratacao().toString());
        }

        item.put("funcionarios", funcionarios);

        JSONObject json = new JSONObject(item);

        FileWriter file = new FileWriter("C:\\Projects\\JavaClassesJohn\\src\\aula01\\files\\empresa.json");
        file.write(json.toJSONString());
        file.flush();
        file.close();
    }
}
