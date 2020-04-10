package com.sx.model.entity;

import java.lang.reflect.Field;

public class MBaseEntity {
	
	public String mToString() {
		Class<? extends MBaseEntity> clazz = this.getClass();
		Field[] fields = clazz.getDeclaredFields();
//		try {
//			MBaseEntity baseEntity = clazz.newInstance(); 
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		StringBuilder sBuilder=new StringBuilder();
		sBuilder.append("{"+clazz.getName()+":{");
		int i=0;
		for(Field field:fields) {
			field.setAccessible(true);
			String name = field.getName();
			sBuilder.append(name+":");
			try {
				Object object = field.get(this);
				sBuilder.append(object);
				if(i!=fields.length-1) {
					sBuilder.append(",");
				}
				if(i==fields.length-1) {
					sBuilder.append("}");
				}
				i++;
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}
		sBuilder.append("}");
		System.out.println("this--->"+this);
		return sBuilder.toString();
				
	}

}
