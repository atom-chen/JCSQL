package pers.jc.sql;

import java.sql.Statement;
import java.util.ArrayList;

public class CURD {
	
	public static void init() {
		try {
			Access.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static <T> ArrayList<T> select(Class<T> modelClass, SQL sql) {
		sql.SELECT_FROM(modelClass);
		return Handle.select(modelClass, sql.toString());
	}
	
	public static <T> T selectOne(Class<T> modelClass, SQL sql) {
		sql.SELECT_FROM(modelClass);
		return Handle.select(modelClass, sql.toString()).get(0);
	}
	
	public static <T> ArrayList<T> selectAll(Class<T> modelClass) {
		return Handle.select(modelClass, new SQL(){{
			SELECT_FROM(modelClass);
		}}.toString());
	}
	
	@SuppressWarnings("unchecked")
	public static <T> int insert(T... models) {
		return Handle.insert(Statement.NO_GENERATED_KEYS, models);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> int insertAndGenerateKeys(T... models) {
		return Handle.insert(Statement.RETURN_GENERATED_KEYS, models);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> int update(T... models) {
		return Handle.update(models);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> int delete(T... models) {
		return Handle.delete(models);
	}
}
