package villar.financial.financialcontrol.infrastructure.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import villar.financial.financialcontrol.infrastructure.config.adapter.LocalDateTimeDeserializerAdapter;
import villar.financial.financialcontrol.infrastructure.config.adapter.LocalDateTimeSerializerAdapter;

import java.time.LocalDateTime;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        final JavaTimeModule javaTimeModule = new JavaTimeModule();

        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializerAdapter());
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializerAdapter());

        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.registerModule(javaTimeModule);

        return mapper;
    }

}
