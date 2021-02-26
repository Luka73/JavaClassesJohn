package aula01.repositories;

import aula01.entities.Empresa;
import aula01.interfaces.IEmpresaRepository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class EmpresaRepositoryXml implements IEmpresaRepository {
    @Override
    public void exportarDados(Empresa empresa) throws Exception {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element root = document.createElement("EMPRESA");
        document.appendChild(root);

        Element idEmpresa = document.createElement("IDEMPRESA");
        idEmpresa.setTextContent(empresa.getIdEmpresa().toString());

        Element razaoSocial = document.createElement("RAZAOSOCIAL");
        razaoSocial.setTextContent(empresa.getRazaoSocial());
        root.appendChild(razaoSocial);

        Element cnpj = document.createElement("CNPJ");
        cnpj.setTextContent(empresa.getCnpj());
        root.appendChild(cnpj);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);

        StreamResult streamResult = new StreamResult(new File("C:\\Projects\\JavaClassesJohn\\src\\aula01\\files\\empresa.xml"));
        transformer.transform(domSource, streamResult);
    }
}
