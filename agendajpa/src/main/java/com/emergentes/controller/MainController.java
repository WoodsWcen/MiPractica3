package com.emergentes.controller;

import com.emergentes.bean.BeanContacto;
import com.emergentes.entidades.Contacto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("ESTAMOS EN SERVLET");
        int id;

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        BeanContacto contacto = new BeanContacto();
        Contacto con=new Contacto();

        switch (action) {
            case "add":
                request.setAttribute("contacto", con);
                //contacto.insertar(con);
                request.getRequestDispatcher("contacto-edit.jsp").forward(request, response);
                break;
            case "edit":
                id=Integer.parseInt(request.getParameter("id"));
                contacto.buscar(id);
                request.getRequestDispatcher("contacto-edit.jsp").forward(request, response);
                break;
            case "delete":
                id=Integer.parseInt(request.getParameter("id"));
                contacto.eliminar(id);
                response.sendRedirect("MainController");
                break;
            case "view":
                List<Contacto> lista = contacto.listarTodos();
                request.setAttribute("contactos", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
        //nuevo();
        //eliminar();
        //mostrar();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanContacto cont = new BeanContacto();
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        String valor = request.getParameter("valor");
        Contacto cnt = new Contacto();
        
        cnt.setId(id);
        cnt.setNombre(valor);
        cnt.setCorreo(valor);
        cnt.setTelefono(valor);
        
        if (id>0) {
            cont.editar(cnt);
        } else {
            cont.insertar(cnt);
        }
        response.sendRedirect("MainController");
    }

    private void mostrar() {
        BeanContacto dao = new BeanContacto();

        List<Contacto> lista = dao.listarTodos();

        for (Contacto item : lista) {
            System.out.println(item.toString());
        }
    }
}
