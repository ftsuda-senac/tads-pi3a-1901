/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "FormularioServlet", urlPatterns = {"/formulario-servlet"})
public class FormularioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("formulario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // RECUPERA INFORMACOES DA REQUISICAO
        String escondido = request.getParameter("escondido");
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String senha = request.getParameter("senha");
        String quantidadeStr = request.getParameter("quantidade");
        String precoCompraStr = request.getParameter("prcompra");
        String precoVendaStr = request.getParameter("prvenda");
        String disponivelStr = request.getParameter("disponivel");
        String[] categoriasArr = request.getParameterValues("categorias");

//        // VALIDAR DADOS
//        boolean temErros = false;
//        if (nome == null || nome.length() == 0) {
//            temErros = true;
//            request.setAttribute("erroNome", "Nome não preenchido");
//        }
//        if (descricao == null || descricao.length() == 0) {
//            temErros = true;
//            request.setAttribute("erroDescricao", "Descrição não preenchida");
//        }
//        if (categoriasArr == null || categoriasArr.length == 0) {
//            temErros = true;
//            request.setAttribute("erroCategoria", "Categoria não selecionada");
//        }
//
//        if (temErros) {
//            // REAPRESENTA FORMULARIO INDICANDO OS ERROS
//            RequestDispatcher dispatcher = request.getRequestDispatcher("formulario.jsp");
//            dispatcher.forward(request, response);
//        }

        // ARMAZENANDO VALORES COMO ATRIBUTOS
        request.setAttribute("metodoHttp", "POST");
        request.setAttribute("escondido", escondido);
        request.setAttribute("nome", nome);
        request.setAttribute("descricao", descricao);
        request.setAttribute("senha", senha);
        request.setAttribute("quantidade", Integer.parseInt(quantidadeStr));
        request.setAttribute("precoCompra", new BigDecimal(precoCompraStr));
        request.setAttribute("precoVenda", new BigDecimal(precoVendaStr));
        request.setAttribute("disponivel", "1".equals(disponivelStr) ? "SIM" : "NÃO");
        request.setAttribute("categorias", (categoriasArr != null) ? Arrays.asList(categoriasArr) : new ArrayList<String>());

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/resultado.jsp");
        dispatcher.forward(request, response);
    }

}
