import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SalvarAluno")
public class SalvarAluno extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter escreverTela=response.getWriter();		
		String nome=request.getParameter("nome");
                String email=request.getParameter("email");
                String dataNascimento=request.getParameter("dataNascimento");
		String senha=request.getParameter("senha");		
		
                Aluno a=new Aluno();
		a.setNome(nome);
		a.setEmail(email);
                Date dataConvertida=Date.valueOf(dataNascimento);
                a.setDataNascimento(dataConvertida);     
		a.setSenha(senha);  
		int alunoCadastro=AlunoDao.salvar(a);
                
		if(alunoCadastro>0){
			escreverTela.print("<p>Aluno inserido com sucesso</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}else{
			escreverTela.println("Erro na inserção do aluno");
		}	
		escreverTela.close();
	}

}
