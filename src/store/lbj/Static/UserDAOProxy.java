package store.lbj.Static;

public class UserDAOProxy implements DAOInterface{

	UserDAO userDAO = null;
	
	public UserDAOProxy(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public void add() {
		// TODO Auto-generated method stub
		userDAO.add();
        System.out.println("记录日志add");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		userDAO.delete();
        System.out.println("记录日志delete");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		userDAO.update();
        System.out.println("记录日志update");
	}

	@Override
	public void query() {
		// TODO Auto-generated method stub
		userDAO.query();
        System.out.println("记录日志query");
	}

}
