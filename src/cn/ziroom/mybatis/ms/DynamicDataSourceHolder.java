package cn.ziroom.mybatis.ms;

public class DynamicDataSourceHolder {
	/*
	 * public static final ThreadLocal<String> holder = new
	 * ThreadLocal<String>();
	 * 
	 * public static void putDataSource(String name) { holder.set(name); }
	 * 
	 * public static String getDataSouce() { return holder.get(); }
	 */

	// 线程本地环境
	private static final ThreadLocal<String> dataSources = new ThreadLocal<String>();

	// 设置数据源
	public static void setDataSource(String customerType) {
		dataSources.set(customerType);
	}

	// 获取数据源
	public static String getDataSource() {
		return (String) dataSources.get();
	}

	// 清除数据源
	public static void clearDataSource() {
		dataSources.remove();
	}
}
