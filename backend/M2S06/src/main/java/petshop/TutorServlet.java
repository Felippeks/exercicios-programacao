package petshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tutor/*")
public class TutorServlet extends HttpServlet {
    private static Map<Integer, Tutor> tutores = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        PrintWriter writer = resp.getWriter();
        
        if (pathInfo == null || pathInfo.equals("/")) {
            writer.println("Lista de todos os tutores: " + tutores.values());
        } else {
            String[] splits = pathInfo.split("/");
            if (splits.length == 2) {
                try {
                    int id = Integer.parseInt(splits[1]);
                    Tutor tutor = tutores.get(id);
                    if (tutor != null) {
                        writer.println("Detalhes do tutor: " + tutor);
                    } else {
                        writer.println("Tutor com ID " + id + " não encontrado.");
                    }
                } catch (NumberFormatException e) {
                    writer.println("ID inválido.");
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nome = req.getParameter("nome");
        String endereco = req.getParameter("endereco");
        String telefone = req.getParameter("telefone");
        String email = req.getParameter("email");

        Tutor tutor = new Tutor(id, nome, endereco, telefone, email);
        tutores.put(id, tutor);

        PrintWriter writer = resp.getWriter();
        writer.println("Tutor cadastrado com sucesso: " + tutor);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Tutor tutor = tutores.get(id);
        if (tutor != null) {
            tutor.setNome(req.getParameter("nome"));
            tutor.setEndereco(req.getParameter("endereco"));
            tutor.setTelefone(req.getParameter("telefone"));
            tutor.setEmail(req.getParameter("email"));

            PrintWriter writer = resp.getWriter();
            writer.println("Tutor com ID " + id + " atualizado com sucesso: " + tutor);
        } else {
            PrintWriter writer = resp.getWriter();
            writer.println("Tutor com ID " + id + " não encontrado para atualização.");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo != null) {
            String[] splits = pathInfo.split("/");
            if (splits.length == 2) {
                try {
                    int id = Integer.parseInt(splits[1]);
                    Tutor removedTutor = tutores.remove(id);
                    PrintWriter writer = resp.getWriter();
                    if (removedTutor != null) {
                        writer.println("Tutor com ID " + id + " excluído com sucesso.");
                    } else {
                        writer.println("Tutor com ID " + id + " não encontrado.");
                    }
                } catch (NumberFormatException e) {
                    PrintWriter writer = resp.getWriter();
                    writer.println("ID inválido.");
                }
            }
        }
    }
}