import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditarAluno")

public class EditarAluno extends HttpServlet {
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter escreverTela=response.getWriter();
		escreverTela.println("<h1>Atualizar Aluno</h1>");
		int id=Integer.valueOf(request.getParameter("id").trim());
		Aluno a=AlunoDao.getAlunoId(id);
		escreverTela.print("<form action='EditarAluno2' method='post'>");
		escreverTela.print("<table>");
		escreverTela.print("<tr><td><input type='hidden' name='id' value="+a.getId()+"></td></tr>");
		escreverTela.print("<tr><td>Name:</td><td><input type='text' name='nome' value="+a.getNome()+"></td></tr>");
                escreverTela.print("<tr><td>Email:</td><td><input type='email' name='email' value="+a.getEmail()+"></td></tr>");
                escreverTela.print("<tr><td>Data de Nascimento:</td><td><input type='date' name='dataNascimento' value="+a.getDataNascimento()+"></td></tr>");
		escreverTela.print("<tr><td>Senha:</td><td><input type='password' name='senha' value="+a.getSenha()+"></td></tr>");
		escreverTela.print("</td></tr>");
		escreverTela.print("<tr><td colspan='2'><input type='submit' value='Salvar'/></td></tr>");
		escreverTela.print("</table>");
		escreverTela.print("</form>");
		escreverTela.close();
	}
}
