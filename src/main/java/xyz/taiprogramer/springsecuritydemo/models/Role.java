package xyz.taiprogramer.springsecuritydemo.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "role")
@Data
@EqualsAndHashCode(exclude = { "name", "users" })
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "name", unique = true)
        private String name;

        @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
        private Set<User> users;

        public static class RoleBuilder {
                private String name;

                public RoleBuilder name(RoleEnum roleEnum) {
                        name = roleEnum.name();
                        return this;
                }
        }
}
