package org.bianqi.seat.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.SynchronousQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.bianqi.seat.grab.GrabSeat;
import org.bianqi.seat.login.SeatLogin;

/**
 * 抢座软件
 * @author BIANQI
 */
public class MainGUI {
	public static void main(String[] args) {
		Frame frame = new MainFrame("齐齐哈尔大学图书馆自习室抢座小助手");
	}
}

class MainFrame extends JFrame{

	private static final long serialVersionUID = -5115488791553705781L;
	private String seatNum = "";
	String selectedItem1 = "";
	String selectedItem2 = "";
	String cookie;
	JDialog jDialog = null;
	JMenuBar mb = null;
	JMenu m = null;
	JMenu m1 = null;
	JMenuItem closeItem = null;
	JMenuItem aboutItem = null;
	JMenuItem useItem = null;
	JLabel lbl1 = null;
	JLabel lbl2 = null;
	JLabel lbl3 = null;
	JLabel lbl4 = null;
	JLabel bll3 = null;
	JTextField txt = null;
	JPasswordField pasw = null;
	JButton btn1 = null;
	ImageIcon img = null;
	JLabel imgLabel = null;
	Container contain = null;
	JComboBox<String> jcb1 = null;
	JComboBox<String> jcb2 = null;
	JComboBox<String> jcb3 = null;
	Frame frame = this;
	public MainFrame(String title) {
		this.init(title);
	}
	
	public void init(String title){
		Toolkit t = Toolkit.getDefaultToolkit();
		Image i = t.getImage(MainGUI.class.getClassLoader().getResource("title.png"));
//		Image i = t.getImage("title.png");
		this.setIconImage(i);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setLocation(400, 200);
		this.setSize(506, 329);
		this.setTitle(title);
		this.setResizable(false);
		mb =new JMenuBar();//创建菜单栏
		m = new JMenu("开始");//创建“文件”菜单    
		m1 = new JMenu("关于");
		closeItem = new JMenuItem("退出");//创建“退出"菜单项

		closeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int showConfirmDialog = JOptionPane.showConfirmDialog(frame, "一旦退出,就无法定时抢座!你确定退出?", "退出", JOptionPane.YES_NO_OPTION); 
				if(showConfirmDialog != 1){
					System.exit(0);
				}
			}
		});
		
		aboutItem =new JMenuItem("关于");
		aboutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "      开发者软件141BQ", "关于", JOptionPane.INFORMATION_MESSAGE); 
			}
		});
		
		useItem = new JMenuItem("使用说明");
		useItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "1401代表东区401,2101代表中区101,1开头为东区,2开头为中区,3开头为西区,每天0:00~~13:00可以使用这个软件,其他时间不可以使用", "使用说明", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
        m.add(closeItem);//将“退出”菜单项添加到“文件”菜单上
        m1.add(useItem);
        m1.add(aboutItem);
        mb.add(m);//将文件添加到菜单栏上
        mb.add(m1);
        this.setJMenuBar(mb);//将此窗体的菜单栏设置为指定的菜单栏。
        
         //用户名或者密码错误 问题的考虑
        lbl1 = new JLabel("学   号:"); 
        lbl1.setBounds(10, 10, 90, 30);
        lbl2 = new JLabel("密　码:"); 
        lbl2.setBounds(10, 50, 90, 30);
        txt = new JTextField(10); 
        txt.setBounds(60,10, 150, 25);
        pasw = new JPasswordField(10);
        pasw.setBounds(60, 50, 150, 25);
        pasw.setEchoChar('*'); 
        lbl3 = new JLabel("教   室:"); 
        lbl3.setBounds(10,90, 80, 30);
        lbl4 = new JLabel("座   位:"); 
        lbl4.setBounds(280,90, 80, 30);
        img = new ImageIcon(MainGUI.class.getClassLoader().getResource("timg.jpg"));  
