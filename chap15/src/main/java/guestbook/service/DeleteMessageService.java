package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import connection.ConnectionProvider;
import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.jdbcUtil;

public class DeleteMessageService {
	
	private static DeleteMessageService instance = new DeleteMessageService();
	
	public static DeleteMessageService getInstance() {
		return instance;
	}
	
	private DeleteMessageService() {
		
	}
	
	public void deleteMessage(int messageId, String password) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			MessageDao messageDao = MessageDao.getInstance();
			Message message = messageDao.select(conn, messageId);
			if (message == null) {
				throw new MessageNotFoundException("메시지 없음");
			}
			if (!message.matchPassword(password)) {
				throw new InvaildPasswordException("bad password");
			}
			messageDao.delete(conn, messageId);
			
			conn.commit();
		} catch (SQLException e) {
			jdbcUtil.rollback(conn);
			throw new ServiceException("삭제 실패: " + e.getMessage(), e);
		} catch (InvaildPasswordException | MessageNotFoundException e) {
			jdbcUtil.rollback(conn);
			throw e;
		} finally {
			jdbcUtil.close(conn);
		}
	}
}
