package net.jsrois.api.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.format.FormatterRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
class WebConfiguration : WebMvcConfigurer {

    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("/").setViewName("forward:/app/index.html")
        registry.addViewController("/admin").setViewName("forward:/backoffice/index.html")
    }

    private val CLASSPATH_RESOURCE_LOCATIONS = arrayOf(
            "classpath:/resources/","classpath:/static/", "classpath:/static/app/", "classpath:/static/backoffice/"
    )

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/**").addResourceLocations(*CLASSPATH_RESOURCE_LOCATIONS)
    }
}