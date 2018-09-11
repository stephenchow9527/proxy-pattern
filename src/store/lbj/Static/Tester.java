package store.lbj.Static;

public class Tester {
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		DAOInterface proxy = new UserDAOProxy(userDAO);
		
		proxy.add();
		proxy.query();
		proxy.update();
		proxy.delete();
	}
}
