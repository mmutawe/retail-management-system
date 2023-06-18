//package com.mmutawe.projects.ms.retail;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mmutawe.projects.ms.retail.dtos.ProductRequestDto;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.testcontainers.containers.PostgreSQLContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//
//import java.math.BigDecimal;
//
//import static com.mmutawe.projects.ms.retail.utils.Constant.PRODUCT_URI;
//
//@SpringBootTest
//@Testcontainers
//@AutoConfigureMockMvc
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // deactivate the default behaviour
//public class ProductServiceApplicationTests {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//
//    @Container
//    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:13.3")
//            .withDatabaseName("integration-tests-db")
//            .withUsername("sa")
//            .withPassword("sa");
//
//    @DynamicPropertySource
//    static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
//        dynamicPropertyRegistry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
//        dynamicPropertyRegistry.add("spring.datasource.username", postgreSQLContainer::getUsername);
//        dynamicPropertyRegistry.add("spring.datasource.password", postgreSQLContainer::getPassword);
//    }
//
//    @Test
//    void CreateProductWillResponse201() throws Exception {
//
//        String productRequestJson = objectMapper.writeValueAsString(getProductRequestDto());
//        System.out.println("### " + productRequestJson);
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post(PRODUCT_URI)
//                        .contentType(MediaType.APPLICATION_JSON_VALUE)
////                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(productRequestJson))
//                .andExpect(MockMvcResultMatchers
//                        .status()
//                        .isCreated());
//    }
//
//    private ProductRequestDto getProductRequestDto() {
//        return ProductRequestDto.builder()
//                .name("Macbook")
//                .description("Apple laptop")
//                .price(BigDecimal.valueOf(899))
//                .build();
//    }
//}
