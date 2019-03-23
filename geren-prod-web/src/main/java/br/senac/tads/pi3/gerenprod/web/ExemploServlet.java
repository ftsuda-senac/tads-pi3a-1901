/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "ExemploServlet", urlPatterns = "/exemplo")
public class ExemploServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String dtNasc = request.getParameter("nascimento");
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dtNasc, formatter);
        LocalDate outro = LocalDate.now().minusYears(date.getYear());
        
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!doctype html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='utf-8'>");
            out.println("<title>Exemplo Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Exemplo Servlet (rodando na máquina da frente)</h1>");
            out.println("<h2>Welcome <span style='text-decoration: underline'>" + nome + "</span>  sua idade é " + outro.getYear() + " anos</h2>");
            out.println("<h3>Data e hora de acesso: " + LocalDateTime.now().toString() + "</h3>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
