package group.demo;

import group.demo.model.OrderDetail;
import group.demo.model.Product;
import group.demo.repository.OrderDetailRepository;
import group.demo.repository.ProductRepository;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class DemoCrisalisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCrisalisApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOriginPatterns(Arrays.asList(
				"*"));
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter();
	}

	/*  source.registerCorsConfiguration(patter: "/**", config);
		return new CorsFilter(source);*/

/*	@Bean
	CommandLineRunner commandLineRunner(
			OrderDetailRepository orderDetailRepository,
			ProductRepository productRepository
	){
		return args -> {
			Product product = productRepository.save(new Product(null, "Celular",
					BigDecimal.valueOf(5000), null));
			OrderDetail orderDetail = orderDetailRepository.save(new OrderDetail(null, product.getPrice(),
					4.0, product));
			System.out.println(orderDetail.toString());
		};

	}*/



}
