import java.io.*;
import java.util.Properties;
import java.time.LocalDateTime;

public class javaFileDemo
{	
	private static Properties properties = null;

	// 静态代码块中读取配置文件
	static
	{	
		try{
			properties = new Properties();
			FileInputStream fileInputStream = new FileInputStream("appConfig.properties");
			properties.load(fileInputStream);
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public static void main(String[] args) throws Exception
	{
		// output_log("开始写入log....");
		// File file = new File("/home/hzwxdf/work/tmp/java.log");
		// FileWriter fwileWrite = new FileWriter(file);
		// fwileWrite.write("2020-08-27,[hzwxdf],[index]:log记载开始");
		// fwileWrite.write(System.lineSeparator());
		// fwileWrite.write("2020-08-27,[hzwxdf],[index]:log记载结束");
		// fwileWrite.write(System.lineSeparator());
		// fwileWrite.close();

		// 使用properties来管理路径配置
		// Properties properties = new Properties();
		// FileInputStream fileInputStream = new FileInputStream("appConfig.properties");
		// properties.load(fileInputStream);

		String rooPath = properties.getProperty("RootPath"); // =/home/hzwxdf/work/tmp
		output_log("读取配置文件中的根目录: " + rooPath);
		if (rooPath != null || rooPath != "")
		{
			String path = rooPath + File.separator + "java.log";
			output_log("开始获取文件路径==" + path);
			File file = new File(path);
			FileWriter fwileWrite = new FileWriter(file, true);

			output_log("开始写入log....");
			fwileWrite.write(getTime() + ",[hzwxdf],[index]:log记载开始=Properties");
			fwileWrite.write(System.lineSeparator());
			fwileWrite.write(getTime() + ",[hzwxdf],[index]:log记载结束=Properties");
			fwileWrite.write(System.lineSeparator());

			fwileWrite.close();
		}

	}

	// 控制台的日志输出
	public static void output_log(String logInfo)
	{
		System.out.println(logInfo);
	}

	// 获取当前时间
	public static String getTime()
	{
		return LocalDateTime.now().toString();
	}
}