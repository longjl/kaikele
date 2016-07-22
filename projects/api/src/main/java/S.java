import com.jfinal.core.JFinal;


public class S {
	/**
	 * 建议使用 JFinal 手册推荐的方式启动项目 运行此 main
	 * 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此 第一个参数填写的是“WEB-INF”文件夹的父文件夹名称
	 * 第二个参数是设置访问的端口号 第三个参数是设置该项目的访问根目录 第四个参数是设置jetty每隔几秒钟扫描文件变化并重启应用
	 */
	public static void main(String[] args) throws Exception {
		JFinal.start("/Users/longjianlin/Documents/05 开课/api-kaike/projects/api/src/main/webapp", 8082, "/", 5);
	}

}
