package com.survey.model;

import java.io.Serializable;
import java.lang.reflect.Field;

public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -5814818610006383658L;

	public abstract void setId(Integer id);

	public abstract Integer getId();

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		
		Class clazz = this.getClass();
		buffer.append(clazz.getSimpleName());
		buffer.append("(");
		Field[] fields = clazz.getDeclaredFields();
		String fieldName;
		Class fieldType;
		Object fieldValue;
		try {
			for (Field f : fields) {
				fieldType = f.getType();
				fieldName = f.getName();
				f.setAccessible(true);
				fieldValue = f.get(this);

				if (fieldType.isPrimitive() || fieldType == String.class
						|| fieldType == Integer.class
						|| fieldType == Short.class || fieldType == Long.class
						|| fieldType == Double.class
						|| fieldType == Character.class
						|| fieldType == Float.class
						|| fieldType == Boolean.class) {
					buffer.append(fieldName);
					buffer.append(":");
					buffer.append(fieldValue);
					buffer.append(",");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		buffer.substring(0, buffer.length()-1);
		buffer.append(")");
		return buffer.toString();
	}
}
