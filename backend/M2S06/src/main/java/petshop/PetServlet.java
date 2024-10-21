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

@WebServlet("/pet/*")
public class PetServlet extends HttpServlet {
    private static Map<Integer, Pet> pets = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        PrintWriter writer = resp.getWriter();
        
        if (pathInfo == null || pathInfo.equals("/")) {
            writer.println("Lista de todos os pets: " + pets.values());
        } else {
            String[] splits = pathInfo.split("/");
            if (splits.length == 2) {
                try {
                    int id = Integer.parseInt(splits[1]);
                    Pet pet = pets.get(id);
                    if (pet != null) {
                        writer.println("Detalhes do pet: " + pet);
                    } else {
                        writer.println("Pet com ID " + id + " não encontrado.");
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
        String especie = req.getParameter("especie");
        String raca = req.getParameter("raca");
        int idade = Integer.parseInt(req.getParameter("idade"));
        float peso = Float.parseFloat(req.getParameter("peso"));
        String sexo = req.getParameter("sexo");

        Pet pet = new Pet(id, nome, especie, raca, idade, peso, sexo);
        pets.put(id, pet);

        PrintWriter writer = resp.getWriter();
        writer.println("Pet cadastrado com sucesso: " + pet);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Pet pet = pets.get(id);
        if (pet != null) {
            pet.setNome(req.getParameter("nome"));
            pet.setEspecie(req.getParameter("especie"));
            pet.setRaca(req.getParameter("raca"));
            pet.setIdade(Integer.parseInt(req.getParameter("idade")));
            pet.setPeso(Float.parseFloat(req.getParameter("peso")));
            pet.setSexo(req.getParameter("sexo"));

            PrintWriter writer = resp.getWriter();
            writer.println("Pet com ID " + id + " atualizado com sucesso: " + pet);
        } else {
            PrintWriter writer = resp.getWriter();
            writer.println("Pet com ID " + id + " não encontrado para atualização.");
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
                    Pet removedPet = pets.remove(id);
                    PrintWriter writer = resp.getWriter();
                    if (removedPet != null) {
                        writer.println("Pet com ID " + id + " excluído com sucesso.");
                    } else {
                        writer.println("Pet com ID " + id + " não encontrado.");
                    }
                } catch (NumberFormatException e) {
                    PrintWriter writer = resp.getWriter();
                    writer.println("ID inválido.");
                }
            }
        }
    }
}