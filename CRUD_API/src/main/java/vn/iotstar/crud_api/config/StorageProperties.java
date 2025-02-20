package vn.iotstar.crud_api.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("storage")
public class StorageProperties {
    private String location;
}
