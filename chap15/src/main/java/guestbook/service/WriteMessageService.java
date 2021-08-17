package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import connection.ConnectionProvider;
import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.jdbcUtil;

public class WriteMessageService {
	private static WriteMessageService instance = new WriteMessageService();
	
	public static WriteMessageService getInstance() {
		return instance;
	}
	
	public WriteMessageService() {
	}
	
	public void write(Message message) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao messageDao = MessageDao.getInstance();
			messageDao.insert(conn, message);
		} catch (SQLException e) {
			throw new ServiceException("�޽������ ����: " + e.getMessage(), e);
		} finally {
			jdbcUtil.close(conn);
		}
	}
}
