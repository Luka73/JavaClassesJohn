package aula01.principal;

import aula01.entities.Empresa;
import aula01.entities.Funcionario;
import aula01.enums.TipoContratacao;
import aula01.interfaces.IEmpresaRepository;
import aula01.repositories.EmpresaRepositoryJson;
import aula01.repositories.EmpresaRepositoryXml;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa(1, "COTI Informática", "64.737.104/0001-66");
        Funcionario funcionario1 = new Funcionario(1, "Pedro", "13131313", TipoContratacao.Estagio);
        Funcionario funcionario2 = new Funcionario(2, "Maria", "13131313", TipoContratacao.Estagio);
        List<Funcionario> funcionarioList = new ArrayList<>();
        funcionarioList.add(funcionario1);
        funcionarioList.add(funcionario2);
        empresa.setFuncionarios(funcionarioList);


        try {
            System.out.println("Informe (1) XML ou (2) JSON....: ");
            int opcao = Integer.parseInt(new Scanner(System.in).next());
            IEmpresaRepository empresaRepository = null;

            switch (opcao) {
                case 1:
                    empresaRepository = new EmpresaRepositoryXml();
                    break;
                case 2:
                    empresaRepository = new EmpresaRepositoryJson();
                    break;
                default:
                    throw new Exception("Opção inválida!");
            }

            empresaRepository.exportarDados(empresa);
            System.out.println("Dados gravados com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
