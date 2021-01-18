package com.base.code.io.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DirUtil {

	public static final String LOWER = "\\$\\{NAME}";

	public static final String UPPER = "\\$\\{name}";

	public static final String PACKAGE_NAME = "\\$\\{PACKAGE_NAME}";
	
	public static final String NOW = "\\$\\{NOW}";

	/**
	 * 模板地址
	 */
//	private static String srcPath = System.getProperty("user.dir") + "/src/com/jfy/jdbtools/common/template/";
	private static String templatePath = "C:/Users/七听芬达/eclipse-workspace2/jdb-tools/src/com/jfy/jdbtools/template/";

	/**
	 * controller模板
	 */
	public static final String CONTROLLER_TEMPLATE = templatePath + "controller.txt";
	/**
	 * service模板
	 */
	public static final String SERVICE_TEMPLATE = templatePath + "service.txt";
	/**
	 * serviceImpl模板
	 */
	public static final String SERVICE_IMPL_TEMPLATE = templatePath + "serviceImpl.txt";
	/**
	 * dao模板
	 */
	public static final String DAO_TEMPLATE = templatePath + "dao.txt";
	/**
	 * mapper模板
	 */
	public static final String MAPPER_TEMPLATE = templatePath + "mapper.txt";
	/**
	 * msg模板
	 */
	public static final String MSG_TEMPLATE = templatePath + "msg.txt";
	/**
	 * constant模板
	 */
	public static final String CONSTANT_TEMPLATE = templatePath + "constant.txt";

	private String moduleName;

	private String firstUpper;

	private String path;
	
	private String packageName;

	public DirUtil(String moduleName, String path) {
		if (moduleName == null || moduleName.length() < 1) {
			throw new RuntimeException("模块名不能为空");
		}
		this.firstUpper = moduleName.substring(0, 1).toUpperCase() + moduleName.substring(1);
		this.moduleName = moduleName;
		this.path = path + "/" + moduleName;
		String java = "java/";
		int index = path.indexOf(java);
		if (index < 0)  {
			new RuntimeException("找不到根目录");
		}
		
		this.packageName = path.substring(index + java.length()).replaceAll("/", ".") + "." + moduleName;
	}

	public void create() {
		// 创建控制器
		createController();
		// 创建业务层接口
		createService();
		// 创建业务层实现
		createServiceImpl();
		// 创建持久层接口
		createDao();
		// 创建持久层实现
		createMapper();
		// 创建枚举消息层
		createMsg();
		// 创建常量
		createConstant();
		// 创建常量
		createModel();
	}

	private void createModel() {
		String dest = path + "/model/";
		String bo = dest + "bo/";
		String vo = dest + "vo/";
		String po = dest + "po/";
		// 创建目录
		createMkdirs(dest);
		createMkdirs(bo);
		createMkdirs(vo);
		createMkdirs(po);
	}

	private void createConstant() {
		String dest = path + "/constant/";
		// 创建目录
		createMkdirs(dest);
		// 创建文件
		dest = dest + firstUpper + "Constant.java";
		createFile(CONSTANT_TEMPLATE, dest);
	}

	private void createMsg() {
		String dest = path + "/msg/";
		// 创建目录
		createMkdirs(dest);
		// 创建文件
		dest = dest + firstUpper + "Msg.java";
		createFile(MSG_TEMPLATE, dest);
	}

	private void createMapper() {
		String dest = path + "/mapper/";
		// 创建目录
		createMkdirs(dest);
		// 创建文件
		dest = dest + firstUpper + "Mapper.xml";
		createFile(MAPPER_TEMPLATE, dest);
	}

	private void createDao() {
		String dest = path + "/dao/";
		// 创建目录
		createMkdirs(dest);
		// 创建文件
		dest = dest + firstUpper + "Dao.java";
		createFile(DAO_TEMPLATE, dest);
	}

	private void createServiceImpl() {
		String dest = path + "/service/impl/";
		// 创建目录
		createMkdirs(dest);
		// 创建文件
		dest = dest + firstUpper + "ServiceImpl.java";
		createFile(SERVICE_IMPL_TEMPLATE, dest);
	}

	private void createService() {
		String dest = path + "/service/";
		// 创建目录
		createMkdirs(dest);
		// 创建文件
		dest = dest + firstUpper + "Service.java";
		createFile(SERVICE_TEMPLATE, dest);
	}

	private void createController() {
		String dest = path + "/controller/";
		// 创建目录
		createMkdirs(dest);
		// 创建文件
		dest = dest + firstUpper + "Controller.java";
		createFile(CONTROLLER_TEMPLATE, dest);
	}

	private void createFile(String target, String dest) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			// 创建输入输出流
			File read = new File(target);
			File writer = new File(dest);
			fr = new FileReader(read);
			fw = new FileWriter(writer);
			char[] buffer = new char[1024];
			int len;
			StringBuilder sb = new StringBuilder();
			while ((len = fr.read(buffer)) != -1) {
				String str = new String(buffer, 0, len);
				sb.append(str);
			}
			// 替换内容
			String str = sb.toString();
			str = str.replaceAll(UPPER, moduleName);
			str = str.replaceAll(LOWER, firstUpper);
			str = str.replaceAll(PACKAGE_NAME, packageName);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	        String nowDateTime = LocalDateTime.now().format(formatter);
	        str = str.replaceAll(NOW, nowDateTime);
			// 写出文件
			fw.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4.关闭资源
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void createMkdirs(String path) {
		File file = new File(path);
		if (!file.exists()) {
			boolean flag = file.mkdirs();
			if (!flag) {
				throw new RuntimeException("创建目录失败");
			}
		}
	}

}
