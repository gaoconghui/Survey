package com.survey.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.hibernate.id.UUIDHexGenerator;
import org.springframework.stereotype.Service;

import com.survey.dao.BaseDao;
import com.survey.model.Log;
import com.survey.service.LogService;
import com.survey.util.LogUtil;

@Service("logService")
public class LogServiceImpl extends BaseServiceImpl<Log> implements LogService {

	@Resource(name = "logDao")
	@Override
	public void setBaseDao(BaseDao<Log> baseDao) {
		super.setBaseDao(baseDao);
	}

	@Override
	public void createLogTabe(String tableName) {
		String sql = "create table if not exists " + tableName + " like LOG";
		this.executeSql(sql);
	}

	@Override
	public void saveEntity(Log t) {
		String sql = "INSERT INTO "
				+ LogUtil.generateLogTableName(0)
				+ " (ID,OPERATOR,OPERNAME,OPERPARAMS,OPERRESULT,RESULTMSG,OPERTIME) "
				+ "VALUES(?,?,?,?,?,?,?)";
		UUIDHexGenerator uuid = new UUIDHexGenerator();
		String id = (String) uuid.generate(null, null);
		this.executeSql(sql,id, t.getOperator(), t.getOperName(),
				t.getOperParams(), t.getOperResult(), t.getResultMsg(),
				t.getOperTime());
	}

	@Override
	public List<Log> findNearlestLogs(int n) {
		String tableName = LogUtil.generateLogTableName(0);
		String sql = "select table_name from information_schema.tables "
				+ "where table_schema = 'suvery' "
				+ "and table_name like 'logs_%' " + "and table_name <='"
				+ tableName + "' " + "order by table_name desc limit 0," + n;
		List list = this.executeSQLQuery(null,sql);
		// 查询最近若干月的日志
		String logsql = "";
		String logName;
		for (int i = 0; i < list.size(); i++) {
			logName = (String) list.get(i);
			logsql = logsql + "select * from " + logName;
			if (i != (list.size() - 1)) {
				logsql = logsql + " union ";
			}
		}
		return this.executeSQLQuery(Log.class, logsql);
	}

}
