package PreStatementTry;

import java.text.SimpleDateFormat;
public class TestModel {

	    public static void main(String[] args) throws Exception {
	        testAdd();
	    }

	    private static void testAdd() throws Exception {
	        SimpleDateFormat sr = new SimpleDateFormat("yyyy-MM-dd");
	        UserBean bean = new UserBean();
	        bean.setId(10);
	        bean.setFirst_name("Aditya");
	        bean.setLast_name("Verma");
	        bean.setDob(sr.parse("2004-09-25"));
	        bean.setLogin_Id("adityaverma1125v@gmail.com");
	        bean.setPassword("Adi@123");
	        bean.setMobile_No(8359817216L);

	        ModelBean model = new ModelBean();
	        model.add(bean);
	    }
	}


