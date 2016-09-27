package cn.ziroom.mybatis.ms;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		//return DynamicDataSourceHolder.getDataSouce();
		return DynamicDataSourceHolder.getDataSource();
	}
	
	

}
