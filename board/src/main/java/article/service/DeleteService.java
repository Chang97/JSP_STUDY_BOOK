package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import jdbc.jdbcUtil;
import jdbc.connection.ConnectionProvider;

public class DeleteService {
	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	public void delete(String authUser, int no) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Article article = articleDao.selectById(conn, no);
			if (article == null) {
				throw new ArticleNotFoundException();
			}
			if (!canDelete(authUser, article)) {
				throw new PermissionDeniedException();
			}
			articleDao.delete(conn, no);
			contentDao.delete(conn, no);
			conn.commit();
		} catch (SQLException e) {
			jdbcUtil.close(conn);
		}
	}
	
	private boolean canDelete(String deleteUserId, Article article) {
		return article.getWriter().getId().equals(deleteUserId);
	}
}
