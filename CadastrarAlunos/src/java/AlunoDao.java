import java.util.*;
import java.sql.*;

public class AlunoDao {
        private static final String DRIVER = "com.mysql.jdbc.Driver";
        private static final String URL = "jdbc:mysql://localhost:3306/escola";
        private static final String USER = "root";
        private static final String SENHA = "";
        
	public static Connection getConnection(){
		try{
                Class.forName(DRIVER);
                Connection con;
                return con=DriverManager.getConnection(URL,USER,SENHA);
		}catch(Exception e){
                    System.out.println(e);
                    return null;
                }
                
	}
	public static int salvar(Aluno e){
		int alunoCadastro=0;
		try{
			Connection con=AlunoDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into aluno(nome,email,dataNascimento,senha) values (?,?,?,?)");
			ps.setString(1,e.getNome());
                        ps.setString(2,e.getEmail());
                        ps.setDate(3,e.getDataNascimento());
			ps.setString(4,e.getSenha());			
			alunoCadastro=ps.executeUpdate();		
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return alunoCadastro;
	}
        
	public static int atualizar(Aluno a){
		int alunoCadastro=0;
		try{
			Connection con=AlunoDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update aluno set nome=?,email=?,dataNascimento=?,senha=? where id=?");
			ps.setString(1,a.getNome());			
			ps.setString(2,a.getEmail());
                        ps.setDate(3, a.getDataNascimento());
                        ps.setString(4,a.getSenha());
			ps.setInt(5,a.getId());
			alunoCadastro=ps.executeUpdate();
			con.close();
                        
		}catch(Exception ex){ex.printStackTrace();}
		
		return alunoCadastro;
	}
	public static int deletar(int id){
		int alunosCadastrado=0;
		try{
			Connection con=AlunoDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from aluno where id=?");
			ps.setInt(1,id);
			alunosCadastrado=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return alunosCadastrado;
	}
	public static Aluno getAlunoId(int id){
		Aluno a=new Aluno();
		
		try{
			Connection con=AlunoDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from aluno where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				a.setId(rs.getInt(1));
				a.setNome(rs.getString(2));
                                a.setEmail(rs.getString(3));				
                                a.setDataNascimento(rs.getDate(4));				
                                a.setSenha(rs.getString(5));
                                
			}
			con.close();
		}catch(Exception ex){
                    ex.printStackTrace();
                }
		
		return a;
	}
	public static List<Aluno> getTodosAlunos(){
		List<Aluno> listaAlunos=new ArrayList<Aluno>();
		
		try{
			Connection con=AlunoDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from aluno");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Aluno a=new Aluno();
				a.setId(rs.getInt(1));
				a.setNome(rs.getString(2));
                                a.setEmail(rs.getString(3));
                                a.setDataNascimento(rs.getDate(4));				
                                a.setSenha(rs.getString(5));
				listaAlunos.add(a);
			}
			con.close();
		}catch(Exception e){
                    e.printStackTrace();
                }
		
		return listaAlunos;
	}
}
