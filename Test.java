package studywell;

import java.awt.BorderLayout; 
import java.awt.Container; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.BufferedReader; 
import java.io.File; 
import java.io.FileReader; 
import java.io.FileWriter; 
import java.io.IOException; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.JTextArea; 
import javax.swing.JScrollPane;

public class Test extends JFrame{
	 private JTextArea jt; 
	 private JScrollPane js; 
	 private JPanel jp2;
	 private Container c; 
	 private JButton read;
	 private JButton write; 
	 private JButton clear;
	 
public void createFile(){
	File file=new File("TRUST.txt");//实例化文件对象 
	if (file.exists()) {//判断文件是否存在 
		try { 
			file.createNewFile();
		}catch (IOException e1) { 
			e1.printStackTrace(); 
			}
		}
	}
public JButton createReadButton(){ 
	JButton read=new JButton("读取文件");
	read.addActionListener(new ActionListener() { 
		public void actionPerformed(ActionEvent e) { 
			File file=new File("TRUST.txt");
			try { 
			FileReader in=new FileReader(file);//读取文件内容 
			BufferedReader br=new BufferedReader(in);//新建缓存 
			String s=null;
			while ((s=br.readLine())!=null) { 
				jt.append(s);//设置文本框内容 
				jt.append("\n");//增加换行符 
				}
			} catch (Exception e1) {
				e1.printStackTrace(); 
				}
			}
		}); 
	return read;
	}
public JButton createWriteButton(){ 
	JButton write=new JButton("写入文件"); 
	write.addActionListener(new ActionListener() {  
		public void actionPerformed(ActionEvent e) {
			File file=new File("TRUST.txt");
			try { 
				FileWriter out=new FileWriter(file); 
				out.write(jt.getText());//将文本框内容全部写入文件 
				out.close(); 
				System.out.println("写入文件成功");
				jt.setText("");//清空文本框内容 
				} catch (IOException e1) {
					e1.printStackTrace();
					} 
			}
		});
	return write;
	}
private JButton createClearButton() {
	JButton clear=new JButton("清除文件");
	clear.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			File file=new File("TRUST.txt");
			try {
				FileWriter fileclear=new FileWriter(file);
				fileclear.write("");
				fileclear.flush();
				fileclear.close();
				System.out.println("清除成功");
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	});
	return clear;
}
private void go(){
	createFile();
	setTitle("Reader and Writer");
	c=getContentPane();
	read=createReadButton();
	write=createWriteButton();//调用方法返回“写入文件”按钮
	clear=createClearButton();
	jt=new JTextArea(10,29);//设置文本框行数 
	jt.setLineWrap(true);// 激活自动换行功能  
	jt.setWrapStyleWord(true);// 激活断行不断字功能 
	js=new JScrollPane(jt); 
	jp2=new JPanel();
	jp2.add(read);
	jp2.add(write);
	jp2.add(clear);
	c.add(js,BorderLayout.NORTH);
	c.add(jp2,BorderLayout.SOUTH); 
	setVisible(true); 
	setSize(300,215);
	}
public static void main(String[] args) {
	
	new Test().go();
	}
}
