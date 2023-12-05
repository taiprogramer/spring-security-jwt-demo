package xyz.taiprogramer.springsecuritydemo.dto;

import java.util.List;
import lombok.Data;

@Data
public class UserDto {
        private String username;
        private List<String> role;
}
