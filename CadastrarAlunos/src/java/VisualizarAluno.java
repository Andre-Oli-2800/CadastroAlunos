import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/VisualizarAluno")

public class VisualizarAluno extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter escreverTela=response.getWriter();
		escreverTela.println("<h1>Lista de Alunos</h1>");
		List<Aluno> lista=AlunoDao.getTodosAlunos();
		escreverTela.print("<table border='1' width='100%'");
		escreverTela.print("<tr><th>Id</th><th>Nome</th><th>E-mail</th><th>Data de Nascimento</th><th>Senha</th><th>Editar</th><th>Deletar</th></tr>");
		for(Aluno a:lista){                
                        String formatoAlterado = new SimpleDateFormat("dd/MM/yyyy").format(a.getDataNascimento());
			escreverTela.print("<tr><td>"+a.getId()+"</td><td>"+a.getNome()+"</td><td>"+a.getEmail()+"</td><td>"+formatoAlterado+"</td><td>"+a.getSenha()+"</td><td><a href='EditarAluno?id= "+a.getId()+"'>Editar</a></td><td> <a href='DeletarAluno?id="+a.getId()+"'>Deletar</a></td></tr>");            
                }
                
		escreverTela.print("</table>");
		escreverTela.print("<a href='index.html'>Adicionar Novo Aluno</a>");
		escreverTela.close();
	}
}
