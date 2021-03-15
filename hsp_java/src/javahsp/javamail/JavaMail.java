package javahsp.javamail;

public class JavaMail {
	/*public static void test(String[] args) throws Exception {
		JavaMailUtil.sendMail("ryannathanslam@gmail.com");
	}*/
	
	
	public void send_mail(String mail) {
			try {
				JavaMailUtil.sendMail(mail);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
