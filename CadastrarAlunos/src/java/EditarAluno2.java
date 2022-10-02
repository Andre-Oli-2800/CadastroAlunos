import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditarAluno2")
public class EditarAluno2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter escreverTela=response.getWriter();
		
		String sid=request.getParameter("id");
		String nome=request.getParameter("nome");	
		String email=request.getParameter("email");
                String dataNascimento= request.getParameter("dataNascimento");
		String senha=request.getParameter("senha");	
		Aluno a=new Aluno();
                int id=Integer.valueOf(sid); 
		a.setId(id);
		a.setNome(nome);
		a.setEmail(email);
                Date dataConvertida=Date.valueOf(dataNascimento);
                a.setDataNascimento(dataConvertida);     
		a.setSenha(senha);          
		int alunosCadastrado=AlunoDao.atualizar(a);
		if(alunosCadastrado>0){
			response.sendRedirect("VisualizarAluno");
		}else{
			escreverTela.println("Erro ao atualizar os dados do aluno");
		}
		
		escreverTela.close();
	}

}
