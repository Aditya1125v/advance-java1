package preparedStatement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestModel {
	public static void main(String[] args) throws Exception {
		//testadd();
		// testupdate();
		// testdelete();
		testSearch();
	}

	private static void testSearch() throws Exception {
	UserBean bean=new UserBean();
	UserModel1 model =new UserModel1();
	List list = new ArrayList();
	 
	// bean.setFirst_name("Faruk");
//	bean.setLast_name("khan");

	list = model.search(bean);

	Iterator it = list.iterator();

	while (it.hasNext()) {

		bean = (UserBean) it.next();

		System.out.print(bean.getId());
		System.out.print("\t" + bean.getFirst_name());
		System.out.print("\t" + bean.getLast_name());
		System.out.print("\t" + bean.getDob());
		System.out.print("\t" + bean.getLogin_Id());
		System.out.print("\t" + bean.getPassword());
		System.out.println("\t" + bean.getMobile_No());

	}

}


	private static void testadd() throws Exception {
		SimpleDateFormat sr = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();
		/*
		 * bean.setId(9);
		 */ bean.setFirst_name("rasidya");
		bean.setLast_name("tanuja");
		bean.setDob(sr.parse("2011-01-19"));
		bean.setLogin_Id("tanujasabrother@gmail.com");
		bean.setPassword("tanuormanu");
		bean.setMobile_No(9898816251L);

		UserModel1 model = new UserModel1();

		model.add(bean);
	}

	private static void testupdate() throws Exception {
		UserBean bean = new UserBean();
		bean.setId(9);
		bean.setFirst_name("druvi");

		UserModel1 model = new UserModel1();

		model.update(bean);
	}

	private static void testdelete() throws Exception {
		UserBean bean = new UserBean();
		bean.setId(9);

		UserModel1 model = new UserModel1();

		model.delete(bean);
	}
}
