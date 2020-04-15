package com.dalrada.gateway.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;
@Configuration
@Primary
@EnableSwagger2WebFlux
@EnableConfigurationProperties({SwaggerServicesConfig.class,SwaggerServicesConfig.SwaggerServices.class})
public class PropertyResourceProvider implements SwaggerResourcesProvider {

	@Autowired
	private SwaggerServicesConfig swaggerServiceList ;

	public PropertyResourceProvider() {
		super();
	}
	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<>();
		swaggerServiceList.getServices().forEach(service -> {
			resources.add(swaggerResource(service.getName(),service.getUrl(), service.getVersion()));
		});
		return resources;
	}
	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;	
	}
}