//        img = new ImageIcon("timg.jpg");  
        //TODO 需要显示座位
        bll3 = new JLabel("座位号");  
        String str1[] = {"1401", "2101",
        		"2201", "2206", "2211", "3207",
        		"3401"};  
        final String str1401[] = {"001", "002", "003", "004",
        		            "005", "006", "007", "008",
        		            "009", "010", "011", "012",
        		            "013", "014", "015", "016",
        		            "017", "018", "019", "020",
        		            "001", "002", "003", "004",
        		            "005", "006", "007", "008",
        		            "009", "010", "011", "012",
        		            "013", "014", "015", "016",
        		            "017", "018", "019", "020",
        		            "021", "022", "023", "024",
        		            "025", "026", "027", "028",
        		            "029", "030", "031", "032",
        		            "033", "034", "035", "036",
        		            "037", "038", "039", "040",
        		            "041", "042", "043", "044",
        		            "045", "046", "047", "048",
        		            "049", "050", "051", "052",
        		            "053", "054", "055", "056",
        		            "057", "058", "059", "060",
        		            "061", "062", "063", "064",
        		            "065", "066", "067", "068",
        		            "069", "070", "071", "072",
        		            "073", "074", "075", "076",
        		            "077", "078", "079", "080",
        		            "081", "082", "083", "084",
        		            "085", "086", "087", "088",
        		            "089", "090", "091", "092",
        		            "093", "094", "095", "096",
        		            "097", "098", "099", "100",
        		            "101", "102", "103", "104",
        		            "105", "106", "107", "108",
        		            "109", "110", "111", "112",
        		            "113", "114", "115", "116",
        		            "117", "118", "119", "120",
        		            "101", "102", "103", "104",
        		            "105", "106", "107", "108",
        		            "109", "110", "111", "112",
        		            "113", "114", "115", "116",
        		            "117", "118", "119", "120",
        		            "121", "122", "123", "124",
        		            "125", "126", "127", "128",
        		            "129", "130", "131", "132",
        		            "133", "134", "135", "136",
        		            "137", "138", "139", "140",
        		            "141", "142", "143", "144",
        		            "145", "146", "147", "148",
        		            "149", "150", "151", "152",
        		            "153", "154", "155", "156",
        		            "157", "158", "159", "160",
        		            "161", "162", "163", "164",
        		            "165", "166", "167", "168",
        		            "169", "170", "171", "172",
        		            "173", "174", "175", "176",
        		            "177", "178", "179", "180",
        		            "181", "182", "183", "184",
        		            "185", "186", "187", "188",
        		            "189", "190", "191", "192",
        		            "193", "194", "195", "196",
        		            "197", "198", "199", "200",
        		            "201", "202", "203", "204",
        		            "205", "206", "207", "208",
        		            "209", "210", "211", "212",
        		            "213", "214", "215", "216",
        		            "217", "218", "219", "220",
        		            "201", "202", "203", "204",
        		            "205", "206", "207", "208",
        		            "209", "210", "211", "212",
        		            "213", "214", "215", "216",
        		            "217", "218", "219", "220",
        		            "221", "222", "223", "224",
        		            "225", "226", "227", "228",
        		            "229", "230", "231", "232",
        		            "233", "234", "235", "236",
        		            "237", "238", "239", "240",
        		            "241", "242", "243", "244",
        		            "245", "246", "247", "248",
        		            "249", "250", "251", "252",
        		            "253", "254", "255", "256",
        		            "257", "258", "259", "260",
        		            "261", "262", "263", "264",
        		            "265", "266", "267", "268",
        		            "269", "270", "271", "272",
        		            "273", "274", "275", "276",
        		            "277", "278", "279", "280",
        		            "281", "282", "283", "284",
        		            "285", "286", "287", "288",
        		            "289", "290", "291", "292",
        		            "293", "294", "295", "296",
        		            "297", "298", "299", "300",
        		            "301", "302", "303", "304",
        		            "305", "306", "307", "308",
        		            "309", "310", "311", "312",
        		            "313", "314", "315", "316",
        		            "317", "318", "319", "320",
        		            "301", "302", "303", "304",
        		            "305", "306", "307", "308",
        		            "309", "310", "311", "312",
        		            "313", "314", "315", "316",
        		            "317", "318", "319", "320",
        		            "321", "322", "323", "324",
        		            "325", "326", "327", "328",
        		            "329", "330", "331", "332",
        		            "333", "334", "335", "336"
        		};          
        
        final String str2101[] = {"001","002", "003", "004",
				            "005", "006", "007", "008",
				            "009", "010", "011", "012",
				            "013", "014", "015", "016",
				            "017", "018", "019", "020",
				            "001", "002", "003", "004",
				            "005", "006", "007", "008",
				            "009", "010", "011", "012",
				            "013", "014", "015", "016",
				            "017", "018", "019", "020",
				            "021", "022", "023", "024",
				            "025", "026", "027", "028",
				            "029", "030", "031", "032",
				            "033", "034", "035", "036",
				            "037", "038", "039", "040",
				            "041", "042", "043", "044",
				            "045", "046", "047", "048",
				            "049", "050", "051", "052",
				            "053", "054", "055", "056",
				            "057", "058", "059", "060",
				            "061", "062", "063", "064",
				            "065", "066", "067", "068",
				            "069", "070", "071", "072",
				            "073", "074", "075", "076",
				            "077", "078", "079", "080",
				            "081", "082", "083", "084",
				            "085", "086", "087", "088",
				            "089", "090", "091", "092",
				            "093", "094", "095", "096",
				            "097", "098", "099", "100",
				            "101", "102", "103", "104",
				            "105", "106", "107", "108",
				            "109", "110", "111", "112",
				            "113", "114", "115", "116",
				            "117", "118", "119", "120",
				            "101", "102", "103", "104",
				            "105", "106", "107", "108",
				            "109", "110", "111", "112",
				            "113", "114", "115", "116",
				            "117", "118", "119", "120",
				            "121", "122", "123", "124",
				            "125", "126", "127", "128",
				            "129", "130", "131", "132",
				            "133", "134", "135", "136",
				            "137", "138", "139", "140",
				            "141", "142", "143", "144",
				            "145", "146", "147", "148",
				            "149", "150", "151", "152",
				            "153", "154", "155", "156",
				            "157", "158", "159", "160"
	            };
        
        final String str2201[] = {"001","002", "003", "004",
				            "005", "006", "007", "008",
				            "009", "010", "011", "012",
				            "013", "014", "015", "016",
				            "017", "018", "019", "020",
				            "001", "002", "003", "004",
				            "005", "006", "007", "008",
				            "009", "010", "011", "012",
				            "013", "014", "015", "016",
				            "017", "018", "019", "020",
				            "021", "022", "023", "024",
				            "025", "026", "027", "028",
				            "029", "030", "031", "032",
				            "033", "034", "035", "036",
				            "037", "038", "039", "040",
				            "041", "042", "043", "044",
				            "045", "046", "047", "048",
				            "049", "050", "051", "052",
				            "053", "054", "055", "056",
				            "057", "058", "059", "060",
				            "061", "062", "063", "064",
				            "065", "066", "067", "068",
				            "069", "070", "071", "072",
				            "073", "074", "075", "076",
				            "077", "078", "079", "080",
				            "081", "082", "083", "084",
				            "085", "086", "087", "088",
				            "089", "090", "091", "092",
				            "093", "094", "095", "096",
				            "097", "098", "099", "100",
				            "101", "102", "103", "104",
				            "105", "106", "107", "108",
				            "109", "110", "111", "112",
				            "113", "114", "115", "116",
				            "117", "118", "119", "120",
				            "101", "102", "103", "104",
				            "105", "106", "107", "108",
				            "109", "110", "111", "112",
				            "113", "114", "115", "116",
				            "117", "118", "119", "120",
				            "121", "122", "123", "124",
				            "125", "126", "127", "128",
				            "129", "130", "131", "132",
				            "133", "134", "135", "136",
				            "137", "138", "139", "140",
				            "141", "142", "143", "144",
				            "145", "146", "147", "148",
				            "149", "150", "151", "152",
				            "153", "154", "155", "156",
				            "157", "158", "159", "160",
				            "161", "162", "163", "164",
				            "165", "166", "167", "168",
				            "169", "170", "171", "172",
				            "173", "174", "175", "176",
				            "177", "178", "179", "180",
				            "181", "182", "183", "184",
				            "185", "186", "187", "188",
				            "189", "190", "191", "192",
				            "193", "194", "195", "196",
				            "197", "198", "199", "200",
				            "201", "202", "203", "204",
				            "205", "206", "207", "208",
				            "209", "210", "211", "212",
				            "213", "214", "215", "216",
				            "217", "218", "219", "220",
				            "201", "202", "203", "204",
				            "205", "206", "207", "208",
				            "209", "210", "211", "212",
				            "213", "214", "215", "216",
				            "217", "218", "219", "220",
				            "221", "222", "223", "224",
				            "225", "226", "227", "228",
				            "229", "230", "231", "232",
				            "233", "234", "235", "236",
				            "237", "238", "239", "240",
				            "241", "242", "243", "244",
				            "245", "246", "247", "248",
				            "249", "250", "251", "252",
				            "253", "254", "255", "256",
				            "257", "258", "259", "260",
				            "261", "262", "263", "264",
				            "265", "266", "267", "268",
				            "269", "270", "271", "272",
				            "273", "274", "275", "276",
				            "277", "278", "279", "280",
				            "281", "282", "283", "284",
				            "285", "286", "287", "288"};
        
        final String str2206[] = {"001","002", "003", "004",
				            "005", "006", "007", "008",
				            "009", "010", "011", "012",
				            "013", "014", "015", "016",
				            "017", "018", "019", "020",
				            "001", "002", "003", "004",
				            "005", "006", "007", "008",
				            "009", "010", "011", "012",
				            "013", "014", "015", "016",
				            "017", "018", "019", "020",
				            "021", "022", "023", "024",
				            "025", "026", "027", "028",
				            "029", "030", "031", "032",
				            "033", "034", "035", "036",
				            "037", "038", "039", "040",
				            "041", "042", "043", "044",
				            "045", "046", "047", "048",
				            "049", "050", "051", "052",
				            "053", "054", "055", "056",
				            "057", "058", "059", "060",
				            "061", "062", "063", "064",
				            "065", "066", "067", "068",
				            "069", "070", "071", "072",
				            "073", "074", "075", "076",
				            "077", "078", "079", "080",
				            "081", "082", "083", "084",
				            "085", "086", "087", "088",
				            "089", "090", "091", "092",
				            "093", "094", "095", "096",
				            "097", "098", "099", "100",
				            "101", "102", "103", "104",
				            "105", "106", "107", "108",
				            "109", "110", "111", "112",
				            "113", "114", "115", "116",
				            "117", "118", "119", "120",
				            "101", "102", "103", "104",
				            "105", "106", "107", "108",
				            "109", "110", "111", "112",
				            "113", "114", "115", "116",
				            "117", "118", "119", "120",
				            "121", "122", "123", "124",
				            "125", "126", "127", "128",
				            "129", "130", "131", "132",
				            "133", "134", "135", "136",
				            "137", "138", "139", "140",
				            "141", "142", "143", "144",
				            "145", "146", "147", "148",
				            "149", "150", "151", "152",
				            "153", "154", "155", "156",
				            "157", "158", "159", "160",};
        
        final String str2211[] = {"001","002", "003", "004",
				            "005", "006", "007", "008",
				            "009", "010", "011", "012",
				            "013", "014", "015", "016",
				            "017", "018", "019", "020",
				            "001", "002", "003", "004",
				            "005", "006", "007", "008",
				            "009", "010", "011", "012",
				            "013", "014", "015", "016",
				            "017", "018", "019", "020",
				            "021", "022", "023", "024",
				            "025", "026", "027", "028",
				            "029", "030", "031", "032",
				            "033", "034", "035", "036",
				            "037", "038", "039", "040",
				            "041", "042", "043", "044",
				            "045", "046", "047", "048",
				            "049", "050", "051", "052",
				            "053", "054", "055", "056",
				            "057", "058", "059", "060",
				            "061", "062", "063", "064",
				            "065", "066", "067", "068",
				            "069", "070", "071", "072",
				            "073", "074", "075", "076",
				            "077", "078", "079", "080",
				            "081", "082", "083", "084",
				            "085", "086", "087", "088",
				            "089", "090", "091", "092",
				            "093", "094", "095", "096",
				            "097", "098", "099", "100",
				            "101", "102", "103", "104",
				            "105", "106", "107", "108",
				            "109", "110", "111", "112",
				            "113", "114", "115", "116",
				            "117", "118", "119", "120",
				            "101", "102", "103", "104",
				            "105", "106", "107", "108",
				            "109", "110", "111", "112",
				            "113", "114", "115", "116",
				            "117", "118", "119", "120"};
			        
        final String str3207[] = {"001","002", "003", "004",
				            "005", "006", "007", "008",
				            "009", "010", "011", "012",
				            "013", "014", "015", "016",
				            "017", "018", "019", "020",
				            "001", "002", "003", "004",
				            "005", "006", "007", "008",
				            "009", "010", "011", "012",
				            "013", "014", "015", "016",
				            "017", "018", "019", "020",
				            "021", "022", "023", "024",
				            "025", "026", "027", "028",
				            "029", "030", "031", "032",
				            "033", "034", "035", "036",
				            "037", "038", "039", "040",
				            "041", "042", "043", "044",
				            "045", "046", "047", "048",
				            "049", "050", "051", "052",
				            "053", "054", "055", "056",
				            "057", "058", "059", "060",
				            "061", "062", "063", "064",
				            "065", "066", "067", "068",
				            "069", "070", "071", "072",
				            "073", "074", "075", "076",
				            "077", "078", "079", "080",
				            "081", "082", "083", "084",
				            "085", "086", "087", "088",
				            "089", "090", "091", "092",
				            "093", "094", "095", "096",
				            "097", "098", "099", "100",
				            "101", "102", "103", "104",
				            "105", "106", "107", "108",
				            "109", "110", "111", "112",
				            "113", "114", "115", "116",
				            "117", "118", "119", "120",
				            "101", "102", "103", "104",
				            "105", "106", "107", "108",
				            "109", "110", "111", "112",
				            "113", "114", "115", "116",
				            "117", "118", "119", "120",
				            "121", "122", "123", "124",
				            "125", "126", "127", "128",
				            "129", "130", "131", "132",
				            "133", "134", "135", "136",
				            "137", "138", "139", "140",
				            "141", "142", "143", "144",
				            "145", "146", "147", "148",
				            "149", "150", "151", "152",
				            "153", "154", "155", "156",
				            "157", "158", "159", "160",
				            "161", "162", "163", "164",
				            "165", "166", "167", "168",
				            "169", "170", "171", "172",
				            "173", "174", "175", "176",
				            "177", "178", "179", "180",
				            "181", "182", "183", "184",
				            "185", "186", "187", "188",
				            "189", "190", "191", "192",
				            "193", "194", "195", "196",
				            "197", "198", "199", "200",
				            "201", "202", "203", "204",
				            "205", "206", "207", "208",
				            "209", "210", "211", "212",
				            "213", "214", "215", "216",
				            "217", "218", "219", "220",
				            "201", "202", "203", "204",
				            "205", "206", "207", "208",
				            "209", "210", "211", "212",
				            "213", "214", "215", "216",
				            "217", "218", "219", "220",
				            "221", "222", "223", "224",
				            "225", "226", "227", "228",
				            "229", "230", "231", "232",
				            "233", "234", "235", "236",
				            "237", "238", "239", "240",
				            "241", "242", "243", "244",};
        
        final String str3401[] = {"001","002", "003", "004",
			             "005", "006", "007", "008",
			             "009", "010", "011", "012",
			             "013", "014", "015", "016",
			             "017", "018", "019", "020",
			             "001", "002", "003", "004",
			             "005", "006", "007", "008",
			             "009", "010", "011", "012",
			             "013", "014", "015", "016",
			             "017", "018", "019", "020",
			             "021", "022", "023", "024",
			             "025", "026", "027", "028",
			             "029", "030", "031", "032",
			             "033", "034", "035", "036",
			             "037", "038", "039", "040",
			             "041", "042", "043", "044",
			             "045", "046", "047", "048",
			             "049", "050", "051", "052",
			             "053", "054", "055", "056",
			             "057", "058", "059", "060",
			             "061", "062", "063", "064",
			             "065", "066", "067", "068",
			             "069", "070", "071", "072",
			             "073", "074", "075", "076",
			             "077", "078", "079", "080",
			             "081", "082", "083", "084",
			             "085", "086", "087", "088",
			             "089", "090", "091", "092",
			             "093", "094", "095", "096",
			             "097", "098", "099", "100",
			             "101", "102", "103", "104",
			             "105", "106", "107", "108",
			             "109", "110", "111", "112",
			             "113", "114", "115", "116",
			             "117", "118", "119", "120",
			             "101", "102", "103", "104",
			             "105", "106", "107", "108",
			             "109", "110", "111", "112",
			             "113", "114", "115", "116",
			             "117", "118", "119", "120",
			             "121", "122", "123", "124",
			             "125", "126", "127", "128",
			             "129", "130", "131", "132",
			             "133", "134", "135", "136",
			             "137", "138", "139", "140",
			             "141", "142", "143", "144",
			             "145", "146", "147", "148",
			             "149", "150", "151", "152",
			             "153", "154", "155", "156",
			             "157", "158", "159", "160",
			             "161", "162", "163", "164",
			             "165", "166", "167", "168",
			             "169", "170", "171", "172",
			             "173", "174", "175", "176",
			             "177", "178", "179", "180",
			             "181", "182", "183", "184",
			             "185", "186", "187", "188",
			             "189", "190", "191", "192",
			             "193", "194", "195", "196",
			             "197", "198", "199", "200",
			             "201", "202", "203", "204",
			             "205", "206", "207", "208",
			             "209", "210", "211", "212",
			             "213", "214", "215", "216",
			             "217", "218", "219", "220",
			             "201", "202", "203", "204",
			             "205", "206", "207", "208",
			             "209", "210", "211", "212",
			             "213", "214", "215", "216",
			             "217", "218", "219", "220",
			             "221", "222", "223", "224",
			             "225", "226", "227", "228",
			             "229", "230", "231", "232",
			             "233", "234", "235", "236",
			             "237", "238", "239", "240",
			             "241", "242", "243", "244",
			             "245", "246", "247", "248",
			             "249", "250", "251", "252",
			             "253", "254", "255", "256",
			             "257", "258", "259", "260",
			             "261", "262", "263", "264",
			             "265", "266", "267", "268",
			             "269", "270", "271", "272",
			             "273", "274", "275", "276",
			             "277", "278", "279", "280",
			             "281", "282", "283", "284",
			             "285", "286", "287", "288",
			             "289", "290", "291", "292",
			             "293", "294", "295", "296",
			             "297", "298", "299", "300",
			             "301", "302", "303", "304"};
        
        jcb1 = new JComboBox<>(str1);
        jcb1.setBounds(60,90,130,25);
        String[] str2 = {"--请选择--"};
        jcb2 = new JComboBox<>(str2);
        jcb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedItem1 = (String) jcb1.getSelectedItem();
				System.out.println(selectedItem1);
				if(selectedItem1.equals("1401")){
					jcb2.removeAll();
					for (int i = 0; i < str1401.length; i++) {
						jcb2.addItem(str1401[i]);
					}
				}else if(selectedItem1.equals("2101")){
					jcb2.removeAll();
					for (int i = 0; i < str2101.length; i++) {
						jcb2.addItem(str2101[i]);
					}
				}else if(selectedItem1.equals("2201")){
					jcb2.removeAll();
					for (int i = 0; i < str2201.length; i++) {
						jcb2.addItem(str2201[i]);
					}
				}else if(selectedItem1.equals("2206")){
					jcb2.removeAll();
					for (int i = 0; i < str2206.length; i++) {
						jcb2.addItem(str2206[i]);
					}
				}else if(selectedItem1.equals("2211")){
					jcb2.removeAll();
					for (int i = 0; i < str2211.length; i++) {
						jcb2.addItem(str2211[i]);
					}
				}else if(selectedItem1.equals("3207")){
					jcb2.removeAll();
					for (int i = 0; i < str3207.length; i++) {
						jcb2.addItem(str3207[i]);
					}
				}else if(selectedItem1.equals("3401")){
					jcb2.removeAll();
					for (int i = 0; i < str3401.length; i++) {
						jcb2.addItem(str3401[i]);
					}
				}
			}
		});
        
        jcb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedItem2 = (String) jcb2.getSelectedItem();
				System.out.println(selectedItem2);
				seatNum = selectedItem1+selectedItem2;
			}
		});
        jcb2.setBounds(330,90,130,25);

        imgLabel = new JLabel(img);  
        btn1 = new JButton("定时抢座");
        btn1.setBounds(330, 160, 140, 40);
        
        // 定时抢座的按钮
        btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//要抢的座位
				//开始校验用户名密码可用性
				try {
					cookie = SeatLogin.getCookie("http://172.16.47.84/",txt.getText(),pasw.getText());
					if(cookie == ""){
						JOptionPane.showMessageDialog(frame, "您输入的用户名或者密码错误噢~~", "小助手温馨提示", JOptionPane.INFORMATION_MESSAGE); 
						return;
					}else{
						JOptionPane.showMessageDialog(frame, "用户名密码验证通过~~", "小助手温馨提示", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "学校的服务器可能有问题哦~~", "小助手温馨提示", JOptionPane.INFORMATION_MESSAGE); 
					System.exit(0);
					return;
				}
				if(seatNum == "" || seatNum.contains("--请选择--")){
					JOptionPane.showMessageDialog(frame, "您没有输入座位号哦~~", "小助手温馨提示", JOptionPane.INFORMATION_MESSAGE); 
					return;
				}
				//开启定时 如果是下午和晚上 定时器不开启
				Calendar instance = Calendar.getInstance();
				int hour = instance.get(Calendar.HOUR_OF_DAY);
				if(hour >= 13 && hour < 23){
					JOptionPane.showMessageDialog(frame, "小助手在13:00~00:00需要休息哦~~", "小助手温馨提示", JOptionPane.INFORMATION_MESSAGE); 
					System.exit(0);
				}
				JOptionPane.showMessageDialog(frame, "13:00准时小助手帮你抢座~~", "小助手温馨提示", JOptionPane.INFORMATION_MESSAGE); 
				 btn1.setText("定时任务正在运行");
				 btn1.setEnabled(false);
				 btn1.setBackground(new Color(255,0,0));
				try{
					String taskGrab = GrabSeat.taskGrab("http://172.16.47.84/Skip.aspx", "http://172.16.47.84/", txt.getText(),pasw.getText(), seatNum);
					if(taskGrab.equals("明日预约成功")){
						JOptionPane.showMessageDialog(frame, "您已经抢到了"+seatNum+"记得每天早上8:00签到哦~~", "小助手温馨提示", JOptionPane.INFORMATION_MESSAGE); 
						return;
					}else{
						JOptionPane.showMessageDialog(frame, "您已经预约了或者座位被人抢了~~", "小助手温馨提示", JOptionPane.INFORMATION_MESSAGE); 
					}
				}catch(Exception e1){
					JOptionPane.showMessageDialog(frame, "抢座失败了,好桑心~~", "小助手温馨提示", JOptionPane.INFORMATION_MESSAGE); 
					System.exit(0);
					return;
				}
			}
		});
        this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));  
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());  
        contain = this.getContentPane();  
        ((JPanel) contain).setOpaque(false);   
        contain.setLayout(null);
        contain.add(lbl1);
        contain.add(txt);  
        contain.add(lbl2);  
        contain.add(pasw);
        contain.add(lbl3);
        contain.add(lbl4);
        contain.add(btn1);
        contain.add(jcb1);
        contain.add(jcb2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true); 
	}
}
