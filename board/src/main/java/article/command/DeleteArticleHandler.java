package article.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleNotFoundException;
import article.service.DeleteService;
import article.service.ModifyRequest;
import article.service.PermissionDeniedException;
import auth.service.User;
import mvc.command.CommandHandler;

public class DeleteArticleHandler implements CommandHandler{
	
	private DeleteService deleteService = new DeleteService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return processSubmit(req, res);
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
			User authUser = (User) req.getSession().getAttribute("authUser");
			String noVal = req.getParameter("no");
			int no = Integer.parseInt(noVal);
			
			try {
				deleteService.delete(authUser.getId(), no);
				return "/WEB-INF/view/deleteSuccess.jsp";
			} catch (ArticleNotFoundException e) {
				res.sendError(HttpServletResponse.SC_NOT_FOUND);
				return null;
			} catch (PermissionDeniedException e) {
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
		}
}
