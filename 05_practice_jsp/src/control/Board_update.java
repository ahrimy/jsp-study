package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardDAO;
import model.BoardDTO;
import model.UserDAO;
import model.UserDTO;

/**
 * Servlet implementation class Board_update
 */
@WebServlet("/Board_update.do")
public class Board_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void reqPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if(session.getAttribute("log")!=null) {
			int user_num = (int) session.getAttribute("log");
			UserDTO user = UserDAO.getInstance().getOneUser(user_num);
			request.setAttribute("user_id", user.getUser_id());
		}
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		BoardDTO board = BoardDAO.getInstance().getOneBoard(board_num);
		request.setAttribute("board", board);
		// jsp 페이지로 이동하기
		// 이동할 JSP페이지 명

		RequestDispatcher dis = request.getRequestDispatcher("board_update.jsp");
		dis.forward(request, response);
	}

}
