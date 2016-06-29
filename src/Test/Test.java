package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
class UI {
	private JFrame frame;
	private JPanel panel;
//	private JLabel label1;
	private JLabel label2;
	private JTextField keyField, dateField;
	private JButton button;
	public UI() {
		frame = new JFrame("软狗制作工具");
		panel = new JPanel();
//		label1 = new JLabel("秘钥");
		label2 = new JLabel("日期");
		keyField = new JTextField("__hzjq__stop__service@2016", 12);
		dateField = new JTextField("", 12);
		button = new JButton("生成文件");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					Test.makeSecret(dateField.getText(), keyField.getText(), "bmc.certification");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				}
			}
		});
//		panel.add(label1);
//		panel.add(keyField);
		panel.add(label2);
		panel.add(dateField);
		panel.add(button);
		frame.add(panel);
		frame.setSize(300, 100);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
public class Test {
	public static void test() {
		String s = "__hzjq__stop__service@2016";
		char c[] = s.toCharArray();
		for(int i = 0; i < c.length; i++)
		System.out.print((int)c[i]+",");
	}
	public static void main(String[] args) throws ParseException, IOException {
//		Date now = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String dueTime = "2015-05-09 20:00:00";
//		System.out.println(now.after(sdf.parse(dueTime)));
		
//		System.out.println(openSecret("E:/bmc.certification"));
//		char a[] = {69,58,47,98,109,99,46,99,101,114,116,105,102,105,99,97,116,105,111,110};
//		String s = new String(a);
//		System.out.println(s);
//		Double double1 = 123456789.123456789;  
//        DecimalFormat decimalFormat = new DecimalFormat("0.00");//格式化设置  
//        System.out.println(decimalFormat.format(double1));  
//        System.out.println(double1);  
//		makeSecret("D:/bmc.certification", "E:/bmc.certification");
//		char a[] = {69,58,47,98,109,99,46,99,101,114,116,105,102,105,99,97,116,105,111,110};
//		String s = new String(a);
//		System.out.println(s);
//		test();
		new UI();
	}
	public static void makeSecret(String path, String dest) throws IOException {
		File file = new File(path);
		FileInputStream fis = new FileInputStream(path);
		FileOutputStream fos = new FileOutputStream(dest);
		byte[] bytes = new byte[(int)file.length()];
		fis.read(bytes);
//		fos.write(Secret.encrypt(bytes, "_yundao_lier@2015"));
		fos.write(Secret.encrypt(bytes, "__hzjq__stop__service@2016"));
		fis.close();
		fos.close();
	}
	public static void makeSecret(String date, String key, String dest) throws IOException {
		FileOutputStream fos = new FileOutputStream(dest);
		byte[] bytes = date.getBytes();
		fos.write(Secret.encrypt(bytes, key));
		fos.close();
	}
	public static String openSecret(String path) throws IOException {
		return openSecret(path, "__hzjq__stop__service@2016");
	}
	public static String openSecret(String path, String key) throws IOException {
		File file = new File(path);
		FileInputStream fis = new FileInputStream(path);
		byte[] bytes = new byte[(int)file.length()];
		fis.read(bytes);
		fis.close();
		return new String(Secret.decrypt(bytes, key));
	}
}