package com.nisum.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class MyDataRouteEx1 extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:C:\\source")
		.to("file:C:\\destination");
	}

}
