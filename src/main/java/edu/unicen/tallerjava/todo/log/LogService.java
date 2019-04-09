package edu.unicen.tallerjava.todo.log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import edu.unicen.tallerjava.todo.users.User;

/**
 * El servicio de logs.
 */
@Service
public class LogService {
	private final List<Log> logs = new ArrayList<>();

	public List<Log> getLogs() {
		return logs;
	}

	/**
	 * Este método agrega un log a la lista de logs.
	 * @param action La acción a logear
	 * @param user El usuario que generó la acción
	 */
	public void addLog(String action, User user) {
		Log log = new Log(UUID.randomUUID(), action, user);
		synchronized(this) {
			logs.add(log);
		}
	}

	/**
	 * Limpia la lista de logs.
	 */
	public void clear() {
		this.logs.clear();
	}
}
