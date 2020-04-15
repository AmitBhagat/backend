package com.dalrada.upload.intg.beanBuilder;

import com.dalrada.upload.intg.entity.OrderDetails;

public interface OderBeanBuilder {
	public  OrderDetails buildBean(String record);
}
