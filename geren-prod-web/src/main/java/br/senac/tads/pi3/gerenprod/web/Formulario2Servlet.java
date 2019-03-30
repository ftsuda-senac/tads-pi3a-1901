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
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "Formulario2Servlet", urlPatterns = {"/formulario2-servlet"})
public class Formulario2Servlet extends HttpServlet {

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

        // VALIDAR DADOS
        boolean temErros = false;
        if (nome == null || nome.trim().length() == 0) {
            temErros = true;
            request.setAttribute("erroNome", "Nome não preenchido");
        }
        if (descricao == null || descricao.length() == 0) {
            temErros = true;
            request.setAttribute("erroDescricao", "Descrição não preenchida");
        }
        if (categoriasArr == null || categoriasArr.length == 0) {
            temErros = true;
            request.setAttribute("erroCategorias", "Categoria não selecionada");
        }

        if (temErros) {
            // REAPRESENTA FORMULARIO INDICANDO OS ERROS
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("formulario.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        HttpSession sessao = request.getSession();

        // ARMAZENANDO VALORES COMO ATRIBUTOS
        sessao.setAttribute("metodoHttp", "POST");
        sessao.setAttribute("escondido", escondido);
        sessao.setAttribute("nome", nome);
        sessao.setAttribute("descricao", descricao);
        sessao.setAttribute("senha", senha);
        int quantidade = 0;
        try {
            quantidade = Integer.parseInt(quantidadeStr);
        } catch (Exception e) {

        }
        sessao.setAttribute("quantidade", quantidade);
        sessao.setAttribute("precoCompra", new BigDecimal(precoCompraStr));
        sessao.setAttribute("precoVenda", new BigDecimal(precoVendaStr));
        sessao.setAttribute("disponivel", "1".equals(disponivelStr) ? "SIM" : "NÃO");
        sessao.setAttribute("categorias", (categoriasArr != null) ? Arrays.asList(categoriasArr) : new ArrayList<String>());

        response.sendRedirect("resultado-servlet");
    }

}
